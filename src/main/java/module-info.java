module com.nuos {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.nuos to javafx.fxml;
    exports com.nuos;
}
