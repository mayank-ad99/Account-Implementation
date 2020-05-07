package bankaccountApp;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Savings extends Account {
	
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
	public Savings(String name, String sSN, double initDeposit){
		super(name,sSN, initDeposit,1);
		System.out.println("Savings Account");
		
		accountNumber = "1" + accountNumber;
		System.out.println("Account Number: " + this.accountNumber);
		
		setSafetyDepostitBox();
	}
	
	private static Set<Integer> allSafetyDepositBoxID = new HashSet<Integer>();
	
	public void showInfo(){
		super.showInfo();
		System.out.println("Your Savings Account Features:\n"
				+ "Safety Deposit Box ID: " + safetyDepositBoxID 
				+ "\nSafety Deposit Box Key: " + safetyDepositBoxKey);
	}
	
	private void setSafetyDepostitBox() {
		int safetyDepositBoxIDTest = 1000 + new Random().nextInt(9000);
		while(allSafetyDepositBoxID.contains(safetyDepositBoxIDTest)){
			safetyDepositBoxIDTest = 1000 + new Random().nextInt(9000);
		}
		
		allSafetyDepositBoxID.add(safetyDepositBoxIDTest);
		safetyDepositBoxID = safetyDepositBoxIDTest; 
		safetyDepositBoxKey = 1000 + new Random().nextInt(9000);
	}
	
	public void setRate(){
		this.rate = getBaseRate() - 0.25;
	}
}
