module com.mycompany.pp_lab6 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.pp_lab6 to javafx.fxml;
    exports com.mycompany.pp_lab6;
}
