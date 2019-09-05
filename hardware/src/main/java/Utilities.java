public class Utilities {

    public static String makeVbScript(String vbClassName) {
        StringBuilder sb = new StringBuilder("");

        sb.append("Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")").append("\n");
        sb.append("Set colItems = objWMIService.ExecQuery _ ").append("\n");
        sb.append("(\"Select ").append("*").append(" from ").append(vbClassName).append("\") ").append("\n");
//        sb.append("For Each objItem in colItems ").append("\n");
//        sb.append("Next ").append("\n");
        return sb.toString();
    }
}