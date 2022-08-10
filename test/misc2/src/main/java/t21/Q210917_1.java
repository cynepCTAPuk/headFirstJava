package t21;

public class Q210917_1 {

    public static void main(String... args) {
        try {
            throw new UnsupportedOperationException();
        } catch (Throwable throwable) {
            System.out.println("1");
        }
/*
        catch (Exception e) {
            System.out.println("2");
        } catch (UnsupportedOperationException uoe) {
            System.out.println("3");
        }
*/
    }
}