import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
// Import the File class
// Import this class to handle errors
import java.io.*;
/**
 * This class is the driver class objects and methods are called from another class
 * 
 * @author KailashBalachandiran
 * @version 21/10/2022
 */
public class Driver
{
     
	/**
     * Creating a main method to run the program.
     *
     * @throws IO Exception
     * 
     */
       public static void main(String[] args) throws IOException
       
       {
    	   //Read the file clubName.txt to get the club details 
    	   Path filePath1 = Path.of("/Users/kailashbalachandiran/eclipse-workspace/SportsLeague/ClubName");

    	     String clubname = Files.readString(filePath1);
    	     
    	     String[] lines1 = clubname.split("\n");
    	     //list of clubs
    	     Club[] clubs = new Club[3];
    	     
    	     for(int i=0;i<lines1.length;i++) {
    	    	 //Defining the clubs
    	    	 clubs[i] = new Club (lines1[i]);
    	    	 
    	     }
    	     //Read the file PlayersName.txt to get the players details
    	     Path filePath2 = Path.of("/Users/kailashbalachandiran/eclipse-workspace/SportsLeague/PlayersName");
    	     
    	     String playername = Files.readString(filePath2);
    	     
    	     String[] lines2 = playername.split("\n");
    	     //list of players
    	     Player[] players = new Player[6];
    	     
    	     for(int i=0;i<lines2.length;i++) {
    	    	 
    	    	 String[] values = lines2[i].split(",");
    	    	//Defining the players
    	    	 players[i] = new Player(values[0],Integer.parseInt(values[1]),Integer.parseInt(values[2]),Integer.parseInt(values[3]),Integer.parseInt(values[4]));
    	    	 
    	     }
    	   

	  
	  //Defining all the clubs
	  Club club1 = new Club("Newcastle United");
	  Club club2 = new Club("Manchester City");
	  Club club3 = new Club("Liverpool");
	  
	
	  
	  
	  League league = new League("English Premier", 3);

	  
	  //Defining all the players
	  
	  Player player1 = new Player("Cristiano Ronaldo", 175, 1980, 10, 06);
	  Player player2 = new Player("Alistair Carter", 172, 1990, 12, 05);
	  Player player3 = new Player("Alan Iverson", 180, 1979, 12, 05);
	  Player player4 = new Player("Peter McDonald", 183, 2000, 11, 02);
	  Player player5 = new Player("Ibrahim Ozturk", 183, 1984, 10, 05);
	  Player player6 = new Player("Yoel Romero", 195, 1986, 10, 06);
	  
	  
	//Adds p1, p2 players to club1
      club1.addPlayer(player1);
      club1.addPlayer(player2);
        
       //Adds p3, p4 players to club2
      club2.addPlayer(player3);
      club2.addPlayer(player4);
      
       //Adds p5, p6 players to club2
      club3.addPlayer(player5);
      club3.addPlayer(player6);
      
      
      
      
      
      
      //Adds p1, p2 players to club1
      club1.addPlayerToTheTeam(player1);
      club1.addPlayerToTheTeam(player2);
      
      //Adds p1, p2 players to club1
      club2.addPlayerToTheTeam(player3);
      club2.addPlayerToTheTeam(player4);
      
     //Adds p1, p2 players to club1
      club3.addPlayerToTheTeam(player5);
      club3.addPlayerToTheTeam(player6);
      
      
      
       
      //Adds Clubs to League
     league.addClubToTheLeague(club1);
     league.addClubToTheLeague(club2);
     league.addClubToTheLeague(club3);
     
     
     
 
     

     //reading data from a file
     Path filePath = Path.of("/Users/kailashbalachandiran/eclipse-workspace/SportsLeague/Matches");

     String content = Files.readString(filePath);
     
//     System.out.println(content);
     
     //lines[0] = first line
     String[] lines = content.split("\n");
     
     //list if matches.
     Match[] matches = new Match[4];
     //matches[i] = new Match();
     
     int[] clubNumbers = {0,1,2,3,4};
     
     for(int i =0;i<lines.length;i++) {
    	 
    	 
          String[] values = lines[i].split(",");
    	 
    	 
    	 
    	 //values[0] = clubName in line 1
    	
//    	 Club club22 = league.LeagueClubs.get(Integer.parseInt(values[2]));
    	 
    	 
    	 matches[i] = new Match(values[0],Integer.parseInt(values[1]),Integer.parseInt(values[2]),league.LeagueClubs.get((int) (Math.random() * 2)), league.LeagueClubs.get( (int) (Math.random() * 2)));
    	 
//    	 Match match = new Match(values[0],Integer.parseInt(values[1]),);
    	 
     }
     

     //Match setup
     
     Match match1 = new Match("Old Traford", 22, 44, league.LeagueClubs.get(0), league.LeagueClubs.get(1));        
     Match match2 = new Match("Emirates", 10, 44, league.LeagueClubs.get(1), league.LeagueClubs.get(0));
     Match match3 = new Match("Newcastle", 10, 23, league.LeagueClubs.get(1), league.LeagueClubs.get(2));
     Match match4 = new Match("Old Traford", 10, 23, league.LeagueClubs.get(0), league.LeagueClubs.get(2));
     
      //Adds Match to League
     league.addMatchToTheLeague(match1);
     league.addMatchToTheLeague(match2);
     
     String str = "";
     //View fixtures - match not yet played; we expect 2 list of matches
     str += league.viewFixtures()+"\n";
     
     league.LeagueMatches.get(0).setMatchAsEndedOrPlayed();
     
     
     //Add goals to players
     league.LeagueMatches.get(0).playerScored(player3);
     league.LeagueMatches.get(0).playerScored(player3);
     league.LeagueMatches.get(0).playerScored(player4);
     league.LeagueMatches.get(0).playerScored(player2);
     
     
    league.LeagueMatches.get(0).setMatchAsEndedOrPlayed();
    league.LeagueMatches.get(1).setMatchAsEndedOrPlayed();
    
    
    
     System.out.println("**************Testing- 1st Match Only expected***************************************");
     
     
     league.LeagueMatches.get(0).getPlayersPlayedAndGoals();
     
     //View fixtures - match not yet played; - we expect only 1 club
     str += league.viewFixtures()+"\n";
     
     //View status of ended match by getting league result 
     str += league.leagueResults()+"\n";
    
     //View Top team or Club
     str += league.topClubInLeague()+"\n";
     
     System.out.println("\n");
      
     //Print League table
     str += league.printLeagueTable();
     
     System.out.println("\n");
     
      //View top scorer;
     str += league.topScorer()+"\n";
     
     league.LeagueClubs.get(0).setNameOfTheGoalKeeper("Musa");
     str += league.bestGoalKeeper()+"\n";
     
     

     //Printing the output on the file path
     String path = "/Users/kailashbalachandiran/eclipse-workspace/SportsLeague/output";
     
     Files.write( Paths.get(path), str.getBytes());
     
     
     
}
}
  

	  
	  
	  
 