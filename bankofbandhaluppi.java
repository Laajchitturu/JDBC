package jdbc;
import com.mysql.cj.xdevapi.Result;
import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;
class A extends Exception
{
	A(){
		System.out.println("exception raised:");
	}
}
public class bankofbandhaluppi {
     

	     
	    void Withdraw(int w,int n,int c,int u) throws SQLException
		{
		   if(c==1)
		   {     
				try
				   {
			   		 if(n>=w)
			   		 {
			   			int rem=n-w;
			   			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","root");
			   			PreparedStatement ps=con.prepareStatement("UPDATE `bankofbhogpur` SET `balance` = ? WHERE (`accountno` = ?);");
			   			ps.setInt(1, rem);
			   			ps.setInt(2, u);
			   			int i=ps.executeUpdate();
			   			if(i>0)
			   		       System.out.println("amount withdrawn done:  Reamining bal: "+rem);
			   			else
			   				System.out.println("not yet done");
			   		 }
			   		 else
			   		 {
			   			 throw new A();
			   		 }	
				   }catch(A e) {
					   System.out.println(".......INSUFFICIENT FUNDS.......");
					   	e.printStackTrace();
				   }
		   }
		 if(c==2)
		   {
			   try
			   {
		   		 if(w>500)
		   		 {
		   			
		   			 int r=n+w;
		   			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","root");
		   			PreparedStatement ps=con.prepareStatement("UPDATE `bankofbhogpur` SET `balance` = ? WHERE (`accountno` = ?);");
		   			ps.setInt(1, r);
		   			ps.setInt(2, u);
		   			int i=ps.executeUpdate();
		   			 System.out.println("deposited:\navalilable bal : "+r);
		   		 }
		   		 else
		   		 {
		   			 System.out.println("YOU SHOULD CREDIT MORETHAN 500..");throw new A();
		   		 }	
			   }catch(A e) {
				   e.printStackTrace();
			   }
		   } 
		   if(c==3) {
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","root");
			   PreparedStatement ps=con.prepareStatement("select  balance  from  bankofbhogpur where accountno=?;");
			    ps.setInt(1,u);
			    ResultSet rs=ps.executeQuery();
			   // System.out.println(".........................");
	  		   rs.absolute(1);
		       n=rs.getInt(1); 
			  System.out.println("balance is "+n);   
		   }
		   if(c==4)
		   {
			  try { Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","root");
			   PreparedStatement ps=con.prepareStatement("select  balance  from  bankofbhogpur where accountno=?;");
			    ps.setInt(1,w);
			    ResultSet rs=ps.executeQuery(); 
			    rs.absolute(1);
			    int f=rs.getInt(1);
			    System.out.println("enter amount to transfer: ");
			    Scanner sc=new Scanner(System.in);
			    int t=sc.nextInt();
                if(t<=n)
                {   Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","root");
                	PreparedStatement ps1=con.prepareStatement("UPDATE `bankofbhogpur` SET `balance` = ? WHERE (`accountno` = ?);");
		   			ps1.setInt(1, n-t);
		   			ps1.setInt(2, u);
		   			ps1.executeUpdate();
		   			ps1.setInt(1, f+t);
		   			ps1.setInt(2, w);
		   			ps1.executeUpdate();
                }
			  else {System.out.println(".....INSUFFICIENT AMOUNT TO TRANSFER......");throw new A();}
			  }catch(A e)
			  {
				  e.printStackTrace();
			  }
		   }
		
	    
	}
	    void create() throws SQLException{   
			   try{
				   Scanner sc=new Scanner(System.in);
			   
			   System.out.println("enter id card no:");
	 		   int acn=sc.nextInt();
	 		   System.out.println("enter your name:");
	 		   String s=sc.next();
	 		   System.out.println("enter adress:");
	           String add=sc.next();
	           System.out.println("your id card number is your user name and account no..........please don't forget....");
	           System.out.println("enter your username :");
	           int su=sc.nextInt();
	           System.out.println("set a strong password:");
	           String p=sc.next();
	           System.out.println("re enter password:");
	           String p1=sc.next();
	           int count=0;
	           if(p.equals(p1)&&count<2) {
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","root");
	  		   PreparedStatement ps=con.prepareStatement("INSERT INTO `bankofbhogpur` (`accountno`, `name`, `adress`, `password`) VALUES (?, ?, ?,?);");
	  		   ps.setInt(1,acn);
	  		   ps.setString(2, s);
	  		   ps.setString(3,add);
	  		   ps.setString(4,p);
	  		   int i=ps.executeUpdate();
	  		   System.out.println("account created successfully....");
	  		   System.out.println("sno and account no will be sent to your address with in 24 seconds....");}
	           else {System.out.println(".........REENTER CORRECT PASSWORD.........");throw new A();}
			   }catch(A e) {e.printStackTrace();}
	}
		     
	 
		
	public static void main(String [] args) throws ClassNotFoundException, SQLException
	{ 
          
		int user;
		String pass;
		Scanner sc=new Scanner(System.in);
		bankofbandhaluppi bob=new bankofbandhaluppi();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","root");
		System.out.println("connection established succesfully");
		PreparedStatement ps=con.prepareStatement("select * from bankofbhogpur");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getInt(2)+"  "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getString(6));
		}
		System.out.println("Do u have account if yes press 1 or press 0");
		int b=sc.nextInt();
		if(b==1) {
		System.out.println("enetr your username");
		user=sc.nextInt();
		System.out.println("enter your password");
		pass=sc.next();
		PreparedStatement ps1=con.prepareStatement("select * from  bankofbhogpur where accountno=?");
		ps1.setInt(1, user);
		ResultSet rs1=ps1.executeQuery();
		rs1.next();
		int bal=rs1.getInt(4);
		int u=rs1.getInt(2);
		String p=rs1.getString(6);
		if(p.equals(pass) && u==user)
		{
			while(true)
	    	{   
				PreparedStatement ps2=con.prepareStatement("select * from  bankofbhogpur where accountno=?");
				ps2.setInt(1, user);
				ResultSet rs2=ps2.executeQuery();
				rs2.next();
				 bal=rs2.getInt(4);
				 u=rs2.getInt(2);
	    		System.out.println("enter your choice:");
	    		System.out.println("1.withdraw\n2.deposit\n3.showbal\n4.monet transfer\n5.exit");
	    		int c=sc.nextInt();
	    		switch(c)
	    		{
	    		  case 1:   System.out.println("enter amount to withdrawn");
	    		            int w=sc.nextInt();
	    		            bob.Withdraw(w,bal,c,u); 
	    		            break;
	    			         
	    		  case 2:  System.out.println("enter amount to deposit");
	    			       int d=sc.nextInt();
	    			       bob.Withdraw(d,bal,c,u);
	    			       break;
	    			       
	    		    
	    		  case 3: bob.Withdraw(0, bal, c, u); break;
	    		
	    		  case 4: System.out.println("enter recipient account no");
	    		          int r=sc.nextInt();
	    		          bob.Withdraw(r, bal, c, u);
	    		          break;
	    		  case 5: System.exit(0);
	    		 default: System.out.println("enter correct option..");
	    		          break;
	    	    }
		}
		
	}
		}else {
			 bob.create();
		}
	
 }
	
}
