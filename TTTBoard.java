import java.util.Scanner;

public class TTTBoard {

    // package access
    private static Scanner in = new Scanner(System.in);  // input Scanner
    TTTCell[][] cells;  // a board composes of ROWS-by-COLS Cell instances
    int currentRow, currentCol;  // the current seed's row and column
    int width,length,connect;

    /** Constructor to initialize the game board */
    public TTTBoard() {
        cells = new TTTCell[10][10];  // allocate the array
        for (int row = 0; row < 10; ++row) {
            for (int col = 0; col < 10; ++col) {
                cells[row][col] = new TTTCell(row, col); // allocate element of the array
            }
        }
    }

    /** Initialize (or re-initialize) the contents of the game board */
    public void init() {
        for (int row = 0; row < width; ++row) {
            for (int col = 0; col < length; ++col) {
                cells[row][col].clear();  // clear the cell content
            }
        }
//        System.out.println("w="+width);
    }

    /** Return true if it is a draw (i.e., no more EMPTY cell) */
    public boolean isDraw() {
        for (int row = 0; row < width; ++row) {
            for (int col = 0; col < length; ++col) {
                if (cells[row][col].content == Seed.EMPTY) {
                    return false; // an empty seed found, not a draw, exit
                }
            }
        }
        return true; // no empty cell, it's a draw
    }
//    public boolean istheSeed(Seed theSeed, int crow, int ccol){
//        return(cells[currentRow][ccol].content == theSeed);
//    }

    /** Return true if the player with "theSeed" has won after placing at
     (currentRow, currentCol) */
    public boolean hasWon(Seed theSeed) {
        //n-in-a-line
        int count=0;
        for(int j=0;j<length;j++)
        {
            if(cells[currentRow][j].content == theSeed){
                count++;//connect n in a row
                if(count==connect) return true;
            }
            else{
                count=0;
            }
        }
        //n-in-a-col
        count=0;
        for(int i=0;i<width;i++)
        {
            if(cells[i][currentCol].content == theSeed){
                count++;//connect n in a col
                if(count==connect) return true;
            }
            else{
                count=0;
            }
        }
        //diagonal\
        count=0;
        if(currentCol>=currentRow){//cells[0][currentCol-currentRow].content == theSeed
            for(int i=0;i<width && i>=currentRow-currentCol;i++){
                if(cells[i][currentCol-currentRow+i].content == theSeed)
                {
                    count++;//connect n in a diagonal\\\\\\\\
                    if(count==connect) return true;
                }
                else{
                    count=0;
                }
            }
        }
        else{//cells[currentRol-currentCow][0].content == theSeed
            for(int j=0;j<length&&j>=currentCol-currentRow;j++){
                if(cells[currentRow-currentCol+j][j].content == theSeed)
                {
                    count++;
                    if(count==connect) return true;
                }
                else{
                    count=0;
                }
            }
        }
        //diagonal/
        count=0;
        if(currentCol+currentRow<length){
            for(int i=0;i<width&&i<=currentCol+currentRow;i++){//cells[0][currentCol+currentRow].content == theSeed
                if(cells[i][currentCol+currentRow-i].content == theSeed)
                {
                    count++;//connect n in a diagonal///////
                    if(count==connect) return true;
                }
                else{
                    count=0;
                }
            }
        }
        else{
            for(int i=0;i<length&&currentCol+currentRow-length+1+i>=0;i++){//cells[0][currentCol+currentRow].content == theSeed
                if(cells[currentCol+currentRow-length+1+i][length-1-i].content == theSeed)
                {
                    count++;
                    if(count==connect) return true;
                }
                else{
                    count=0;
                }
            }
        }
        return false;
    }

    /** Paint itself */
    public void paint() {
        for(int i=0;i<length;i++)
        {
            System.out.print("+--");
        }
        System.out.println("+");
//        System.out.println("+--+--+--+");
        for (int row = 0; row < width; ++row) {
            System.out.print("|");
            for (int col = 0; col < length; ++col) {
                cells[row][col].paint(row,col,length);
//                System.out.println(row+" "+col);
                if (col != length - 1) {
                    System.out.print("|");
                }
            }
            System.out.print("|");
            System.out.println();
            if (row != width - 1) {
                for(int i=0;i<length;i++)
                {
                    System.out.print("+--");
                }
                System.out.println("+");
            }
        }
        for(int i=0;i<length;i++)
        {
            System.out.print("+--");
        }
        System.out.println("+");
        System.out.println();
    }
}
