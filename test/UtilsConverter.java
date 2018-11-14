public class UtilsConverter {

public static void main(String[] args) {
    int number = 255;
    System.out.println("Number "+ number + " to binary "
        + intToString(number, 4) + " inToString");
    System.out.print("Number "+ number + " to binary");
    bitPattern(number);
    System.out.print("Nubmer "+ number+ " to binary ");
    toBase(number, 2);
    System.out.println("Number "+ number + " to binary "
        + convertNumber(number) + " convertNumber");
    System.out.println("Number "+ number + " to binary "
        + toBinary(number,8) + " toBinary");
    System.out.println("Number "+ number + " to binary "
        + Integer.toBinaryString(number) + " Integer.toBinaryString("+number+")");
}   

public static String intToString(int number, int groupSize) {
    StringBuilder result = new StringBuilder();
    for(int i = 31; i >= 0 ; i--) {
        int mask = 1 << i;
        result.append((number & mask) != 0 ? "1" : "0");
        if (i % groupSize == 0) result.append(" ");
    }
    result.replace(result.length() - 1, result.length(), "");
    return result.toString();
}

public static void bitPattern(int n) {
    int mask = 1 << 31;
    int count = 0;
    while(mask != 0) {
        if(count%4 == 0) System.out.print(" ");
        if((mask&n) == 0) System.out.print("0");
        else System.out.print("1");
        count++;
        mask = mask >>> 1;
    }
    System.out.println(" bitPattern");
}

public static void toBase(int number, int base) {
    String binary = "";
    int temp = number/2+1;
    int tmp = 16;
    for (int j = 0; j < tmp ; j++) {
        try {
            binary += "" + number % base;
            number /= base;
        } catch (Exception e) {
        }
    }
    for (int j = binary.length() - 1; j >= 0; j--) System.out.print(binary.charAt(j));
    System.out.println(" toBase");
}

public static String convertNumber(int a)  { 
              StringBuilder sb = new StringBuilder();
              sb.append(a & 1);
              while ((a >>=1) != 0)  { 
                  sb.append(a & 1);
               }
              // sb.append("b0");
              return sb.reverse().toString();
  }

public static String toBinary(int a, int bits) {
    if (--bits > 0) return toBinary(a>>1, bits) + ((a&0x1)==0?"0":"1");
    else return (a&0x1)==0?"0":"1";
  }

}