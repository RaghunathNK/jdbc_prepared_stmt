package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateEmployee {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployee","root","root");
		PreparedStatement preparedStatement=connection.prepareStatement("update employee set name=? where id=?");
		preparedStatement.setString(1,"raghuu");
		preparedStatement.setInt(2,10);
		preparedStatement.execute();
		connection.close();
		System.out.println("data updated");
	}
	catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
}
}
