package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		System.out.println("Enter account data");
		System.out.println("Number:");
		int number = scan.nextInt();
		System.out.println("Holder:");
		scan.nextLine();
		String holder = scan.nextLine();
		System.out.println("Initial balance:");
		Double initialBalance = scan.nextDouble();
		System.out.println("Withdraw limit:");
		Double withdrawLimit = scan.nextDouble();
		Account acc = new Account(number, holder, initialBalance, withdrawLimit);
		
		System.out.println("Enter amount for withdraw:");
		double ammount = scan.nextDouble();
		
		try {
			acc.withdraw(ammount);
			System.out.println("New balance: "+String.format("%.2f", acc.getBalance()));
		}
		
		catch (DomainException e){
			System.out.println("Withdraw error: "+e.getMessage());
		}
		
		scan.close();
		

	}

}
