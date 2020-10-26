package model.entities;

import model.exceptions.DomainInvalidDateException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Book {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    public Book(){

    }

    public Book(Integer roomNumber, Date checkIn, Date checkOut) throws DomainInvalidDateException{
        Date now = new Date();
        if(checkIn.after(now))
            throw new DomainInvalidDateException("Reservation dates must be future date");
        if(checkIn.after(checkOut))
            throw new DomainInvalidDateException("Check-out date must be after Check-in");
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public long duration(){
        long difference = checkOut.getTime() - checkIn.getTime();  //Provides the difference of the two dates in
        // milliseconds
        return TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS); // Converts milliseconds into day
    }

    public void updateDates(Date checkIn, Date checkOut) throws DomainInvalidDateException{

        Date now = new Date();

        if (checkIn.before(now) || checkOut.before(now))
           throw new DomainInvalidDateException("Error in reservation: Reservation dates for update must be future date");
        if (checkIn.after(checkOut))
            throw new DomainInvalidDateException( "Error in reservation: Check-out date must be after Check-in");

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return "Reservation : Room " +
                roomNumber +
                " check-in: " +
                dateFormat.format(checkIn) +
                ", check-out: " +
                dateFormat.format(checkOut) +
                " , " +
                duration() +
                " nights";
        }
}
