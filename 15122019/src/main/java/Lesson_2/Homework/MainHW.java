package Lesson_2.Homework;

/**
 * 1. Сделать методы для работы с БД (CREATE, UPDATE, DELETE, INSERT, SELECT)
 * 2. Добавить в сетевой логирования входа/выхода + неудачный вход
 */

import java.sql.*;

public class MainHW {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstm;

    public static void main(String[] args) {
        try {
            connect();

            Savepoint spl = connection.setSavepoint();
            try {
//                stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob1', 10)");
//                stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob2', 20)");
//                stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob3', 30)");
             /**
              * Создадим таблицу testTable
              **/
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS testTable (" +
                        "TestID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," +
                        "TestName TEXT NOT NULL ," +
                        "AnotherField TEXT ," +
                        "OneMoreField INTEGER )");
                stmt.executeQuery("SELECT name FROM students WHERE ID > 6099");
                stmt.executeUpdate("INSERT INTO testTable (TestID, TestName, AnotherField, OneMoreField) VALUES (1000, 'Name1', 'Blabla', 1224)");
                stmt.executeUpdate("INSERT INTO testTable (testName, AnotherField, OneMoreField) VALUES ('Name2', 'lablab', 1324)");
                stmt.executeUpdate("INSERT INTO testTable (testName, AnotherField, OneMoreField) VALUES ('Name3', 'ablabl', 1524)");
                stmt.executeQuery("SELECT * FROM testTable");
                /**
                 * У далим строки где значения в стобце OneMoreFiled меньше 1300
                 */

                stmt.executeUpdate("DELETE FROM testTable WHERE OneMoreField < 1300");

                /**
                 *  в столбце AnotherField все значения будут переписаны значениями из столбца OneMoreField
                 */

                stmt.executeUpdate("UPDATE testTable SET [AnotherField] = [OneMoreField]");
                stmt.executeQuery("SELECT * FROM testTable");
                /**
                 * Удаляем тестовую таблицу
                 */

                 stmt.executeUpdate("DROP TABLE testTable");
            } catch (Exception e) {
                connection.rollback(spl);
            }
        
            connection.setAutoCommit(true);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

        // работа с БД
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
