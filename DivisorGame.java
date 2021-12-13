// Divisor Game
//
// This program officiates the Divisor Game between two players, which is played
// as follows:  an initial positive integer n is picked.  All factors of n 
// (including 1 and n) are displayed.  Player1 picks a number off of this list--that
// number and all its factors are eliminated.  Then Player2 picks a number and so on.
// The player who picks n looses.

import java.util.Scanner;

public class DivisorGame
{
	public static Scanner kbd = new Scanner(System.in);

	public static void main(String [] args)
	{
		int n, turn = 0, i, pick;
		String [] player = new String[2];
		boolean [] alive;
      
      System.out.println("\n");
      System.out.println("Mohammed Hamed, cs-200-3, Summer 2016.");
		System.out.println("Assignment 5:  Divisor Game");
      				
		getPlayerNames(player);
		n = getGameValue();

		alive = new boolean[n+1];
		
		initializeArray(n, alive);
		
		while (alive[n])
		{
			turn = (turn + 1) % 2;
			playOneTurn(n, alive, turn, player);
		}
		
		System.out.println("\nYou lose, " + player[turn] + "!");
		System.out.println("\nBye!");
	}

//*******************************************************************
			
	public static void getPlayerNames(String [] player)
	{
		System.out.print("\nEnter the FIRST player's name:  ");
		player[1] = kbd.nextLine();
		System.out.print("Enter the SECOND player's name:  ");
		player[0] = kbd.nextLine();
	}
	
//*******************************************************************
			
	public static int getGameValue()
	{
      int n=0;
      
      for(int i=1; i==1; ){
         System.out.println();
         System.out.print("Enter a positive integer n: ");
         n=kbd.nextInt();
         if(n>0)
            i=2;
      }
      return n; 
	}
	
//*******************************************************************
			
	public static void initializeArray(int n, boolean [] alive)
	{
      for(int i=1; i<=n; i++){
         if(n%i==0)
            alive[i]= true;
         else
            alive[i]= false;
       }


	}
		
//*******************************************************************
			
	public static void playOneTurn(int n, boolean [] alive, int turn, String [] player)
	{
		int pick=0, i;
		
         System.out.println();
		   System.out.println(player[turn] + ", pick one of the following integers:  ");
		   displayValues(n, alive);

		   System.out.print(player[turn] + ", which do you pick?:  ");
		   pick = kbd.nextInt();
		
         if(pick<1 || pick>n || alive[pick]==false){
            System.out.println();
            System.out.print(player[turn]+ ", you MUST pick one of the integers below: ");
            System.out.println();
            displayValues(n, alive);
            
            System.out.print(player[turn] + ", which do you pick?:  ");
		      pick = kbd.nextInt();
         }   
         
         for(i=1; i<=pick; i++){
            if(pick%i==0)
               alive[i]=false;
         }               

	}
	
//*****************************************************************************************
	
	public static void displayValues(int n, boolean [] alive)
	{    
      int i;
      
      for(i=n; i>=1; i--){
         if(alive[i]==true)
            System.out.print(n/i + " ");
      }
		System.out.println();
	}

//*******************************************************************
}  // end public class DivisorGame
