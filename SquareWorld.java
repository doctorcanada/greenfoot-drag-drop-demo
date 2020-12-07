import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)

/**
 * In this scenario, the player can drop a Square onto one of two possible Targets.
 * 
 * @author Brian Canada, PhD (bcanada@uscb.edu)
 * @version 0.1
 */
public class SquareWorld extends World
{
    /* FIELD(S) */
    private Square square;
    private Target targetCorrect;
    private Target targetIncorrect;
    private int correctPlacementCount;
    private int incorrectPlacementCount;
    
    /* CONTSTRUCTOR(S) */
    /**
     * Create the SquareWorld. Our world has a size of 500x500 cells, 
     * where every cell is just 1 pixel. Also, initialize instance variables,
     * prepare the "scoreboard", and place object sprites in the world.
     */
    public SquareWorld() 
    {
        super(500, 500, 1);
        
        correctPlacementCount = 0;
        incorrectPlacementCount = 0;
        
        showText("Correct Placements: " + correctPlacementCount, 250, 50 );
        showText("Incorrect Placements: " + incorrectPlacementCount, 250, 75 );
        
        prepare();
    } // end SquareWorld constructor

    /* METHOD(S) */
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        square = new Square();
        addObject(square,250,400);
        targetCorrect = new Target(true);
        addObject(targetCorrect,100,150);
        targetIncorrect = new Target(false);
        addObject(targetIncorrect,400,150);
        
        /* Square should be in foreground, Target should be in background */
        setPaintOrder( Square.class, Target.class );
    } // end method prepare
    
    /**
     * Allows the SquareWorld to behave like an Actor class,
     * so that certain things can be updated during each cycle 
     * through the game loop
     */
    public void act()
    {
        showText("Correct Placements: " + correctPlacementCount, 250, 50 );
        showText("Incorrect Placements: " + incorrectPlacementCount, 250, 75 );
    } // end method act
    
    /**
     * Allows an object of another class to access ("get") the
     * value of `correctPlacementCount`, if necessary
     */
    public int getCorrectPlacementCount()
    {
        return correctPlacementCount;
    } // end method getCorrectPlacementCount
    
    /**
     * Allows an object of another class to modify ("set") the
     * value of `correctPlacementCount`, if necessary
     */
    public void setCorrectPlacementCount( int correctPlacementCount )
    {
        this.correctPlacementCount = correctPlacementCount;
    } // end method setCorrectPlacementCount
    
    /**
     * Allows an object of another class to access ("get") the
     * value of `incorrectPlacementCount`, if necessary
     */
    public int getIncorrectPlacementCount()
    {
        return incorrectPlacementCount;
    } // end method getIncorrectPlacementCount
    
    /**
     * Allows an object of another class to modify ("set") the
     * value of `incorrectPlacementCount`, if necessary
     */
    public void setIncorrectPlacementCount( int incorrectPlacementCount )
    {
        this.incorrectPlacementCount = incorrectPlacementCount;
    } // end method setIncorrectPlacementCount
    
} // end class SquareWorld
