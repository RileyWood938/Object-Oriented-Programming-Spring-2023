package lab7.arraylistandcomparables;
import java.util.*;

import lab7.bankRelatedClasses.CheckingAccount;
import lab7.bankRelatedClasses.SavingsAccount;

import javax.print.CancelablePrintJob;

//Define a main(…) method there. Do the followings in the main method:
//i. Create an ArrayList to store references of different CheckingAccount type objects.
//ii. Once five such accounts are added to your collection, print them using an iterator.
//iii. Now sort the collection with the help of the built-in Collections.sort(…) method based on
//the account balance.
//iv. Print the sorted list
public class CompareItems2 {
    public static void main(String[] Args){

        List<CheckingAccount> allcheckingaccounts = new ArrayList<>();

        allcheckingaccounts.add(new CheckingAccount(1,  20000, 2));
        allcheckingaccounts.add(new CheckingAccount(2,  201, .2));
        allcheckingaccounts.add(new CheckingAccount(3,  240, 99));
        allcheckingaccounts.add(new CheckingAccount(4,  60, 2));
        allcheckingaccounts.add(new CheckingAccount(5,  2900, 1));

        Iterator<CheckingAccount> CheckingAccountsIterator = allcheckingaccounts.iterator();

        while (CheckingAccountsIterator.hasNext()){
            CheckingAccountsIterator.next().print();
        }

        Collections.sort(allcheckingaccounts);

        CheckingAccountsIterator = allcheckingaccounts.iterator();

        while (CheckingAccountsIterator.hasNext()){
            CheckingAccountsIterator.next().print();
        }

    }
}

