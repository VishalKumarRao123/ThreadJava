package package1;
import java.util.*;
class Account{
	private int bal;
	public 
	Account(int bal) {
		this.bal=bal;
	}
	public boolean isSufficient(int w) {
		if(bal>=w)
			 return true;
		return false;
	}
	public void withDraw(int amt) {
		bal = bal - amt;
		System.out.println("Debited Amount : "+amt);
		System.out.println("Current Amount : "+bal);
	}
}
class Customer implements Runnable{
	private Account account;
	private String name;
	public Customer(Account account,String name) {
		this.account = account;
		this.name=name;
	}
	public void run() {
		Scanner sc = new Scanner(System.in);
		synchronized(account) {
			System.out.println(name+" Enter Amount to WithDraw : ");
			int amt = sc.nextInt();
		if(account.isSufficient(amt)) {
			System.out.println(name+",");
			account.withDraw(amt);
		}
		else {
			System.out.println("InSufficient Balance !");
		}
	}}
}
public class SynchronizationINMultiThreading {

	public static void main(String[] args) {
		Account ac = new Account(1000);
		Customer c1 = new Customer(ac,"Vishal");
		Customer c2  = new Customer(ac,"Ankit");
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		t1.start();
		t2.start();
	}

}
