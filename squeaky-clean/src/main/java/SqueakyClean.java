
class SqueakyClean {
    static String clean(String identifier) {
        return new SqueakyClean(identifier)
        .removeNumbersAndSmallGreek()
        .replaceSpaces()
        .convertToCamelCase()
        .replaceControls()
        .removeEmojis()
        .getResult();
    }

    private String result;

    public SqueakyClean(String identifier) {
        this.result = identifier;
    }

    public String getResult() {
        return this.result;
    }

    public SqueakyClean removeNumbersAndSmallGreek() {
        String string = this.result;
        String toReturn = "";
        char[] toChar = string.toCharArray();
        for (char c : toChar) {
            int charNumber = Integer.valueOf(c);
            if (charNumber >= 945 && charNumber <= 969 || charNumber >= 48 && charNumber <= 57) {
                continue;
            }
            toReturn += c;
        }
        this.result = toReturn;
        return this;
    }

    public SqueakyClean replaceSpaces() {
        this.result = this.result.replace(" ", "_");
        return this;
    }

    public SqueakyClean convertToCamelCase() {
        String string = this.result;
        if (string.contains("-")) {
            String[] parts = string.split("-");
            string = "";
            int i = 0;
            for (String part : parts) {
                if (i == 0) {
                    string += part;
                    i++;
                    continue;
                }
                String firstPart = String.valueOf(part.charAt(0));
                String secondPart = part.substring(1);
                string += firstPart.toUpperCase() + secondPart;
                i++;
            }
        }
        this.result = string;
        return this;
    }

    public SqueakyClean replaceControls() {
        this.result = this.result.replace("\0", "CTRL");
        return this;
    }

    public SqueakyClean removeEmojis() {
        this.result = this.result.replaceAll("[\uD83D\uDE00]", "");
        return this;
    }

    public static void main(String[] args) {
        String stringToClean = "9 -abcĐ\uD83D\uDE00ω\0";
        System.out.println(stringToClean);
        System.out.println(clean(stringToClean));
    }
}
