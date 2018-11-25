package ru.bukova.se;
import java.sql.*;
import java.util.Scanner;

public class WorkWithDB {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement prstmt;
    Scanner sc = new Scanner(System.in);

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:shopDB.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void application() {
        try{
            connect();
            stmt.execute("DELETE FROM products");
            stmt.execute("CREATE TABLE IF NOT EXISTS products (id INTEGER PRIMARY KEY AUTOINCREMENT, prodid INTEGER, title TEXT, cost INTEGER)");
            connection.setAutoCommit(false);
            for (int i = 1; i <= 10000; i++) {
                stmt.addBatch("INSERT INTO products  (prodid,title,cost)" +
                        "VALUES ("+i + ",'товар"+i+"'"+","+i*10+")");
            }
            stmt.executeBatch();
            connection.setAutoCommit(true);
            while (true){
                System.out.println("приложение для работы с БД запущено. Для выхода введите 'выход'");
                String command = sc.nextLine();
                if(command.startsWith("цена")){
                    String[] items =command.split(" ",2);
                    prstmt = connection.prepareStatement("SELECT cost FROM products WHERE title =?");
                    prstmt.setString(1, items[1]);
                    ResultSet rs = prstmt.executeQuery();
                    if(rs.next()){
                        System.out.println(rs.getInt("cost"));
                    }
                    else System.out.println("такого товара нет в таблице");
                }
                if(command.startsWith("сменить")){
                    String[] items =command.split(" ",4);
                    prstmt = connection.prepareStatement("UPDATE products SET cost =? WHERE title =?");
                    prstmt.setInt(1, Integer.parseInt(items[3]));
                    prstmt.setString(2,items[2]);
                    prstmt.execute();
                }
                if(command.startsWith("товары")){
                    String[] items =command.split(" ",4);
                    prstmt = connection.prepareStatement("SELECT title FROM products WHERE cost =?");
                    prstmt.setInt(1, Integer.parseInt(items[3]));
                    ResultSet rs=prstmt.executeQuery();
                    boolean flag = true;
                    while(rs.next()){
                        System.out.println(rs.getString("title"));
                        flag = false;
                    }
                    if(flag){
                        System.out.println("товары по такой цене не найдены");
                    }
                }
                if(command.startsWith("выйти")){
                    disconnect();
                    break;
                }
            }
        } catch(
                SQLException e)

        {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
