package application;

import java.util.Scanner;

import model.entities.Account;
import model.exception.LimitsException;

public class ProgramAccount {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
			
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.next();
			System.out.print("Initial balance: ");
			double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			Account acc = new Account(number, holder, initialBalance, withdrawLimit);
			
			System.out.print("\nEnter amount to withdraw: ");
			double withdraw = sc.nextDouble();
			acc.withDraw(withdraw);
			
			System.out.println("New balance: "+ String.format("%.2f", acc.getBalance()));
		} catch (LimitsException e) {
			System.out.println("Withdraw error: "+e);
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}finally {
          sc.close();
		}
	}

}
