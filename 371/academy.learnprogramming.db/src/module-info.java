module academy.learnprogramming.db {
    requires transitive academy.learnprogramming.common;
    requires java.sql;
    requires sqlite.jdbc;

    exports academy.learnprogramming.db;
}