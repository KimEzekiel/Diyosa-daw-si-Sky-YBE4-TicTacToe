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

     public TicTacToe(int rounds, Player player1, Player player2){
          this.rounds = rounds;
          for(int i = 0; i < BOARD_HGHT;i ++ ){
               for(int j = 0; j < BOARD_WDTH; j++){
                    this.board[i][j] = ' ';
               }
          }
          this.players = new Player[PLYER_NUM];
          this.players[0] = player1;
          this.players[1] = player2;
          this.currentRound = 1;
          this.currPlayerCount = 0;

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
     public int getCurrentTurnNumber(){
          return this.currTurnNumber;
     }

     /*Setters*/
     public void setRounds(int rounds){
          this.rounds = rounds;
     }
     public void setCurrentRound(int round){
          this.currentRound = round;
     }
     public void addToGame(Player newPlayer){
          if(this.currPlayerCount  < PLYER_NUM){
               this.players[this.currPlayerCount] = newPlayer;
          }
     }
     public void playerMoves(int x, int y){
          if(this.currentRound%2 == 0){ //if currentRound is even
               if(this.currTurnNumber%2 == 0){    //currTurnNumber is even
                    this.players[1].mark(x,y);
               }else this.players[0].mark(x,y);
          }else{
               if(this.currTurnNumber%2 == 0){    //currTurnNumber is even
                    this.players[0].mark(x,y);
               }else this.players[1].mark(x,y);
          }
     }
     public void printBoard(){
          for(int i = 0; i < BOARD_HGHT; i++){
               System.out.println(this.board[i]);
          }
     }
}
