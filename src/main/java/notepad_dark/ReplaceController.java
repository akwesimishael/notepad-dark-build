package notepad_dark;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ReplaceController implements Initializable {

    @FXML
    private Button replaceButton;

    @FXML
    private TextField findWhatTextField;

    @FXML
    private TextField replaceWithTextField;

    @FXML
    private Label errorLabel;

    public TextArea primaryTextArea;


    public void replaceOperation(ActionEvent actionEvent) {
        if (primaryTextArea != null) {
            String textAreaText = primaryTextArea.getText();
            String findText = findWhatTextField.getText();
            String replaceText = replaceWithTextField.getText();
            if (textAreaText.contains(findText)) {
                String newTextArea = textAreaText.replace(findText, replaceText);
                primaryTextArea.setText(newTextArea);
                MainController.getReplaceStage().hide();
            } else if (!textAreaText.contains(findText))    {
                errorLabel.setVisible(true);
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        replaceButton.disableProperty().bind(findWhatTextField.textProperty().isEmpty().or(replaceWithTextField.textProperty().isEmpty()));
    }
}
