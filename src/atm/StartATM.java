package atm;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import atm.class_designs.Transaction;
import atm.class_designs.UserAccount;
import atm.dao.TransactionDAO;
import atm.dao.UserAccountDAO;
import atm.helpers.HashPassword;
import atm.helpers.Input;

public class StartATM {

	Scanner input=Input.getInstance();
	UserAccountDAO userDao=new UserAccountDAO();
	TransactionDAO historyDao=new TransactionDAO();

	public StartATM() {
		System.out.println("############## Welcome ################");
	}
	public boolean isAuthenticated(UserAccount user) {
		String realPassword=userDao.getPassword(user);
		String enteredPasswrod=user.getPassword();
		if(realPassword.equals(HashPassword.getHashedPassword(enteredPasswrod)))
			return true;
		else
			return false;
	}
	
	public void createAccount() {
		UserAccount user= new UserAccount();
		
		line();
		System.out.println("Enter Your Phone Number : ");
		user.setPhone(input.nextLine());
		System.out.println("Enter Your Name : ");
		user.setUserName(input.nextLine());
		System.out.println("Enter Your Password : ");
		user.setPassword(HashPassword.getHashedPassword(input.nextLine()));
		System.out.println("Enter Your Initial Deposit : ");
		user.setDepositAmount(input.nextInt());
		input.nextLine();
		line();
		
		userDao.createAccount(user);
		Transaction transaction=new Transaction(0,user.getPhone(),user.getDepositAmount(),"Initial",LocalDate.now().toString()+" "+LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString());
		historyDao.saveTransaction(transaction);
		
		endChoice(user);
	}

	public void deposit(UserAccount user) {
		line();
		System.out.println("Enter The Amount : ");
		int amount=input.nextInt();
		user.setDepositAmount(userDao.getDeposit(user) + amount);
		input.nextLine();
		userDao.deposit(user);
		Transaction transaction=new Transaction(0,user.getPhone(), amount,"Deposit",LocalDate.now().toString()+" "+LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString());
		historyDao.saveTransaction(transaction);
		
		endChoice(user);
	}
	
	public void withdraw(UserAccount user) {
		
		System.out.println("Enter The Amount : ");
		int amount=input.nextInt();
		user.setDepositAmount(userDao.getDeposit(user)  - amount);
		input.nextLine();
		userDao.deposit(user);
		Transaction transaction=new Transaction(0,user.getPhone(),-amount,"Withdraw",LocalDate.now().toString()+" "+LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString());
		historyDao.saveTransaction(transaction);
		
		endChoice(user);
	}

	public void transfer(UserAccount sender) {
		
		UserAccount receiver=new UserAccount();
		
		System.out.println("Enter The Receiver Phone Number : ");
		receiver.setPhone(input.nextLine());
		System.out.println("Enter The Amount : ");
		int amount=input.nextInt();  input.nextLine();
		
		userDao.transfer(sender,receiver,amount);
		Transaction senderTransaction=new Transaction(0,sender.getPhone(),-amount,"Transfer",LocalDate.now().toString()+" "+LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString());
		historyDao.saveTransaction(senderTransaction);
		
		Transaction receiverTransaction=new Transaction(0,receiver.getPhone(),amount,"Transfer",LocalDate.now().toString()+" "+LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString());
		historyDao.saveTransaction(receiverTransaction);
		
		endChoice(sender);
	}
	
	public void balance(UserAccount user) {
	System.out.println("Current Balance : "+ userDao.getDeposit(user));	
		endChoice(user);
	}
	
	public void transactionHistory(UserAccount user) {
		List<Transaction> history= historyDao.getHistory(user);
		System.out.println("TransactionID \t Amount \t Reason \t TimeStamp");
		longLine();
		for (Transaction transaction : history) {
			System.out.println(transaction.getTransactionId()+" \t\t "+transaction.getAmount()+" \t\t "+
										transaction.getReason()+" \t "+ transaction.getTimeStamp());
			 		} 
		
		endChoice(user);
	}

	
	public void goToHome() {
		String [] args= {"2"};
		Main.main(args);
	}


	public void line() {
		System.out.println("---------------------------------");
		}

	public void longLine() {
		System.out.println("----------------------------------------------------------------------------------");}

 public void endChoice(UserAccount user) {
	 line();
		System.out.println("1. Home \t (Any Key) Quit");
		line();
		String option= Input.getInstance().nextLine();
		
		if(option.equals("1")) 
			Main.goToHome(user);
		else 
			System.exit(1);
 }











}
