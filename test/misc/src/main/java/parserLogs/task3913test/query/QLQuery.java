package parserLogs.task3913test.query;

import java.util.Set;

public interface QLQuery {
    Set<Object> execute(String query);
}