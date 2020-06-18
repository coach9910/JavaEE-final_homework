package org.example.spring.servlet;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {

      private String dbUrl="jdbc:mysql://127.0.0.1:3306/test2";
      private String dbUserName="root";
      private String dbPassword="991015";
      private String jdbcName="com.mysql.jdbc.Driver";


      public Connection getCon() throws Exception{
          Class.forName(jdbcName);
          Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
          return con;
      }


      public void closeCon(Connection con) throws Exception{
          if(con!=null){
              con.close();
          }
      }

      public static void main(String[] args) {
          DbUtil dbUtil=new DbUtil();
          try {
              dbUtil.getCon();
              System.out.println("连接数据库成功！");
          } catch (Exception e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
      }
}