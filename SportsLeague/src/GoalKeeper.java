import java.util.*;
import java.time.LocalDate;

/**
 * This class represents a GoalKeeper and inherits from the parent class Player
 * 
 * @author KailashBalachandiran
 * @version 21/10/2022
 */
public class GoalKeeper extends Player
{
     //Fields for GoalKeeper class
    private int goalConceded;
    private int cleanSheet;
    /**
     * Constructor for objects of Class GoalKeeper
     * 
     * @param playername, playerheight, year, month, day
     */
    public GoalKeeper(String playername, double playerheight, int year, int month, int day)
    {
        super (playername, playerheight, year, month, day);
        goalConceded = 0;
        cleanSheet = 0;
          

    }
    /**
     * Method to add to the GoalConceded
     * @param  int of goalConceded - add the conceded goals to the goalConceded
     */
    public void addGoalConceded()
    {
        goalConceded += 1;
    }
    /**
    * Retrieves the total goals conceded
    * @returns goalConceded
    */
    
    public int totalConceded()
    {
        return goalConceded;
    }
    /**
     * Method to add the goals in the CleanSheet
     * 
     */
    public void addCleanSheet()
    {
        cleanSheet++;
    }
    /**
     * Method to get the cleanSheet
     * @returns cleanSheet
     */
    public int getcleanSheet()
    {
        return cleanSheet;
    }
}
