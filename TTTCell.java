public class TTTCell {
    // package access
    Seed content; // content of this cell of type Seed.
    // take a value of Seed.EMPTY, Seed.CROSS, or Seed.NOUGHT
    int row, col; // row and column of this cell, not used in this program
    TTTBoard tttboard;

    /** Constructor to initialize this cell */
    public TTTCell(int row, int col) {
        this.row = row;
        this.col = col;
        clear();  // clear content
    }

    /** Clear the cell content to EMPTY */
    public void clear() {
        content = Seed.EMPTY;
    }

    /** Paint itself */
    public void paint(int row, int col,int length) {
        tttboard = new TTTBoard();
//        System.out.println("length："+length);
        switch (content) {
            case CROSS:  System.out.print("X "); break;
            case NOUGHT: System.out.print("O "); break;
            case EMPTY:
                if(row * length + 1 + col <10){
                    System.out.print(row * length + 1 + col+" ");
                }else{
                    System.out.print(row * length + 1 + col);
                }
                break;
        }
    }
}

