public static class MailService<T> implements Consumer<Sendable<T>> {
    private final Map<String, List<T>> map = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            return super.getOrDefault(key, Collections.emptyList());
        }
    };

    public Map<String, List<T>> getMailBox() {
        return map;
    }

    @Override
    public void accept(Sendable<T> sendable) {
        String to = sendable.getTo();
        if (!map.containsKey(to)) {
            map.put(to, new ArrayList<>());
        }
        map.get(to).add(sendable.getContent());
    }
}

public static class MailMessage implements Sendable<String> {
    private final String from;
    private final String to;
    private final String content;

    public MailMessage(String from, String to, String content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public String getContent() {
        return content;
    }
}

public static class Salary implements Sendable<Integer> {
    private final String from;
    private final String to;
    private final int content;

    public Salary(String from, String to, int content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public Integer getContent() {
        return content;
    }
}

public interface Sendable<T> {
    String getFrom();

    String getTo();

    T getContent();
}
