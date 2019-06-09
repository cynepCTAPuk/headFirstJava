package com.example.nurse;

import org.junit.Assert;
import org.junit.Test;

import java.net.URL;

public class XmlTest {

    @Test
    public void shouldSaveConfigurationToXmlFile() {
        Nurse nurse = new Nurse();
        nurse.scan("com.example");
        nurse.register(PatientWithInjectAnnotation.class);
//        nurse.register(Patient.class);

        Register reg = nurse.build();

        Pen pen = new XmlPen("c:/000/nurse/infirmary2.xml");
        pen.write(reg.createInfirmary());
    }

    @Test
    public void shouldReadConfigurationFromXmlFile() {
        URL url = this.getClass().getResource("c:/000/nurse/infirmary.xml");
        Eyes eyes = new XmlEyes(url);
        Infirmary infirmary = eyes.read();

        Nurse nurse = new Nurse();
        Register reg = nurse.registerInfirmary(infirmary).build();
        SimplePatient patient = reg.get(SimplePatient.class).get();

        Assert.assertNotNull(patient);
        Assert.assertNotNull(patient.getGlucose());
    }
}