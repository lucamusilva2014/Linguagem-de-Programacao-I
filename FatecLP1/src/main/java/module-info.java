module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.example to javafx.fxml;
    exports org.example;
    exports org.example.Classe;
    opens org.example.Classe to javafx.fxml;
    exports org.example.Controller;
    opens org.example.Controller to javafx.fxml;
}
