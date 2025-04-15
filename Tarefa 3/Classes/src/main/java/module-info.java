module org.example {
    requires javafx.fxml;
    requires org.controlsfx.controls;

    opens org.example to javafx.fxml;
    exports org.example;
}
