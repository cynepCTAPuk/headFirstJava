package com.example.lombok;
/*
https://easyjava.ru/java/lombok/builder-v-odnu-stroku/
 */
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Person {
    @NonNull
    Integer id;
    String name;
    @Singular
    List<Address> addresses;
}