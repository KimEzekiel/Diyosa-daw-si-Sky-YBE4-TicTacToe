class TicTacToe{
     static final int PLYER_NUM = 2;
     static final int BOARD_HGHT = 3;
     static final int BOARD_WDTH = 3;

     private char[][] board;
     private int rounds;
     private Player[] players;
     private int currPlayerCount;
     private int currentRound;
     private int currTurnNumber;
     private Player winner;

     public TicTacToe(int rounds, Player player1, Player player2){
          this.rounds = rounds;
          this.board = new char[BOARD_HGHT][BOARD_WDTH];
          for(int i = 0; i < BOARD_HGHT;i ++ ){
               for(int j = 0; j < BOARD_WDTH; j++){
                    this.board[i][j] = ' ';
               }
          }
          this.players = new Player[PLYER_NUM];
          this.players[0] = player1;
          this.players[1] = player2;
          this.currentRound = 1;
          this.currPlayerCount = 2;
          player1.setTicTacToe(this);
          player2.setTicTacToe(this);

     }
     /*Getters*/
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
     public int getCurrentPlayerCount(){
          return this.currPlayerCount;
     }
     public int getCurrentTurn(){
          return this.currTurnNumber;
     }
     public Player getWinner(){
          return this.winner;
     }
     /*Setters*/
     public void setRounds(int rounds){
          this.rounds = rounds;
     }
     public void setCurrentRound(int round){
          this.currentRound = round;
     }
     public void setCurrentTurn(int turn){

     }
/*
     public void addToGame(Player newPlayer){
          if(this.currPlayerCount  < PLYER_NUM){
               this.players[this.currPlayerCount] = newPlayer;
          }
     }
*/
     public void playerMoves(int x, int y){
          if(this.currentRound <= this.rounds){   //game is ongoing
               if(this.currTurnNumber <= 9){ //a round is ongoing
                    if(this.currentRound%2 == 0){ //if currentRound is even
                         if(this.currTurnNumber%2 == 0){    //currTurnNumber is even
                              System.out.println("Player2 moves");
                              this.players[1].mark(x,y);
                         }else{
                              this.players[0].mark(x,y);
                              System.out.println("Player1 moves");
                         }
                    }else{    //currentRound is odd
                         if(this.currTurnNumber%2 == 0){    //currTurnNumber is even
                              this.players[0].mark(x,y);
                              System.out.println("Player1 moves");
                         }else {
                              this.players[1].mark(x,y);
                              System.out.println("Player2 moves");
                         }
                    }
               }else{//end of round
                    //start next round
                    this.currentRound ++;
                    this.currTurnNumber = 1; //back to round 1
               }
          }else{     //end of game, get winner

          }

          if(this.currTurnNumber <=9 ){
          }if(this.currTurnNumber >=10){
               this.currentRound++;
               this.currTurnNumber = 1;
          }
     }


     public void play(int x,int  y){
          for(this.currentRound; this.currentRound <= this.rounds; this.currentRound++){  //for each round
               this.playerMoves(x,y);
          }
     }


     public void printBoard(){
          for(int i = 0; i < BOARD_HGHT; i++){
               System.out.println(this.board[i]);
          }
     }
}
