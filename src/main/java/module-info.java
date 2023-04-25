module org.alda.dsm.utl.examenmongonube {
    requires javafx.controls;
    requires javafx.fxml;
    requires gson;
    requires mongo.java.driver;

    opens org.alda.dsm.utl.examenmongonube to javafx.fxml;
    exports org.alda.dsm.utl.examenmongonube;
}