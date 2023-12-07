/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package ComplexCalculator;

import ComplexCalculatorOperation.Calculator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;

/**
 *
 * @author giasen
 */
public class ComplexCalculatorController implements Initializable {

    @FXML
    private ComboBox<Character> varList;
    @FXML
    private TextField textInput;
    @FXML
    private ListView<Complex> stackView;

    private Calculator c = new Calculator();
    private ObservableList<Complex> oblist = FXCollections.observableArrayList();
    private ObservableList<Character> combolist = FXCollections.observableArrayList();

    @FXML
    private Button pushVar;
    @FXML
    private Button popVar;
    @FXML
    private Button sumVar;
    @FXML
    private Button subVar;
    @FXML
    private Button deleteButton;
    @FXML
    private Button enterButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stackView.setItems(oblist);
        initBinding();
        initVarList();

        stackView.setCellFactory(lv -> {
            ListCell<Complex> cell = new ListCell<Complex>() {
                @Override
                protected void updateItem(Complex c, boolean empty) {
                    super.updateItem(c, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(c.toString());
                        setFont(Font.font(15));
                    }
                }
            };
            cell.setAlignment(Pos.CENTER);

            return cell;
        });
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
    private void handleEnter(ActionEvent event) {
        try {
            c.interpreter(textInput.getText());

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            textInput.setText("");
            oblist.setAll(c.getStack());
        }
    }

    private void initBinding() {
        StringProperty btn0 = new SimpleStringProperty(">");
        pushVar.textProperty().bind(Bindings.concat(">", varList.valueProperty()));

        StringProperty btn1 = new SimpleStringProperty("<");
        popVar.textProperty().bind(Bindings.concat("<", varList.valueProperty()));

        StringProperty btn2 = new SimpleStringProperty("+");
        sumVar.textProperty().bind(Bindings.concat("+", varList.valueProperty()));

        StringProperty btn3 = new SimpleStringProperty("-");
        subVar.textProperty().bind(Bindings.concat("-", varList.valueProperty()));
        
        deleteButton.disableProperty().bind(Bindings.isEmpty(textInput.textProperty()));
        enterButton.disableProperty().bind(Bindings.isEmpty(textInput.textProperty()));
    }
    
    private void initVarList(){
        varList.getSelectionModel().select('a');
        for(Character i = 'a'; i <= 'z'; i++){
            combolist.add(i);
        }
        varList.setItems(combolist);
        varList.getSelectionModel().selectFirst();
        
        varList.setCellFactory(lv -> {
            ListCell<Character> cell = new ListCell<Character>() {
                @Override
                protected void updateItem(Character c, boolean empty) {
                    super.updateItem(c, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(c.toString());
                    }
                }
            };
            cell.setAlignment(Pos.CENTER);
            return cell;
        });

    }

    @FXML
    private void handleEnterGeneral(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER) && !textInput.getText().equals("")) {
            try {
            c.interpreter(textInput.getText());
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                textInput.setText("");
                oblist.setAll(c.getStack());
            }
        }
    }
}
