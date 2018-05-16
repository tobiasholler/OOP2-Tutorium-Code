package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button buttonClear;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button buttonDiv;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button buttonMul;

    @FXML
    private Button button0;

    @FXML
    private Button buttonPlus;

    @FXML
    private Button buttonMinus;

    @FXML
    private Button buttonSum;
    
    @FXML
    private Label anzeige;

    private int operand1;
    
    private char operator;
    
    @FXML
    void clearClicked(ActionEvent event) {
    	anzeige.setText("0");
    }

    @FXML
    void divClicked(ActionEvent event) {
    	String operand1Str = anzeige.getText();
    	operand1 = Integer.parseInt(operand1Str);
    	operator = '/';
    	anzeige.setText("");
    }

    @FXML
    void minusClicked(ActionEvent event) {
    	String operand1Str = anzeige.getText();
    	operand1 = Integer.parseInt(operand1Str);
    	operator = '-';
    	anzeige.setText("");
    }

    @FXML
    void mulClicked(ActionEvent event) {
    	String operand1Str = anzeige.getText();
    	operand1 = Integer.parseInt(operand1Str);
    	operator = '*';
    	anzeige.setText("");
    }

    @FXML
    void numberClicked(ActionEvent event) {
    	Button numberButton = (Button) event.getSource();
    	String zahlStr = numberButton.getText();
    	
    	if (anzeige.getText().equals("0")) anzeige.setText("");
    	anzeige.setText(anzeige.getText() + zahlStr);
    	
    	
//    	Object einObjekt;
//    	einObjekt = event.getSource();
//    	Button einButton;
//    	einButton = (Button) einObjekt;

    }

    @FXML
    void plusClicked(ActionEvent event) {
    	String operand1Str = anzeige.getText();
    	operand1 = Integer.parseInt(operand1Str);
    	operator = '+';
    	anzeige.setText("");
    }

    @FXML
    void sumClicked(ActionEvent event) {
    	int operand2 = Integer.parseInt(anzeige.getText());
    	int ergebnis;
    	switch (operator) {
			case '+':
				ergebnis = operand1 + operand2;
				break;
			case '-':
				ergebnis = operand1 - operand2;
				break;
			case '*':
				ergebnis = operand1 * operand2;
				break;
			case '/':
				if (operand2 == 0) {
					anzeige.setText("Error!");
					return;
				}
				ergebnis = operand1 / operand2;
				break;
			default:
				ergebnis = 0;
		}
    	anzeige.setText(Integer.toString(ergebnis));
    }

}
