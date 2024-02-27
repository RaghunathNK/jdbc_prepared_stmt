package com.ty;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Employee {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);

		while(true)
		{
		System.out.println("enter the emp id");
		int id=s.nextInt();
		System.out.println("enter the emp name");
		String name=s.next();
		System.out.println("enter the emp age");
		int age=s.nextInt();
		System.out.println("enter the emp gender");
		String gender=s.next();
		System.out.println("enter the emp phno");
		int phno=s.nextInt();
		System.out.println("enter the emp salary");
		double sal=s.nextDouble();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployee","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2,name);
			preparedStatement.setInt(3, age);
			preparedStatement.setString(4,gender);
			preparedStatement.setInt(5, phno);
			preparedStatement.setDouble(6, sal);
			preparedStatement.execute();
			connection.close();
			System.out.println("data saved");
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		}
	}
}
