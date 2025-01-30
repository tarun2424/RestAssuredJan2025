package demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Connection URL Syntax : jdbc:mysql://[host]:[port]/[database]
		String dbURL = "jdbc:mysql://localhost:3306/emp";
		
		//Database UserName
		String username = "root";
		
		//Database Password
		String password = "root";
		
		//Query to Execute
		String query = "select * from employees";
		
		//load mysql jdbcdriver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Create connetion to DB
		Connection con =DriverManager.getConnection(dbURL,username,password);
		
		//Create Statement Object
		Statement stmt = con.createStatement();
		
		//Execute the SQL query and store results in ResultSet
		ResultSet rs = stmt.executeQuery(query)	;
		
		//While Loop to iterate and print all values
		while(rs.next()) {
			String emp_id = rs.getString(1);
			String first_name = rs.getString(2);
			String last_name = rs.getString(3);
			String salary = rs.getString(4);
			System.out.println(emp_id+"| "+first_name+"| "+last_name+"| "+salary+"| ");
		}
	}

}
