
/**
 * The class <b>DotInfo</b> is a simple helper class to store 
 * the state (e.g. clicked, mined, number of neighbooring mines...) 
 * at the dot position (x,y)
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class DotInfo {
    private int neighbooringMines;
    private boolean covered;
    private int x_coord;
    private int y_coord;
    private boolean mined;
    private boolean wasClicked;
     // ADD YOUR INSTANCE VARIABLES HERE

    /**
     * Constructor, used to initialize the instance variables
     * 
     * @param x
     *            the x coordinate
     * @param y
     *            the y coordinate
     */
    public DotInfo(int x, int y){
        x_coord = x;
        y_coord = y;
        mined =false;
        covered = true;
        wasClicked = false;
        neighbooringMines = 0;
    // ADD YOU CODE HERE
    }

    /**
     * Getter method for the attribute x.
     * 
     * @return the value of the attribute x
     */
    public int getX(){
        return x_coord;
    // ADD YOU CODE HERE

    }
    
    /**
     * Getter method for the attribute y.
     * 
     * @return the value of the attribute y
     */
    public int getY(){
        return y_coord;
    // ADD YOU CODE HERE

    }
 
    /**
     * Setter for mined
     */
    public void setMined() {
        mined = true;
    // ADD YOU CODE HERE
    }

    /**
     * Getter for mined
     *
     * @return mined
     */
    public boolean isMined() {
        return mined;
    // ADD YOU CODE HERE

    }


    /**
     * Setter for covered
     */
    public void uncover() {
        covered = false;
    // ADD YOU CODE HERE

    }

    /**
     * Getter for covered
     *
     * @return covered
     */
    public boolean isCovered(){
        return covered;
    // ADD YOU CODE HERE

    }



    /**
     * Setter for wasClicked
     */
    public void click() {
        wasClicked = true;
    // ADD YOU CODE HERE

    }


    /**
     * Getter for wasClicked
     *
     * @return wasClicked
     */
    public boolean hasBeenClicked() {
        return wasClicked;
    // ADD YOU CODE HERE

    }


    /**
     * Setter for neighbooringMines
     *
     * @param neighbooringMines
     *          number of neighbooring mines
     */
    public void setNeighbooringMines(int neighbooringMines) {
        this.neighbooringMines = neighbooringMines;
    // ADD YOU CODE HERE
    }

    /**
     * Get for neighbooringMines
     *
     * @return neighbooringMines
     */
    public int getNeighbooringMines() {
        return neighbooringMines;
    // ADD YOU CODE HERE
    }
 }
