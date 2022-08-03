package annotation.refactoring;

public class Test {
    public void logMessage(String prefix, String name, int loglevel, Throwable exception) {
        dolog(loglevel, prefix != null ? prefix + ":" + name : name
                , exception.getMessage(), exception.getCause(), exception.getStackTrace());
/*
        String title = prefix == null ? name : prefix + ":" + name;
        dolog(loglevel, title, exception.getMessage(), exception.getCause(), exception.getStackTrace());
*/
/*
        if (prefix != null) {
            dolog(loglevel, prefix + ":" + name, exception.getMessage()
                    , exception.getCause(), exception.getStackTrace());
        } else {
            dolog(loglevel, name, exception.getMessage()
                    , exception.getCause(), exception.getStackTrace());
        }
*/
    }

    private void dolog(int level, String title, String message, Throwable cause, StackTraceElement[] stackTrace) {
//        Do logging
        System.out.println(level + " " + title + " " + message + "\n" + cause + " " + stackTrace);
    }

    public static void main(String[] args) {
        new Test().logMessage("preffix", "Core", 999, new Exception());
    }

}
