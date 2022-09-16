package lombock;

import lombok.*;

import java.io.Serializable;

//@ToString
//@Setter
//@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    private String firstName;
    private String secondName;
    private String lastName;
    private int age;
}