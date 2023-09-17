package atm;

import atm.class_designs.UserAccount;
import atm.helpers.Input;

public class Main {
	
	public static void main(String[] args) {
	
		
		StartATM atm=new StartATM();
		UserAccount user=new UserAccount();
		System.out.println("# \t 1. Create New Account\t\t#");
		System.out.println("# \t 2. Log in\t\t\t#");
		System.out.println("####################################### \n\n");
		String o=Input.getInstance().nextLine();
		
		
		
		if(o.equals("1")) 
			atm.createAccount();
		else {
			
			atm.line();
		System.out.println("PhoneNumber : ");
		user.setPhone(Input.getInstance().nextLine());
		System.out.println("Password : ");
		user.setPassword(Input.getInstance().nextLine());
		atm.line(); 
		
		boolean bool=atm.isAuthenticated(user);
		
		if(bool)
		{
			System.out.println("########################################");
			System.out.println("Which Service do you want ?");
			System.out.println("1. Deposit");
			System.out.println("2. Withdrawal");
			System.out.println("3. Transfer ");
			System.out.println("4. Balance ");
			System.out.println("5. Transaction History ");
			System.out.println("Any Key. Quit");
			System.out.println("########################################");
			
			String option=Input.getInstance().nextLine();
			
			
			switch (option) {
			
			case "1": 
				atm.deposit(user);
				break;
			case "2":
				atm.withdraw(user);
				break;
			case "3": 
				atm.transfer(user);
				break;
			case "4":
				atm.balance(user);
				break;
			case "5":
				atm.transactionHistory(user);
				break;
			default: System.exit(1);
			}
		}
			
			else {
				System.out.println("Unknown User !");
				
			}
			
			
			
			
		}
			
			
			
			
			
			
			
			
		}
	
	
public static void goToHome(UserAccount user) {
	
	StartATM atm=new StartATM();
	System.out.println("########################################");
	System.out.println("Which Service do you want ?");
	System.out.println("1. Deposit");
	System.out.println("2. Withdrawal");
	System.out.println("3. Transfer ");
	System.out.println("4. Balance ");
	System.out.println("5. Transaction History ");
	System.out.println("Any Key. Quit");
	System.out.println("########################################");
	String option=Input.getInstance().nextLine();
	
	
	switch (option) {
	
	case "1": 
		atm.deposit(user);
		break;
	case "2":
		atm.withdraw(user);
		break;
	case "3": 
		atm.transfer(user);
		break;
	case "4":
		atm.balance(user);
		break;
	case "5":
		atm.transactionHistory(user);
		break;
	default: System.exit(1);
	}
}
	
}

		
	


