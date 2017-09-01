package ru.osipov.calculator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTest {
    private Calculator calculator;
    private Display display = new DisplayStub ();

    @Before
    public void setUp () throws Exception {
        calculator = new Calculator (display);
    }

    @Test
    public void inputDigitFD () throws Exception {
        //
        display.setDisplayText1 ("177.776");
        //
        String  number =  display.getDisplayText1 ();
        //
        assert number == "177.776";
    }

    @Test
    public void inputZeroFD () throws Exception {
        //
        display.setDisplayText1 ("0");
        //
        String number = display.getDisplayText1 ();
        //
        if (display.getDisplayText1 ().equals ("0")){
            display.setDisplayText1 ("0");
        } else display.setDisplayText1 (number);
    }

    @Test
    public void inputDotFD () throws Exception {
        //
        display.setDisplayText1 (".");
        //
        String dot = display.getDisplayText1 ();
        //
        assert dot == ".";
    }

    @Test
    public void inputPlusMinusFD () throws Exception {
        //
        display.setDisplayText1 ("9");
        //
        double number = calculator.inputPlusMinusFD (display.getDisplayText1 ());
        //
        assert number == 9;
    }

    @Test
    public void inputDigitSD () throws Exception {
        //
        display.setDisplayText2 ("123");
        //
        String  number =  display.getDisplayText2 ();
        //
        assert number == "123";


    }


    @Test
    public void inputZeroSD () throws Exception {
        //
        display.setDisplayText2 ("0");
        //
        String number = display.getDisplayText2();
        //
        assert number == "0";
    }

    @Test
    public void inputDotSD () throws Exception {
        //
        display.setDisplayText2 (".");
        //
        String dot = display.getDisplayText2 ();
        //
        assert dot == (".");

        assertEquals(dot, ".");
    }


    @Test
    public void inputPlusMinusSD () throws Exception {
        //given
        display.setDisplayText2 ("142");
        //
        double number = calculator.inputPlusMinusSD (display.getDisplayText2 ());
        //
        assert number == 142;
    }

    @Test
    public void clearDisplay () throws Exception {
        display.setDisplayText1 ("4");
        display.setDisplayText2 ("-12");
        display.setDisplayText2 ("0");
        display.setDisplayText1 ("0");
    }

    @Test
    public void enter () throws Exception {
        Double a = Double.valueOf (display.setDisplayText1 ( "25"));
        Double b = Double.valueOf (display.setDisplayText2 ("5"));
        Double decision = (a / b);
       assert decision == 5;
    }

private static class DisplayStub implements Display {
    private String displayText1;
    private String displayText2;
    private String displayText3;

    @Override
    public String getDisplayText1 () {
        return displayText1;
    }

    @Override
    public String setDisplayText1 (String displayText1) {
        this.displayText1 = displayText1;
        return displayText1;
    }

    @Override
    public String getDisplayText2 () {
        return displayText2;
    }

    @Override
    public String setDisplayText2 (String displayText2) {
        this.displayText2 = displayText2;
        return displayText2;
    }

    @Override
    public String getDisplayText3 () {
        return displayText3;
    }

    @Override
    public String setDisplayText3 (String displayText3) {
        this.displayText3 = displayText3;
        return displayText3;
    }

}
}