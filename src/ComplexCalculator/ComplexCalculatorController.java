/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package ComplexCalculator;

import ComplexCalculatorOperation.Calculator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author giasen
 */
public class ComplexCalculatorController implements Initializable {
    
    @FXML
    private ComboBox<?> varList;
    @FXML
    private TextField textInput;
    @FXML
    private ListView<?> stackView;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleEasyButton(ActionEvent event) {
        Button b = (Button) event.getSource();
        textInput.setText(textInput.getText() + b.getText());
    }

    @FXML
    private void handleDeleteAllAction(ActionEvent event) {
        textInput.setText("");
    }

    @FXML
    private void handleDeleteAction(ActionEvent event) {
        String s = textInput.getText().substring(0, textInput.getText().length() - 1);
        textInput.setText(s);
    }

    @FXML
    private void handleMultiplyAction(ActionEvent event) {
        textInput.setText(textInput.getText() + "*");
    }

    @FXML
    private void handleDivisionAction(ActionEvent event) {
        textInput.setText(textInput.getText() + "/");
    }

    @FXML
    private void handleInvertButton(ActionEvent event) {
        textInput.setText(textInput.getText() + "+-");
    }

    @FXML
    private void handleSqrtAction(ActionEvent event) {
        textInput.setText(textInput.getText() + "sqrt");
    }

    @FXML
    private void handleEnter(ActionEvent event) {

    }
    
}
