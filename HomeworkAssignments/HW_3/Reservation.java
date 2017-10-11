package HomeworkAssignments.HW_3;

/**
 * A Reservation SuperClass.
 * Created by almaccrory on 9/22/15.
 */
public class Reservation {

    /** The customer's last name */
    private String lastName;
    /** The name of either the airline, hotel, or rental agency */
    private String companyName;
    /** The customer's starting travel date */
    private String startDate;
    /** The customer's ending travel date */
    private String endDate;
    /** The resevations ability to be canceled */
    protected boolean canCancel;
    /** The resevations ability to change the dates of travel */
    protected boolean canChangeDate;
    /** The resevations cancelation status */
    protected boolean isCanceled;

    /**
     * Initializes variables that are common to all subClasses.
     * @param lastName The current customer's last name
     * @param companyName The name of the current company being used
     * @param startDate The current start date
     * @param endDate The current end date
     */
    public Reservation(String lastName, String companyName, String startDate, String endDate){
        this.lastName= lastName;
        this.companyName=companyName;
        this.startDate=startDate;
        this.endDate= endDate;
        //the initial booleans for hotels/cars but not flights
        canCancel= true;
        canChangeDate= true;
        isCanceled= false;
    }

    /**
     * Accessor.
     * @return Customers last name.
     */
    public String getLastName(){
        return lastName;
    }
    /**
     * Accessor.
     * @return Company being of the reservation.
     */
    public String getCompanyName(){
        return companyName;
    }
    /**
     * Accessor.
     * @return Vacation start date.
     */
    public String getStartDate(){
        return startDate;
    }
    /**
     * Accessor.
     * @return Vacation end date.
     */
    public String getEndDate(){
        return endDate;
    }
    /**
     * Accessor.
     * @return Whether or not a resevation can be canceled.
     */
    public boolean getCanCancel(){
        return canCancel;
    }
    /**
     * Accessor.
     * @return Whether or not a resevation is canceled.
     */
    public boolean getIsCanceled(){
        return isCanceled;
    }
    /**
     * Accessor.
     * @return Whether or not a reservation's date can be changed.
     */
    public boolean getCanChangeDate() {
        return canChangeDate;
    }

    /**
     * Setter.
     * Call the front desk to cancel the reservation if it is able to be canceled.
     */
    public void theFrontDesk(){
        if (this.canCancel == true) {
            this.isCanceled = true;
            System.out.println("Your reservation has successfully canceled.");
        }else{
            System.out.println("Your flight reservation is not able to be canceled.");
        }
    }

    /**
     * Setter.
     * Call customer services to change your reservation dates.
     * @param startDate The new vacation start date.
     * @param endDate The new vacation end date.
     */
    public void customerServices(String startDate, String endDate){
        if (this.canChangeDate == true) {
            this.startDate= startDate;
            this.endDate= endDate;
        }else{
            System.out.println("Your flight date is not able to be changed.");
        }
    }

    /**
     * Setter.
     * @param reservation The new reservation.
     * @param array The array to place everything in.
     * @param index The index of the array to place things at.
     * Josh Ma explained how to implement the first line(with the parameters) of this method
     */
    public void addToArray(Reservation reservation, Reservation[] array, int index){
        if (index<0)
            throw new IllegalArgumentException("Index of array must be positive");
        else
            array[index]= reservation;
    }

    /**
     *
     * @return A receipt of the usefull travel information.
     */
    public String toString(){
        return lastName + '\n' + "Company Name:" + companyName + '\n' +
                "Travel Dates:" + startDate + "-" + endDate;
    }
}

/**
 * Sources:
 * Taylor Pellerin and I initially worked on this at the same time,
 * and we talked through the logic of what is included in each class(Reservation, hotel, car, and flight).
 *
 * Josh Ma helped me with one line of the addToArray method
 */