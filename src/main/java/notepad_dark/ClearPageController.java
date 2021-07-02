package notepad_dark;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.io.IOException;

public class ClearPageController    {

    public TextArea primaryTextArea;

    @FXML
    public void yesOnAction(ActionEvent actionEvent) throws IOException {
        if (primaryTextArea != null) {
            primaryTextArea.clear();
            MainController.getClearPageStage().hide();
        }
    }

    @FXML
    public void noOnAction(ActionEvent actionEvent) throws IOException {
        MainController.getClearPageStage().hide();
    }
}
