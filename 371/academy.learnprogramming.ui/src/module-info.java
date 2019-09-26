module academy.learnprogramming.ui {
//    requires academy.learnprogramming.common;
    requires academy.learnprogramming.db;
//    requires javafx.base;
    //requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    exports academy.learnprogramming.ui to javafx.graphics;

    opens academy.learnprogramming.ui to javafx.fxml;
}