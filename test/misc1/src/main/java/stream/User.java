package stream;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

}
