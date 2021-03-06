package game;
import gui.*;
public class TicTacToe{
     static final int PLYER_NUM = 2;
     static final int BOARD_HGHT = 3;
     static final int BOARD_WDTH = 3;

     private char[][] board;
     private int rounds;
     private Player[] players;
     /*current states*/
     private int currPlayer;
     private int currentRound;
     private int currTurnNumber;   //current turn number, start:1, end:
     private Player winner;
     private Board gui;

     public TicTacToe(int rounds, Player player1, Player player2){
          this.rounds = rounds;
          this.board = new char[BOARD_HGHT][BOARD_WDTH];
          for(int i = 0; i < BOARD_HGHT;i ++ ){
               for(int j = 0; j < BOARD_WDTH; j++){
                    this.board[i][j] = ' ';
               }
          }
               /*create players*/
          this.players = new Player[PLYER_NUM];
          this.players[0] = player1;
          this.players[1] = player2;
          player2.setTicTacToe(this);
          player1.setTicTacToe(this);

          this.currentRound = 0;
          this.currTurnNumber = 0;
          this.currPlayer = 0;

          this.gui = new Board(this);
     }
     /*Getters*/
     public Board getGui(){
          return this.gui;
     }
     public char[][] getBoard(){
          return this.board;
     }
     public int getRounds(){
          return this.rounds;
     }
     public int getCurrentRound(){
          return this.currentRound;
     }
     public Player[] getPlayers(){
          return players;
     }
     public int getCurrentPlayerNum(){
          if(this.currentRound%2 == 0){
               this.currPlayer = (this.currTurnNumber%2 == 0)? 0:1;
          }else{
               this.currPlayer = (this.currTurnNumber%2 == 0)? 1:0;
          }
          return this.currPlayer;
     }
     public Player getCurrentPlayer(){
          return this.players[this.getCurrentPlayerNum()];
     }
     public int getCurrentTurn(){
          return this.currTurnNumber;
     }
     public Player getWinner(){
          if(players[0].getScore() > players[1].getScore()){
               this.winner = players[0];
          }else if (players[0].getScore() < players[1].getScore()){
               this.winner = players[1];
          }else this.winner = null;
          return this.winner;

     }
     // public int getDraw(){
     //      return this.draw;
     // }
     /*Setters*/
     public void setRounds(int rounds){
          this.rounds = rounds;
     }

     public void nextRound(){
          this.currTurnNumber = 0;
          this.currentRound++;
          /*clear the board*/
          for(int i = 0; i < TicTacToe.BOARD_HGHT; i++){
               for(int j = 0; j < TicTacToe.BOARD_WDTH; j++){
                    this.board[i][j] = ' ';
               }
          }
          this.gui.resetButtons();
          this.gui.updatePlayerTurn();
     }
     public void nextTurn(){
          this.currTurnNumber++;
          if(this.currTurnNumber >= 9){
               this.nextRound();
          }
     }
     private void startCheckers(){
          /*check if someone gets a point*/
          Thread hChecker = new Thread(new HorizontalChecker(this));
          Thread vChecker = new Thread(new VerticalChecker(this));
          Thread dChecker = new Thread(new DiagonalChecker(this));
          hChecker.start();
          vChecker.start();
          dChecker.start();
          try{
                vChecker.join();
                hChecker.join();
                dChecker.join();
          }catch(Exception e){
              System.out.println("Interrupted at join.");
          }
     }
     /*other methods*/
     public void playerMoves(int x, int y){
          /*operation for movement*/
          if(this.currentRound < this.rounds){   //game is ongoing
               if(this.currTurnNumber < 9){ //a round is ongoing
                    /*ether player makes a move*/
                    // this.gui.updatePlayerTurn();
                    // int toMove = this.getCurrentPlayerNum();
                    this.players[this.getCurrentPlayerNum()].mark(x,y);
                    /*next turn*/
                    this.currTurnNumber++;
                    /*check is round is finished*/
                    this.startCheckers();

                    if(this.currTurnNumber >= 9 ){
                         this.nextRound();
                    }
                    if(this.currentRound >= this.rounds){
                         // this.gui.closeGame();
                         // System.out.println((this.getWinner() == null)? "It's a tie": this.getWinner().getName() + "wins ");
                         this.gui.updateWinner((this.getWinner() == null)? 2:(this.getWinner() == players[0])? 0:1);
                    }
                    this.gui.updatePlayerTurn();
               }
               this.printBoard();
          }else{     //end of game, get winner
               System.out.println((this.getWinner() == null)? "It's a tie": this.getWinner().getName() + "wins ");
          }
     }
     public void printBoard(){
          for(int i = 0; i < BOARD_HGHT; i++){
               System.out.println(this.board[i]);
          }
     }
}
