public class MyUtility {

    public static String makeVbScript(String vbClassName, String[] propNames) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < propNames.length; i++) {
            if (i < propNames.length - 1) sb.append(propNames[i]).append(",");
            else sb.append(propNames[i]);
        }
        String colNameString = sb.toString();
        sb.setLength(0);

        sb.append("Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")").append("\n");
        sb.append("Set colItems = objWMIService.ExecQuery _ ").append("\n");
        sb.append("(\"Select ").append(colNameString).append(" from ").append(vbClassName).append("\") ").append("\n");
        sb.append("For Each objItem in colItems ").append("\n");
        for (String propName : propNames) {
            sb.append("    Wscript.Echo objItem.").append(propName).append("\n");
        }
        sb.append("Next ").append("\n");
        return sb.toString();
    }
}