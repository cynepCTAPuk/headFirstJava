package parser.logParser.task3913.query;

import java.util.Set;

public interface QLQuery {
    Set<Object> execute(String query);
}