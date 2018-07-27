package com.virtusapolaris.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.virtusapolaris.employeedao.Dao;

public class Employeeserviceimp {
public static String check(String a,String b) throws ClassNotFoundException, SQLException{
	Connection con=Dao.getconnection();
	PreparedStatement pst=con.prepareStatement("select dept from empapp where name=? and password=?");
	pst.setString(1, a);
	pst.setString(2, b);
	ResultSet rs=pst.executeQuery();
	rs.next();
	String i=null;
	String dept=rs.getString(1);
	if(dept.equals("hr")){
		i="10";
	}
	else if(dept.equals("emp")){
		i="20";
	}
	else{
		i="else not found";
	}
	return i;
}
public static ResultSet hr() throws ClassNotFoundException, SQLException{
	
	
	Connection con=Dao.getconnection();
	PreparedStatement pst=con.prepareStatement("select * from empapp");

	ResultSet rs=pst.executeQuery();
	return rs;
	}
public static ResultSet emp(String a,String b) throws ClassNotFoundException, SQLException{
	
	
	Connection con=Dao.getconnection();
	PreparedStatement pst=con.prepareStatement("select * from empapp where name=? and password=?");
	pst.setString(1, a);
	pst.setString(2, b);
	ResultSet rs=pst.executeQuery();
	return rs;
	}
}