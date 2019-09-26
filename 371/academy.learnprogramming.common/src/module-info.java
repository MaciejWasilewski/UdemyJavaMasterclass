module academy.learnprogramming.common {
    requires javafx.base;

    opens academy.learnprogramming.common to javafx.base;

    exports academy.learnprogramming.common;
}