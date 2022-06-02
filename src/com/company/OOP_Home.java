package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class OOP_Home {
    public static void main(String[] args) {
       GameSeason gameSeason = new GameSeason((byte) 0);
        ArrayList<Player> players=new ArrayList<>();
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
        players.add(new Player("Player 3"));
        players.add(new Player("Player 4"));
        players.add(new Player("Player 5"));
        players.add(new Player("Player 6"));
        players.add(new Player("Player 7"));
        players.add(new Player("Player 8"));
        players.add(new Player("Player 9"));
        players.add(new Player("Player 10"));
        //RatingPlus ratingPlus=new RatingPlus("Player+");
        //RatingMinus ratingMinus=new RatingMinus("Player-");

    }
}
class Player {
    public Player(String name){
        this.name=name;
    }
    public static String getName(){
        return name;
    }
private static String name = null;
    public void working(){
        System.out.println(getName()+
                "Run to the ball and glory!");
    }
}

class Games {
    public byte getSingleGame() {
        return singleGame;
    }

    private final byte singleGame;
    public Games(byte singleGame){

        this.singleGame=singleGame;
    }
}

class GameSeason extends Games {
    private final LinkedList<Integer> game;

    public GameSeason(byte singleGame) {
        super(singleGame);
        game = new LinkedList<>();
        game.add(1);
        game.add(2);
        game.add(3);
        game.add(4);
        game.add(5);
        game.add(6);
        game.add(7);
        game.add(8);
        game.add(9);
        game.add(10);
    }


    public void Starter() {
        System.out.println("The game has begun!" + getSingleGame());
    }

    public void Looking_for_game(byte number){
        System.out.println(getSingleGame()+" Looking for game: "+ game.get(number));
    }
}

class RatingPlus extends Player {
    public RatingPlus(String name) {
        super(name);
    }

    public void Playing(){
        System.out.println(getName()+" processing...");
    }
    public void GameResult(){
        System.out.println("We have a winner in game"+getName());
    }
class RatePlus extends Rate{

    public RatePlus(int rate) {
        super(rate);
        rate+=10;
    }

    public void Congratulating(){
System.out.println(getName()+
        "Congratulations,player. Level up! Enjoy our future games. Rate="+getRate());
    }
    }
}

class Rate  {
    public int getRate() {
        return rate;
    }

    private int rate=0;//!
    public Rate(int rate){

        this.rate= Integer.parseInt(Player.getName());//!

    }
}

class RatingMinus extends Player {
    public RatingMinus(String name) {
        super(name);
    }

    public void Playing() {
        System.out.println(getName() + " processing...");
    }

    public void GameResult() {
        System.out.println("We have a winner in game" + getName());
    }

    class RateMinus extends Rate {

        public RateMinus(int rate) {
            super(rate);
            rate -= 10;
        }


        public void Congratulating() {
            System.out.println(getName() + "Congratulations,player." +
                    "You are loser! Enjoy our future games. Rate="+getRate());
        }
    }
}

