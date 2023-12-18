

import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws SQLException {
        String dBURl= "jdbc:mysql://127.0.0.1:3306/joandb";
        String username ="root";
        String password="";
        Statement statement=null;
        ResultSet resultSet=null;
        Connection connection=null;

        try {
            connection= DriverManager.getConnection(dBURl,username,password);
            System.out.println("Connexion successfully good job");
             statement=connection.createStatement();
             resultSet=statement.executeQuery("SELECT *FROM employee");
            statement=connection.createStatement();
            statement.execute("INSERT INTO employee VALUES(NULL,'JACK',23)");
            while (resultSet.next()){
                int Id=resultSet.getInt("Id");
                String name=resultSet.getNString("name");
                int age =resultSet.getInt("age");
                System.out.println("Id:" +Id+" Name: " +name+" age: "+age);

            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        //connection establish now we execute the statements;

    }
}
