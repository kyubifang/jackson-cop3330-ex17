package base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void output_string_includes_legal() {
        App myApp = new App();
        int binary = 1;
        int oz = 3;
        int lbs = 175;
        int hours = (int) ((binary == 1) ? .73 : .66);
        double ratio = .73;
        double bac = (oz * 5.14 / lbs * ratio) - .015 * hours;
        String legal = (bac < 0.08) ? ("It is legal for you to drive.") : ("It is not legal for you to drive.");

        String actualOutput = myApp.generateOutputString(legal);

        assertEquals(legal, actualOutput);
    }
}