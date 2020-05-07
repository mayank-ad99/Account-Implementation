package bankaccountApp;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/* Contain common properties to both the Savings and Checking Accounts */
public abstract class Account implements IBaseRate {
	
	private String name;
	private String sSN;
	protected String accountNumber;
	
	private double balance;
	protected double rate;
	
	private static int index = 10000;
	
	private static Set<String> allCheckingAccountNumbers = new HashSet<>();
	private static Set<String> allSavingAccountNumbers = new HashSet<>();
	
	public Account(String name, String sSN, double initDeposit, int type ){
		this.name = name;
		this.sSN = sSN;
		this.balance = initDeposit;
		
		Set<String> currAccountNumbers; 
		
		if(type == 1){
			currAccountNumbers = allSavingAccountNumbers;
		}
		else{
			currAccountNumbers = allCheckingAccountNumbers;
		}
		
		String accountNumberTest = setAccountNumber();
		while(currAccountNumbers.contains(accountNumberTest)){
			accountNumberTest = setAccountNumber();
		}
		
		this.accountNumber = accountNumberTest;
		currAccountNumbers.add(accountNumberTest);
		
		setRate();
	}
	
	private String setAccountNumber(){
		index++;
		String sSNlastTwo = sSN.substring(sSN.length() - 2);
		int uniqueID = index;
		
		int randomNumber = 100 + new Random().nextInt(900);
		
		return sSNlastTwo + uniqueID + randomNumber;
	}
	
	public abstract void setRate();
	
	
	/* Common Methods
	 * Between the Checking and Savings Class
	 */
	public void showInfo(){
		System.out.println("\nName: " + name + "\nSSN: " + sSN + "\nBalance: $" + balance);
	}
	
	public void printBalance(){
		System.out.println("Your Current Balance is $"+balance+".");
	}
	
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		balance += amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}

	public void withdraw(double amount){
		balance -= amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}
	
	public void transfer(String toWhere, double amount){
		balance -= amount;
		System.out.println("Transferring $" + amount + " to " + toWhere);
		printBalance();
	}
	
	public void compound(){
		double accruedInterest = balance * (rate/100);
		System.out.println("Accrued Interest is: " + accruedInterest);
		balance += accruedInterest;
	}
	
}
