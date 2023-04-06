package lab7.bankRelatedClasses;

public abstract class BankAccount{

		protected int acctNum;
		protected double balance;	
		
		public BankAccount(int acctNum, double balance) 
			{
				this.acctNum = acctNum;
				this.setBalance(balance);
			
			}
		
		public int getAccNum() 
			{
				return acctNum;
			
			}
		
		public double getBalance() {

			return balance;
		}
		
		
		public abstract boolean withdraw(double amount);
		
		public void deposit(double amount)
		{
			if (amount > 0)
				this.setBalance(this.getBalance() + amount);
			
		}
		
		public void print(){ 
			
			System.out.println("The account number is: "+ this.acctNum);
			
		}
		
		public String toString(){ 
			
			return Integer.toString(acctNum);
			
		}
		
		public void setBalance(double balance) {
			this.balance = balance;
		}
		
		
}
