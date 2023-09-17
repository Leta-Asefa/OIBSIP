package atm.class_designs;

public class Transaction {

	private String phone;
	private int amount;
	private String reason;
	private int transactionId;
	private String timeStamp;
	
	public Transaction() {}
	

	public Transaction( int transactionId, String phone,int amount, String reason, String timeStamp) {
		super();
		this.phone = phone;
		this.amount = amount;
		this.reason = reason;
		this.transactionId = transactionId;
		this.timeStamp = timeStamp;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}


	@Override
	public String toString() {
		return "Transaction [phone=" + phone + ", amount=" + amount + ", reason=" + reason + ", transactionId="
				+ transactionId + ", timeStamp=" + timeStamp + "]";
	}
	
	

}
