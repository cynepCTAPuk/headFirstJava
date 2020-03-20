package parser.logParser.task3913;

import com.javarush.task.task39.task3913.query.*;

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
        String[] parts = query.split("=");
        if (parts.length == 1) return getBasicQueries(query);
        if (parts.length == 2) {
            String[] fields1 = parts[0].split(" ");
            String tag = fields1[1];
            String field = fields1[3];
            String[] fields2 = parts[1].split("\"");
            String value = fields2[1];
            String after = null;
            String before = null;
            if (fields2.length > 2) {
                after = fields2[3];
                before = fields2[5];
            }

            Date a = null;
            Date b = null;
            Date date = null;
            try {
                a = (after == null) ? new Date(0) : new SimpleDateFormat("d.M.y H:m:s").parse(after);
                b = (before == null) ? new Date(Long.MAX_VALUE) : new SimpleDateFormat("d.M.y H:m:s").parse(before);
                if (field.equals("date")) date = new SimpleDateFormat("d.M.y H:m:s").parse(value);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String ip = field.equals("ip") ? value : null;
            String user = (field.equals("user")) ? value : null;
            Event event = (field.equals("event")) ? Event.valueOf(value) : null;
            Status status = (field.equals("status")) ? Status.valueOf(value) : null;
            EventEntry eventEntry = new EventEntry(event, null, status);

            if (tag.equals("ip")) return new HashSet<>(getIp(date, user, a, b, eventEntry));
            if (tag.equals("user")) return new HashSet<>(getUser(date, ip, a, b, eventEntry));
            if (tag.equals("event")) return new HashSet<>(getEvent(date, ip, user, a, b, eventEntry));
            if (tag.equals("status")) return new HashSet<>(getStatus(date, ip, user, a, b, eventEntry));
            if (tag.equals("date")) return new HashSet<>(getDate(date, ip, user, a, b, eventEntry));
        }
        return new HashSet<>();
    }

    private Set<Date> getDate(Date date, String ip, String user, Date after, Date before, EventEntry eventEntry) {
        return getRecordsExclude(after, before).stream()
                .filter(logEntry -> ip == null || logEntry.ip.equals(ip))
                .filter(logEntry -> user == null || logEntry.user.equals(user))
                .filter(logEntry -> eventEntry == null || eventEntry.event == null || logEntry.eventEntry.event.equals(eventEntry.event))
                .filter(logEntry -> eventEntry == null || eventEntry.status == null || logEntry.eventEntry.status.equals(eventEntry.status))
                .filter(logEntry -> date == null || logEntry.date.equals(date))
                .map(logEntry -> logEntry.date)
                .collect(Collectors.toSet());

    }

    private Set<Status> getStatus(Date date, String ip, String user, Date after, Date before, EventEntry eventEntry) {
        return getRecordsExclude(after, before).stream()
                .filter(logEntry -> ip == null || logEntry.ip.equals(ip))
                .filter(logEntry -> user == null || logEntry.user.equals(user))
                .filter(logEntry -> eventEntry == null || eventEntry.event == null || logEntry.eventEntry.event.equals(eventEntry.event))
                .filter(logEntry -> date == null || logEntry.date.equals(date))
                .map(logEntry -> logEntry.eventEntry.status)
                .collect(Collectors.toSet());
    }

    private Set<Event> getEvent(Date date, String ip, String user, Date after, Date before, EventEntry eventEntry) {
        return getRecordsExclude(after, before).stream()
                .filter(logEntry -> ip == null || logEntry.ip.equals(ip))
                .filter(logEntry -> user == null || logEntry.user.equals(user))
                .filter(logEntry -> eventEntry == null || eventEntry.status == null || logEntry.eventEntry.status.equals(eventEntry.status))
                .filter(logEntry -> date == null || logEntry.date.equals(date))
                .map(logEntry -> logEntry.eventEntry.event)
                .collect(Collectors.toSet());
    }

    private Set<String> getUser(Date date, String ip, Date after, Date before, EventEntry eventEntry) {
        return getRecordsExclude(after, before).stream()
                .filter(logEntry -> ip == null || logEntry.ip.equals(ip))
                .filter(logEntry -> eventEntry == null || eventEntry.event == null || logEntry.eventEntry.event.equals(eventEntry.event))
                .filter(logEntry -> eventEntry == null || eventEntry.status == null || logEntry.eventEntry.status.equals(eventEntry.status))
                .filter(logEntry -> date == null || logEntry.date.equals(date))
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet());
    }

    private Set<String> getIp(Date date, String user, Date after, Date before, EventEntry eventEntry) {
        return getRecordsExclude(after, before).stream()
                .filter(logEntry -> user == null || logEntry.user.equals(user))
                .filter(logEntry -> eventEntry == null || eventEntry.event == null || logEntry.eventEntry.event.equals(eventEntry.event))
                .filter(logEntry -> eventEntry == null || eventEntry.status == null || logEntry.eventEntry.status.equals(eventEntry.status))
                .filter(logEntry -> date == null || logEntry.date.equals(date))
                .map(logEntry -> logEntry.ip)
                .collect(Collectors.toSet());
    }

    private Set<Object> getBasicQueries(String query) {
        if (query.equals("get ip")) return new HashSet<>(getUniqueIPs(null, null));
        else if (query.equals("get user")) return new HashSet<>(getAllUsers());
        else if (query.equals("get date")) return new HashSet<>(getAllDates());
        else if (query.equals("get event")) return new HashSet<>(getAllEvents(null, null));
        else if (query.equals("get status")) return new HashSet<>(getAllStatus());
        return new HashSet<>();
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
        private Integer task;
        private Status status;

        public EventEntry(Event event, Integer task, Status status) {
            this.event = event;
            this.task = task;
            this.status = status;
        }

        @Override
        public String toString() {
            String task = this.task == null ? "" : ":" + this.task;
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

    private Set<LogEntry> getRecordsExclude(Date after, Date before) {
        return entryList.stream()
                .filter(logEntry -> logEntry.date.after(after))
                .filter(logEntry -> logEntry.date.before(before))
                .collect(Collectors.toSet());
    }

    private Set<LogEntry> getRecordsInclude(Date after, Date before) {
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
        return getRecordsInclude(after, before).stream()
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet()).size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.user.equals(user))
                .map(logEntry -> logEntry.eventEntry.event)
                .collect(Collectors.toSet()).size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.ip.equals(ip))
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.LOGIN))
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.DOWNLOAD_PLUGIN))
                .filter(logEntry -> logEntry.eventEntry.status.equals(Status.OK))
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.WRITE_MESSAGE))
                .filter(logEntry -> logEntry.eventEntry.status.equals(Status.OK))
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.SOLVE_TASK))
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.SOLVE_TASK))
                .filter(logEntry -> logEntry.eventEntry.task == task)
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.DONE_TASK))
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.DONE_TASK))
                .filter(logEntry -> logEntry.eventEntry.task == task)
                .map(logEntry -> logEntry.user)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.user.equals(user))
                .filter(logEntry -> logEntry.eventEntry.event.equals(event))
                .map(logEntry -> logEntry.date)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.status.equals(Status.FAILED))
                .map(logEntry -> logEntry.date)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.status.equals(Status.ERROR))
                .map(logEntry -> logEntry.date)
                .collect(Collectors.toSet());
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.user.equals(user))
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.LOGIN))
                .map(logEntry -> logEntry.date)
                .sorted()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        return getRecordsInclude(after, before).stream()
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
        return getRecordsInclude(after, before).stream()
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
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.user.equals(user))
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.WRITE_MESSAGE))
                .filter(logEntry -> logEntry.eventEntry.status.equals(Status.OK))
                .map(logEntry -> logEntry.date)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.user.equals(user))
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.DOWNLOAD_PLUGIN))
                .filter(logEntry -> logEntry.eventEntry.status.equals(Status.OK))
                .map(logEntry -> logEntry.date)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .map(logEntry -> logEntry.eventEntry.event)
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .map(logEntry -> logEntry.eventEntry.event)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.ip.equals(ip))
                .map(logEntry -> logEntry.eventEntry.event)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.user.equals(user))
                .map(logEntry -> logEntry.eventEntry.event)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.status.equals(Status.FAILED))
                .map(logEntry -> logEntry.eventEntry.event)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.status.equals(Status.ERROR))
                .map(logEntry -> logEntry.eventEntry.event)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.SOLVE_TASK))
                .filter(logEntry -> logEntry.eventEntry.task == task)
                .mapToInt(logEntry -> 1).sum();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.DONE_TASK))
                .filter(logEntry -> logEntry.eventEntry.task == task)
                .mapToInt(logEntry -> 1).sum();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.SOLVE_TASK))
                .collect(Collectors.toMap(e -> e.eventEntry.task, e -> 1, Integer::sum));
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(Event.DONE_TASK))
                .collect(Collectors.toMap(e -> e.eventEntry.task, e -> 1, Integer::sum));
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .map(logEntry -> logEntry.ip)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.user.equals(user))
                .map(logEntry -> logEntry.ip)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.event.equals(event))
                .map(logEntry -> logEntry.ip)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return getRecordsInclude(after, before).stream()
                .filter(logEntry -> logEntry.eventEntry.status.equals(status))
                .map(logEntry -> logEntry.ip)
                .collect(Collectors.toSet());
    }
}