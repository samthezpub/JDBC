package org.example;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Hello world!
 */
public class App {
    static Connection connection;

    private static boolean getRandomBoolean() {
        Random random = new Random();

        return random.nextBoolean();
    }

    public static void main(String[] args) {

        Statement statement;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/init", "postgres", "12341234");
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        while (true) {
//            Date date = new Date();
//
//            long currentTime = date.getTime();
//
//            System.out.println(currentTime);
//
//            Message message = new Message("Текущее время " + currentTime, TypeEnum.getRandomType(), getRandomBoolean());
//            String insertSQL = "INSERT INTO notice (message, type, processed) VALUES (?, ?, ?)";
//
//            PreparedStatement preparedStatement = null;
//            try {
//                preparedStatement = connection.prepareStatement(insertSQL);
//                preparedStatement.setString(1, message.getMessage());
//                preparedStatement.setString(2, message.getType());
//                preparedStatement.setBoolean(3, message.isProcessed());
//                preparedStatement.executeUpdate();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }


//            String selectMessagesSQL = "SELECT id, message,type, processed FROM notice WHERE type='INFO' AND processed=false";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(selectMessagesSQL)) {
//                ResultSet resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()){
//                    int id = resultSet.getInt("id");
//                    String message = resultSet.getString("message");
//                    String type = resultSet.getString("type");
//                    boolean processed = resultSet.getBoolean("processed");
//
//                    // Делай что-то с полученными данными, например, выводи их на экран
//                    System.out.println("ID: " + id);
//                    System.out.println("Message: " + message);
//                    System.out.println("Type: " + type);
//                    System.out.println("Processed: " + processed);
//
//                    String deleteMessageSQL = "DELETE FROM notice WHERE id=" + id;
//                    try(PreparedStatement preparedStatement1 = connection.prepareStatement(deleteMessageSQL)) {
//                        int rowsAffected = preparedStatement1.executeUpdate();
//                    }
//                }
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }

        String selectWarnSQL = "SELECT id,message,type,processed FROM notice WHERE type='WARN' AND processed=false";

        try (PreparedStatement preparedStatement1 = connection.prepareStatement(selectWarnSQL)) {
            ResultSet resultSet = preparedStatement1.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String message = resultSet.getString("message");
                String type = resultSet.getString("type");
                boolean processed = resultSet.getBoolean("processed");

                // Делай что-то с полученными данными, например, выводи их на экран
                System.out.println("ID: " + id);
                System.out.println("Message: " + message);
                System.out.println("Type: " + type);
                System.out.println("Processed: " + processed);

                String updateMessageSQL = "UPDATE notice SET processed=true";
                try (PreparedStatement preparedStatement2 = connection.prepareStatement(updateMessageSQL)) {
                    int rowsAffected = preparedStatement2.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

