void checkPalindrom(String s){
    String a = s
        .replaceAll(" ", "")
        .replaceAll("\\p{Punct}", "")
        .replaceAll("’", "");
    String b = new StringBuilder(a).reverse().toString();
    System.out.println((a.equalsIgnoreCase(b)) ? "yes" : "no");
}




