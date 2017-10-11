package HomeworkAssignments.HW_3;

/**
 * Created by almaccrory on 9/22/15.
 */
public class Flight extends Reservation {

    /** The customer's first name */
    private String firstName;
    /** The customer's flight number */
    private String flightNum;

    /**
     * Initializes hotel specific variables.
     * @param firstName The current first name
     * @param lastName The current last name
     * @param companyName The name of the current company being used
     * @param flightNum The current flight number
     * @param startDate The current start date
     */
    public Flight(String firstName, String lastName, String companyName, String flightNum, String startDate){
        super(lastName, companyName, startDate, null);
        this.firstName=firstName;
        this.flightNum=flightNum;
        //the booleans were set to match the initial car and hotel standards
        //so make it so we cant change date or cancel for a flight
        canChangeDate=false;
        canCancel= false;
        isCanceled= false;
    }

    /**
     * Accessor.
     * @return The customer's first name.
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * Accessor.
     * @return The customer's full name.
     */
    public String getFullName(){
        return firstName + " " + getLastName();
    }

    /**
     * Accessor.
     * @return The flight number of reserved flight.
     */
    public String getFlightNum(){
        return flightNum;
    }

    /**
     *
     * @return The receipt with the addition of a customers first name and flight number.
     */
    public String toString(){
        return flightNum + '\n' + firstName + super.toString();
    }
}
