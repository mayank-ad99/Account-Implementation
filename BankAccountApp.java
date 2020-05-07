package bankaccountApp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		String file = "C:\\Users\\RIA-Admin\\Downloads\\records.csv";
		
		List<String[]> newAccountHolderData = utilites.CSV.read(file); 

		List<Account> accountsList = new LinkedList<>();
		
		for(String[] accountHolder: newAccountHolderData){
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accType = accountHolder[2];
			double initDeposit = Double.valueOf(accountHolder[3]);
			
			if(accType.equals("Savings")){
				accountsList.add(new Savings(name, sSN, initDeposit));
			}
			else{
				accountsList.add(new Checking(name, sSN, initDeposit));
			}
		}
		System.out.println("-------------");
		for(Account account: accountsList){
			account.showInfo();
		}
		

	}

}
