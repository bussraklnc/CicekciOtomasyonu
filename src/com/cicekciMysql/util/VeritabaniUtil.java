package com.cicekciMysql.util;
import java.sql.*;


public class VeritabaniUtil {
static Connection conn=null;

public static Connection Baglan() {
	try {
		conn=DriverManager.getConnection("jdbc:mysql://localhost/cicekcidb","root","123456");
		return conn;
	} catch (Exception e) {
		System.out.println(e.getMessage().toString());
		return null;
		
	}
	
}
}
