package HomeworkAssignments.HW_3;

/**
 * Created by almaccrory on 9/22/15.
 */
public class Car extends Reservation {

    /** The customer's rental car type */
    private String carType;

    /**
     * Initializes car specific variables.
     * @param lastName The current customer's last name
     * @param companyName The name of the current company being used
     * @param carType The current rental car type
     * @param startDate The current start date
     * @param endDate The current end date
     */
    public Car(String lastName, String companyName, String carType, String startDate, String endDate) {
        super(lastName, companyName, startDate, endDate);
        this.carType= carType;
    }

    /**
     * Accessor.
     * @return The type of car being rented.
     */
    public String getCarType(){
        return carType;
    }

    /**
     * Setter.
     * @param carType The new rental car type
     */
    public void dealer(String carType){
        this.carType= carType;
    }

    /**
     *
     * @return The receipt with the addition of the car type.
     */
    public String toString(){
        return carType + '\n' + super.toString();
    }
}
