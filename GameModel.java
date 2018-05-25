import java.util.Random;

/**
 * The class <b>GameModel</b> holds the model, the state of the systems.
 * It stores the following information:
 * - the state of all the ``dots'' on the board (mined or not, clicked
 * or not, number of neighbooring mines...)
 * - the size of the board
 * - the number of steps since the last reset
 *
 * The model provides all of this informations to the other classes trough
 *  appropriate Getters.
 * The controller can also update the model through Setters.
 * Finally, the model is also in charge of initializing the game
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class GameModel {
private int widthOfGame;
private int heigthOfGame;
private int numberOfMines;
private int numberOfSteps;
private int numberUncovered;
private DotInfo[][] model;

     // ADD YOUR INSTANCE VARIABLES HERE

    /**
     * Constructor to initialize the model to a given size of board.
     *
     * @param width
     *            the width of the board
     *
     * @param heigth
     *            the heigth of the board
     *
     * @param numberOfMines
     *            the number of mines to hide in the board
     */
    public GameModel(int width, int heigth, int numberOfMines) {
      widthOfGame = width;
      heigthOfGame = heigth;
      this.numberOfMines= numberOfMines;
      model= new DotInfo[heigthOfGame][widthOfGame];
      for(int i=0; i<heigthOfGame;i++){
        for(int j=0; j<widthOfGame; j++){
          model[i][j]=  new DotInfo(i,j);
        }
      }
      Random randy = new Random();
      int minesSet = 0;
      while(minesSet < numberOfMines){
        int i=randy.nextInt(heigthOfGame);
        int j=randy.nextInt(widthOfGame);
        if(!model[i][j].isMined()){
          model[i][j].setMined();
          minesSet++;
        }
      }
      for(int i = 0; i<heigthOfGame; i++){
        for(int j=0; j<widthOfGame; j++){

          int count=0;
          try{
            if(model[model[i][j].getX()+1][model[i][j].getY()].isMined()){
              count++;
            }
          }
          catch(Exception e) {}
          try{
            if(model[model[i][j].getX()+1][model[i][j].getY()+1].isMined()){
              count++;
            }
          }
          catch(Exception e) {}
          try{
            if(model[model[i][j].getX()][model[i][j].getY()+1].isMined()){
              count++;
            }
          }
          catch(Exception e) {}
          try{
            if(model[model[i][j].getX()-1][model[i][j].getY()+1].isMined()){
              count++;
            }
          }
          catch(Exception e) {}
          try{
            if(model[model[i][j].getX()-1][model[i][j].getY()].isMined()){
              count++;
            }
          }
          catch(Exception e) {}
          try{
            if(model[model[i][j].getX()-1][model[i][j].getY()-1].isMined()){
              count++;
            }
          }
          catch(Exception e) {}
          try{
            if(model[model[i][j].getX()][model[i][j].getY()-1].isMined()){
              count++;
            }
          }
          catch(Exception e) {}
          try{
            if(model[model[i][j].getX()+1][model[i][j].getY()-1].isMined()){
              count++;
            }
          }
          catch(Exception e) {}
          model[i][j].setNeighbooringMines(count);
        }
      }
    }
  // ADD YOU CODE HERE


    /**
     * Resets the model to (re)start a game. The previous game (if there is one)
     * is cleared up .
     */
    public void reset(){
      numberUncovered=0;
      numberOfSteps=0;
      for(int i=0; i<heigthOfGame;i++){
        for(int j=0; j<widthOfGame; j++){
          model[i][j]=  new DotInfo(i,j);
        }
      }
      Random randy = new Random();
      int minesSet = 0;
      while(minesSet < numberOfMines){
        int i=randy.nextInt(heigthOfGame);
        int j=randy.nextInt(widthOfGame);
        if(!model[i][j].isMined()){
          model[i][j].setMined();
          minesSet++;
        }
      }
      for(int i = 0; i<heigthOfGame; i++){
        for(int j=0; j<widthOfGame; j++){

          int count=0;
          try{
            if(model[model[i][j].getX()+1][model[i][j].getY()].isMined()){
              count++;
            }
          }
          catch(Exception e) {}
          try{
            if(model[model[i][j].getX()+1][model[i][j].getY()+1].isMined()){
              count++;
            }
          }
          catch(Exception e) {}
          try{
            if(model[model[i][j].getX()][model[i][j].getY()+1].isMined()){
              count++;
            }
          }
          catch(Exception e) {}
          try{
            if(model[model[i][j].getX()-1][model[i][j].getY()+1].isMined()){
              count++;
            }
          }
          catch(Exception e) {}
          try{
            if(model[model[i][j].getX()-1][model[i][j].getY()].isMined()){
              count++;
            }
          }
          catch(Exception e) {}
          try{
            if(model[model[i][j].getX()-1][model[i][j].getY()-1].isMined()){
              count++;
            }
          }
          catch(Exception e) {}
          try{
            if(model[model[i][j].getX()][model[i][j].getY()-1].isMined()){
              count++;
            }
          }
          catch(Exception e) {}
          try{
            if(model[model[i][j].getX()+1][model[i][j].getY()-1].isMined()){
              count++;
            }
          }
          catch(Exception e) {}
          model[i][j].setNeighbooringMines(count);
        }
      }
    }

    /**
     * Getter method for the heigth of the game
     *
     * @return the value of the attribute heigthOfGame
     */
    public int getHeigth(){
      return heigthOfGame;
    }

    /**
     * Getter method for the width of the game
     *
     * @return the value of the attribute widthOfGame
     */
    public int getWidth(){
        return widthOfGame;
    // ADD YOU CODE HERE

    }



    /**
     * returns true if the dot at location (i,j) is mined, false otherwise
    *
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */
    public boolean isMined(int i, int j){
      return  model[i][j].isMined();
    // ADD YOU CODE HERE

    }

    /**
     * returns true if the dot  at location (i,j) has
     * been clicked, false otherwise
     *
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */
    public boolean hasBeenClicked(int i, int j){
      return model[i][j].hasBeenClicked();

    // ADD YOU CODE HERE

    }

  /**
     * returns true if the dot  at location (i,j) has zero mined
     * neighboor, false otherwise
     *
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */
    public boolean isBlank(int i, int j){
      return (getNeighbooringMines(i,j)==0);  // ADD YOU CODE HERE
    }
    /**
     * returns true if the dot is covered, false otherwise
    *
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */
    public boolean isCovered(int i, int j){
      return model[i][j].isCovered();
    // ADD YOU CODE HERE
    }

    /**
     * returns the number of neighbooring mines os the dot
     * at location (i,j)
     *
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the number of neighbooring mines at location (i,j)
     */
    public int getNeighbooringMines(int i, int j){
      return model[i][j].getNeighbooringMines();

    }


    /**
     * Sets the status of the dot at location (i,j) to uncovered
     *
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     */
    public void uncover(int i, int j){
      model[i][j].uncover();
    // ADD YOU CODE HERE
    }

    /**
     * Sets the status of the dot at location (i,j) to clicked
     *
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     */
    public void click(int i, int j){
      model[i][j].click();
    // ADD YOU CODE HERE
    }
     /**
     * Uncover all remaining covered dot
     */
    public void uncoverAll(){
for(DotInfo[] arraydots: model){
   for( DotInfo dot : arraydots){
      dot.uncover();
   }
}
    // ADD YOU CODE HERE

    }



    /**
     * Getter method for the current number of steps
     *
     * @return the current number of steps
     */
    public int getNumberOfSteps(){
      return numberOfSteps;
    // ADD YOU CODE HERE

    }



    /**
     * Getter method for the model's dotInfo reference
     * at location (i,j)
     *
      * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     *
     * @return model[i][j]
     */
    public DotInfo get(int i, int j) {
      return model[i][j];
}
   /**
     * The metod <b>step</b> updates the number of steps. It must be called
     * once the model has been updated after the payer selected a new square.
     */
     public void step(){
      numberOfSteps++;
    // ADD YOU CODE HERE

    }

   /**
     * The metod <b>isFinished</b> returns true iff the game is finished, that
     * is, all the nonmined dots are uncovered.
     *
     * @return true if the game is finished, false otherwise
     */
     // the is finished function is wrong.
    public boolean isFinished(){
      for (DotInfo[] arraydots:model){
        for (DotInfo dot: arraydots){
          if (dot.isCovered()==true){
            if(dot.isMined()==false){
              return false;
      }
    }
  }
}
      return true;
    }


   /**
     * Builds a String representation of the model
     *
     * @return String representation of the model
     */
    public String toString(){
      String aString = "";
      for(int i = 0; i < heigthOfGame; i++) {
       for(int j = 0; j < widthOfGame; j++) {
         if(model[i][j].isMined()==false){
           aString += "o";
         }
         else {
           aString += " m ";
         }
        //  if (isCovered(row,col)){
        //    aString += "";
        //   aString += " " + model[row][col];
        //  }
        // }
        // aString += "\r\n";
      }
    }
    return aString;
    // public void printstring(){
    //   for(int row = 0; row < model.length; row++) {
    //     for(int col = 0; col < model[row].length; col++) {
    //       System.out.print("| "+ model[row][col].isCovered() +"|");
    //   }
    //   System.out.println("");
    //   }
    //   }
}
}
