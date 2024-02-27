package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetEmployee {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployee","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("select * from employee");
//			preparedStatement.setString(1,"raghuu");
//			preparedStatement.setInt(2,10);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getInt(3));
				System.out.println(resultSet.getString(4));
				System.out.println(resultSet.getInt(5));
				System.out.println(resultSet.getDouble(6));
				System.out.println("----------------------------");
			}
			connection.close();
			System.out.println("data updated");
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
