package com.example.nurse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegisterTest {
    private Register register;

    @Before
    public void setUp() {
        register = new Register();
    }

    @Test
    public void absentObjectReturnsNull() {
        Object something = register.get("absent");
        Assert.assertNull(something);
    }

    @Test
    public void canRegisterSomethingAndRetrieve() {
        Object one = new Object();
        register.add("one", one);
        Object two = new Object();
        register.add("two", two);
        Object retrievedOne = register.get("one");
        Object retrievedTwo = register.get("two");

        Assert.assertNotNull(retrievedOne);
        Assert.assertSame(one, retrievedOne);
        Assert.assertNotNull(retrievedTwo);
        Assert.assertSame(two, retrievedTwo);
        Assert.assertNotSame(retrievedOne, retrievedTwo);
    }

    @Test
    public void canRegisterByTypeAndRetrieve() {
        Glucose glucose = new Glucose();
        register.add(glucose);
        Water water = new Water();
        register.add(water);
        Glucose retriveGlucose = register.get(Glucose.class);
        Water retriveWater = register.get(Water.class);
        Assert.assertSame(glucose, retriveGlucose);
        Assert.assertSame(water, retriveWater);
    }

    @Test(expected = RuntimeException.class)
    public void secondRegisterOfSameNameThrowsException() {
        register.add("same", new Object());
        register.add("same", new Object());
    }

    @Test
    public void patientShouldBeInjectedByGlucose() {
        Glucose glucose = new Glucose();
        register.add(new Patient());
        register.add(glucose);
        register.inject();
        Patient retrievedPatient = register.get(Patient.class);
        Glucose injectedGlucose = retrievedPatient.getGlucose();
        Assert.assertNotNull(injectedGlucose);
        Assert.assertSame(glucose, injectedGlucose);
    }
}
