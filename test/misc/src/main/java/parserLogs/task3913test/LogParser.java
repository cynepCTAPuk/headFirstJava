package parserLogs.task3913test;

import parserLogs.task3913test.query.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private List<LogEntry> entryList;

    public LogParser(Path logDir) {
        entryList = getLogs(logDir);
    }

    public List<LogEntry> getEntryList() {
        return entryList;
    }

    @Override
    public Set<Object> execute(String query) {
        Set<Object> set = new HashSet<>();
        String[] parts = query.split("=");
        if (parts.length == 1) {
            if (query.equals("get ip")) set.addAll(getUniqueIPs(null, null));
            else if (query.equals("get user")) set.addAll(getAllUsers());
            else if (query.equals("get date")) set.addAll(getAllDates());
            else if (query.equals("get event")) set.addAll(getAllEvents(null, null));
            else if (query.equals("get status")) set.addAll(getAllStatus());
        }
        if (parts.length > 1) {
            String[] fields = parts[0].split(" ");
            String field1 = fields[1];
            String field2 = fields[3];
            String value1 = parts[1].substring(2, parts[1].length() - 1);
            System.out.println("get " + field1 + " for " + field2 + " = " + value1);
//            set = execute(fields[0] + " " + fields[3]);
        }
        return set;
    }

    class LogEntry {
        private String ip;
        private String user;
        private Date date;
        private EventEntry eventEntry;

        public LogEntry(String ip, String user, Date date, EventEntry eventEntry) {
            this.ip = ip;
            this.user = user;
            this.date = date;
            this.eventEntry = eventEntry;
        }

        @Override
        public String toString() {
            return "{" + "ip='" + ip + '\'' + ", user='" + user + '\'' +
                    ", date=" + new SimpleDateFormat("y.MM.dd HH:mm:ss").format(date) +
                    ", " + eventEntry + '}';
        }
    }

    class EventEntry {
        private Event event;
        private int task;
        private Status status;

        public EventEntry(Event event, int task, Status status) {
            this.event = event;
            this.task = task;
            this.status = status;
        }

        @Override
        public String toString() {
            String task = this.task == -1 ? "" : ":" + this.task;
            return "[" + event + task + ", status=" + status + ']';
        }
    }

    private void getFiles(List<Path> paths, Path path) {
        if (path == null) return;
        if (!path.toFile().isDirectory()) return;

        File[] files = path.toFile().listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) getFiles(paths, file.toPath());
                else if (file.toString().toLowerCase().endsWith(".log")) paths.add(file.toPath());
            }
        }
    }

    private List<String> getLogStrings(Path path) {
        List<String> result = new ArrayList<>();
        List<Path> paths = new ArrayList<>();
        getFiles(paths, path);
        try {
            for (Path file : paths) result.addAll(Files.readAllLines(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<LogEntry> getLogs(Path path) {
        List<LogEntry> logs = new ArrayList<>();
        for (String string : getLogStrings(path)) {
            String[] strings = string.split("\t");
            Date date = null;
            try {
                date = new SimpleDateFormat("dd.MM.yyyy HH:mm:s").parse(strings[2]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String[] events = strings[3].split(" ");
            Event e = Event.valueOf(events[0]);
            int n = events.length == 2 ? Integer.parseInt(events[1]) : -1;
            Status s = Status.valueOf(strings[4]);
            EventEntry eventEntry = new EventEntry(e, n, s);
            logs.add(new LogEntry(strings[0], strings[1], date, eventEntry));
        }
        return logs;
    }

    private Set<LogEntry> getRecords(Date after, Date before) {
        final Date a = (after == null) ? new Date(Long.MIN_VALUE) : after;
        final Date b = (before == null) ? new Date(Long.MAX_VALUE) : before;
        return entryList.stream()
                .filter(logEntry -> !logEntry.date.before(a))
                .filter(logEntry -> !logEntry.date.after(b))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAllUsers() {
        return entryList.stream()
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet());
    }

    public Set<Date> getAllDates() {
        return entryList.stream()
                .map(logEntry -> logEntry.date)
                .collect(Collectors.toSet());
    }

    public Set<Status> getAllStatus() {
        return entryList.stream()
                .map(logEntry -> logEntry.eventEntry.status)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return getRecords(after, before).stream()
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet()).size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.user.equals(user))
                .map(logEntry -> logEntry.eventEntry.event)
                .collect(Collectors.toSet()).size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.ip.equals(ip))
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.LOGIN))
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.DOWNLOAD_PLUGIN))
                .filter(logEntry -> logEntry.eventEntry.status.equals(Status.OK))
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.WRITE_MESSAGE))
                .filter(logEntry -> logEntry.eventEntry.status.equals(Status.OK))
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.SOLVE_TASK))
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.SOLVE_TASK))
                .filter(logEntry -> logEntry.eventEntry.task == task)
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.DONE_TASK))
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.DONE_TASK))
                .filter(logEntry -> logEntry.eventEntry.task == task)
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.user.equals(user))
                .filter(logEntry -> logEntry.eventEntry.event.equals(event))
                .map(logEntry -> logEntry.date)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.status.equals(Status.FAILED))
                .map(logEntry -> logEntry.date)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.status.equals(Status.ERROR))
                .map(logEntry -> logEntry.date)
                .collect(Collectors.toSet());
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.user.equals(user))
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.LOGIN))
                .map(logEntry -> logEntry.date)
                .sorted()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.user.equals(user))
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.SOLVE_TASK))
                .filter(logEntry -> logEntry.eventEntry.task == task)
                .map(logEntry -> logEntry.date)
                .sorted()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.user.equals(user))
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.DONE_TASK))
                .filter(logEntry -> logEntry.eventEntry.task == task)
                .map(logEntry -> logEntry.date)
                .sorted()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.user.equals(user))
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.WRITE_MESSAGE))
                .filter(logEntry -> logEntry.eventEntry.status.equals(Status.OK))
                .map(logEntry -> logEntry.date)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.user.equals(user))
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.DOWNLOAD_PLUGIN))
                .filter(logEntry -> logEntry.eventEntry.status.equals(Status.OK))
                .map(logEntry -> logEntry.date)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getRecords(after, before).stream()
                .map(logEntry -> logEntry.eventEntry.event)
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return getRecords(after, before).stream()
                .map(logEntry -> logEntry.eventEntry.event)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.ip.equals(ip))
                .map(logEntry -> logEntry.eventEntry.event)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.user.equals(user))
                .map(logEntry -> logEntry.eventEntry.event)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.status.equals(Status.FAILED))
                .map(logEntry -> logEntry.eventEntry.event)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.status.equals(Status.ERROR))
                .map(logEntry -> logEntry.eventEntry.event)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.SOLVE_TASK))
                .filter(logEntry -> logEntry.eventEntry.task == task)
                .mapToInt(logEntry -> 1).sum();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.DONE_TASK))
                .filter(logEntry -> logEntry.eventEntry.task == task)
                .mapToInt(logEntry -> 1).sum();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.SOLVE_TASK))
                .collect(Collectors.toMap(e -> e.eventEntry.task, e -> 1, Integer::sum));
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.DONE_TASK))
                .collect(Collectors.toMap(e -> e.eventEntry.task, e -> 1, Integer::sum));
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getRecords(after, before).stream()
                .map(logEntry -> logEntry.ip)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.user.equals(user))
                .map(logEntry -> logEntry.ip)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(event))
                .map(logEntry -> logEntry.ip)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return getRecords(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.status.equals(status))
                .map(logEntry -> logEntry.ip)
                .collect(Collectors.toSet());
    }
}