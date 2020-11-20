import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class serves as the "destination" for the purpose of having the player 
 * try to drag a Square object and drop it onto a Target (see the Square class 
 * for more details). 
 * 
 * Note that this class has no `act()` method, since it's not really necessary
 * for this particular example (it's not like the Target is moving or anything)
 * 
 * @author example@email.uscb.edu
 * @version 0.1
 */
public class Target extends Actor
{
    /* FIELD(S) */
    boolean correctTarget;
    
    /* CONSTRUCTOR(S) */
    /**
     * Initializes instance variables for this object based on argument values
     * passed to `new Target(_trueOrFalse_)` (see the SquareWorld `prepare` method)
     */
    public Target( boolean correctTarget )
    {
        this.correctTarget = correctTarget;
    } // end Target constructor
    
    /* METHOD(S) */
    /**
     * Returns true if this is the "correct" target
     */
    public boolean isCorrectTarget()
    {
        return correctTarget;
    } // end method isCorrectTarget
    
} // end class Target
