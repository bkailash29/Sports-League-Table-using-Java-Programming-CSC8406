import java.util.*;
import java.time.LocalDate;

/**
 * This class represent the Player. The Player Class manages Player in the league, club and match.
 * A player plays for a club in a match that can be of a league
 * @author  KailashBalachandiran
 * @version 21/10/2022
 */

public class Player
{
    //Fields for the Class Player
	private String Playername;
    private double Playerheight;    
    private int playergoaltally;
    private int playerage;
    private LocalDate playerdob; 
    private LocalDate currentday; 
    private int year;
    private int month;
    private int day;
    
    

    /**
     * Constructor for objects of Player Class
     * @param playername, player height, year, month, day
     * 
     */
    public Player(String playername, double playerheight, int yearx, int monthx, int dayx)
    {
        Playername = playername;
        Playerheight = playerheight;
        year = yearx;
        month = monthx;
        day = dayx;
        currentday = LocalDate.now();
        playerdob = LocalDate.of(year, month, day);
        playerage = currentday.getYear() - playerdob.getYear(); // Can use this in the clubs class 
        playergoaltally = 0;
    }
    
    
    /**
     * setNameOfThePlayer method - to set the Name of the player
     * @param playername - name of the player 
     */
    
    public void setNameOfThePlayer(String playername)
    {
        Playername = playername;
    }
    /**
     * getNameOfThePlayer method - Retrieves Name of the player
     * @return Playername - Name of Player
     */
    
        public String getNameOfThePlayer()
    {
        return Playername;
    }
    
     /**
     * setHeightOfThePlayer method - to set the Height of the player
     * @param playerheight - height of the player 
     */
    
    public void setHeightOfThePlayer(double playerheight) 
    {
        Playerheight = playerheight;
    }
    /**
     * getHeightOfThePlayer method - Retrieves the Height of the player
     * @return Playerheight - Height of the player
     */
    
    public double getHeightOfThePlayer() 
    {
        return Playerheight;
    }
    
     /**
     * setDOBOfThePlayer method - to set the player DOB
     * @param year, month, day - Date of Birth of the player (YYYY, DD, MM)
     */
    
    public void setDOBOfThePlayer(int year, int month, int day) //Enter the date of birth of player in the format: year, day, month - YYYY, DD, MM, 
    {
        
        playerdob = LocalDate.of(year, month, day);
        
    }
    
     
    
     /**
     * getDOBOfThePlayer method - Retrieves the Player Date of Birth
     * @return playerdob - Date of Birth of Player
     */
    
    public LocalDate getDOBOfThePlayer() //Enter the date of birth of player in the format: year, day, month - YYYY, DD, MM, 
    {
        
        playerdob = LocalDate.of(year, month, day);
        return playerdob;
    }
    
        
    /**
     * Add to the GoalTallyOfThePlayer
     * @param  goal of int - add goal(s) to the playergoaltally.
     */
    
    public void addGoalTallyOfThePlayer()
    {
        playergoaltally += 1;
    }
    
    
    /**
     * Retrieves the goaltally of the player;
     * @returns playergoaltally
     */
    
    public int getGoalTallyOfThePlayer()
    {
        return playergoaltally;
    }    
    
    /**
     * Retrieves the goaltally of the player;
     * @returns playerage
     */
 
    public int getAgeOfThePlayer()
    {
        return playerage;
    }
    
    
    /**
     * Resets the goaltally of the player;
     * @return void
     */
    public void resetGoalTallyOfThePlayer()
    {
        playergoaltally = 0;
    }
}
          
        
    
    
     