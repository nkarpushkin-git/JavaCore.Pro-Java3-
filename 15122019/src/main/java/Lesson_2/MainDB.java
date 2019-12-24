package Lesson_2;

/**
 * 1. Сделать методы для работы с БД (CREATE, UPDATE, DELETE, INSERT, SELECT)
 * 2. Добавить в сетевой логирования входа/выхода + неудачный вход
 */

import java.sql.*;

public class MainDB {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstm;

    public static void main(String[] args) {
        try {
            connect();

//            ResultSet rs = stmt.executeQuery("SELECT id, name, score FROM students");
//
//            ResultSetMetaData rsmd = rs.getMetaData();
//
//            for (int i = 1; i < rsmd.getColumnCount(); i++) {
//                System.out.println(rsmd.getColumnName(i) + " " + rsmd.getColumnType(i));
//            }
//
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + " " + rs.getString("name"));
//            }

//            long t = System.currentTimeMillis();
//            connection.setAutoCommit(false);
//            for (int i = 0; i < 1000; i++) {
//                stmt.addBatch("INSERT INTO students (name, score)\n" +
//                        "VALUES ('Bob1', 10)");
//                stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob1', 10)");
//            }
//            stmt.executeBatch();
//            connection.setAutoCommit(true);
//            System.out.println(System.currentTimeMillis() - t);

//            int res = stmt.executeUpdate("CREATE TABLE students (" +
//                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                    "name TEXT," +
//                    "score INTEGER)");
//            System.out.println(res);

//            connection.setAutoCommit(false);
//            pstm = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?, ?)");
//            for (int i = 0; i < 1000; i++) {
//                pstm.setString(1, "Bob " + i);
//                pstm.setInt(2, 20 + i);
//                pstm.addBatch();
//            }
//            pstm.executeBatch();
//            connection.setAutoCommit(true);

            Savepoint spl = connection.setSavepoint();
            try {
//                stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob1', 10)");
//                stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob2', 20)");
//                stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob3', 30)");
                //Создадим таблицу testTable
//                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS testTable (" +
//                        "TestID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," +
//                        "TestName TEXT NOT NULL ," +
//                        "AnotherField TEXT ," +
//                        "OneMoreField INTEGER )");
//                stmt.executeQuery("SELECT name FROM students WHERE ID > 6099");
//                stmt.executeUpdate("INSERT INTO testTable (TestID, TestName, AnotherField, OneMoreField) VALUES (1000, 'Name1', 'Blabla', 1224)");
//                stmt.executeUpdate("INSERT INTO testTable (testName, AnotherField, OneMoreField) VALUES ('Name2', 'lablab', 1324)");
//                stmt.executeUpdate("INSERT INTO testTable (testName, AnotherField, OneMoreField) VALUES ('Name3', 'ablabl', 1524)");
//                stmt.executeQuery("SELECT * FROM testTable");
//                stmt.executeUpdate("UPDATE testTable SET [AnotherField] = [OneMoreField]"); //в столбце AnotherField все значения будут переписаны значениями из столбца OneMoreField
//                stmt.executeQuery("SELECT * FROM testTable");
                //Удалим строки где значения в стобце OneMoreFiled меньше 1300
//                stmt.executeUpdate("DELETE FROM testTable WHERE OneMoreField < 1300");
//                stmt.executeQuery("SELECT * FROM testTable");
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
