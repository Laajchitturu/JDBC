package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class select{
   public static void main(String[] args) throws ClassNotFoundException,SQLException
   {
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","root");
	  System.out.println("connection Established");
	  PreparedStatement ps=con.prepareStatement("select * from emp");
	   ResultSet rs=ps.executeQuery();
	  System.out.println("....done....");
	  
   }
}
