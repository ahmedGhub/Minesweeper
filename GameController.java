import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.*;


/**
 * The class <b>GameController</b> is the controller of the game. It is a listener
 * of the view, and has a method <b>play</b> which computes the next
 * step of the game, and  updates model and view.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */


public class GameController implements ActionListener {

    private GameModel gameModel;
    private GameView  gameView;

    /**
     * Constructor used for initializing the controller. It creates the game's view
     * and the game's model instances
     *
     * @param width
     *            the width of the board on which the game will be played
     * @param height
     *            the height of the board on which the game will be played
     * @param numberOfMines
     *            the number of mines hidden in the board
     */
    public GameController(int width, int height, int numberOfMines) {

        gameModel = new GameModel(width, height, numberOfMines);
        gameView = new GameView(gameModel, this);
    // ADD YOU CODE HERE
    }


    /**
     * Callback used when the user clicks a button (reset or quit)
     *
     * @param e
     *            the ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source instanceof JButton) {
            JButton source2 = (JButton)source;
            if(source2.getText() == "Reset"){
                reset();
            }
            else if (source2.getText() == "Quit"){
                System.exit(0);
            }
            else {
                DotButton source3 = (DotButton)source;
                if(gameModel.hasBeenClicked(source3.getColumn(),source3.getRow())==false){
                    gameModel.step();
                  if(gameModel.isFinished()==false){
                    play(source3.getRow(), source3.getColumn());
                  }
                }
            }
        }

    // ADD YOU CODE HERE
    }

    /**
     * resets the game
     */
    private void reset(){
      gameModel.reset();
      gameView.update();
      //gameView.update();    // ADD YOU CODE HERE
    }

    /**
     * <b>play</b> is the method called when the user clicks on a square.
     * If that square is not already clicked, then it applies the logic
     * of the game to uncover that square, and possibly end the game if
     * that square was mined, or possibly uncover some other squares.
     * It then checks if the game
     * is finished, and if so, congratulates the player, showing the number of
     * moves, and gives to options: start a new game, or exit
     * @param width
     *            the selected column
     * @param heigth
     *            the selected line
     */
    private void play(int width, int heigth){
      gameModel.click(heigth,width);
      if(gameModel.isFinished()){
        for(int i = 0; i<gameModel.getHeigth(); i++){
            for(int j=0; j<gameModel.getWidth(); j++) {
              gameModel.uncover(i, j);
            }
          }
          gameView.update();
          int reply = JOptionPane.showConfirmDialog(null, "You won in " + gameModel.getNumberOfSteps() + "steps. Would you like to play again?", "Finished", JOptionPane.YES_NO_OPTION);
          if (reply == JOptionPane.YES_OPTION) {
            reset();
          }
          else {
            System.exit(0);
          }
      }
      if(gameModel.isMined(heigth, width)) {
        for(int i = 0; i<gameModel.getHeigth(); i++){
          for(int j=0; j<gameModel.getWidth(); j++) {
            gameModel.uncover(i, j);

          }
        }
        gameView.update();
        int reply = JOptionPane.showConfirmDialog(null, "You lost in " + gameModel.getNumberOfSteps() + "steps. Would you like to play again?", "Title", JOptionPane.YES_NO_OPTION);
          if (reply == JOptionPane.YES_OPTION) {
            reset();
          }
          else {
            System.exit(0);
          }
}
      else if(gameModel.isMined(heigth, width) == false) {
        //this line is redundant.  gameModel.click(heigth, width);
        gameModel.uncover(heigth, width);


      clearZone(gameModel.get(heigth,width));
      }
      

      gameView.update();
    // ADD YOU CODE HERE
    }

   /**
     * <b>clearZone</b> is the method that computes which new dots should be ``uncovered''
     * when a new square with no mine in its neighborood has been selected
     * @param initialDot
     *      the DotInfo object corresponding to the selected DotButton that
     * had zero neighbouring mines
     */
    private void clearZone(DotInfo initialDot) {
      GenericArrayStack<DotInfo> clearAroundDotsStack = new   GenericArrayStack<>(400);
      clearAroundDotsStack.push(initialDot);
      while (clearAroundDotsStack.isEmpty()==false){
        DotInfo currentTopElement= clearAroundDotsStack.pop();
         if (gameModel.getNeighbooringMines(currentTopElement.getX(),currentTopElement.getY())==0){
           try{
             if(gameModel.isCovered(currentTopElement.getX()+1,currentTopElement.getY())){
                gameModel.uncover(currentTopElement.getX()+1,currentTopElement.getY());
                clearAroundDotsStack.push(gameModel.get(currentTopElement.getX()+1,currentTopElement.getY()));
               }
             }

           catch(Exception e) {}
           try{
             if(gameModel.isCovered(currentTopElement.getX()+1,currentTopElement.getY()+1)){
              gameModel.uncover(currentTopElement.getX()+1,currentTopElement.getY()+1);
                   clearAroundDotsStack.push(gameModel.get(currentTopElement.getX()+1,currentTopElement.getY()+1));
             }
           }
           catch(Exception e) {}
           try{
             if(gameModel.isCovered(currentTopElement.getX(),currentTopElement.getY()+1)){
              gameModel.uncover(currentTopElement.getX(),currentTopElement.getY()+1);
                   clearAroundDotsStack.push(gameModel.get(currentTopElement.getX(),currentTopElement.getY()+1));
             }
           }
           catch(Exception e) {}
           try{
             if(gameModel.isCovered(currentTopElement.getX()-1,currentTopElement.getY()+1)){
              gameModel.uncover(currentTopElement.getX()-1,currentTopElement.getY()+1);
                   clearAroundDotsStack.push(gameModel.get(currentTopElement.getX()-1,currentTopElement.getY()+1));
             }
           }
           catch(Exception e) {}
           try{
             if(gameModel.isCovered(currentTopElement.getX()-1,currentTopElement.getY())){
              gameModel.uncover(currentTopElement.getX()-1,currentTopElement.getY());
                   clearAroundDotsStack.push(gameModel.get(currentTopElement.getX()-1,currentTopElement.getY()));
             }
           }
           catch(Exception e) {}
           try{
             if(gameModel.isCovered(currentTopElement.getX()-1,currentTopElement.getY()-1)){
              gameModel.uncover(currentTopElement.getX()-1,currentTopElement.getY()-1);
                   clearAroundDotsStack.push(gameModel.get(currentTopElement.getX()-1,currentTopElement.getY()-1));
             }
           }
           catch(Exception e) {}
           try{
             if(gameModel.isCovered(currentTopElement.getX(),currentTopElement.getY()-1)){
              gameModel.uncover(currentTopElement.getX(),currentTopElement.getY()-1);
                   clearAroundDotsStack.push(gameModel.get(currentTopElement.getX(),currentTopElement.getY()-1));
             }
           }
           catch(Exception e) {}
           try{
             if(gameModel.isCovered(currentTopElement.getX()+1,currentTopElement.getY()-1)){
              gameModel.uncover(currentTopElement.getX()+1,currentTopElement.getY()-1);
                   clearAroundDotsStack.push(gameModel.get(currentTopElement.getX()+1,currentTopElement.getY()-1));
             }
           }
           catch(Exception e) {}

                      }
                    //  if( gameModel.getNeighbooringMines(p,q)==0){
                    //    clearAroundDotsStack.push(gameModel.get(p,q));
                      }

        }
}

    // ADD YOU CODE HERE

    //}
