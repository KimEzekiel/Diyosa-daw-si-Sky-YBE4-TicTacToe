class Player{
     static final String P1NAME = "Player 1";
     static final char P1SYMBOL = 'x';
     static final String P2NAME = "Player 2";
     static final char P2SYMBOL = 'o';

     private String name;;
     private char boardSymbol;
     private int score;
     private TicTacToe tictactoe;

     public Player(String name, char symbol, TicTacToe tictactoe){
          this.name = name;
          this.boardSymbol = symbol;
          this.tictactoe = tictactoe;
          this.score = 0;
     }
     /*Getters*/
     public String getName(){
          return this.name;
     }
     public char getBoardSymbol(){
          return this.boardSymbol;
     }
     public int getScore(){
          return this.score;
     }
     public TicTacToe getTicTacToe(){
          return this.tictactoe;
     }
     /*Setters*/
     public void setName(String name){
          this.name = name;
     }
     public void setBoardSymbol(char symbol){
          this.boardSymbol = symbol;
     }
     public void setTicTacToe(TicTacToe tictactoe){
          this.tictactoe = tictactoe;
     }
     /**/
}
