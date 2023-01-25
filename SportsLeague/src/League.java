import java.util.ArrayList;

/**
 * Models the operation of a League - managing Clubs and Players.
 * 
 * @author KailashBalachandiran
 * @version 21/10/2022
 */

public class League
{
    //Fields of the League Class
    public ArrayList<Club> LeagueClubs;
    public ArrayList<Match> LeagueMatches;
    private String leagueName;
    private int clubLimit;
    
    

    /**
     * Constructor for objects of Class Leagues
     * New Leagues to be created (Spanish La Liga, Bundes Liga, English Premiership,  etc).
     * @param name, limit; name of league, number of clubs to play
     */
    
    public League(String name, int limit)
    {
        LeagueClubs = new ArrayList<Club>();
        LeagueMatches = new ArrayList<Match>();
        leagueName = name;
        clubLimit = limit;
        
    }
    /**
     * Sets the NameofTheLeague;
     * @param name - leagueName Name of the league
     */
    public void setNameofTheLeague(String name)
    {
        leagueName = name;
    }
    /** Gets the NameofTheLeague
     * 
     * @return leagueName
     */
    public String getNameofTheLeague()
    {
        return leagueName;
    }
    /**
     * Sets the LimitOfTheClub;
     * @param limit - clubLimit limit of the club
     */
    public void setLimitOfTheClub(int limit)
    {
        clubLimit = limit;
        
    }
    /** Gets the LimitOfTheClub
     * 
     * @return clubLimit
     */
    public int getLimitOfTheClub()
    {
        return clubLimit;
        
    }
    /**
     * Add to the clubToTheLeague
     * @param  club of Club - add club(s) to the LeagueClubs.
     */
    public void addClubToTheLeague(Club club)
    {
        if(LeagueClubs.size()<clubLimit){
             LeagueClubs.add(club);
        }
    }
    /**
     * Add to the MatchToTheLeague
     * @param  match of Match - add match(s) to the LeagueMatches.
     */
    
    public void addMatchToTheLeague(Match match)
    {
     if (this.LeagueMatches.contains(match)==false)
     {
        LeagueMatches.add(match);
     }  
    }
    /**
     * Add to the Fixtures
     * @param  match of Match - add match(s) to the LeagueMatches.
     */
    
    public void addFixtures(Match match)
    {
        if (match.getMatchStatus()!=true && LeagueMatches.contains(match)==false )
        {
        LeagueMatches.add(match);
        }
    
    }
    /**
     * Method to reveal viewFixtures in the form or for example: Newcastle United vs Manchester City - Old Traford (Venue)  22:44 (Time)
     * @return fixtures match yet to be played
     */
    
    public String viewFixtures()
    {
    	String str = "";
        for (int i=0; i<LeagueMatches.size(); i++)
        {
            boolean currentstatus = LeagueMatches.get(i).getMatchStatus();
            if (currentstatus!=true)
            {
                str += LeagueMatches.get(i).getPlayingClubs() + "   -  \t" + LeagueMatches.get(i).getVenueOfTheMatch() + " (Venue)\t " + LeagueMatches.get(i).getTimeOfTheMatch() + " (Time)";
                System.out.println(LeagueMatches.get(i).getPlayingClubs() + "   -  \t" + LeagueMatches.get(i).getVenueOfTheMatch() + " (Venue)\t " + LeagueMatches.get(i).getTimeOfTheMatch() + " (Time)");
               
            }
        }
        return str;
        
    }
    /**
    * Method to reveal leagueResults in the form or for example: Newcastle United 1 - 3 Manchester City
    * @return fixtures match yet to be played
    */
    public String leagueResults()
    {
    	String str = "";
        //addMatchdetails once played
        System.out.println("\t** Match Results **");
        
        
        for (int i=0; i<LeagueMatches.size(); i++)
        {
            boolean match = this.LeagueMatches.get(i).getMatchStatus();
            if (match==true)
            {
                this.LeagueMatches.get(i).MatchFinalScores();
               
                               
                
            }
            
            
            
        }
        return str;
    }
    /**
     * Method to check the indexOfTheMatch 
     * @return index of the LeagueMatches
     */
    
    public int indexOfTheMatch(Match match){
        if (LeagueMatches.contains(match)==true)
    
            for (int i=0; i<LeagueMatches.size(); i++)
        {
            if(LeagueMatches.get(i).equals(match)) 
            {
               return LeagueMatches.indexOf(match);   
            }
            
        }
        
        return -1;
     }
    /**
     * Method to check the whether the match is ended or not
     * 
     */
    
    public void endAMatch(Match match)
     {
        //End a match in a league once played
        if (LeagueMatches.contains(match) && indexOfTheMatch(match)!=-1)
      {
        this.LeagueMatches.get(indexOfTheMatch(match)).setMatchAsEndedOrPlayed();
     }
     else      System.out.println("Match not setup for the league or does not exist in league"); 
    }
    
    /**
     * Method to check top club in the league
     * @return Top club in the league
     * 
     */
        
    
    public String topClubInLeague()
    {
    	String str = "";
        int maximum = LeagueClubs.get(0).getPointsTally();
        int tracker = 0;
        for (int i = 0; i < LeagueClubs.size(); i++)
        {
            if (LeagueClubs.get(i).getPointsTally() > maximum)
            {
                maximum =LeagueClubs.get(i).getPointsTally();
                tracker = i;
            }
        }
        
        
       
    str += "The Top Club in League is: " + LeagueClubs.get(tracker).getNameOfTheClub()+ " with " + maximum + " points";
    		System.out.println("The Top Club in League is: " + LeagueClubs.get(tracker).getNameOfTheClub()+ " with " + maximum + " points");

        return str;
        // Top team in the league 
    }
    
    /**
     * Method to print the league table
     * @return league table
     * 
     */
    
    public String printLeagueTable()
    {
        //print league table - consisting all clubs in the league
        String str ="";
        System.out.println("\t\t***" + this.leagueName + " League Table ***");
        System.out.println("************************************************************");
        System.out.println("Team Name" + "\t\t" + " " + "GS\t" + " " + "GC\t" + " " + "GD\t" + " " + "PT\t");
        for (int i=0; i<LeagueClubs.size(); i++)
        {
            //boolean match = this.LeagueClubs.get(i).getMatchStatus();
                     str += LeagueClubs.get(i).getNameOfTheClub() + "\t\t" + LeagueClubs.get(i).getGoalScoredTally() + "\t" + LeagueClubs.get(i).getGoalConcededTally()
                             + "\t" + LeagueClubs.get(i).getGoalDifference() + "\t" +LeagueClubs.get(i).getPointsTally();
            System.out.println(LeagueClubs.get(i).getNameOfTheClub() + "\t\t" + LeagueClubs.get(i).getGoalScoredTally() + "\t" + LeagueClubs.get(i).getGoalConcededTally()
            + "\t" + LeagueClubs.get(i).getGoalDifference() + "\t" +LeagueClubs.get(i).getPointsTally());
           
        }
        System.out.println("*************************************************************");
                       System.out.println("Table Keys:");
                       System.out.println("GS: Goals Score");
                       System.out.println("GC:  Goal Conceived");
                       System.out.println("GD: Goal Difference");
                       System.out.println("PT: Points Accumulated");
                       return str;
    }
    /**
     * Method to print the top scorer (Golden Boot) in the league
     * @return the top scorer in the league
     * 
     */
    public String topScorer()
    {
    	String str = "";
        int maximum = LeagueClubs.get(0).topStrikerGoals();
        int tracker = 0;
        for (int i = 0; i < LeagueClubs.size(); i++)
        {
            if (LeagueClubs.get(i).topStrikerGoals() > maximum)
            {
                maximum = LeagueClubs.get(i).topStrikerGoals();
                tracker = i;
            }
        }
        str += "The Top Scorer in League is: " + LeagueClubs.get(tracker).topStriker()+ " with " + maximum + "goals";
        System.out.println("The Top Scorer in League is: " + LeagueClubs.get(tracker).topStriker()+ " with " + maximum + " goals");
        return str;
  
        // Golden Boot in League - Scores highest
    }
    /**
     * Method to print the bestGoalKeeper in the league
     * @return the best goal keeper
     * 
     */
    public String bestGoalKeeper(){
    	String str = "";
        int max = LeagueClubs.get(0).cleanSheet();
        int tracker = 0;
        for (int i = 0; i < LeagueClubs.size(); i++)
        {
            if (LeagueClubs.get(i).cleanSheet() > max)
            {
                max = LeagueClubs.get(i).cleanSheet();
                tracker = i;
            }
        }
        str += "The Best Goalkeeper in the League is: " + LeagueClubs.get(tracker).getNameOfTheGoalKeeper()+ " from " + LeagueClubs.get(tracker).getNameOfTheClub() + " who has " + max + " clean sheets";
        System.out.println("The Best Goalkeeper in the League is: " + LeagueClubs.get(tracker).getNameOfTheGoalKeeper()+ " from " + LeagueClubs.get(tracker).getNameOfTheClub() + " who has " + max + " clean sheets");
        return str;
        
    }
    
}