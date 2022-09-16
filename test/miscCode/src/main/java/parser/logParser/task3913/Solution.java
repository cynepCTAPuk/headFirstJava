package parser.logParser.task3913;

import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws ParseException {
        LogParser logParser = new LogParser(Paths.get("c:/000/logs/"));
//        logParser.getEntryList().stream().forEach(x -> System.out.println(x));
//        logParser.getAllUsers().stream().forEach(System.out::println);
        Date date1 = new SimpleDateFormat("d.M.yyyy H:m:s").parse("09.09.1962 0:0:0");
        Date date2 = new SimpleDateFormat("d.M.yyyy H:m:s").parse("11.09.2013 11:11:11");
        Date date3 = new SimpleDateFormat("d.M.yyyy H:m:s").parse("22.09.2222 22:22:22");

//        System.out.println("NumberOfUniqueIPs: " + logParser.getNumberOfUniqueIPs(null, new Date()));
//        System.out.println("UniqueIPs: " + logParser.getUniqueIPs(null, new Date()));
//        System.out.println("IPsForUser: " + logParser.getIPsForUser("Eduard Petrovich Morozko", null, new Date()));
//        System.out.println("IPsForEvent: " + logParser.getIPsForEvent(Event.WRITE_MESSAGE, null, new Date()));
//        System.out.println("IPsForStatus: " + logParser.getIPsForStatus(Status.OK, null, new Date()));
//

//        System.out.println(logParser.getNumberOfUsers(null, date2));
//        System.out.println(logParser.getNumberOfUserEvents("Amigo",date2, null));
//        System.out.println(logParser.getUsersForIP("127.0.0.1",date2, null));
//        System.out.println(logParser.getUsersForIP("192.168.100.2",null, null));

//        System.out.println(logParser.getLoggedUsers(null, null));
//        System.out.println(logParser.getDownloadedPluginUsers(null, null));
//        System.out.println(logParser.getWroteMessageUsers(null, null));
//        System.out.println(logParser.getSolvedTaskUsers(null, null));
//        System.out.println(logParser.getSolvedTaskUsers(null, null, 18));

//        System.out.println(logParser.getDatesForUserAndEvent("Amigo", Event.SOLVE_TASK, null, null));
//        System.out.println(logParser.getDatesWhenSomethingFailed(null, null));
//        System.out.println(logParser.getDatesWhenErrorHappened(null, null));
//        System.out.println(logParser.getDateWhenUserLoggedFirstTime("Amigo", date2, null));
//        System.out.println(logParser.getDateWhenUserSolvedTask("Amigo", 18, null, null));
//        System.out.println(logParser.getDateWhenUserDoneTask("Vasya Pupkin", 15, null, null));
//        System.out.println(logParser.getDatesWhenUserWroteMessage("Eduard Petrovich Morozko", null, null));
//        System.out.println(logParser.getDatesWhenUserDownloadedPlugin("Eduard Petrovich Morozko", null, null));

//        System.out.println(logParser.getNumberOfAllEvents(null, date3));
//        System.out.println(logParser.getAllEvents(null, date3));
//        System.out.println(logParser.getEventsForIP("127.0.0.1", null, date3));
//        System.out.println(logParser.getEventsForUser("Amigo", null, date3));
//        System.out.println(logParser.getFailedEvents( null, date3));
//        System.out.println(logParser.getErrorEvents( null, date3));
//        System.out.println(logParser.getNumberOfAttemptToSolveTask(18, null, date3));
//        System.out.println(logParser.getNumberOfSuccessfulAttemptToSolveTask(18, null, date3));
//        System.out.println(logParser.getAllSolvedTasksAndTheirNumber( null, date3));
//        System.out.println(logParser.getAllDoneTasksAndTheirNumber( null, date3));

//        System.out.println(date1 + " --- " + date2 + " --- " + date3);
//        System.out.println(logParser.execute("get ip"));
//        System.out.println(logParser.execute("get date"));
//        System.out.println(logParser.execute("get event"));
//        System.out.println(logParser.execute("get status"));

//        System.out.println(logParser.execute("get ip for user = \"Vasya Pupkin\""));
//        logParser.execute("get ip for date = \"30.08.2012 16:08:40\"");
//        System.out.println(logParser.execute("get ip for date = \"30.08.2012 16:08:40\""));
//        logParser.execute("get ip for event = \"DONE_TASK\"");
//        System.out.println(logParser.execute("get ip for event = \"DONE_TASK\""));
//        logParser.execute("get ip for status = \"OK\"");

//        System.out.println(logParser.execute("get ip for user = \"Vasya Pupkin\""));
        System.out.println(logParser.execute("get ip for date = \"30.08.2012 16:08:40\""));
//        System.out.println(logParser.execute("get ip for event = \"LOGIN\""));
//        System.out.println(logParser.execute("get ip for status = \"ERROR\""));
//
//        System.out.println(logParser.execute("get user for ip = \"127.0.0.1\""));
        System.out.println(logParser.execute("get user for date = \"30.08.2012 16:08:40\""));
//        System.out.println(logParser.execute("get user for event = \"LOGIN\""));
//        System.out.println(logParser.execute("get user for status = \"ERROR\""));

//        System.out.println(logParser.execute("get date for ip = \"127.0.0.1\""));
//        System.out.println(logParser.execute("get date for user = \"Vasya Pupkin\""));
//        System.out.println(logParser.execute("get date for event = \"LOGIN\""));
//        System.out.println(logParser.execute("get date for status = \"OK\""));

//        System.out.println(logParser.execute("get event for ip = \"127.0.0.1\""));
//        System.out.println(logParser.execute("get event for user = \"Vasya Pupkin\""));
        System.out.println(logParser.execute("get event for date = \"30.08.2012 16:08:40\""));
//        System.out.println(logParser.execute("get event for status = \"ERROR\""));
//
//        System.out.println(logParser.execute("get status for ip = \"127.0.0.1\""));
//        System.out.println(logParser.execute("get status for user = \"Vasya Pupkin\""));
        System.out.println(logParser.execute("get status for date = \"30.08.2012 16:08:40\""));
//        System.out.println(logParser.execute("get status for event = \"LOGIN\""));

        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
        System.out.println(logParser.execute("get ip for user = \"Amigo\" and date between \"30.08.2012 16:08:12\" and \"30.08.2012 16:08:14\""));
        System.out.println(logParser.execute("get ip for date = \"30.08.2012 16:08:40\" and date between \"30.08.2012 16:08:39\" and \"30.08.2012 16:08:41\""));
    }
}