package ru.geekbrains.chat.server;

import java.sql.*;

public class AuthService {
    private static Connection connection;
    private static Statement stmt;

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:users.db");
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addUser(String login, String pass, String nick) {
        try {
            String query = "INSERT INTO main (login, password, nickname) VALUES (?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, login);
            ps.setInt(2, pass.hashCode());
            ps.setString(3, nick);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getNickByLoginAndPass(String login, String pass) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT nickname, password FROM main WHERE login = '" + login + "'");
            int myHash = pass.hashCode();
            if (rs.next()) {
                String nick = rs.getString(1);
                int dbHash = rs.getInt(2);
                if (myHash == dbHash) {
                    return nick;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getNickByLogin(String login) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT nickname FROM main WHERE login = '" + login + "'");
            rs.next();
            String nick = rs.toString();
//            if (rs.next()) {
//                String nick = rs.getString(1);
                return nick;
//            }
       } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addLoginLog(String login, String status) {
        try {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS loginLogs (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," +
                    "login TEXT NOT NULL ," +
                    "status TEXT," +
                    "current_timestamp );");
/**
 * 2. Добавить в сетевой чат логирования входа/выхода + неудачный вход
 */
            String query = "INSERT INTO loginLogs (login, status, current_timestamp ) VALUES (?, ?, current_timestamp );";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, login);
           ps.setString(2, status);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addBlackList(String nick, String blockedNick) {
        try {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS blackList (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," +
                    "nick TEXT NOT NULL ," +
                    "blockedNick TEXT);");

            String query = "INSERT INTO blackList (nick, blockedNick) VALUES (?, ?);";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nick);
            ps.setString(2, blockedNick);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void undoBlackList(String nick, String unBlockedNick) {
        try {
            String query = "DELETE FROM blackList WHERE nick = '" + nick + "' AND blockedNick = '" + unBlockedNick + "';";
            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, nick);
//            ps.setString(2, unBlockedNick);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
