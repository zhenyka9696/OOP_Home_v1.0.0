package com.company;

import java.util.*;

public class OOP_Home {
    public static void main(String[] args) {
        //->
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        Player player4 = new Player("Player 4");
        Player player5 = new Player("Player 5");
        Player player6 = new Player("Player 6");
        Player player7 = new Player("Player 7");
        Player player8 = new Player("Player 8");
        Player player9 = new Player("Player 9");
        Player player10 = new Player("Player 10");

        List<Player> players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        players.add(player7);
        players.add(player8);
        players.add(player9);
        players.add(player10);

        for (Player player : players) {
            player.working();
        }

        Game game1 = new Game("Game 1");
       Game game2 = new Game("Game 2");
        Game game3 = new Game("Game 3");
        Game game4 = new Game("Game 4");
        Game game5 = new Game("Game 5");
        Game game6 = new Game("Game 6");
        Game game7 = new Game("Game 7");
        Game game8 = new Game("Game 8");
        Game game9 = new Game("Game 9");
        Game game10 = new Game("Game 10");

        List<Game> games = new LinkedList<>();
        games.add(game1);
        games.add(game2);
        games.add(game3);
        games.add(game4);
        games.add(game5);
        games.add(game6);
        games.add(game7);
        games.add(game8);
        games.add(game9);
        games.add(game10);

        Rate rate = new Rate(players);
        for (Game game : games) {
            game.starter();
            rate.change();
        }
        //<-
        PlayerOpponent playerOpponent=new PlayerOpponent();
        System.out.println(playerOpponent.opponents());
            }
        }

 class PlayerOpponent{

    public  int[]getMoves() {
        return moves;
    }

    public PlayerOpponent() {
        this.moves=moves;
    }


    private int[] moves = {1, -2, 2, -1, 2, 1, 1, 2, -1, 2, -2, 1, -2, -1, -1, -2}; // Possible moves

    public   List<String> opponents() {
        List<String> opponents = new ArrayList<>();
        int success=0;
        for (int value:getMoves()){
            success+=value;
           }

        for (int n=1;n<11;n++){
            String number=Integer.toString(n);
            opponents.add("Player"+number+" Rate="+(success+(int)(Math.random()*401-201)));
            }

        return opponents;
        }

}

class Game {
    private final  String gameName;


    public String getGameName() {
        return gameName;
    }

    public Game(String gameName) {
        this.gameName=gameName;
    }
    public void starter() {
        System.out.println(getGameName()+" has begun!");//->
    }

/*    public void looking_for_game(){
        System.out.println(" Looking for game: "+ getGameName());
    }*/
}
class Player {
    public Player(String name){
        this.name=name;
    }
    public  String getName(){
        return name;
    }

    public int getRate(){
       return rate;
    }
    public void setRate(int rate){
        this.rate=rate;
    }
    private int rate;
private final String name ;

    public  void working(){
        System.out.println(getName()+
                " Run to the ball and glory!");
    }
}

class Rate {
    List <Player> players;

  public Rate(List<Player> players){
      this.players=players;
players.forEach(player -> player.setRate((int)(Math.random()*101)));
    }

    public void incRate(Player player){
        if(player.getRate()>50){
            System.out.println(player.getName()+" processing...");
            System.out.println("We have a winner in a game. It's: "+player.getName());
        }

player.setRate(player.getRate()+10);
System.out.println(" Congratulations, "+player.getName()+". Level up! Enjoy our future games. Rate="+player.getRate());
        }

        public void decRate(Player player){
            if(player.getRate()<-20){
                System.out.println(player.getName()+" processing...");
                System.out.println(player.getName()+ "is realy awful");
            }

            player.setRate(player.getRate()-10);
            //public void SadCongratulating()
            System.out.println("Congratulations, " +player.getName()+
                    " You are loser! Enjoy our future games. Rate="+player.getRate());

        }

public void change(){
      for(Player player:players){
          System.out.println("Last rate is: "+player.getRate());
          byte choice=(byte)(Math.random()*2);
          if(choice==0)incRate(player);
          else decRate(player);
          System.out.println("Overall rate is: " + player.getRate());
      }
}
 }