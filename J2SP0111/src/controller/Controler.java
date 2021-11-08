/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.View;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class Controler {

    private View view;
    private boolean incal = false;
    private boolean reset = false;
  
    private BigDecimal curentNumber;
    private BigDecimal firstNum = new BigDecimal("0");
    private BigDecimal secondNum;
    private String operator = null;
    private DecimalFormat fortmat = new DecimalFormat("0.#########");
    private JTextField text;

    public Controler(View view) {
        this.view = view;
        this.text = view.getTxtDisplay();

        ControlAction();
    }

    private void ControlAction() {
        // Press Number action:
        view.getBtn0().addActionListener((ae) -> { // use lamda expression for funtional interface ActionListener
            PressNumber(view.getBtn0());
        });
        view.getBtn1().addActionListener((ae) -> {
            PressNumber(view.getBtn1());
        });
        view.getBtn2().addActionListener((ae) -> {
            PressNumber(view.getBtn2());
        });
        view.getBtn3().addActionListener((ae) -> {
            PressNumber(view.getBtn3());
        });
        view.getBtn4().addActionListener((ae) -> {
            PressNumber(view.getBtn4());
        });
        view.getBtn5().addActionListener((ae) -> {
            PressNumber(view.getBtn5());
        });
        view.getBtn6().addActionListener((ae) -> {
            PressNumber(view.getBtn6());
        });
        view.getBtn7().addActionListener((ae) -> {
            PressNumber(view.getBtn7());
        });
        view.getBtn8().addActionListener((ae) -> {
            PressNumber(view.getBtn8());
        });
        view.getBtn9().addActionListener((ae) -> {
            PressNumber(view.getBtn9());
        });

        //caculate Action 's
        view.getBtnPlus().addActionListener((ae) -> {
            caculate();
            operator = "+";
        });
        view.getBtnSub().addActionListener((ae) -> {
            caculate();
            operator = "-";
        });
        view.getBtnMul().addActionListener((ae) -> {
            caculate();
            operator = "*";
        });
        view.getBtnDiv().addActionListener((ae) -> {
            caculate();
            operator = "/";
        });
        view.getBtnEqual().addActionListener((ae) -> {
            equal();
        });

        view.getBtnC().addActionListener((ae) -> {
            PressC();
        });

        // press Back action
        view.getBtnBack().addActionListener((ae) -> {
            PressBack();
        });
        //press dot action
        view.getBtnDot().addActionListener((ae) -> {
            pressDot();
        });
        //press negate action
        view.getBtnPorM().addActionListener((ae) -> {
            pressNegate();
        });
        //press invert action
        view.getBtnInvert().addActionListener((ae) -> {
            pressInvert();
        });
        //press precent action
        view.getBtnPercent().addActionListener((ae) -> {
            pressPercent();
        });
        //press sqrt action
        view.getBtnSqrt().addActionListener((ae) -> {
            pressSqrt();
        });
        view.getBtnCE().addActionListener((ae) -> {
            PressC();
        });

    }

    private BigDecimal getNumber() {
        curentNumber = new BigDecimal(text.getText());
        return curentNumber;
    }

    private void PressNumber(JButton button) {
        if (incal == true || reset == true) { // if in the caculator or reset clear text
            text.setText("0");
            incal = false;
            reset = false;
        }
        try {
            curentNumber = new BigDecimal(text.getText() + button.getText());
        } catch (Exception e) {
            text.setText("ERROR");
            reset = true;
            return;
        }

        text.setText(curentNumber.toPlainString());

    }

    private void caculate() {
        if (incal == false) { // before calculate
            if (operator == null) {  //before press 
                if (text.getText().equalsIgnoreCase("ERROR")) {
                    text.setText(firstNum.toPlainString());
                }
                firstNum = getNumber(); // take the number before press operator 
            } else { // after press oper
                secondNum = getNumber();
                switch (operator) {
                    case "+":
                        firstNum = firstNum.add(secondNum);
                        break;
                    case "-":
                        firstNum = firstNum.subtract(secondNum);
                        break;
                    case "*":
                        firstNum = firstNum.multiply(secondNum).setScale(6, RoundingMode.HALF_DOWN);
                        break;
                    case "/":
                        if (secondNum.doubleValue() == 0) {
                            text.setText("ERROR");
                            reset = true; // error reset
                            return;
                        } else {
                            firstNum = firstNum.divide(secondNum, 7, RoundingMode.HALF_UP);
                            break;
                        }

                }

            }

            firstNum = firstNum.stripTrailingZeros(); //  remove unnesscessary zero digit            
            // remove 0 digit in last
            text.setText(firstNum.toPlainString());
            incal = true;
        }
    }

    private void equal() {
        if (text.getText().equalsIgnoreCase("ERROR")) {
            text.setText(firstNum.toPlainString()); // back to first number
        } else {
            caculate();  // just excute on calculate
            operator = null;
        }
    }

    private void PressBack() {
        StringBuilder builder = new StringBuilder(text.getText());
        if (text.getText().equalsIgnoreCase("ERROR")) {  // if error reset 
            text.setText("0");
            reset = true;
        }
        if (text.getText().startsWith("-")) {  
            if (text.getText().length() > 2) {  // if text length than 2 dele
                text.setText(builder.deleteCharAt(text.getText().length() - 1).toString()); // delete last number digit
            } else {
                text.setText("0");
                reset = true;
            }
        } else {
            if (text.getText().length() > 1) {
                text.setText(builder.deleteCharAt(text.getText().length() - 1).toString()); // delete last number 
            } else {
                text.setText("0");
                reset = true;
            }
        }

        incal = false;

    }

    private void PressC() { // clear all
        text.setText("0");
        operator = null;
        incal = false;
        reset = true;
    }

    private void pressDot() {
        if (incal == true || reset == true) { // if in the caculator or reset clear text
            text.setText("0");
            incal = false;
            reset = false;
        }

        if (text.getText().contains(".") == false) {
            text.setText(text.getText() + ".");
        }

    }

    private void pressNegate() {
        equal();
        text.setText(getNumber().negate().toPlainString());
        incal = false;// make it to be first number maybe

    }

    private void pressInvert() {
        equal();
        curentNumber = getNumber(); // take number in text
        if (curentNumber.doubleValue() == 0) {
            text.setText("ERROR");
        } else {
            curentNumber = new BigDecimal(1).divide(curentNumber, 7, RoundingMode.HALF_DOWN).stripTrailingZeros();
           
            text.setText(curentNumber.toPlainString());
            incal = false; // make it to be first number maybe
            
            
        }
        reset = true; // to reset 

    }

    private void pressPercent() {
        equal();
        curentNumber = getNumber();
        curentNumber = curentNumber.divide(new BigDecimal(100));
        text.setText(curentNumber.toPlainString());
        incal = false;
        reset = true;
    }

    private void pressSqrt() {
        if (text.getText().startsWith("-")) { // sqrt can not negative
            text.setText("ERROR");
            reset = true;
        } else {
            curentNumber = getNumber();
            double sqrt = Math.sqrt(curentNumber.doubleValue());
            text.setText(fortmat.format(sqrt));
            incal = false;
            reset = true;
        }
    }

}
