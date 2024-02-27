package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployee {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployee","root","root");
		PreparedStatement preparedStatement=connection.prepareStatement("delete from employee where id=?");
		preparedStatement.setInt(1,103);
		preparedStatement.execute();
		connection.close();
		System.out.println("data deleted");
	}
	catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
}
}
