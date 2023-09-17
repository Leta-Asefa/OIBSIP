package atm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import atm.class_designs.Transaction;
import atm.class_designs.UserAccount;

public class TransactionDAO {
	String userName="root";
	String password="0991175590";
	String url="jdbc:mysql://localhost:3306/ATM";
	
	Connection connection=null;
	PreparedStatement statement=null;
	ResultSet result;
	
	public TransactionDAO() {
		try {
			connection=DriverManager.getConnection(url, userName, password);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveTransaction(Transaction transaction) {
		try {
			statement=connection.prepareStatement("insert into transactionTable values (null,?,?,?,?) ");
			statement.setString(1, transaction.getPhone());
			statement.setInt(2, transaction.getAmount());
			statement.setString(3, transaction.getReason());
			statement.setString(4, transaction.getTimeStamp());
			statement.execute();
		
			
			int id;
			statement=connection.prepareStatement("select transactionId from transactionTable where phonefk=? and timestamp=? ");
			statement.setString(1, transaction.getPhone());
			statement.setString(2, transaction.getTimeStamp());
			result=statement.executeQuery();
			result.next();
			id=result.getInt("transactionId");
			
			System.out.println("Transaction Id : "+ id);
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<Transaction> getHistory(UserAccount user){
		List<Transaction>  history=new ArrayList<>();
		try {
			statement=connection.prepareStatement("select * from transactionTable where phonefk=?");
			statement.setString(1, user.getPhone());
			result=statement.executeQuery();
		
			while(result.next()) {
				history.add(new Transaction(result.getInt("transactionId"),
											result.getString("phonefk"),
											result.getInt("amount"),
											result.getString("reason"),
											result.getString("timestamp"))
										);
			}
		
		
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return history;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
