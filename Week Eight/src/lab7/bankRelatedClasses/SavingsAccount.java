package lab7.bankRelatedClasses;

public class SavingsAccount extends BankAccount implements Comparable<SavingsAccount>{

	private double interestRate;
	
	public SavingsAccount(int acctNum, double balance, double interestRate)
	{
		super(acctNum, balance);
		this.interestRate = interestRate;
		
		
	}

	public double getInterestRate() {return interestRate;}
	
	public void payInterest()
	{
		this.balance += this.balance * interestRate;
	}
	
	public boolean withdraw(double amount) 
	{ 
		if ((amount <= this.getBalance()))
		{
			this.setBalance(this.getBalance() - amount);
			return true;
		}
		else
			return false;
	}
	
	public void print()
	{

		System.out.print("This is a Savings Account. ");
		super.print();
	}

	public int compareTo(SavingsAccount o) {
		if (this.acctNum < o.getAccNum())
			return -1;
		else
			return 1;
	}
}


