import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represent the Club in the League. 
 * 
 * @author KailashBalachandiran
 * @version 21/10/2022
 */

public class Club
{
    //Fields for Class Players
     private ArrayList<Player> squad;
     private ArrayList<Player> team;
     private String clubName;
     private int totalGoalScored;
     private int totalGoalsConceded;
     private int goalDifference;
     private int pointsTally;
     private int numberOfPlayers;
     private int teamSize;
     private GoalKeeper goalie;
     private GoalKeeper goalie1;
    
     
     
    /**
     * Constructor for objects of class Clubs
     * Creates a new club
     * @param name: Name of the club
     * 
     */
    
    public Club(String name)
    {
        squad = new ArrayList<Player>();
        team = new ArrayList<Player>();
        clubName = name;
        totalGoalScored = 0;
        totalGoalsConceded = 0;
        goalDifference = 0;
        pointsTally = 0;
        teamSize = 0;
        goalie = new GoalKeeper("Mykeeper", 1.2, 2000, 12, 05);
        goalie1 = new GoalKeeper("Elias", 1.2, 2000, 12, 05);
        
       squad.add(goalie1);
       //squad.add(goalie2);
    }

         
    /**
     * Specifies the name of the club;
     * @param name: Name of Club
     * 
     */
       
    public void setNameOfTheClub(String name)
    {
      clubName = name;
    }
    
    /**
     * Specifies the team size of the club;
     * @param teamSize: Size of Team of Club
     * 
     */
       
    public void setSizeOfTheTeam(int size)
    {
      teamSize = size;
    }
    
    /**
     * Change the GoalKeeper name in the club;
     * @param name: 
     * 
     */
       
    public void setNameOfTheGoalKeeper(String name)
    {
      this.goalie.setNameOfThePlayer(name);
    }
    
    
    /**
     * Retrieves the name of the club;
     * @ returns club name
     */
    
    public String getNameOfTheClub()
    {
        return clubName;
        
    }    
    
    
    
    /**
     * Retrieves the current team size of the club;
     * @ returns club team: Team is always a fixed size.
     */
    
    public int getSizeOfTheTeam(int size)
    {
        return teamSize;
        
    }    
    
    /**
     * Adds to the goalScoredTally of the club and returns the recent total goal scored by the club
     * @param NumOfGoal: Number of Goal Scored to be added.
     */
    public int getGoalScoredTally()
    {
        return totalGoalScored;
  
    }
    
    /**
     * Adds to the GoalscoredTally of the club and returns the recent total goal scored by the club
     * @param NumOfGoal: Number of Goal Scored to be added.
     */
    public void addGoalScoredTally()
    {
        totalGoalScored += 1;
  
    }
    
    /**
     * Adds to the goals concededTally of the club and returns the recent total goal conceded by the club
     * @param NumOfGoal: Number of Goal Scored to be added to conceded goals.
     */
    public void addGoalConcededTally()
    {
        totalGoalsConceded += 1;
        
    }
   
    
    /**
     * Gets the goals concededTally of the club and returns the total goal conceded by the club
     * @return goalConceded; Number of Goal Scored to be added to conceded goals.
     */
    public int getGoalConcededTally()
    {
        return totalGoalsConceded;
        
    }
    
    
     /**
     * Gets the goals difference of the club and returns total goal difference
     * @returns goalDifference - goal difference of the club
     */
    public int getGoalDifference()
    {
        goalDifference = totalGoalScored - totalGoalsConceded;
        return goalDifference;
    }
    
    
    
    /**
     * Adds to the pointsTally of the club and returns the newest total tally of club
     * @param newestTally; Represents new tally from a match that would be added to the existing tally
     */
    public void addPointsTally(int newTally)
    {
        pointsTally += newTally;
        
    }
    
    /**
     * Gets the accumulated pointsTally of the club
     * @returns pointTally of the club;
     */
    
    public int getPointsTally()
    {
        return pointsTally;
    }
    
     /**
     * Adds a player to the Club's Squad
     * @param player: - Object of Players
     */
    
    public void addPlayer(Player player)
    {
        
        this.squad.add(player);
    }    
   
    /**
     * Checks if a player is in the Club's Squad
     * @param player: - Object of Players
     */
    
    public boolean checkPlayerInASquad(Player player)
     {
         if (squad.contains(player)==true)
         {
            System.out.println("True, This player is in this Squad");
             return true;
         }
         
         else
         
         System.out.println("False, This player is NOT in this Squad - Check with other clubs");
         return false;
     }
     
     
     /**
     * Checks if a player is in the Club's Team
     * @param player: - Object of Players in team ArrayList
     */
     
     public boolean checkPlayerInATeam(Player player)
     {
         if (team.contains(player)==true)
         {
            System.out.println("True, This player is in this Squad");
             return true;
         }
         
         else
         
        System.out.println("False, This player is NOT in this Squad - Check with other clubs");
         return false;
     }
    
     
     
     
     /**
     * Finds the average age of the Squad
     * @returns average - average age of the the squad;
     */
    public int averageAgeOfTheSquad()
     {
         int i=0;
         int j=0;
         for(int k = 0; k<squad.size(); k++)
         {
            i += squad.get(k).getAgeOfThePlayer();
            j++;
         }   
          int average = i/j;
          System.out.println("Average Age of Squad is: " + average);
         return average;
          
     }
    
     
    /**
     * Finds the average height of the Squad
     * @returns average - average height of the the squad;
     */
     public double averageHeightOfTheSquad()
     {
         double i=0;
         double j=0;
         for(int k = 0; k<squad.size(); k++)
         {
            i += squad.get(k).getHeightOfThePlayer();
            j++;
         }   
          double average = i/j;
          System.out.println("Average Height of Squad is : " + average + " years");
         return average;
          
     }
     
     
     /**
     * Adds a player to a selected team for a match; Player must be in Squad first;
     * @param player - player object from players (squad) array list
     */
    
      public void addPlayerToTheTeam(Player player) //Assuming Coach selects players for match
    {
        if (squad.contains(player)==true)
        {
          team.add(player);
        }
        
        else
        {
            System.out.println("Player is not in Squad pls - Add to Club Squad first"); //Throw exception instead.
        }
    }    
    
    /**
     * Removes a player from a selected team for a match; Player must be in Team first;
     * @param player - player object from team array list
     */
    
      public void removePlayerInATeam(Player player) //Assuming Coach selects players for match
    {
        if (team.contains(player)==true)
        {
          team.remove(player);
        }
        
        else
        {
            System.out.println("Player is not in Current Team pls"); //Throw exception instead.
        }
    }    

    /**
     * List and prints to console Players selected as part of the team in ArrayList of team;
     * @displays ArrayList of Players - player object from team array list
     */
   
    
    public void getPlayerInTeamOfTheMatch()
    {
        int playergoals = 0;
        String playername;
        for (int i=0; i<team.size(); i++)
        {
            
            playername = team.get(i).getNameOfThePlayer();
            playergoals = team.get(i).getGoalTallyOfThePlayer();
            System.out.println(playername + " from " + this.getNameOfTheClub() + " played in the match ");
            
        }

       
    }
    
        
    /**
     * List and prints to console Players in the Club (the Squad);
     * @displays ArrayList of Players - player object from squad array list
     */
 
    
      public void getPlayersInSquadOfTheClub()
    {
        int playergoals = 0;
        String playername;
        for (int i=0; i<squad.size(); i++)
        {
            
            playername = squad.get(i).getNameOfThePlayer();
            playergoals = team.get(i).getGoalTallyOfThePlayer();
            System.out.println(playername + " from  " + this.getNameOfTheClub() + " exist");
            
        }

       
    }

    
    /**
     * Adds a GoalKeeper to the Club (in the Squad);
     * @param Goalkeeper p: GoalKeeper is added to the club's squad;
     */
 
      public void addGoalKeeperToTheSquad(GoalKeeper goalie)
   {
       if (!squad.contains(goalie)==true)
        {
          squad.add(goalie);
        }
        
        else
        {
            System.out.println("Goalkeeper is already in squad pls - Add to Club Squad first"); //Throw exception instead.
        }
       squad.add(goalie);
   }
   
   
    /**
     * Provides index number of a Player in the Club or the Squad
     * @param Players p: p is a Player which may be present in the Club, through the club's squad;
     * @return index : index is index number or position of that player in the squad (ArrayList)
     */
   
   public int indexOfPlayer(Player player){
        //    if (LeagueMatches.contains(match)==true)
    
            for (int i=0; i<squad.size(); i++)
        {
            if(this.squad.get(i).equals(player)) 
            {
               return squad.indexOf(player);   
            }
            
        }
        
        return -1;
     }

     /**
     * Provides index number of a Player in the Club or the Squad
     * @param Players p: p is a Player which may be present in the Club, through the club's squad;
     * @return index : index is index number or position of that player in the squad (ArrayList)
     */
   
   public int indexOfPlayer1(Player player){
        //    if (LeagueMatches.contains(match)==true)
    
            for (int i=0; i<team.size(); i++)
        {
            if(this.team.get(i).equals(player)) 
            {
               return team.indexOf(player);   
            }
            
        }
        
        return -1;
     }
     
     
     
    /**
     * The top striker goals in the Club is recorded here
     * @return p: goals so far scored by the top striker is returned;
     */
     
     public int topStrikerGoals()
    {
        int maximum = squad.get(0).getGoalTallyOfThePlayer();
        int tracker = 0;
        for (int i = 0; i < squad.size(); i++)
        {
            if (squad.get(i).getGoalTallyOfThePlayer() > maximum)
            {
                maximum =squad.get(i).getGoalTallyOfThePlayer();
                tracker = i;
            }
        }
    
       return maximum;
        // Golden Boot in League - Scores highest
    }

    
    /**
     * Shows Name of the Top Striker in the Club (or Squad);
     * @return getPlayerName(): This methods reveals player's name;
     */
    
    
     public String topStriker()
    {
        int maximum = squad.get(0).getGoalTallyOfThePlayer();
        int tracker = 0;
        for (int i = 0; i < squad.size(); i++)
        {
            if (squad.get(i).getGoalTallyOfThePlayer() > maximum)
            {
                maximum =squad.get(i).getGoalTallyOfThePlayer();
                tracker = i;
            }
        }
    
       return squad.get(tracker).getNameOfThePlayer();//+ + " is Top Scorer : " + " with " + max + " goals" + "from " + this.NameOfClub() );
       // Golden Boot in League - Scores highest
    }
     
    
    /**
     * Adds a GoalKeeper to the Club (in the Squad);
     * @param Goalkeeper p: GoalKeeper is added to the club's squad;
     */
     public void topScorerOfTheClub()
    {
        int maximum = squad.get(0).getGoalTallyOfThePlayer();
        int tracker = 0;
        for (int i = 0; i < squad.size(); i++)
        {
            if (squad.get(i).getGoalTallyOfThePlayer() > maximum)
            {
                maximum =squad.get(i).getGoalTallyOfThePlayer();
                tracker = i;
            }
        }
        System.out.println(squad.get(tracker).getNameOfThePlayer()+ " with " + maximum + " goals is the Top Scorer in " + this.clubName);
  
        // Used to obtain a printout for Highest Goal Scorer in Club 
    }
     
    /**
     * Updates a player's goal tally within the club/squad;
     * @param Players p: Players ;
     */

    public void updatePlayerSquadGoal(Player x)
    {
         if (squad.contains(x)==true && indexOfPlayer(x)!=-1)
         {
             squad.get(indexOfPlayer(x)).addGoalTallyOfThePlayer();
         }
    } 
    
    /**
     * Updates a player's goal tally within the club/squad;
     * @param Player : Player ;
     */

    public void updatePlayerTeamGoal(Player player)
    {
         if (team.contains(player)==true && indexOfPlayer1(player)!=-1)
         {
             team.get(indexOfPlayer1(player)).addGoalTallyOfThePlayer();
         }
    } 
    
    
    
    /**
     * Updates goalKeepers cleanSheet record
     * 
     */
    
    public void updateGoalKeeperCleanSheet()
    {
        if (squad.contains(goalie)==true)
         {
                goalie.addCleanSheet();
         }

    }
    
    /**
     * Retrieves current cleanSheet record of the goalKeeper
     * @return goalKeepers cleanSheet
     */
    
    public int cleanSheet()
    {
        return goalie.getcleanSheet();
    }
    
    
    /**
     * Retrieves current goalKeeper name
     * @return goalkeeper's name
     */
    
    public String getNameOfTheGoalKeeper()
    {
        return goalie.getNameOfThePlayer();
    }
}
    
