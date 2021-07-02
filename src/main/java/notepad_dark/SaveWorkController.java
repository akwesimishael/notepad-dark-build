package notepad_dark;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class SaveWorkController {

    public TextArea primaryTextArea;

    @FXML
    public void yesOnAction(ActionEvent actionEvent) throws IOException {
        MainController mc = new MainController();
        MainController.getSaveWorkStage().close();


        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("C:\\"));
        fileChooser.setInitialFileName("Document 1");
        fileChooser.setTitle("Save Document");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text File", "*.txt"));
        File file = fileChooser.showSaveDialog(null);

        try {
            if (file != null) {
                mc.SaveFile(primaryTextArea.getText(), file);
            }
        } catch (NullPointerException ne) {
            System.out.println(ne);
        }

        MainController.getSaveWorkStage().close();
        MainApp.getPrimaryStage().close();
        primaryTextArea.setText("");
        MainApp.getPrimaryStage().show();
    }

    @FXML
    public void noOnAction(ActionEvent actionEvent) throws IOException {
        MainController.getSaveWorkStage().close();
        MainApp.getPrimaryStage().close();
        primaryTextArea.setText("");
        MainApp.getPrimaryStage().show();
    }
}
