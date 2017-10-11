//package HomeworkAssignments.HW_3;
//
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//import static org.junit.Assert.assertEquals;
//
///**
// * Created by almaccrory on 9/22/15.
// */
//public class ReservationTest {
//    @Test
//    public void reservationClass (){
//        Reservation book= new Reservation("MacCrory", "GoFar", "09/23/2015","09/27/2015" );
//        //getters
//        assertEquals("MacCrory", book.getLastName());
//        assertEquals("GoFar", book.getCompanyName());
//        assertEquals("09/23/2015", book.getStartDate());
//        assertEquals("09/27/2015", book.getEndDate());
//        assertEquals(true, book.getCanCancel());
//        assertEquals(true, book.getCanChangeDate());
//        assertEquals(false, book.getIsCanceled());
//        //cancel
//        book.theFrontDesk();
//        assertEquals(true, book.getIsCanceled());
//        //change date
//        book.customerServices("09/27/2015", "10/03/2015");
//        assertEquals("09/27/2015", book.getStartDate());
//        assertEquals("10/03/2015", book.getEndDate());
//    }
//    @Test
//    public void hotelClass (){
//        Hotel hotel= new Hotel("MacCrory", 5, "GoFar", "09/23/2015","09/27/2015" );
//        //getters
//        assertEquals("MacCrory", hotel.getLastName());
//        assertEquals(5, hotel.getGroupSize());
//        assertEquals("GoFar", hotel.getCompanyName());
//        assertEquals("09/23/2015", hotel.getStartDate());
//        assertEquals("09/27/2015", hotel.getEndDate());
//        assertEquals(true, hotel.getCanCancel());
//        assertEquals(true, hotel.getCanChangeDate());
//        assertEquals(false, hotel.getIsCanceled());
//        //cancel
//        hotel.theFrontDesk();
//        assertEquals(true, hotel.getIsCanceled());
//        //change date
//        hotel.customerServices("09/27/2015", "10/03/2015");
//        assertEquals("09/27/2015", hotel.getStartDate());
//        assertEquals("10/03/2015", hotel.getEndDate());
//        //change group size
//        hotel.manager(7);
//        assertEquals(7, hotel.getGroupSize());
//    }
//    @Test
//    public void carClass (){
//        Car car= new Car("MacCrory", "GoFar", "Ford Focus", "09/23/2015","09/27/2015" );
//        //getters
//        assertEquals("MacCrory", car.getLastName());
//        assertEquals("GoFar", car.getCompanyName());
//        assertEquals("Ford Focus", car.getCarType());
//        assertEquals("09/23/2015", car.getStartDate());
//        assertEquals("09/27/2015", car.getEndDate());
//        assertEquals(true, car.getCanCancel());
//        assertEquals(true, car.getCanChangeDate());
//        assertEquals(false, car.getIsCanceled());
//        //cancel
//        car.theFrontDesk();
//        assertEquals(true, car.getIsCanceled());
//        //change date
//        car.customerServices("09/27/2015", "10/03/2015");
//        assertEquals("09/27/2015", car.getStartDate());
//        assertEquals("10/03/2015", car.getEndDate());
//        //change car
//        car.dealer("Bugatti");
//        assertEquals("Bugatti", car.getCarType());
//    }
//    @Test
//    public void flightClass (){
//        Flight flight= new Flight("Alec", "MacCrory", "GoFar", "345HJ89", "09/23/2015");
//        //getters
//        assertEquals("Alec", flight.getFirstName());
//        assertEquals("MacCrory", flight.getLastName());
//        assertEquals("Alec MacCrory", flight.getFullName());
//        assertEquals("GoFar", flight.getCompanyName());
//        assertEquals("345HJ89", flight.getFlightNum());
//        assertEquals("09/23/2015", flight.getStartDate());
//        assertEquals(null, flight.getEndDate());
//        assertEquals(false, flight.getCanCancel());
//        assertEquals(false, flight.getCanChangeDate());
//        assertEquals(false, flight.getIsCanceled());
//        //cancel
//        flight.theFrontDesk();
//        assertEquals(false, flight.getIsCanceled());
//        //change date
//        flight.customerServices("09/27/2015", "10/03/2015");
//        assertEquals("09/23/2015", flight.getStartDate());
//        assertEquals(null, flight.getEndDate());
//    }
//}