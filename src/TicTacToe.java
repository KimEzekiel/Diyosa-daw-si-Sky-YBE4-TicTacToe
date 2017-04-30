class TicTacToe{
     static final int PLYER_NUM = 2;
     static final int BOARD_HGHT = 3;
     static final int BOARD_WDTH = 3;

     private char[][] board;
     private int rounds;
     private Player[] players;
     private int currPlayerCount;
     private int currentRound;
     private int currTurnNumber;   //current turn number, start:1, end:
     private int draw;
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
          this.draw = 0;
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
     public int getDraw(){
          return this.draw;
     }
     /*Setters*/
     public void setRounds(int rounds){
          this.rounds = rounds;
     }
     public void nextRound(){
          this.currentRound++;
     }
     public void nextTurn(){
          this.currTurnNumber++;
     }
     public int playerMoves(int x, int y){

          if(this.board[x][y] == '0' || this.board[x][y] == 'x' ){
               System.out.println("Invalid move");
               return 0;
          }
          if(this.currentRound <= this.rounds){   //game is ongoing
               if(this.currTurnNumber <= 9){ //a round is ongoing
                    /*ether player makes a move*/
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
                    /*next turn*/
                    this.currTurnNumber++;
                    /*check if someone gets a point*/
                    /*check is round is finished*/
                    if(this.currTurnNumber > 9){
                         this.currTurnNumber = 1;//current number reset
                         this.currentRound++;
                         
                    }
               }
          }else{     //end of game, get winner

          }

          if(this.currTurnNumber <=9 ){



          }
          if(this.currTurnNumber >=10){
               this.draw += 1;
               this.currentRound++;
               this.currTurnNumber = 1;
          }
          return 1;
     }

     public void play(int x,int  y){
          for(this.currentRound = this.currentRound; this.currentRound <= this.rounds; this.currentRound++){  //for each round
               this.playerMoves(x,y);
          }
     }

     public void printBoard(){
          for(int i = 0; i < BOARD_HGHT; i++){
               System.out.println(this.board[i]);
          }
     }
     public boolean matchPoint(){
       System.out.println("Here");
       System.out.println("1: " + this.players[0].getScore());
       System.out.println("2: " + this.players[1].getScore());
       if(this.players[0].getScore() + draw == this.currentRound || this.players[1].getScore() + draw == this.currentRound) return true;
       else return false;
     }

}
