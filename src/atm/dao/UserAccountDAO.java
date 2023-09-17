package atm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import atm.class_designs.UserAccount;

public class UserAccountDAO {

	String userName="root";
	String password="0991175590";
	String url="jdbc:mysql://localhost:3306/ATM";
	
	Connection connection=null;
	PreparedStatement statement=null;
	ResultSet result;
	
	public UserAccountDAO() {
		try {
			connection=DriverManager.getConnection(url, userName, password);
		
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createAccount(UserAccount user) {
		try {
			String query="insert into useraccountTable values(?,?,?,?)";
			statement=connection.prepareStatement(query);
			statement.setString(1, user.getPhone());
			statement.setString(2, user.getUserName());
			statement.setString(3, user.getPassword());
			statement.setInt(4, user.getDepositAmount());
			statement.execute();
		
			System.out.println("saved successfully !");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void deposit(UserAccount user) {
		try {
			String query="update UserAccountTable set amount=? where phone=?";
			statement=connection.prepareStatement(query);
			statement.setInt(1, user.getDepositAmount());
			statement.setString(2, user.getPhone());
			statement.execute();
		
			System.out.println("finished successfully !");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public int getDeposit(UserAccount user) {
	
		int amount = 0;
		try {
			
			String query="select amount from UserAccountTable where phone=?";
			statement=connection.prepareStatement(query);
			statement.setString(1, user.getPhone());
			result=statement.executeQuery();
			result.next();
			amount=result.getInt("amount");
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amount;
	}

	
	public void transfer(UserAccount sender, UserAccount receiver, int amount) {
		try {
			String query="update UserAccountTable set amount=? where phone=? ";
			PreparedStatement statement=connection.prepareStatement("update UserAccountTable set amount=? where phone=?");
			statement.setInt(1, this.getDeposit(sender)-amount);
			statement.setString(2, sender.getPhone());
			statement.execute();
			
			
			String receiveingQuery="update UserAccountTable set amount=? where phone=? ";
			statement=connection.prepareStatement(receiveingQuery);
			statement.setInt(1, this.getDeposit(receiver) + amount);
			statement.setString(2,receiver.getPhone());
			statement.execute();
			
		
			System.out.println("transfered successfully !");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getPassword(UserAccount user) {

		String password = null;
		try {
			
			String query="select password from UserAccountTable where phone=?";
			statement=connection.prepareStatement(query);
			statement.setString(1, user.getPhone());
			result=statement.executeQuery();
			result.next();
			password=result.getString("password");
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
