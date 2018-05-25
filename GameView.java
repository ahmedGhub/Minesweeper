import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out a matrix of <b>DotButton</b> (the actual game) and
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class GameView extends JFrame {

     // ADD YOUR INSTANCE VARIABLES HERE
    private DotButton[][] board;
    private GameModel gameModel;
    private javax.swing.JLabel nbreOfStepsLabel;
    private JPanel layout;
    private JPanel options;
    private JLabel numberOfSteps;
    JButton reset;
    JButton quit;

    /**
     * Constructor used for initializing the Frame
     *
     * @param gameModel
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

    public GameView(GameModel gameModel, GameController gameController) {
      super("Minesweeper");
      this.gameModel=gameModel;

      layout = new JPanel();
      layout.setLayout(new GridLayout(gameModel.getHeigth(), gameModel.getWidth(), 0,0));
      layout.setBorder(new EmptyBorder(10,10,10,10));
      layout.setBackground(Color.WHITE);

      board= new DotButton[gameModel.getHeigth()][gameModel.getWidth()];
      for(int i=0; i<gameModel.getHeigth();i++){
        for(int j=0; j<gameModel.getWidth(); j++){
          board[i][j]=  new DotButton(i,j,getIcon(i,j));
          board[i][j].setBorder(BorderFactory.createEmptyBorder());
          board[i][j].addActionListener(gameController);
          layout.add(board[i][j]);
        }
      }
      add(layout, BorderLayout.CENTER);
      numberOfSteps = new JLabel("Number of steps: 0");

      reset = new JButton("Reset");
      reset.setBackground(Color.WHITE);
      reset.addActionListener(gameController);

      quit = new JButton("Quit");
      quit.setBackground(Color.WHITE);
      quit.addActionListener(gameController);

      options = new JPanel();
      options.add(numberOfSteps);
      options.add(reset);
      options.add(quit);
      add(options, BorderLayout.SOUTH);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBackground(Color.WHITE);
      pack();
      setVisible(true);
}
    /**
     * update the status of the board's DotButton instances based
     * on the current game model, then redraws the view
     */

    public void update(){
      for(int i=0; i<gameModel.getHeigth();i++){
        for(int j=0; j<gameModel.getWidth(); j++){
          board[i][j].setIconNumber(getIcon(i,j));
    // ADD YOU CODE HERE
    }
  }
      numberOfSteps.setText("Number of steps: " + gameModel.getNumberOfSteps());
      
}
    /**
     * returns the icon value that must be used for a given dot
     * in the game
     *
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the icon to use for the dot at location (i,j)
     */
    private int getIcon(int i, int j){
      //if(gameModel.model[i][j].isFlagged()){
        //return 12;
      //}
      if (gameModel.isCovered(i,j)) {
        return 11;
      }
      else if (gameModel.isMined(i,j)&& gameModel.hasBeenClicked(i,j)){
        return 10;
      }
      else if(gameModel.isMined(i,j)){
        return 9;
      }
      else{
        return gameModel.getNeighbooringMines(i,j);
      }


      
      // if (gameModel.get(i,j).hasBeenClicked() == false) {
      //   return 11;
      // }
      // else if (gameModel.get(i,j).hasBeenClicked()){
      //   if (gameModel.get(i,j).isMined()){
      //     return 10;
      //   }
      //   else{
      //     return gameModel.getNeighbooringMines(i,j);
      //   }
      // }
      // else {}


      // else
      // else if (gameModel.get(i,j).isMined()){
      //   return 9;                         // deal with red mine later
      // }

      //  if (gameModel.get(i,j).hasBeenClicked()&& gameModel.get(i,j).isMined()){
      //   return 10;
      // }
      // else if( gameModel.get(i,j).isMined()&& gameModel.get(i,j).isCovered()){
      //   return 11;

      // }
      // else if(gameModel.get(i,j).hasBeenClicked()&& gameModel.get(i,j).isMined()){
      //   return 10;
      // }

      // else if (gameModel.get(i,j).isMined()){
      //   return 9;
      // }
      // else {
      //   return  gameModel.getNeighbooringMines(i,j);
      // }

    }


}
