package calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Text output;

    private String operador = "";
    private double num1 = 0.0;
    private double result;
    private Model model = new Model();
    private boolean start = true;
    private boolean num1Value = false;
    private boolean dot = false;
    private boolean num1Negative = false;

    @FXML
    private void processNumber(ActionEvent event) {
        
        if (start) {
            output.setText("");
            start = false;
        }

        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText() + value);
        num1Value = true;
    }

    @FXML
    private void processOperator(ActionEvent event) {

        String value = ((Button) event.getSource()).getText();

        if (!"=".equals(value)) {
            
            if (!operador.isEmpty()) {
                if (operador.equals("-") && num1Value == true) {
                    operador = value;
                    num1 = Double.parseDouble(output.getText());
                    output.setText("");
                    dot = false;
                }
                return;
            }
            
            
            if (value.equals("-")) {
                if (num1Value == true) {
                    operador = value;
                    num1 = Double.parseDouble(output.getText());
                    output.setText("");
                    dot = false;
                    return;
                } else {
                    output.setText(output.getText() + value);
                    start = false;
                    operador = value;
                }
                return;
            }

            
                return;
            }

            operador = value;
            num1 = Double.parseDouble(output.getText());
            output.setText("");
            dot = false;

        } else {
            
                return;
            }

            if (operador.equals("√")) {
                result = model.calculate(num1, 0, operador);
            } else {
                result = model.calculate(num1, Double.parseDouble(output.getText()), operador);
            }

            output.setText(String.valueOf(result));
            start = true;
            operador = "";
            num1Value = false;
        }
    }

    @FXML
    private void processClean(ActionEvent event) {

        num1 = 0.0;
        operador = "";
        output.setText("");
        num1Value = false;
        dot = false;
    }

   
    @FXML
    private void processDot(ActionEvent event) {

        /
        if (start) {
            output.setText("");
            start = false;
        }

        
        if (dot) {
            return;
        }

        
        if (!num1Value) {
            return;
        }

        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText() + value);
        dot = true;
    }
}
