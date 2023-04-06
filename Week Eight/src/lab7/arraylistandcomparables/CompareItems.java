package lab7.arraylistandcomparables;

import lab7.bankRelatedClasses.*;
import java.util.*;

public class CompareItems{

	
	
	public static void main(String[] args) throws Exception{
		
		
		List<SavingsAccount> allBankAccounts = new ArrayList<SavingsAccount>();
		
		allBankAccounts.add(new SavingsAccount(400,10000, 1.5));
		allBankAccounts.add(new SavingsAccount(901, 3000, 1.5));
		allBankAccounts.add(new SavingsAccount(102, 1220000, 2.5));
		allBankAccounts.add(new SavingsAccount(301, 50000, 7.35));
		allBankAccounts.add(new SavingsAccount(501, 200, 2.5));
		allBankAccounts.add(new SavingsAccount(600, 500, 7.35));

		Collections.sort(allBankAccounts);
		System.out.println(allBankAccounts);

		Collections.sort(allBankAccounts, Collections.reverseOrder());
		System.out.println(allBankAccounts);

		Collections.sort(allBankAccounts, new InterestBasedComparison());
		System.out.println(allBankAccounts);

		Collections.sort(allBankAccounts, new BalenceBasedComparison());
		System.out.println(allBankAccounts);



		List<String> names = Arrays.asList("Alex", "Olivia", "Daisy", "David");
		System.out.println(names);
		Collections.sort(names);
		System.out.println(names);
		Collections.sort(names, Collections.reverseOrder());
		System.out.println(names);


		Iterator<SavingsAccount> SavingsAccountsIterator = allBankAccounts.iterator();
		while(SavingsAccountsIterator.hasNext()) {
			SavingsAccountsIterator.next().print();
		}
	}

	}
class InterestBasedComparison implements Comparator<SavingsAccount>
{
	@Override
	public int compare(SavingsAccount o1, SavingsAccount o2) {
		if(o1.getInterestRate() < o2.getInterestRate())
			return -1;
		else
			return 1;
	}
}

class BalenceBasedComparison implements Comparator<SavingsAccount>
{
	@Override
	public int compare(SavingsAccount o1, SavingsAccount o2) {
		if(o1.getBalance() > o2.getBalance())
			return -1;
		else
			return 1;
	}
}