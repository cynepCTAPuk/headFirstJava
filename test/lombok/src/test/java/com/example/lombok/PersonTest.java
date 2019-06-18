package com.example.lombok;
/*
https://easyjava.ru/java/lombok/builder-v-odnu-stroku/
 */
import lombok.val;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PersonTest {

    @Test(expected = NullPointerException.class)
    public void testCantNull() {
        Person testedObject = Person
                .builder()
                .name("Test von Testoff")
                .build();
    }

    @Test
    public void testTwoAddresses() {
        val addr1 = Address
                .builder()
                .city("Dublin")
                .street("O'Connell Street")
                .building("General Post Office")
                .build();

        val addr2 = addr1.toBuilder()
                .building("Belvedere House")
                .build();

        Person testedObject = Person
                .builder()
                .id(1)
                .name("Test von Testoff")
                .address(addr1)
                .address(addr2)
                .build();

        assertThat(testedObject.getAddresses().size(), is(2));

        System.out.println(testedObject.toString());
    }
}