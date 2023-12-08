package ComplexCalculator;

import ComplexCalculatorException.InvalidInputException;
import ComplexCalculatorException.NotEnoughDataException;
import ComplexCalculatorException.NotEnoughStackElementsException;
import ComplexCalculatorException.VariableException;
import ComplexCalculatorException.ZeroDivisionException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;

public class ComplexCalculatorController implements Initializable {

    private Calculator c = new Calculator();
    private ObservableList<Complex> oblist = FXCollections.observableArrayList();
    private ObservableList<Character> combolist = FXCollections.observableArrayList();
    private Alert alert;

    @FXML
    private ComboBox<Character> varList;
    @FXML
    private TextField textInput;
    @FXML
    private ListView<Complex> stackView;
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
    @FXML
    private Button numButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stackView.setItems(oblist);
        initBinding();
        initVarList();
        initStackList();
        alert = new Alert(AlertType.ERROR);        
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
        inputSend();
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
            inputSend();
        }
    }

    @FXML
    private void handleFixedButton(ActionEvent event) {
        Button b = (Button) event.getSource();
        textInput.setText(b.getText());
    }
    
    private void inputSend(){
        try {
            c.interpreter(textInput.getText());
        } catch (InvalidInputException e) {
            exceptionDialog("Invalid Input Detected", "Bad input insertion!");
        } catch(NotEnoughDataException e){
            exceptionDialog("Not Enough Data","There isn't enough data in the stack for the operation!");
        } catch(NotEnoughStackElementsException e){
            exceptionDialog("Not Enough Stack Element","There aren't enough elements in the stack!");
        } catch(VariableException e){
            exceptionDialog("Variable Exception","Impossible variable operation inserted!");
        } catch(ZeroDivisionException e){
            exceptionDialog("Zero Division Detected","Impossible division by 0!");
        }
            finally {
            textInput.setText("");
            oblist.setAll(c.getStack());
        }

    }

    private void exceptionDialog(String header, String text){
        alert.setTitle("Exception thrown");
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();
    }

    private void initStackList() {
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
}
