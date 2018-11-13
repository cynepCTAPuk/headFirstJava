package appendixB;

public class LinkInvocations {
    private void go() {
        System.out.println("\"LinkInvocations.go()\"");
    }

    public static void main(String[] args) {
        new LinkInvocations().go();

        StringBuffer sb = new StringBuffer("spring");
        System.out.println("sb = " + sb);
//        sb = sb.delete(3, 6).insert(2, "umme").deleteCharAt(1);
        sb = sb.delete(3, 6);
        System.out.println("sb = " + sb);
        sb = sb.insert(2, "umme");
        System.out.println("sb = " + sb);
        sb = sb.deleteCharAt(1);
        System.out.println("sb = " + sb);

        System.out.println("sb = " + sb.reverse());
        System.out.println();

        String st = "subSequence";
        String st1 = st.substring(2, 5);
        String st2 = (String) st.subSequence(2, 5);
        CharSequence ch2 = st.subSequence(2, 5);

        System.out.println(st1);
        System.out.println(st2);
        System.out.println(ch2.charAt(0));
    }
}
