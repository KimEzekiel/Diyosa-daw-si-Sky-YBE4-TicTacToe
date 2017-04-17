class TicTacToe{
     static final int PLYER_NUM = 2;
     static final int BOARD_LNGTH = 3;
     static final int BOARD_WDTH = 3;

     private int[][] board;
     private int rounds;
     private int currentRound;
     private Player[] players;

     public TicTacToe(int rounds, Player player1, Player player2){
          this.rounds = rounds;
          this.board = new int[BOARD_LNGTH][BOARD_WDTH];
          this.players = new Player[PLYER_NUM];
          this.players[0] = player1;
          this.players[1] = player2;
          this.currentRound = 1;

     }
     /*Getters*/
     public int[][] getBoard(){
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
     /*Setters*/
     public void setName(String name){
          this.name = name;
     }
     public void setRounds(int rounds){
          this.rounds = rounds;
     }
     public void setCurrentRound(int round){
          this.round = round;
     }

     public void addToGame(Player newPlayer){

     }
}
