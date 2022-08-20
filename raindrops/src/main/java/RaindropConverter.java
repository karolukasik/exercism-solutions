class RaindropConverter {

    String convert(int number) {
        StringBuilder convertedNumber = new StringBuilder();
        if (number % 3 == 0) {
            convertedNumber.append("Pling");
        }
        if (number % 5 == 0) {
            convertedNumber.append("Plang");
        }
        if (number % 7 == 0) {
            convertedNumber.append("Plong");
        }
        String convertingResult = convertedNumber.toString();
        if (convertingResult.equals("")) {
            convertingResult = String.valueOf(number);
        }

        return convertingResult;
    }

}
