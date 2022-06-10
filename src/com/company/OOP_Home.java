package com.company;

//import java.util.LinkedList;
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
        for (Game game : games) {//used to be
            game.starter();
            rate.change();
        }
        //<-

        Scanner scanner = new Scanner(System.in);
        System.out.println("Внимание, некорректная функция!");
        System.out.println("Введите размер таблицы общего рейтинга оппонента(x&&y)");
        PlayerOpponent.setHome(scanner.nextInt() + 4) ;
        System.out.println("Начальное положение общего рейтинга по успеху оппонента(0..n): ");
        int success =PlayerOpponent.setHome(PlayerOpponent.getHome() - scanner.nextInt() - 3); // home - scanner.nextInt() - 3;
        System.out.println("Начальное положение общего рейтинга по провалу оппонента(0..n): ");
        int failure = scanner.nextInt() + 2;

        PlayerOpponent.setEventGrid(new int[PlayerOpponent.getHome()][PlayerOpponent.getHome()]);
        PlayerOpponent.setGeneralSuccess((PlayerOpponent.getGeneralSuccess()-4)*(PlayerOpponent.getGeneralSuccess()-4));

        for (int s = 0; s < PlayerOpponent.getHome(); s++) {
            for (int f = 0; f < PlayerOpponent.getHome(); f++) {
                if (s < 2 || s > PlayerOpponent.getHome() - 3 || f < 2 || f > PlayerOpponent.getHome() - 3) {
                    PlayerOpponent.setEventGrid_sf(s,f,-1);//eventGrid[s][f] = -1;
                }
            }
        }

        PlayerOpponent.setEventGrid_successfailure(success,failure,-1);//eventGrid[success][failure]=1;
        if(PlayerOpponent.solve(success,failure,2)){
            PlayerOpponent.printResult();
            }
        else System.out.println("no result");
    }


}

class PlayerOpponent{

public static int getHome() {
        return home;
    }

    public static int setHome(int home) {
        PlayerOpponent.home = home;
        return home;
    }

    public static int[][] getMoves() {
        return moves;
    }

    public static void setMoves(int[][] moves) {
        PlayerOpponent.moves = moves;
    }

    public static int[][] getEventGrid() {
        return eventGrid;
    }

    public static void setEventGrid(int[][] eventGrid) {
        PlayerOpponent.eventGrid = eventGrid;
    }

    public static int getEventGrid_sf(int s,int f){
    return eventGrid[s][f];
    }

    public static void setEventGrid_sf(int s,int f,int eventGrid_sf){
    eventGrid[s][f]=eventGrid_sf;
    }

    public static int getEventGrid_successfailure(int success,int failure){
        return eventGrid[success][failure];
    }

    public static void setEventGrid_successfailure(int success,int failure,int eventGrid_successfailure){
        eventGrid[success][failure]=eventGrid_successfailure;
    }

    public static int getGeneralSuccess() {
        return generalSuccess;
    }

    public static void setGeneralSuccess(int generalSuccess) {
        PlayerOpponent.generalSuccess = generalSuccess;
    }

    public PlayerOpponent(int home, int[][] moves, int[][] eventGrid, int generalSuccess) {
        this.moves=moves;
        this.eventGrid=eventGrid;
        this.generalSuccess=generalSuccess;
        this.home=home;
    }

    private static int home;
    private static int[][] moves = {{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}}; // Possible moves by knight on chess
    private static int[][] eventGrid;    // grid
    private static int generalSuccess;   // total squares
    // Return True when solvable
    public static boolean solve(int success, int failure, int count) {
        List<int[]> coach = coaches(success, failure);

        if (coach.isEmpty() && count != generalSuccess) {
            return false;
        }

        Collections.sort(coach, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });

        for (int[] aa : coach) {
            success = aa[0];
            failure = aa[1];
            eventGrid[success][failure] = count;
            //->
            if (!semi_final(generalSuccess, success, failure) && solve(success, failure, count + 1)) {
                return true;
            }
            eventGrid[success][failure] = 0;
        }

        return false;
    }

    // Returns List of coaches
    private static List<int[]> coaches(int success, int failure) {
        List<int[]> coach = new ArrayList<>();
        for (int[] m : moves) {
            int x = m[0];
            int y = m[1];
            if (eventGrid[success + y][failure + x] == 0) {
                int num = countCoaches(success + y, failure + x);
                coach.add(new int[]{success + y, failure + x, num});
            }
        }
        return coach;
    }

    // Returns the generalSuccess of coaches
    private static int countCoaches(int success, int failure) {
        int num = 0;
        for (int[] m : moves) {
            if (eventGrid[success + m[1]][failure + m[0]] == 0) {
                num++;
            }
        }
        return num;
    }

    // Returns true if it is semi_final
    private static boolean semi_final(int count, int success, int failure) {
        if (count < generalSuccess - 1) {
            List<int[]> coach = coaches(success, failure);
            for (int[] aa : coach) {
                if (countCoaches(aa[0], aa[1]) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    // Prints the result grid
    public static void printResult() {
        for (int[] success : eventGrid) {
            for (int i : success) {
                if (i == -1) {
                    continue;
                }
                System.out.printf("%2d ", i);
            }
            System.out.println();
        }
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

    public void looking_for_game(){
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