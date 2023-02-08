package com.palletech;

import java.sql.*;
import java.util.ArrayList;

public class Student {
	
	PreparedStatement ps = null;
	Connection con = null;
	Statement s = null;
	ResultSet rs = null;
	public static String url = "jdbc:mysql://localhost:3306/palle";
	public static String username = "root";
	public static String password = "Ja19ya97";
	
	
	// create the table
	public void creating()
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,username, password);
			
			s = con.createStatement();

			String qry = "create table student(sno int primary key auto_increment, sname varchar(40) not null,"
					+ " ssub varchar(50), semail varchar(50) unique)";
            
			s.executeUpdate(qry);
		
		} 
		catch (ClassNotFoundException e) 
		{
      		e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				   if(s != null && con != null )
				     {
					
					   s.close();
					   con.close();

				     }
							
                } 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
			
	}
	
	// insert table data
	public void inserting(String name, String sub, String email)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
            con = DriverManager.getConnection(url,username, password);
			
			ps = con.prepareStatement("insert into student(sname,ssub,semail) values(?, ?, ?)");  // dynamic query which takes input so prepare statement

			ps.setString(1, name);
			ps.setString(2, sub);
			ps.setString(3, email);
			
			ps.executeUpdate();
		    } 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				if(ps != null && con != null)
				{
				ps.close();
				con.close();
				}

			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			
		}
		
	}
	
	// updating table data
	public void updating(int no, String sub, String email)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
	        con = DriverManager.getConnection(url,username, password);

	        ps = con.prepareStatement("update student set ssub = ?,semail = ? where sno = ?");
	        
	        ps.setString(1, sub);
	        ps.setString(2, email);
	        ps.setInt(3, no);
	        
	        ps.executeUpdate();
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(ps != null && con != null)
			{
				try {
					ps.close();
					con.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}
	
	// delete table data based on sno
	public void deleting(int no)
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
	        con = DriverManager.getConnection(url,username, password);
	        
	        ps = con.prepareStatement("delete from student where sno = ?");
	        
	        ps.setInt(1, no);
	        
	        ps.executeUpdate();

		    } 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(ps != null && con != null)
			{
				try {
					ps.close();
					con.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		

	}

	//read the data from the table
	public void read()
	{
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
	        con = DriverManager.getConnection(url,username, password);
	        
	        s = con.createStatement();
	        
	       rs =  s.executeQuery("select * from student");
	        
	       while(rs.next())
	       {
	    	   System.out.println(rs.getString("sname"));
	       }
	        

		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs != null && s != null && con != null)
			{
				try {
					rs.close();
					s.close();
					con.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}

	public ArrayList<StudentOne> reading()
	{
		ArrayList<StudentOne> alstud = new ArrayList<StudentOne>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
	        con = DriverManager.getConnection(url,username, password);

	       s = con.createStatement();
	       
	      rs =  s.executeQuery("select * from student");
	       
	       while(rs.next())
	       {
	    	   int i = rs.getInt("sno");
	    	  String n = rs.getString("sname");
	    	   String s = rs.getString("ssub");
	    	  String e = rs.getString("semail");
	    	  
	    	  StudentOne so = new StudentOne(i,n,s,e);
	    	  
	    	  alstud.add(so);
	       }
		    } 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return alstud;
		
		
		
		
	}
}
