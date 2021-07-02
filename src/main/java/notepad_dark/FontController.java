package notepad_dark;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static javafx.scene.text.Font.*;

public class FontController {

    @FXML
    private TextField currentFontTextField, previewTextField;

    @FXML
    private SplitMenuButton fontSizeDropDown;

    @FXML
    private Label fontStyleStatus;

    public TextArea primaryTextArea;

    public void selectFontFamily(ActionEvent actionEvent) {
        MenuItem menuItem = (MenuItem) actionEvent.getSource();
        String menuItemText = menuItem.getText().trim();

        switch (menuItemText) {
            case "Arial" -> {
                previewTextField.setFont(font("Arial"));
                currentFontTextField.setText("Arial");
            }
            case "Bauhaus 93" -> {
                previewTextField.setFont(font("Bauhaus 93"));
                currentFontTextField.setText("Bauhaus 93");
            }
            case "Calibri" -> {
                previewTextField.setFont(font("Calibri"));
                currentFontTextField.setText("Calibri");
            }
            case "Copperplate Gothic Bold" -> {
                previewTextField.setFont(font("Copperplate Gothic Bold"));
                currentFontTextField.setText("Copperplate Gothic Bold");
            }
            case "Eras Demi ITC" -> {
                previewTextField.setFont(font("Eras Demi ITC"));
                currentFontTextField.setText("Eras Demi ITC");
            }
            case "Felix Titling" -> {
                previewTextField.setFont(font("Felix Titling"));
                currentFontTextField.setText("Felix Titling");
            }
            case "Garamond" -> {
                previewTextField.setFont(font("Garamond"));
                currentFontTextField.setText("Garamond");
            }
            case "MV Boli" -> {
                previewTextField.setFont(font("MV Boli"));
                currentFontTextField.setText("MV Boli");
            }
            case "Papyrus" -> {
                previewTextField.setFont(font("Papyrus"));
                currentFontTextField.setText("Papyrus");
            }
            case "Vonique 43" -> {
                previewTextField.setFont(font("Vonique 43"));
                currentFontTextField.setText("Vonique 43");
            }
        }
    }

    public void chooseFontSize(ActionEvent actionEvent) {
        MenuItem menuItem = (MenuItem) actionEvent.getSource();
        String menuItemText = menuItem.getText().trim();

        String fontFamily = currentFontTextField.getText();

        switch (menuItemText) {
            case "8" -> {
                fontSizeDropDown.setText("8");
                previewTextField.setStyle("-fx-font-size: 8;");
                previewTextField.setFont(font(fontFamily));
            }
            case "9" -> {
                fontSizeDropDown.setText("9");
                previewTextField.setStyle("-fx-font-size: 9;");
                previewTextField.setFont(font(fontFamily));
            }
            case "10" -> {
                fontSizeDropDown.setText("10");
                previewTextField.setStyle("-fx-font-size: 10;");
                previewTextField.setFont(font(fontFamily));
            }
            case "11" -> {
                fontSizeDropDown.setText("11");
                previewTextField.setStyle("-fx-font-size: 11;");
                previewTextField.setFont(font(fontFamily));
            }
            case "12" -> {
                fontSizeDropDown.setText("12");
                previewTextField.setStyle("-fx-font-size: 12;");
                previewTextField.setFont(font(fontFamily));
            }
            case "14" -> {
                fontSizeDropDown.setText("14");
                previewTextField.setStyle("-fx-font-size: 14;");
                previewTextField.setFont(font(fontFamily));
            }
            case "16" -> {
                fontSizeDropDown.setText("16");
                previewTextField.setStyle("-fx-font-size: 16;");
                previewTextField.setFont(font(fontFamily));
            }
            case "18" -> {
                fontSizeDropDown.setText("18");
                previewTextField.setStyle("-fx-font-size: 18;");
                previewTextField.setFont(font(fontFamily));
            }
            case "22" -> {
                fontSizeDropDown.setText("22");
                previewTextField.setStyle("-fx-font-size: 22;");
                previewTextField.setFont(font(fontFamily));
            }
            case "24" -> {
                fontSizeDropDown.setText("24");
                previewTextField.setStyle("-fx-font-size: 24;");
                previewTextField.setFont(font(fontFamily));
            }
            case "28" -> {
                fontSizeDropDown.setText("28");
                previewTextField.setStyle("-fx-font-size: 28;");
                previewTextField.setFont(font(fontFamily));
            }
            case "32" -> {
                fontSizeDropDown.setText("32");
                previewTextField.setStyle("-fx-font-size: 32;");
                previewTextField.setFont(font(fontFamily));
            }
        }
    }

    public void closeAction(ActionEvent actionEvent) {
        MainController.getFontStage().close();
    }

    public void setBold(ActionEvent actionEvent) {
        fontStyleStatus.setText("BOLD");
        String currentFont = currentFontTextField.getText();
        int currentFontSize = Integer.parseInt(fontSizeDropDown.getText());
        previewTextField.setFont(font(currentFont));
        previewTextField.setFont(font(currentFontSize));
        previewTextField.setStyle("-fx-font-weight: bold;");
    }

    public void setItalics(ActionEvent actionEvent) {
        fontStyleStatus.setText("ITALIC");
        String currentFont = currentFontTextField.getText();
        int currentFontSize = Integer.parseInt(fontSizeDropDown.getText());
        previewTextField.setFont(font(currentFont));
        previewTextField.setFont(font(currentFontSize));
        previewTextField.setStyle("-fx-font-style: italic;");
    }

    public void setBoldItalics(ActionEvent actionEvent) {
        fontStyleStatus.setText("BOLD + ITALIC");
        String currentFont = currentFontTextField.getText();
        int currentFontSize = Integer.parseInt(fontSizeDropDown.getText());
        previewTextField.setFont(font(currentFont));
        previewTextField.setFont(font(currentFontSize));
        previewTextField.setStyle("-fx-font-weight: bold;" + "-fx-font-style: italic;");
    }

    public void reset(ActionEvent actionEvent) {
        fontStyleStatus.setText("PLAIN");
        String currentFont = currentFontTextField.getText();
        int currentFontSize = Integer.parseInt(fontSizeDropDown.getText());
        previewTextField.setFont(font(currentFont));
        previewTextField.setFont(font(currentFontSize));
        previewTextField.setStyle("-fx-font-weight: normal;" + "-fx-font-style: normal;");
    }

    public void applyChanges(ActionEvent actionEvent) {
        String currentFont = currentFontTextField.getText();
        int currentFontSize = Integer.parseInt(fontSizeDropDown.getText());
        String fontStyleStat = fontStyleStatus.getText();

        switch (currentFont) {
            case "Arial" -> primaryTextArea.setFont(font("Arial"));
            case "Bauhaus 93" -> primaryTextArea.setFont(font("Bauhaus 93"));
            case "Calibri" -> primaryTextArea.setFont(font("Calibri"));
            case "Copperplate Gothic Bold" -> primaryTextArea.setFont(font("Copperplate Gothic Bold"));
            case "Eras Demi ITC" -> primaryTextArea.setFont(font("Eras Demi ITC"));
            case "Felix Titling" -> primaryTextArea.setFont(font("Felix Titling"));
            case "Garamond" -> primaryTextArea.setFont(font("Garamond"));
            case "MV Boli" -> primaryTextArea.setFont(font("MV Boli"));
            case "Papyrus" -> primaryTextArea.setFont(font("Papyrus"));
            case "Vonique 43" -> primaryTextArea.setFont(font("Vonique 43"));
        }

        switch (currentFontSize) {
            case 8 -> primaryTextArea.setStyle("-fx-font-size: 8;");
            case 9 -> primaryTextArea.setStyle("-fx-font-size: 9;");
            case 10 -> primaryTextArea.setStyle("-fx-font-size: 10;");
            case 11 -> primaryTextArea.setStyle("-fx-font-size: 11;");
            case 12 -> primaryTextArea.setStyle("-fx-font-size: 12;");
            case 14 -> primaryTextArea.setStyle("-fx-font-size: 14;");
            case 16 -> primaryTextArea.setStyle("-fx-font-size: 16;");
            case 18 -> primaryTextArea.setStyle("-fx-font-size: 18;");
            case 22 -> primaryTextArea.setStyle("-fx-font-size: 22;");
            case 24 -> primaryTextArea.setStyle("-fx-font-size: 24;");
            case 28 -> primaryTextArea.setStyle("-fx-font-size: 28;");
            case 32 -> primaryTextArea.setStyle("-fx-font-size: 32;");
        }

        switch (fontStyleStat) {
            case "BOLD" -> primaryTextArea.setStyle("-fx-font-weight: bold;");
            case "ITALIC" -> primaryTextArea.setStyle("-fx-font-style: italic;");
            case "BOLD + ITALIC" -> primaryTextArea.setStyle("-fx-font-weight: bold;" + "-fx-font-style: italic;");
            case "PLAIN" -> primaryTextArea.setStyle("-fx-font-weight: normal;" + "-fx-font-style: normal;");
        }

        MainController.getFontStage().close();
    }
}
