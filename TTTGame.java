import java.util.Scanner;
import java.util.regex.Pattern;

public class TTTGame {
    private TTTBoard board;            // the game board
    private GameState currentState; // the current state of the game (of enum GameState)
    private Seed currentPlayer;     // the current player (of enum Seed)
    private PlayerState playerWill; // will the game restart (of enum PlayerState)
    private TTTPlayer player;
    String width_,length_,connect_,input_;
    int input;


    private static Scanner in = new Scanner(System.in);  // input Scanner
    public static Scanner in_ = new Scanner(System.in);  // another input Scanner
    public static Scanner in2_ = new Scanner(System.in);  // another input Scanner
    private static Scanner w = new Scanner(System.in);
    private static Scanner l = new Scanner(System.in);
    private static Scanner p = new Scanner(System.in);

    /**
     * Constructor to setup the game
     */
    public TTTGame() {
        System.out.print("Welcome to Tic Tac Toe!\n" +
                "We now have a more diverse chessboard:\n" +
                "~~~You can choose any rectangular checkerboard size (3<=length, width<=9) you like\n" +
                "~~~You can set up how many pieces to connect to win(must bigger than 3 and smaller than the length and width)\n" +
                "~~~You can play on behalf of your team as long as you enter your team number(1-9)," +
                "we support 9 teams playing at the same time");
        System.out.println();
        System.out.println();
        board = new TTTBoard();  // allocate game-board
        player = new TTTPlayer();
        // Initialize the game-board and current status using initGame()
        do{
            player.ioinstruct();
            initGame();
//            System.out.println("Please input the width of board(3>=width>=9)");
//            board.width = w.nextInt();

            do{
                System.out.println("Please input the width of board(3<=width<=9)");
                width_=w.nextLine();
                if(Pattern.matches("\\d+",width_))
                {
                    board.width=Integer.parseInt(width_);
                    if((board.width>9||board.width<3))
                    {
                        System.out.println("Input invalid, try again");
                    }
                }
                else
                {
                    System.out.println("Input invalid, try again");
                }
            }while((!Pattern.matches("\\d+",width_))||(board.width>9||board.width<3));


//            System.out.println("Please input the length of board(3>=length>=9)");
//            board.length = l.nextInt();
            do{
                System.out.println("Please input the length of board(3<=length<=9)");
                length_=l.nextLine();
                if(Pattern.matches("\\d+",length_))
                {
                    board.length=Integer.parseInt(length_);
                    if((board.length>9||board.length<3))
                    {
                        System.out.println("Input invalid, try again");
                    }
                }
                else
                {
                    System.out.println("Input invalid, try again");
                }
            }while((!Pattern.matches("\\d+",length_))||(board.length>9||board.length<3));


            board.paint();

//            System.out.println("How many pieces do you need to connect to win?(3<=pieces<=min(length,width))");
//            board.connect = p.nextInt();

            do{
                System.out.println("How many pieces do you need to connect to win?(3<=pieces<=min(length,width))");
                connect_=p.nextLine();
                if(Pattern.matches("\\d+",connect_))
                {
                    board.connect=Integer.parseInt(connect_);
                    if((board.connect>board.length||board.connect>board.width||board.connect<3))
                    {
                        System.out.println("Input invalid, try again");
                    }
                }
                else
                {
                    System.out.println("Input invalid, try again");
                }
            }while((!Pattern.matches("\\d+",connect_))||(board.connect>board.length||board.connect>board.width||board.connect<3));

            //show the board at the begin.
            board.paint();
            // Play the game unless players want to stop the game.
            do {
                playerMove(currentPlayer); // update the content, currentRow and currentCol
                board.paint();             // paint the board with the new move
                updateGame(currentPlayer); // update currentState
                // Print message if the winner appears
                if (currentState == GameState.CROSS_WON) {
                    player.crosswin();
                } else if (currentState == GameState.NOUGHT_WON) {
                    player.noughtwin();
                } else if (currentState == GameState.DRAW) {
                    player.stalemate();
                }
                // Switch player
                currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
            } while (currentState == GameState.PLAYING);  // repeat until winner appears
            int temp = 0;
            do {
                System.out.print("Continue the game? (y/n)");  // ask players if they want to leave
                String ans = in_.next();  // y/n

                if (ans.equals("n"))  // stop the game
                {
                    playerWill = PlayerState.STOP;
                    temp = 1;
                }
                else if(ans.equals("y")) {  // continue the game
                    playerWill = PlayerState.CONTINUE;
                    temp = 2;
                }
                else{
                    System.out.println("input wrong, try again");
                }
            }while(temp == 0);
        }while(playerWill == PlayerState.CONTINUE);  // if they continue the game
        player.showresult();
    }

    /**
     * Initialize the game-board contents and the current states
     */
    public void initGame() {
        board.init();  // clear the board contents
        do {
            System.out.print("who wants go first? "+player.team[player.t1][player.teamnumber[player.t1]-1]+" (O) or "+player.team[player.t2][player.teamnumber[player.t2]-1]+" (X)?");
            String ans = in2_.nextLine();  // y/n
            if (ans.equals("O") || ans.equals(player.team[player.t1][player.teamnumber[player.t1]-1])) {
                currentPlayer = Seed.NOUGHT;
                System.out.println(player.team[player.t1][player.teamnumber[player.t1]-1]+"(O) go first");
            } else if (ans.equals("X")||ans.equals(player.team[player.t2][player.teamnumber[player.t2]-1])) {
                currentPlayer = Seed.CROSS;
                System.out.println(player.team[player.t2][player.teamnumber[player.t2]-1]+"(X) go first");
            } else {
                System.out.println("input wrong, try again");
            }
        }while(currentPlayer != Seed.NOUGHT && currentPlayer != Seed.CROSS);
//        currentPlayer = Seed.CROSS;       // CROSS plays first
        currentState = GameState.PLAYING; // ready to play
        playerWill = PlayerState.CONTINUE; // still play
    }

    /**
     * The player with "theSeed" makes one move, with input validation.
     * Update Cell's content, Board's currentRow and currentCol.
     */
    public void playerMove(Seed theSeed) {
        boolean validInput = false;  // for validating input
        do {
            if (theSeed == Seed.CROSS) {
//                System.out.print(player.team[player.t2][player.teamnumber[player.t2]]+"Player X Enter your move(input the number): ");
                player.crossask();
            } else {
//                System.out.print("Player O Enter your move(input the number): ");
                player.noughtask();
            }
            input_ = in.nextLine();
            if(Pattern.matches("\\d+",input_))
            {
                input=Integer.parseInt(input_);

            int row,col;
            if(input<=board.width*board.length)
            {
                if(input % board.length!=0)
                {
                    row = input/board.length;
                    col = input % board.length-1;
                }
                else{
                    row = input/board.length-1;
                    col = board.length - 1;
                }
            }
            else
            {
                row = -1;
                col = -1;
            }
            if (row >= 0 && row < board.width && col >= 0 && col < board.length
                    && board.cells[row][col].content == Seed.EMPTY) {
                board.cells[row][col].content = theSeed;
                board.currentRow = row;
                board.currentCol = col;
                validInput = true; // input okay, exit loop
            } else {
                System.out.println("This move is not valid. Try again");
            }
            }
            else
            {
                System.out.println("This move is not valid. Try again");
            }
        } while (!validInput);   // repeat until input is valid
    }

    /**
     * Update the currentState after the player with "theSeed" has moved
     */
    public void updateGame(Seed theSeed) {
        if (board.hasWon(theSeed)) {  // check for win
            currentState = (theSeed == Seed.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
        } else if (board.isDraw()) {  // check for draw
            currentState = GameState.DRAW;
        }
    }

    /**
     * The entry main() method
     */
    public static void main(String[] args) {
        new TTTGame();  // the main is used only as an endpoint that initiates the execution of the program and does not contain any actual program specific logic
    }
}
