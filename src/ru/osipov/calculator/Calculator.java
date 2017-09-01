package ru.osipov.calculator;

import java.math.BigDecimal;

public class Calculator {
    private final Display display;
    private String opearator;

    public Calculator (Display display) {
        this.display = display;
    }

    public void inputDigitFD (String digit) {
        System.out.println ("Button with number " + digit + " is clicked");
        if (! display.getDisplayText1 ().equals ("0")) {
            display.setDisplayText1 (display.getDisplayText1 () + digit);
        } else display.setDisplayText1 (digit);
        System.out.println ("First display = " + display.getDisplayText1 ());
    }

    public void inputZeroFD (String digit) {
        System.out.println ("Button with number " + digit + " is clicked");
        if (! display.getDisplayText1 ().equals ("0")) {
            display.setDisplayText1 (display.getDisplayText1 () + digit);
        }
        System.out.println ("First display = " + display.getDisplayText1 ());
    }

    public void inputDotFD (String digit) {
        System.out.println ("Button with number " + digit + " is clicked");
        if (! display.getDisplayText1 ().contains (".") && ! display.getDisplayText1 ().equals ("")) {
            display.setDisplayText1 (display.getDisplayText1 () + digit);
        }
        System.out.println ("First display = " + display.getDisplayText1 ());
    }

    public double inputPlusMinusFD (String digit) {
        System.out.println ("Button with number " + digit + " is clicked");
        double number = Double.parseDouble (display.getDisplayText1 ());
        display.setDisplayText1 (String.valueOf (number * - 1));
        System.out.println ("Second display = " + display.getDisplayText1 ());
        return number;
    }

    public void inputDigitSD (String digit) {
        System.out.println ("Button with number " + digit + " is clicked");
        if (! display.getDisplayText2 ().equals ("0")) {
            display.setDisplayText2 (display.getDisplayText2 () + digit);
        } else display.setDisplayText2 (digit);
        System.out.println ("Second display = " + display.getDisplayText2 ());
    }

    public void inputZeroSD (String digit) {
        System.out.println ("Button with number " + digit + " is clicked");
        if (! display.getDisplayText2 ().equals ("0")) {
            display.setDisplayText2 (display.getDisplayText2 () + digit);
        }
        System.out.println ("Second display = " + display.getDisplayText2 ());
    }

    public void inputDotSD (String digit) {
        System.out.println ("Button with number " + digit + " is clicked");
        if (! display.getDisplayText2 ().contains (".") && ! display.getDisplayText2 ().equals ("")) {
            display.setDisplayText2 (display.getDisplayText2 () + ".");
        }
        System.out.println ("Second display = " + display.getDisplayText2 ());
    }

    public double inputPlusMinusSD (String digit) {
        System.out.println ("Button with number " + digit + " is clicked");
        double number = Double.parseDouble (display.getDisplayText2 ());
        display.setDisplayText2 (String.valueOf (number * - 1));
        System.out.println ("Second display = " + display.getDisplayText2 ());
        return number;
    }

    void clearDisplay (Controller controller) {
        controller.setDisplayText1 ("0");
        controller.setDisplayText2 ("0");
        controller.setDisplayText3 ("0");
    }

//    public void operator(String opearator){
//        this.opearator = opearator;
//        String leftOp = display.setDisplayText1 (display.getDisplayText1 ());
//        String rightOp = display.setDisplayText2 (display.getDisplayText2 ());
//    }

    public void enter () {
        try {
            Double leftOp = Double.valueOf (display.setDisplayText1 (display.getDisplayText1 ()));
            Double rightOp = Double.valueOf (display.setDisplayText2 (display.getDisplayText2 ()));
            double decision = (leftOp / rightOp);
            System.out.println (leftOp / rightOp);
            display.setDisplayText3 (String.valueOf (decision));
            if (!display.getDisplayText1 ().equals ("0") && display.getDisplayText2 ().equals ("0")){
                display.setDisplayText3 ("Нельзя разделить на 0");}
            if (display.getDisplayText1 ().equals ("0") && display.getDisplayText2 ().equals ("0")) {
                display.setDisplayText3 ("Вы ничего не ввели");
            }
        } catch (Exception ex) {
            System.out.println ("Invalid input data");
            display.setDisplayText3 ("Неправильный ввод");
        }
    }
}
