package autosprogi.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AutoTest {

    @Test
    public void testSetRendszam() {
        String rendszam="ABC-123";
        Auto auto = new Auto();
        try {
            auto.setRendszam(rendszam);
        } catch (RosszRendszam rosszRendszam) {
            rosszRendszam.printStackTrace();
        }
    }

    @Test(expected = RosszRendszam.class)
    public void testSetRendszamWithBadParameter() throws RosszRendszam {
        String rendszam="AC-123";
        Auto auto = new Auto();
        auto.setRendszam(rendszam);

    }
}