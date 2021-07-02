package notepad_dark;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class StickyController implements Initializable {

    @FXML
    private TextField titleTextField;

    @FXML
    private TextArea typeTextArea;

    @FXML
    private Label enterTitleLabel, typingAreaLabel;

    @FXML
    private Button stickToMainButton;

    public TextArea primaryTextArea;

    public void changeTitleLabel(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            enterTitleLabel.setText(titleTextField.getText());
            titleTextField.setVisible(false);
            enterTitleLabel.setVisible(true);
        }
    }

    public void changeTextLabel(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            typingAreaLabel.setText(typeTextArea.getText());
            typeTextArea.setVisible(false);
            typingAreaLabel.setVisible(true);
        }
    }

    public void showTextField(MouseEvent mouseEvent) {
        titleTextField.setVisible(true);
        enterTitleLabel.setVisible(false);
    }

    public void showTextArea(MouseEvent mouseEvent) {
        typeTextArea.setVisible(true);
        typingAreaLabel.setVisible(false);
    }

    public void stickToMain(ActionEvent actionEvent) {
        Date date = new Date();
        primaryTextArea.appendText("\n\n" + date + " " + enterTitleLabel.getText() + "\n\n" + typingAreaLabel.getText() + "\n");
        MainController.getStickyStage().close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        stickToMainButton.disableProperty().bind(titleTextField.textProperty().isEmpty().or(typeTextArea.textProperty().isEmpty()));
    }
}
