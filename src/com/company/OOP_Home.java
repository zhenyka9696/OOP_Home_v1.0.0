package com.company;

//import java.util.LinkedList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OOP_Home {
    public static void main(String[] args) {
       //GameSeason gameSeason = new GameSeason("1");
       //->
        //gameSeason.Starter();
        Player player1 = new Player("Player 1");
        player1.working();
        Player player2  = new Player("Player 2");
        player2.working();
        Player player3 = new Player("Player 3");
        player3.working();
        Player player4  = new Player("Player 4");
        player4.working();
        Player player5 = new Player("Player 5");
        player5.working();
        Player player6  = new Player("Player 6");
        player6.working();
        Player player7 = new Player("Player 7");
        player7.working();
        Player player8  = new Player("Player 8");
        player8.working();
        Player player9 = new Player("Player 9");
        player9.working();
        Player player10  = new Player("Player 10");
        player10.working();

        List<Player> players=new LinkedList<>();
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

        Game game1 = new Game("Game 1");
        Rate rate=new Rate(players);
        rate.change(player1);
        rate.change(player2);
        rate.change(player3);
        rate.change(player4);
        rate.change(player5);
        rate.change(player6);
        rate.change(player7);
        rate.change(player8);
        rate.change(player9);
        rate.change(player10);
        Game game2 = new Game("Game 2");
        rate.change(player1);
        rate.change(player2);
        rate.change(player3);
        rate.change(player4);
        rate.change(player5);
        rate.change(player6);
        rate.change(player7);
        rate.change(player8);
        rate.change(player9);
        rate.change(player10);
        Game game3 = new Game("Game 3");
        rate.change(player1);
        rate.change(player2);
        rate.change(player3);
        rate.change(player4);
        rate.change(player5);
        rate.change(player6);
        rate.change(player7);
        rate.change(player8);
        rate.change(player9);
        rate.change(player10);
        Game game4 = new Game("Game 4");
        rate.change(player1);
        rate.change(player2);
        rate.change(player3);
        rate.change(player4);
        rate.change(player5);
        rate.change(player6);
        rate.change(player7);
        rate.change(player8);
        rate.change(player9);
        rate.change(player10);
        Game game5 = new Game("Game 5");
        rate.change(player1);
        rate.change(player2);
        rate.change(player3);
        rate.change(player4);
        rate.change(player5);
        rate.change(player6);
        rate.change(player7);
        rate.change(player8);
        rate.change(player9);
        rate.change(player10);
        Game game6 = new Game("Game 6");
        rate.change(player1);
        rate.change(player2);
        rate.change(player3);
        rate.change(player4);
        rate.change(player5);
        rate.change(player6);
        rate.change(player7);
        rate.change(player8);
        rate.change(player9);
        rate.change(player10);
        Game game7 = new Game("Game 7");
        rate.change(player1);
        rate.change(player2);
        rate.change(player3);
        rate.change(player4);
        rate.change(player5);
        rate.change(player6);
        rate.change(player7);
        rate.change(player8);
        rate.change(player9);
        rate.change(player10);
        Game game8 = new Game("Game 8");
        rate.change(player1);
        rate.change(player2);
        rate.change(player3);
        rate.change(player4);
        rate.change(player5);
        rate.change(player6);
        rate.change(player7);
        rate.change(player8);
        rate.change(player9);
        rate.change(player10);
        Game game9 = new Game("Game 9");
        rate.change(player1);
        rate.change(player2);
        rate.change(player3);
        rate.change(player4);
        rate.change(player5);
        rate.change(player6);
        rate.change(player7);
        rate.change(player8);
        rate.change(player9);
        rate.change(player10);
        Game game10 = new Game("Game 10");
        rate.change(player1);
        rate.change(player2);
        rate.change(player3);
        rate.change(player4);
        rate.change(player5);
        rate.change(player6);
        rate.change(player7);
        rate.change(player8);
        rate.change(player9);
        rate.change(player10);
        List<Game> games=new LinkedList<>();
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

    //    List<int[]> = coaches(success, failure);

      }
   // {     List<int[]> coaches=new ArrayList<>();    }
}



class Game {
    private  String gameName;

    public String getGameName() {
        return gameName;
    }

    public Game(String gameName) {
        this.gameName=gameName;
    }
    public void Starter() {
        System.out.println("The game has begun!" + getGameName());
    }

    public void Looking_for_game(){
        System.out.println(" Looking for game: "+ getGameName());
    }
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
private  String name ;

    public  void working(){
        System.out.println(getName()+
                " Run to the ball and glory!");
    }
}

/*class Games {
    public String getSingleGame() {
        return singleGame;
    }

      private final String singleGame;

    public Games(String singleGame){
        this.singleGame =singleGame;
    }
    //->
}*/

/*class GameSeason extends Games {
    private final LinkedList<String> game;
        public GameSeason(String singleGame) {
        super(singleGame);
        //<-
        game = new LinkedList<>();
        game.add("Game 1");
        game.add("Game 2");
        game.add("Game 3");
        game.add("Game 4");
        game.add("Game 5");
        game.add("Game 6");
        game.add("Game 7");
        game.add("Game 8");
        game.add("Game 9");
        game.add("Game 10");
    }*/
//}

class Rate {
  public Rate(List<Player> players){
players.forEach(player -> player.setRate((int)(Math.random()*101)));
    }


    public void incRate(Player player){
        if(player.getRate()>101){
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
                    "You are loser! Enjoy our future games. Rate="+player.getRate());

        }

    public void change(Player player){
        System.out.println("Last rate is: "+player.getRate());
      byte choice =(byte)(Math.random()*2);
      if (choice==0) incRate(player);
      else decRate(player);
        System.out.println("Overall rate is: "+player.getRate());
    }
}