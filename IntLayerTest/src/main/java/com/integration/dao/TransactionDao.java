package com.integration.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.*;

import com.integration.model.Transaction;

public class TransactionDao {

	public TransactionDao(){}
	
	public void addTransaction(Transaction transaction){
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountdb", "root", "root");
			String sql = "INSERT INTO account (`DESCRIPTION`,`VALUE`,`TRANSACTION_TYPE`) VALUES (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, transaction.getDescription());
			ps.setDouble(2,transaction.getValue());
			ps.setString(3, transaction.getTransactionType());
			ps.executeUpdate();
			ps.close();
			conn.close();
		}
		catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void deleteTransaction(Transaction transaction){
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountdb", "root", "root");
			String sql = "DELETE FROM account WHERE TRANSACTION_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, transaction.getTransactionId());
			ps.executeUpdate();
			ps.close();
			conn.close();
		}
		catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public List<Transaction> getAllTransactions(){
		Connection conn = null;
		PreparedStatement ps = null;
		List<Transaction> list = new ArrayList<Transaction>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountdb", "root", "root");
			String sql = "SELECT * FROM account";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Transaction t = new Transaction(rs.getString(2), rs.getDouble(3), rs.getString(4));
				t.setTransactionId(rs.getInt(1));
				list.add(t);
				
			}
			rs.close();
			ps.close();
			conn.close();
		}
		catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}		
		return list;
	}
	
	
	
	
	
	
	
	
}
