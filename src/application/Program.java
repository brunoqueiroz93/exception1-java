package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (DD/MM/YYYY): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("Check-ou date (DD/MM/YYYY): ");
        Date checkout = sdf.parse(sc.next());
        
        if (!checkout.after(checkin)) {
        	System.out.println("Error in reservation: checkout date must be after checkin date.");
        } else {
        	Reservation reservation = new Reservation(number, checkin, checkout);
        	System.out.println("Reservation: "+ reservation);
        	
        	System.out.println();
        	System.out.println("Enter data to update the reservation");
        	System.out.print("Check-in date (DD/MM/YYYY): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-ou date (DD/MM/YYYY): ");
            checkout = sdf.parse(sc.next());
            
             String error = reservation.updateDates(checkin, checkout);
             if (error != null) {
            	System.out.println("Error in reservation: "+ error); 
             } else {	
                System.out.println("Reservation: "+ reservation);
             }
                  	
        }              
        sc.close();

	}
	

}
