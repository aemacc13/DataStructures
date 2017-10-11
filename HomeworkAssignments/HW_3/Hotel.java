package HomeworkAssignments.HW_3;

/**
 * Created by almaccrory on 9/22/15.
 */
public class Hotel extends Reservation {

    /** The customer's group size */
    private int groupSize;

    /**
     * Initializes hotel specific variables.
     * @param lastName The current customer's last name
     * @param groupSize The current group size
     * @param companyName The name of the current company being used
     * @param startDate The current start date
     * @param endDate The current end date
     */
    public Hotel(String lastName,int groupSize, String companyName, String startDate, String endDate) {
        super(lastName, companyName, startDate, endDate);
        this.groupSize= groupSize;
    }

    /**
     * Accessor.
     * @return The customers group size.
     */
    public int getGroupSize(){
        return groupSize;
    }

    /**
     * Setter.
     * @param groupSize The new group size
     */
    public void manager(int groupSize){
        this.groupSize= groupSize;
    }

    /**
     *
     * @return The receipt with the addition of the group size.
     */
    public String toString(){
        return groupSize + '\n' + super.toString();
    }
}
