package com.example.lombok;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AddressTest {

    @Test
    public void testBuildAddress() {
        Address testedObject = Address
                .builder()
                .city("Dublin")
                .street("O'Connell Street")
                .building("General Post Office")
                .build();

        Assert.assertEquals(testedObject.getCity(), "Dublin");
        Assert.assertEquals(testedObject.getStreet(), "O'Connell Street");
        Assert.assertEquals(testedObject.getBuilding(), "General Post Office");

        System.out.println(testedObject.toString());
    }

    @Test
    public void testToBuilder() {
        Address sourceObject = Address
                .builder()
                .city("Dublin")
                .street("O'Connell Street")
                .building("General Post Office")
                .build();

        Address testedObject = sourceObject.toBuilder()
                .building("Belvedere House")
                .build();

        assertThat(testedObject.getCity(), is("Dublin"));
        assertThat(testedObject.getStreet(), is("O'Connell Street"));
        assertThat(testedObject.getBuilding(), is("Belvedere House"));

        System.out.println(sourceObject.toString());
        System.out.println(testedObject.toString());
    }
}