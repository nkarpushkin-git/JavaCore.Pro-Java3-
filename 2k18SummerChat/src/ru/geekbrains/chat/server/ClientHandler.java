package ru.geekbrains.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String nick;

    List<String> blackList;

    public String getNick() {
        return nick;
    }

    public ClientHandler(Server server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.blackList = new ArrayList<>();
            new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/auth")) { // /auth login72 pass72
                            String[] tokens = str.split(" ");
                            String newNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);
                            if (newNick != null) {
                                if (!server.isNickBusy(newNick)) {
                                    sendMsg("/authok");
                                    nick = newNick;
                                    server.subscribe(this);
                                    AuthService.addLoginLog(tokens[1], "succesful");
                                    break;
                                } else {
                                    sendMsg("Учетная запись уже используется");
                                    AuthService.addLoginLog(tokens[1], "loginBusy");
                                }
                            } else {
                                sendMsg("Неверный логин/пароль");
                                AuthService.addLoginLog(tokens[1], "wrongCredentials");
                            }
                        }
                    }
                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/create")) { // /auth login72 pass72 nick72
                            String[] tokens = str.split(" ");
                            //здесь надо добавить проверку на совпадения в БД
//                            String newNUser = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);
                            AuthService.addUser(tokens[1], tokens[2], tokens[3]);
                            break;
//                            if (newNUser != null) {
//                                if (!server.isNickBusy(newNUser)) {
//
////                                    sendMsg("/authok");
//                                    sendMsg("Учетная запись успешно создана");
////                                    nick = newNUser;
////                                    server.subscribe(this);
//                                    break;
//                                } else {
//                                    sendMsg("Учетная запись уже существует");
//                                }
//                            } else {
//                                sendMsg("Неверный логин/пароль/nickname");
//                            }
                        } break;
                    }
                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/")) {
                            if (str.startsWith("/end")) {
                                out.writeUTF("/serverclosed");
                                AuthService.addLoginLog(nick, "logOut");
                                break;
                            }
                            if (str.startsWith("/w ")) { // /w nick3 lsdfhldf sdkfjhsdf wkerhwr
                                String[] tokens = str.split(" ", 3);
                                String m = str.substring(tokens[1].length() + 4);
                                server.sendPersonalMsg(this, tokens[1], tokens[2]);
                            }
                            if (str.startsWith("/blacklist ")) { // /blacklist nick3
                                String[] tokens = str.split(" ");
                                blackList.add(tokens[1]);
                                AuthService.addBlackList(nick, tokens[1]);
                                sendMsg("Вы добавили пользователя " + tokens[1] + " в черный список");
                            }
                            if (str.startsWith("/undoblacklist ")) { // /blacklist nick3
                                String[] tokens = str.split(" ");
                                blackList.add(tokens[1]);
                                AuthService.undoBlackList(nick, tokens[1]);
                                sendMsg("Вы удалили пользователя " + tokens[1] + " из чернго списка");
                            }
                        } else {
                            server.broadcastMsg(this, nick + ": " + str);
                        }
                        System.out.println("Client: " + str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    server.unsubscribe(this);
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkBlackList(String nick) {
        return blackList.contains(nick);
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
