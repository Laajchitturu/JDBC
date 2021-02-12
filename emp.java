package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class emp {
   public static void main(String[] args) throws ClassNotFoundException,SQLException
   {
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","root");
	  System.out.println("connection Established");
	  PreparedStatement ps=con.prepareStatement("insert into emp(name,age) values('laaj',20)");
	  int res=ps.executeUpdate();
	  System.out.println("insertion done"+res);
	  System.out.println("insertion done"+res);
	  
   }
}
