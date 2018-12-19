public class LinePrinter {
  public static void main(String[] args) {
//     Note: \\u000A is Unicode;
// representation of linefeed (LF)
    char c = 0x000A;
    System.out.print(1);
    System.out.print(c);
    System.out.print(2);
    System.out.print(c);
  }
}
