package atm.class_designs;

public class UserAccount {

	String phone;
	String userName;
	String password;
	int depositAmount;
	
	public UserAccount() {}

	public UserAccount(String phone, String userName, String password, int depositAmount) {
		super();
		this.phone = phone;
		this.userName = userName;
		this.password = password;
		this.depositAmount = depositAmount;
	}



	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}

	@Override
	public String toString() {
		return "UserAccount [phone=" + phone + ", userName=" + userName + ", password=" + password + ", depositAmount="
				+ depositAmount + "]";
	}
	
	

}
