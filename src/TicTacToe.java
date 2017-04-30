class TicTacToe{
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
     private boolean justGotPoint;
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
          this.currPlayer = 2;
          this.draw = 0;
          this.justGotPoint = false;
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
     public Player getCurrentPlayer(){
          return this.players[this.currPlayer];
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
     public int getDraw(){
          return this.draw;
     }
     /*Setters*/
     public void setRounds(int rounds){
          this.rounds = rounds;
     }
     public void nextRound(){
          this.currTurnNumber = 1;
          this.currentRound++;
          /*clear the board*/
          for(int i = 0; i < TicTacToe.BOARD_HGHT; i++){
               for(int j = 0; j < TicTacToe.BOARD_WDTH; j++){
                    this.board[i][j] = ' ';
               }
          }
     }
     public void nextTurn(){
          this.currTurnNumber++;
     }

     public void playerMoves(int x, int y){

          System.out.println("round "+ this.currentRound);
          if(this.currentRound <= this.rounds){   //game is ongoing
               if(this.currTurnNumber <= 9){ //a round is ongoing
                    /*ether player makes a move*/
                    System.out.println("turn " + this.currTurnNumber);
                    if(this.currentRound%2 == 0){ //if currentRound is even
                         if(this.currTurnNumber%2 == 0){    //currTurnNumber is even
                              System.out.println("Player2 moves");
                              this.players[1].mark(x,y);
                              this.currPlayer = 1;
                         }else{
                              this.players[0].mark(x,y);
                              this.currPlayer = 0;
                              System.out.println("Player1 moves");
                         }
                    }else{    //currentRound is odd
                         if(this.currTurnNumber%2 == 0){    //currTurnNumber is even
                              this.players[0].mark(x,y);
                              this.currPlayer = 0;
                              System.out.println("Player1 moves");
                         }else {
                              this.players[1].mark(x,y);
                              this.currPlayer = 1;
                              System.out.println("Player2 moves");
                         }
                    }
                    /*next turn*/
                    this.currTurnNumber++;
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
                    /*check is round is finished*/

                    if(this.currTurnNumber > 9 || this.justGotPoint){
                         this.nextRound();
                         this.justGotPoint = false;
                    }
                    this.printBoard();
               }
          }else{     //end of game, get winner
               System.out.println("end of game");
               System.out.println((this.getWinner() == null)? "no one": this.getWinner().getName() + "wins ");
          }
}
/*
          if(this.currTurnNumber <=9 ){



          }
          if(this.currTurnNumber >=10){
               this.draw += 1;
               this.currentRound++;
               this.currTurnNumber = 1;
          }
          return 1;
     }
*/
     /*
     public void play(int x,int  y){
          for(this.currentRound = this.currentRound; this.currentRound <= this.rounds; this.currentRound++){  //for each round
               this.playerMoves(x,y);
          }
     }
     */
     public void printBoard(){
          for(int i = 0; i < BOARD_HGHT; i++){
               System.out.println(this.board[i]);
          }
     }
/*
     public boolean matchPoint(){
       System.out.println("Here");
       System.out.println("1: " + this.players[0].getScore());
       System.out.println("2: " + this.players[1].getScore());
       if(this.players[0].getScore() + draw == this.currentRound || this.players[1].getScore() + draw == this.currentRound) return true;
       else return false;
     }
*/
}
