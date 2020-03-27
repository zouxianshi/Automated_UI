package cn.zxs.test.dao;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://49.233.207.137:3306/ssmdemo";
            String user = "root";
            String password = "silvercrow@6133";
            connection = DriverManager.getConnection(url,user,password);
            String sql = "select * from tb_user where id =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,1l);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("user_name"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getInt("age"));
                System.out.println(resultSet.getDate("birthday"));
            }
            
        }finally {
            if (resultSet!=null){
                resultSet.close();
            }

            if (preparedStatement!=null){
                preparedStatement.close();
            }

            if (connection != null){
                connection.close();
            }
        }
    }
}
