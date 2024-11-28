module oopprj.tetrisgame.tetris {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires javafx.swing;

    opens oopprj.tetrisgame.tetris to javafx.fxml;
    exports oopprj.tetrisgame.tetris;
    exports controllers;
    opens controllers to javafx.fxml;
}