package ru.osipov.calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller implements Display {

    Calculator calculator;

    public Controller () {
        calculator = new Calculator (this);
    }

    @FXML
    private TextField displayField1, displayField2, displayField3;

    @FXML
    private Button button1, button2, button3, button4, button5, button6,
            button7, button8, button9, button0, buttonDot, buttonPlusMinus;


    @Override
    public String getDisplayText1 () {
        return displayField1.getText ();
    }

    @Override
    public String setDisplayText1 (String displayText2) {
        displayField1.setText (displayText2);
        return displayText2;
    }

    @Override
    public String getDisplayText2 () {
        return displayField2.getText ();
    }

    @Override
    public String setDisplayText2 (String displayText2) {
        displayField2.setText (displayText2);
        return displayText2;
    }

    @Override
    public String getDisplayText3 () {
        return displayField3.getText ();
    }

    @Override
    public String setDisplayText3 (String displayText3) {
        displayField3.setText (displayText3);
        return displayText3;
    }

    public void buttonClearClick () {
        calculator.clearDisplay (this);
    }

    public void setOnThirdDisplay () {
        calculator.enter ();

    }

    public void inputOnSecondDisplay () {
        button1.setOnAction (getActionSecond ());
        button2.setOnAction (getActionSecond ());
        button3.setOnAction (getActionSecond ());
        button4.setOnAction (getActionSecond ());
        button5.setOnAction (getActionSecond ());
        button6.setOnAction (getActionSecond ());
        button7.setOnAction (getActionSecond ());
        button8.setOnAction (getActionSecond ());
        button9.setOnAction (getActionSecond ());
        button0.setOnAction (actionZeroSecondDisplay ());
        buttonDot.setOnAction (actionDotSecondDisplay ());
        buttonPlusMinus.setOnAction (actionPlusMinusSecondDisplay ());
    }

    public void inputOnFirstDisplay () {
        button1.setOnAction (getActionFirst ());
        button2.setOnAction (getActionFirst ());
        button3.setOnAction (getActionFirst ());
        button4.setOnAction (getActionFirst ());
        button5.setOnAction (getActionFirst ());
        button6.setOnAction (getActionFirst ());
        button7.setOnAction (getActionFirst ());
        button8.setOnAction (getActionFirst ());
        button9.setOnAction (getActionFirst ());
        button0.setOnAction (actionZeroFirstDisplay ());
        // buttonDot.setOnAction(new EventHandler<ActionEvent>() { //IDEA заменил на lambda //Разобраться
        buttonDot.setOnAction (actionDotFirstDisplay ());
        buttonPlusMinus.setOnAction (actionPlusMinusFirstDisplay ());
    }

    private EventHandler <ActionEvent> actionPlusMinusSecondDisplay () {
        return event -> {
            Button button = (Button) event.getSource ();
            String digit = button.getText ();
            calculator.inputPlusMinusSD (digit);
        };
    }



    private EventHandler <ActionEvent> actionDotSecondDisplay () {
        return event -> {
            Button button = (Button) event.getSource ();
            String digit = button.getText ();
            calculator.inputDotSD (digit);
        };
    }



    private EventHandler <ActionEvent> actionZeroSecondDisplay () {
        return event -> {
            Button button = (Button) event.getSource ();
            String digit = button.getText ();
            calculator.inputZeroSD (digit);
        };
    }


    private EventHandler <ActionEvent> getActionSecond () {
        return event -> {
            Button button = (Button) event.getSource ();
            String digit = button.getText ();
            calculator.inputDigitSD (digit);
        };
    }


    private EventHandler <ActionEvent> actionPlusMinusFirstDisplay () {
        return event -> {
            Button button = (Button) event.getSource ();
            String digit = button.getText ();
            calculator.inputPlusMinusFD (digit);
        };
    }



    private EventHandler <ActionEvent> actionDotFirstDisplay () {
        return event -> {
            Button button = (Button) event.getSource ();
            String digit = button.getText ();
            calculator.inputDotFD (digit);
        };
    }



    private EventHandler <ActionEvent> actionZeroFirstDisplay () {
        return event -> {
            Button button = (Button) event.getSource ();
            String digit = button.getText ();
            calculator.inputZeroFD (digit);
        };
    }

    private EventHandler <ActionEvent> getActionFirst () {
        return event -> {
            Button button = (Button) event.getSource ();
            String digit = button.getText ();
            calculator.inputDigitFD (digit);
        };
    }


}
