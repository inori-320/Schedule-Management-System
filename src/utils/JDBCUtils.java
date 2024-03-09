package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author lty
 */
public class JDBCUtils {
    private static final DataSource ds;

     static{
         Properties info = new Properties();
         try {
             info.load(new FileInputStream("resources\\jdbc.properties"));
             ds = DruidDataSourceFactory.createDataSource(info);
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
     }

    public static Connection getConnection(){
         Connection connection;
         try {
             connection = ds.getConnection();
         } catch(Exception e){
             throw new RuntimeException(e);
         }
        return connection;
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet){
         try{
             if(connection != null) connection.close();
             if(statement != null) statement.close();
             if(resultSet != null) resultSet.close();
         } catch(Exception e){
             throw new RuntimeException(e);
         }
    }
}
