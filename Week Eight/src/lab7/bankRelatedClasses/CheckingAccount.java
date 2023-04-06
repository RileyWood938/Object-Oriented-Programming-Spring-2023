package lab7.bankRelatedClasses;

import java.util.Comparator;

public class CheckingAccount extends BankAccount implements Comparable<CheckingAccount> {

	private double interestRate;
	private int debitCardTransactions;
	
	public CheckingAccount(int acctNum, double balance, double interestRate)
	{
		super(acctNum, balance);
		this.interestRate = interestRate;
		this.debitCardTransactions = 0;
		
	}
	
	public void payInterest()
	{
		if (this.debitCardTransactions > 10)
			balance += balance * interestRate;
	}
	
	public void incrementDebitCardTRansection() {debitCardTransactions += 1;}
	public void incrementDebitCardTRansection(int k) {debitCardTransactions += k;}
	
	public boolean withdraw(double amount)
	{ 
		if (amount <= this.getBalance())
		{
			this.setBalance(this.getBalance() - amount);
			return true;
		}
		else
			return false;
	}

	@Override
	public int compareTo(CheckingAccount o) {
		if (this.balance < o.getBalance()){
			return -1;
		} else{
			return 1;
		}
	}
}
