class ReverseString {

    
    String reverse(String inputString){
        return new StringBuilder(inputString).reverse().toString();
    }
    
    // static String reverse(String inputString) {
    //     String outString = "";
    //     for (char c : inputString.toCharArray()) {
    //         outString = c + outString;
    //     }
    //     return outString;
    // }


}
