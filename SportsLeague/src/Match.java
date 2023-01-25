import java.util.*;
import java.time.LocalTime;
/**
 * This class represent the Matches played in the league. 
 * The class manages matches between clubs.
 * 
 * @author KailashBalachandiran
 * @version 21/10/2022
 */
public class Match
{
   
    //Fields for Matches class
    private String matchVenue;
    private LocalTime matchTime;
    private ArrayList<Player> PlayersScoring;
    private String result;
    private Club PlayingClub1;
    private Club PlayingClub2;
    private boolean status;
    private int clubOneScore;
    private int clubTwoScore;
    private League league;
    private int hrs;
    private int min;

    /**
     * Constructor for objects of class Matches
     * @param matchvenuex, hours, minutes, club1, club2
     */
    
    public Match(String matchvenuex, int hours,int minutes, Club club1, Club club2)
    {
        PlayersScoring = new ArrayList<Player>();
        matchVenue = matchvenuex;;
        PlayingClub1 = club1;
        PlayingClub2 = club2;
        status = false;
        clubOneScore = 0;
        clubTwoScore = 0;
        hrs = hours;
        min = minutes;
        matchTime = LocalTime.of(hours, minutes);

       
    }

    /**
     * Sets the Time of Match;
     * @param hours, minutes
     */
    
    public void setTimeOfTheMatch(int hours, int minutes)
    {
        matchTime = LocalTime.of(hours, minutes);
    }

    /**
     * Sets the VenueOfTheMatch;
     * @param matchvenue - matchVenue
     */
    
    public void setVenueOfTheMatch(String matchvenue)
    {
        matchVenue = matchvenue;
    }
    
    /**
     * Gets the VenueOfTheMatch;
     * @return MatchVenue
     */
    
    public String getVenueOfTheMatch()
    {
        return matchVenue;
    }
    
    /**
     * Gets the Time of the Match;
     * @return getMatchTime
     */
    
    public LocalTime getTimeOfTheMatch()
    {
        return matchTime;
    }
   
    /**
     * Setup the 1st Playing Club for matching;
     * @param PlayingClub1
     */
      
    public void set1stPlayingClub(Club club1)
    {
        PlayingClub1 = club1;
    }
    
    /**
     * Setup the 2nd Playing Club for matching;
     * @param PlayingClub2
     */
    public void set2ndPlayingClub(Club club2)
    {
        PlayingClub2 = club2;
    }
    
    /**
     * The 1st Playing Club for matching;
     * @return PlayingClub1
     */
    
    public Club get1stPlayingClub()
    {
        return PlayingClub1;
    }
    
    /**
     * The 2nd Playing Club for matching;
     * @return PlayingClub2
     */
    
    public Club get2ndPlayingClub()
    {
        return PlayingClub2;
    }
    
    /**
     * Setup Both Playing Clubs for the match;
     * @param club1, club2 - Playing Clubs to play the match
     */
    public void setPlayingClubs(Club club1, Club club2)
    {
        PlayingClub1 = club1;
        PlayingClub2 = club2;
    }
    
    
    /**
     * Displays on Console Both Playing Clubs for the match;
     * @return PlayingClubs - A String that displays both Playing Clubs for the match
     */
    
    public String getPlayingClubs()
    {
        String playingClubs = PlayingClub1.getNameOfTheClub() + " vs " + PlayingClub2.getNameOfTheClub();
        return playingClubs;
    }
    
    /**
     * Method to set Match as played
     * 
     */
    // Another method to indicate match has started
    public void setMatchAsEndedOrPlayed()
    {
        status = true;
         if (clubOneScore > clubTwoScore)
         {
            PlayingClub1.addPointsTally(3);
            
         }
         
          else if (clubOneScore < clubTwoScore)
        {
            PlayingClub2.addPointsTally(3);
            
        
        }
        
              
        else
        
        {
            
            PlayingClub1.addPointsTally(1);
            PlayingClub2.addPointsTally(1);
            
        }
         
        if(clubOneScore==0)
        {
            PlayingClub1.updateGoalKeeperCleanSheet();
        }
        
        else if (clubOneScore==0)
        {
            PlayingClub2.updateGoalKeeperCleanSheet();
        }
    
    }
   
    /**
     * Method to indicate status of match, whether ended or not ended.
     * @return status: match status, returns true if ended, false if otherwise.
     */
    
    public boolean getMatchStatus()
    {
        return status;
    }
    
    
    
   
   /**
    * This method is use to record that a player scored. It ensures that a player belongs to a Club Squad or a Team and that Club is in a League
    * It also updates other relevant variable like player's GoalScoredtally, clubs GoalScoredtally and conceded
    * @param  player is an object of Players Class
    */
      
    public void playerScored(Player player)
    {
      if (status == true)
       {
        if ((PlayingClub1.checkPlayerInATeam(player) || PlayingClub1.checkPlayerInASquad(player)))
        {
             Player S = player;
            if (!PlayersScoring.contains(S))
                 {
                    S.resetGoalTallyOfThePlayer();
                    PlayersScoring.add(S);
                    
                }
            
            player.addGoalTallyOfThePlayer();
            S.addGoalTallyOfThePlayer();
            PlayingClub1.addGoalScoredTally();
            PlayingClub2.addGoalConcededTally();
            PlayingClub1.updatePlayerSquadGoal(player);
            PlayingClub1.updatePlayerTeamGoal(player);
            clubOneScore += 1;

            
        }
        
        else if ((PlayingClub2.checkPlayerInATeam(player) || PlayingClub2.checkPlayerInASquad(player)))
            {
                Player S = player;
                if (!PlayersScoring.contains(S))
                {
                   PlayersScoring.add(S);
                    S.resetGoalTallyOfThePlayer();
                 }
            
            player.addGoalTallyOfThePlayer();
            S.addGoalTallyOfThePlayer();
            PlayingClub2.addGoalScoredTally();
            PlayingClub1.addGoalConcededTally();
            PlayingClub2.updatePlayerSquadGoal(player);
            PlayingClub2.updatePlayerTeamGoal(player);
            clubTwoScore += 1;
                
            }
        
        
        else
        {
        
        System.out.println("Player not in any of the playing clubs or not in this league");
       }
      }
       else {       System.out.println("Sorry, this match has ended");}
   }
     
    
   /**
     * Method to get the players who have played in a Match and those who scored;
     * Console to display all players in a club's team and those who scored in the match
     */
    
    //Players Scoring may not be record if team is not in the league. Match maybe assume to be casual   
   
    
    public void getPlayersPlayedAndGoals()
    {
        
        PlayingClub1.getPlayerInTeamOfTheMatch();
        
        PlayingClub2.getPlayerInTeamOfTheMatch();
        
        System.out.println("------------------------------------------------------------------");
        
        for (int i=0; i<PlayersScoring.size(); i++)
        {
            
            String playername = PlayersScoring.get(i).getNameOfThePlayer();
            int playergoals = PlayersScoring.get(i).getGoalTallyOfThePlayer();
            System.out.println(playername + " played in this match and scored " + playergoals + " goals");
            
        }
        
        
    }
    
    /**
     * Reveals match final score in the form of, or for example: "NewcastleWins"
     * It also check the status of the match before providing this information.
     */
    
    public void MatchFinalScores()
        {
        String message;
        if (status == true)
        { 
          System.out.println(PlayingClub1.getNameOfTheClub() + " " + clubOneScore+ " - " + clubTwoScore + " " + PlayingClub2.getNameOfTheClub());
         
        }
      
        else
       
          System.out.println("Match has not ended, please end match first");
         
    }

    
    /**
     * Method to reveal match result in the form or for example: "NewcastleWins"
     * It also check the status of the match before providing this information. 
     */
    
    
    
       public void MatchResult() //Match may not have been played
    {
        if (status == true)
     {
        String message;
        if (clubOneScore > clubTwoScore)
        {
            System.out.print(PlayingClub1.getNameOfTheClub() + " wins" + ") \n" );
                   
        }
         else if (clubOneScore < clubTwoScore)
        {
            System.out.print(PlayingClub2.getNameOfTheClub() + " wins" +")\n" );
            
        }
        
               
        else if (clubOneScore == clubTwoScore) 
        {
            
            System.out.print(" Its a draw" + PlayingClub1.getNameOfTheClub() + " " + clubOneScore+ " - " + clubTwoScore + " " + PlayingClub2.getNameOfTheClub()+"\n"); 
            
        }
        
     }       
        else 
        {
            System.out.print(" Matched not yet played or still in progress, end it if you want to know the result " + PlayingClub1.getNameOfTheClub() + " " + clubOneScore+ " - " + clubTwoScore+ " " + PlayingClub2.getNameOfTheClub()+"\n"); 
            
        }
    }
}
   
    