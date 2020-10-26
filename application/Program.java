package application;

import model.entities.Book;
import model.exceptions.DomainInvalidDateException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class
    Program {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try{
            System.out.print("Room number: ");
            Integer roomNumber = sc.nextInt();

            System.out.print("Check-in (dd/MM/yyyy): ");
            Date checkIn = dateFormat.parse(sc.next());

            System.out.print("Check-out (dd/MM/yyyy): ");
            Date checkOut = dateFormat.parse(sc.next());

            System.out.println("Error in reservation: Check-out date must be after Check-in");
            Book reservation = new Book(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation.toString());
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in (dd/MM/yyyy): ");
            checkIn = dateFormat.parse(sc.next());
            System.out.print("Check-out (dd/MM/yyyy): ");
            checkOut = dateFormat.parse(sc.next());
            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation);
            sc.close();
        }catch ( ParseException e ){
            System.out.println(e.getMessage());
        }catch (DomainInvalidDateException e) {
            System.out.println( "Error in reservation" + e.getMessage());
        }catch ( Exception e ){
            System.out.println("Unexpected error");
        }
    }
}
