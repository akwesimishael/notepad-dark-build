package notepad_dark;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.media.AudioClip;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class MainController {

    @FXML
    private TextArea textArea;

    @FXML
    private CheckMenuItem fiftyPercent;

    @FXML
    private CheckMenuItem hundredPercent;

    @FXML
    private CheckMenuItem hundredTwentyFivePercent;

    @FXML
    private CheckMenuItem hundredFiftyPercent;

    @FXML
    private RadioMenuItem darkButton, lightButton;

    @FXML
    private TitledPane statusBar;

    private static Stage clearPageStage = null;
    private static Stage replaceStage = null;
    private static Stage fontStage = null;
    private static Stage stickyStage = null;
    private static Stage saveWorkStage = null;

    public static Stage getSaveWorkStage() {
        return saveWorkStage;
    }

    public void setOnAction(ActionEvent actionEvent) {
        MainApp.getAboutNotepadStage().show();
    }

    public void openNewWindow(ActionEvent actionEvent) throws IOException {
        if (!textArea.getText().equals("")) {
            AudioClip audioClip = new AudioClip(Paths.get("C:\\Users\\Mishael Opoku-Boamah\\Desktop\\Java Files\\java Intellij Projects\\notepad-dark-build\\src\\main\\resources\\notepad_dark\\windows-10-error-sound.mp3").toUri().toString());
            audioClip.play();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("SavePagePrompt.fxml"));
            Parent root = loader.load();
            SaveWorkController saveWorkController = loader.getController();
            saveWorkController.primaryTextArea = textArea;

            saveWorkStage = new Stage();
            saveWorkStage.setTitle("Save Page");
            saveWorkStage.setResizable(false);
            saveWorkStage.initModality(Modality.APPLICATION_MODAL);
            saveWorkStage.initStyle(StageStyle.UTILITY);
            saveWorkStage.setAlwaysOnTop(true);
            saveWorkStage.setScene(new Scene(root));
            saveWorkStage.show();
        } else  {
            MainApp.getPrimaryStage().close();
            textArea.setText("");
            MainApp.getPrimaryStage().show();
        }
    }

    public void saveTextToFile(ActionEvent actionEvent) {
        if (!textArea.getText().equals("")) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("C:\\"));
            fileChooser.setInitialFileName("Document 1");
            fileChooser.setTitle("Save Document");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text File", "*.txt"));
            File file = fileChooser.showSaveDialog(null);

            try {
                if (file != null) {
                    SaveFile(textArea.getText(), file);
                }
            } catch (NullPointerException ne) {
                System.out.println(ne);
            }
        } else {
            AudioClip audioClip = new AudioClip(Paths.get("C:\\Users\\Mishael Opoku-Boamah\\Desktop\\Java Files\\java Intellij Projects\\notepad-dark-build\\src\\main\\resources\\notepad_dark\\windows-10-error-sound.mp3").toUri().toString());
            audioClip.play();
        }
    }

    public void SaveFile(String content, File file){
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public void handleCloseButtonAction(ActionEvent event) {
        MainApp.getPrimaryStage().close();
    }

    public void cutOnAction(ActionEvent actionEvent) {
        textArea.cut();
    }

    public void copyOnAction(ActionEvent actionEvent) {
        textArea.copy();
    }

    public void pasteOnAction(ActionEvent actionEvent) {
        textArea.paste();
    }

    public void clearOnAction(ActionEvent actionEvent) throws IOException {
        if (!textArea.getText().equals("")) {
            AudioClip audioClip = new AudioClip(Paths.get("C:\\Users\\Mishael Opoku-Boamah\\Desktop\\Java Files\\java Intellij Projects\\notepad-dark-build\\src\\main\\resources\\notepad_dark\\windows-10-error-sound.mp3").toUri().toString());
            audioClip.play();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ClearPage.fxml"));
            Parent root = loader.load();
            ClearPageController clearPageController = loader.getController();
            clearPageController.primaryTextArea = textArea;

            clearPageStage = new Stage();
            clearPageStage.setTitle("Clear Page");
            clearPageStage.setResizable(false);
            clearPageStage.initModality(Modality.APPLICATION_MODAL);
            clearPageStage.initStyle(StageStyle.UTILITY);
            clearPageStage.setAlwaysOnTop(true);
            clearPageStage.setScene(new Scene(root));
            clearPageStage.show();
        } else {
            AudioClip audioClip = new AudioClip(Paths.get("C:\\Users\\Mishael Opoku-Boamah\\Desktop\\Java Files\\java Intellij Projects\\notepad-dark-build\\src\\main\\resources\\notepad_dark\\windows-10-error-sound.mp3").toUri().toString());
            audioClip.play();
        }
    }

    public static Stage getClearPageStage()    {
        return clearPageStage;
    }

    public void replaceOnAction(ActionEvent actionEvent) throws IOException {
        if (!textArea.getText().equals("")) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ReplaceWindow.fxml"));
            Parent root = loader.load();
            ReplaceController replaceController = loader.getController();
            replaceController.primaryTextArea = textArea;

            replaceStage = new Stage();
            replaceStage.setScene(new Scene(root));
            replaceStage.setTitle("Replace");
            replaceStage.setResizable(false);
            replaceStage.initStyle(StageStyle.UTILITY);
            replaceStage.initModality(Modality.APPLICATION_MODAL);
            replaceStage.show();
        } else {
            AudioClip audioClip = new AudioClip(Paths.get("C:\\Users\\Mishael Opoku-Boamah\\Desktop\\Java Files\\java Intellij Projects\\notepad-dark-build\\src\\main\\resources\\notepad_dark\\windows-10-error-sound.mp3").toUri().toString());
            audioClip.play();
        }
    }

    public static Stage getReplaceStage()    {
        return replaceStage;
    }

    public void undoOnAction(ActionEvent actionEvent) {
        textArea.undo();
    }

    public void redoOnAction(ActionEvent actionEvent) {
        textArea.redo();
    }

    public void wrapOnAction(ActionEvent actionEvent) {
        textArea.setWrapText(!textArea.isWrapText());
    }

    public void fiftyPercentZoom(ActionEvent actionEvent) {
        textArea.setStyle("-fx-font-size: 10px;");
        fiftyPercent.setSelected(true);
        hundredPercent.setSelected(false);
        hundredTwentyFivePercent.setSelected(false);
        hundredFiftyPercent.setSelected(false);
    }

    public void hundredPercentZoom(ActionEvent actionEvent) {
        textArea.setStyle("-fx-font-size: 14px;");
        fiftyPercent.setSelected(false);
        hundredPercent.setSelected(true);
        hundredTwentyFivePercent.setSelected(false);
        hundredFiftyPercent.setSelected(false);
    }

    public void hundredTwentyFiveZoom(ActionEvent actionEvent) {
        textArea.setStyle("-fx-font-size: 18px;");
        fiftyPercent.setSelected(false);
        hundredPercent.setSelected(false);
        hundredTwentyFivePercent.setSelected(true);
        hundredFiftyPercent.setSelected(false);
    }

    public void hundredFiftyZoom(ActionEvent actionEvent) {
        textArea.setStyle("-fx-font-size: 24px;");
        fiftyPercent.setSelected(false);
        hundredPercent.setSelected(false);
        hundredTwentyFivePercent.setSelected(false);
        hundredFiftyPercent.setSelected(true);
    }

    public void setStatusBarVisible(ActionEvent actionEvent) {
        statusBar.setVisible(!statusBar.isVisible());
    }

    public void fontBoxOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FontGUI.fxml"));
        Parent root = loader.load();
        FontController fc = loader.getController();
        fc.primaryTextArea = textArea;

        fontStage = new Stage();
        fontStage.setScene(new Scene(root));
        fontStage.setTitle("Font");
        fontStage.setResizable(false);
        fontStage.initStyle(StageStyle.UTILITY);
        fontStage.initModality(Modality.APPLICATION_MODAL);
        fontStage.show();
    }

    public static Stage getFontStage()    {
        return fontStage;
    }

    public void setDarkMode(ActionEvent actionEvent) {
        MainApp.getRootNode().getStylesheets().remove(getClass().getResource("light-gui.css").toExternalForm());
        MainApp.getRootNode().getStylesheets().add(getClass().getResource("main-gui.css").toExternalForm());
        darkButton.setSelected(true);
        lightButton.setSelected(false);
    }

    public void setLightMode(ActionEvent actionEvent) {
        MainApp.getRootNode().getStylesheets().remove(getClass().getResource("main-gui.css").toExternalForm());
        MainApp.getRootNode().getStylesheets().add(getClass().getResource("light-gui.css").toExternalForm());
        lightButton.setSelected(true);
        darkButton.setSelected(false);
    }

    public void createStickyStage(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("StickyGUI.fxml"));
        Parent root = loader.load();
        StickyController sc = loader.getController();
        sc.primaryTextArea = textArea;

        stickyStage = new Stage();
        stickyStage.setScene(new Scene(root));
        stickyStage.setTitle("Sticky Note");
        stickyStage.setResizable(false);
        stickyStage.initStyle(StageStyle.DECORATED);
        stickyStage.initModality(Modality.APPLICATION_MODAL);
        stickyStage.show();
    }

    public static Stage getStickyStage() {
        return stickyStage;
    }
}
