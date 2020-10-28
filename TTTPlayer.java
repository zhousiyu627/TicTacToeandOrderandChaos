import java.util.Scanner;
import java.util.regex.Pattern;

public class TTTPlayer {
    String playername;
    String[][] team=new String[11][11];
    int[] teamnumber=new int[10];
    int[][] teamcount=new int[10][3];
    int t1,t2;
    String tt1,tt2;
    private static Scanner player1 = new Scanner(System.in);
    private static Scanner player2 = new Scanner(System.in);
    private static Scanner team1 = new Scanner(System.in);
    private static Scanner team2 = new Scanner(System.in);

    public TTTPlayer(){

    }
    public void ioinstruct(){
        System.out.println("Player1, please tell me your name");
        playername = player1.nextLine();
        //input name
        System.out.println("You will use piece 'O'");
        do{
            System.out.println(playername+", what is your team number(1-9)?");
            tt1=team1.nextLine();
            if(Pattern.matches("\\d+",tt1))
            {
                t1=Integer.parseInt(tt1);
                if((t1>9||t1<1))
                {
                    System.out.println("Input invalid, try again");
                }
            }
            else
            {
                System.out.println("Input invalid, try again");
            }
        }while((!Pattern.matches("\\d+",tt1))||(t1>9||t1<1));
        team[t1][teamnumber[t1]]=playername;
        teamnumber[t1]++;
        //input team name
        System.out.println("Player2, please tell me your name");
        playername = player2.nextLine();
        System.out.println("You will use piece 'X'");
        do{
            System.out.println(playername+", what is your team number(1-9)?");
            tt2=team2.nextLine();
            if(Pattern.matches("\\d+",tt2))
            {
                t2=Integer.parseInt(tt2);
                if((t2>9||t2<1))
                {
                    System.out.println("Input invalid, try again");
                }
                else if(t2==t1){
                    System.out.println("You can't be the same team as "+team[t1][teamnumber[t1]-1] +", try again");
                }
            }
            else
            {
                System.out.println("Input invalid, try again");
            }
        }while((!Pattern.matches("\\d+",tt2))||(t2>9||t2<1||t2==t1));
        team[t2][teamnumber[t2]]=playername;
        teamnumber[t2]++;
    }
    public void showresult(){
        for(int i=0;i<10;i++)
        {
            if(teamcount[i][0]+teamcount[i][1]+teamcount[i][2]!=0)
            {
                System.out.println("Team "+i+" has player: ");
                System.out.print("{");
                for(int j=0;j<teamnumber[i];j++)
                {
                    System.out.print(team[i][j]+"; ");
                }
                System.out.print("}");
                System.out.println();
                System.out.println("They total win: " + teamcount[i][0]);
                System.out.println("They total lose: " + teamcount[i][1]);
                System.out.println("Stalemate: " + teamcount[i][2]);
                System.out.println();
            }
        }
        System.out.println("Bye");
    }
//    public void isnum(String s){//is the input 1-9?
//
//    }
    public void crosswin(){
        teamcount[t2][0]++;
        teamcount[t1][1]++;
        System.out.println(team[t2][teamnumber[t2]-1]+" won");
    }
    public void noughtwin(){
        teamcount[t1][0]++;
        teamcount[t2][1]++;
        System.out.println(team[t1][teamnumber[t1]-1]+" won");
    }
    public void stalemate(){
        teamcount[t1][2]++;
        teamcount[t2][2]++;
        System.out.println("STALEMATE");
    }
    public void crossask(){
        System.out.print(team[t2][teamnumber[t2]-1]+", enter your move(input the number): ");
    }
    public void noughtask(){
        System.out.print(team[t1][teamnumber[t1]-1]+", enter your move(input the number): ");
    }
}
