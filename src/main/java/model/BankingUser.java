package model;

public class BankingUser {

	// assign data types to variables used on different project levels
	// must be private for abstraction
	private int user_num;
	private int acct_num;
	private String fname;
	private String lname;
	private String address;
	private int zip;
	private String phone;
	private int dob;
	private String userName;
	private String password;

	
	public BankingUser(int user_num, int acct_num, String fname, String lname, String address, int zip, String phone,
			int dob, String userName, String password) {
		super();
		this.user_num = user_num;
		this.acct_num = acct_num;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.zip = zip;
		this.phone = phone;
		this.dob = dob;
		this.userName = userName;
		this.password = password;
	}


	public BankingUser() {

	}

	public int getAcct_num() {
		return acct_num;
	}

	public int getUser_num() {
		return user_num;
	}


	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}


	public void setAcct_num(int acct_num) {
		this.acct_num = acct_num;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getDob() {
		return dob;
	}

	public void setDob(int dob) {
		this.dob = dob;
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


	@Override
	public String toString() {
		return "BankingUser [user_num=" + user_num + ", acct_num=" + acct_num + ", fname=" + fname + ", lname=" + lname
				+ ", address=" + address + ", zip=" + zip + ", phone=" + phone + ", dob=" + dob + ", userName="
				+ userName + ", password=" + password + "]";
	}

}
