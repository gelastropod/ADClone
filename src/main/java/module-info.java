module com.example.adclone {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.adclone to javafx.fxml;
    exports com.example.adclone;
    exports com.example.adclone.Controller;
    opens com.example.adclone.Controller to javafx.fxml;
}