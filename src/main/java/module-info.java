module notepad.dark.build {
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.media;
    opens notepad_dark to javafx.fxml;
    exports notepad_dark;
}