package presentation;

import java.util.List;
import java.util.Scanner;

import model.BankingAcct;
import model.BankingUser;
import service.BankingAcctService;
import service.BankingAcctServiceImpl;
import service.BankingUserService;
import service.BankingUserServiceImpl;

public class BankingManagementSystem {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		BankingUserService bankingUserService = new BankingUserServiceImpl();
		BankingAcctService bankingAcctService = new BankingAcctServiceImpl();
		BankingUser returnedBankingUser = new BankingUser();
		BankingAcct createAcct = new BankingAcct();
		BankingUser newUser = new BankingUser();

		char proceed = 'y';

		while (proceed == 'y') {
			System.out.println("********************************");
			System.out.println("*  BANKING MANAGEMENT SYSTEM   *");
			System.out.println("********************************");
			System.out.println("*     1. Create an Account     *");
			System.out.println("*     2. Account Login         *");
			System.out.println("*     3. Exit                  *");
			System.out.println("********************************");
			System.out.print("   Please Enter an Option: ");

			int selection = scan.nextInt();
			switch (selection) {


			case 1:
				System.out.println("\n   **Input User Information***\n");
				System.out.print("First Name: ");
				scan.nextLine();
				newUser.setFname(scan.nextLine());
				System.out.print("Last Name: ");
				newUser.setLname(scan.nextLine());
				System.out.print("Address: ");
				newUser.setAddress(scan.nextLine());
				System.out.print("Zip Code: ");
				newUser.setZip(scan.nextInt());
				System.out.print("Date of Birth (mmddyyyy): ");
				newUser.setDob(scan.nextInt());
				scan.nextLine();
				System.out.print("Phone Number: ");
				newUser.setPhone(scan.nextLine());
				System.out.println("\n");
				System.out.println("********************************");
				System.out.println("*   SETTING USER CREDENTIALS   *");
				System.out.println("********************************\n");
				System.out.print("Create a Username: ");
				newUser.setUserName(scan.nextLine());
				System.out.print("Create a Password: ");
				newUser.setPassword(scan.nextLine());

				returnedBankingUser = null;
				try {
					returnedBankingUser = bankingUserService.createUser(newUser);

				} catch (Exception e1) {
					System.out.println("*************************************");
					System.out.println("*            SYSTEM ERROR           *");
					System.out.println("*************************************");
					System.out.println("Please try again or exit the program.");
				}
				System.out.println("\nAccount Created!\n\n");

				createAcct.setUser_num(returnedBankingUser.getUser_num());
				bankingAcctService.newAcct(createAcct);
				break;


			case 2:
				BankingUser loginUser = new BankingUser();

				scan.nextLine();
				System.out.print("\nEnter Username: ");
				loginUser.setUserName(scan.nextLine());
				System.out.print("Enter Password: ");
				loginUser.setPassword(scan.nextLine());
				System.out.println("");

				try {
					BankingUser returnedLoginUser = bankingUserService.login(loginUser);
					createAcct.setUser_num(returnedLoginUser.getUser_num());

					int inputtedUser = returnedLoginUser.getUser_num();
					if (inputtedUser != 0) {
						loginUser.setUser_num(inputtedUser);
						System.out.println("***    Login Successful!    ***\n");
					} else {
						System.out.println("You entered the wrong login credentials!");
						System.out.println(" Please try again or exit the program.\n\n");
						break;
					}
				} catch (Exception e) {
					System.out.println("*************************************");
					System.out.println("*            SYSTEM ERROR           *");
					System.out.println("*************************************");
					System.out.println("Please try again or exit the program.");
					break;
				}

				System.out.println("********************************");
				System.out.println("*         USER FEATURES        *");
				System.out.println("********************************");
				System.out.println("*      1. Deposit Funds        *");
				System.out.println("*      2. Withdraw Funds       *");
				System.out.println("*      3. Account Balance      *");
				System.out.println("*      4. Exit                 *");
				System.out.println("*********************************");
				System.out.print("   Please Enter an Option: ");
				int accountSelection = scan.nextInt();
				System.out.println("\n");


				switch (accountSelection) {

				case 1:
					System.out.println("********************************");
					System.out.println("*        ACCOUNT DEPOSIT       *");
					System.out.println("********************************");
					System.out.println("");
					System.out.print("  Enter An Amount to Deposit: ");
					double acctChange = scan.nextDouble();

					try {
						bankingAcctService.depositFunds(createAcct, acctChange);
					} catch (Exception e) {
						System.out.println("*************************************");
						System.out.println("*            SYSTEM ERROR           *");
						System.out.println("*************************************");
						System.out.println("Please try again or exit the program.");
					}
					break;

				case 2:
					System.out.println("********************************");
					System.out.println("*       ACCOUNT WITHDRAW       *");
					System.out.println("********************************\n");
					System.out.print("Enter An Amount to Withdraw: ");
					double acctChange2 = scan.nextDouble();

					try {
						bankingAcctService.withdrawFunds(createAcct, acctChange2);
					} catch (Exception e) {
						System.out.println("*************************************");
						System.out.println("*            SYSTEM ERROR           *");
						System.out.println("*************************************");
						System.out.println("Please try again or exit the program.");
					}
					break;

				case 3:
					System.out.println("********************************");
					System.out.println("*        ACCOUNT BALANCE       *");
					System.out.println("********************************\n");
					bankingAcctService.viewBalance(createAcct);
					break;

				default:
					System.out.println("\n********************************");
					System.out.println("*    THANK YOU FOR USING THE   *");
					System.out.println("*   BANKING MANAGEMENT SYSTEM  *");
					System.out.println("********************************\n");
					System.exit(0);
				}
			case 3:
				System.out.println("\n********************************");
				System.out.println("*    THANK YOU FOR USING THE   *");
				System.out.println("*   BANKING MANAGEMENT SYSTEM  *");
				System.out.println("********************************\n");
				System.exit(0);
			}

		}

	}
}
