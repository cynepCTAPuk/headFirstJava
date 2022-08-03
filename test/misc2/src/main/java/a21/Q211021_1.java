package aaa;

public class Q211021_1 {
}

final class AA {
    private final String value = "";
    public String getValue() {
        return value;
    }
}

final class BB {
    private final String value;
    { value = ""; }
    public String getValue() {
        return value;
    }
}

final class CC {
    private final String value;
    CC() {
        value = "";
    }
    public String getValue() {
        return value;
    }
}
