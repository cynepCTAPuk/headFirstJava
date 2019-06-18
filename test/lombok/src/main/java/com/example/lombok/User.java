package com.example.lombok;

import lombok.Getter;
import lombok.Setter;

public class User {
    private @Getter String name;
    private @Getter String nick;
    private @Getter @Setter boolean loggedIn;
}
