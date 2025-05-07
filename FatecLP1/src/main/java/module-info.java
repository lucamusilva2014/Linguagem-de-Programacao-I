module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example to javafx.fxml;
    exports org.example;
    exports org.example.Classe;
    opens org.example.Classe to javafx.fxml;
}
