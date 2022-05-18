package model;

public class BankingAcct {
	private int acct_num;
	private int user_num;
	private String acct_type;
	private double acct_balance;
	private double acct_change;




	public BankingAcct(int acct_num, int user_num, String acct_type, double acct_balance, double acct_change) {
		super();
		this.acct_num = acct_num;
		this.user_num = user_num;
		this.acct_type = acct_type;
		this.acct_balance = acct_balance;
		this.acct_change = acct_change;
	}
	
	


	public BankingAcct(int acct_num, int user_num, String acct_type, double acct_balance) {
		super();
		this.acct_num = acct_num;
		this.user_num = user_num;
		this.acct_type = acct_type;
		this.acct_balance = acct_balance;
	}




	public BankingAcct() {

	}


	public int getAcct_num() {
		return acct_num;
	}


	public void setAcct_num(int acct_num) {
		this.acct_num = acct_num;
	}


	public String getAcct_type() {
		return acct_type;
	}


	public void setAcct_type(String acct_type) {
		this.acct_type = acct_type;
	}


	public double getAcct_balance() {
		return acct_balance;
	}


	public void setAcct_balance(double acct_balance) {
		this.acct_balance = acct_balance;
	}


	public double getAcct_change() {
		return acct_change;
	}


	public void setAcct_change(double acct_change) {
		this.acct_change = acct_change;
	}
	

	public int getUser_num() {
		return user_num;
	}


	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}


	@Override
	public String toString() {
		return "BankingAcct [acct_num=" + acct_num + ", user_num=" + user_num + ", acct_type=" + acct_type
				+ ", acct_balance=" + acct_balance + ", acct_change=" + acct_change + "]";
	}






}
