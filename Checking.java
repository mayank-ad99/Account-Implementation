package bankaccountApp;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Checking extends Account {
	
	private long debitCardNumber;
	private int debitCardPIN;
	
	public Checking(String name, String sSN, double initDeposit){
		super(name,sSN, initDeposit,2);
		System.out.println("Checking Account Created.");
		
		accountNumber = "2" + accountNumber; 
		
		System.out.println("Account Number: " + this.accountNumber);
		
		setDebitCard();
		
	}
	
	private static Set<Long> allDebitCardNumbers = new HashSet<>();
	
	private static long generateRandom() {
	    Random random = new Random();
	    StringBuilder sb = new StringBuilder();

	    // first not 0 digit
	    sb.append(random.nextInt(9) + 1);

	    // rest of 11 digits
	    for (int i = 0; i < 11; i++) {
	        sb.append(random.nextInt(10));
	    }

	    return Long.valueOf(sb.toString()).longValue();
	    
	}
	
	private void setDebitCard(){
		long debitCardNumberTest = generateRandom();
		
		while(allDebitCardNumbers.contains(debitCardNumberTest)){
			debitCardNumberTest = generateRandom();
		}
		
		allDebitCardNumbers.add(debitCardNumberTest);
		this.debitCardNumber = debitCardNumberTest;
		debitCardPIN = 1000 + new Random().nextInt(9000);
	}
	
	public void showInfo(){
		super.showInfo();
		System.out.println("Checking Account.");
		System.out.println("Debit Card Number: " + this.debitCardNumber);
		System.out.println("Debit Card Pin: " + this.debitCardPIN);
	}
	
	public void setRate(){
		this.rate = getBaseRate() * 0.15; 
	}

}
