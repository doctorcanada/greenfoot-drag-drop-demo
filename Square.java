import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; 

/**
 * This object can be dragged and dropped onto a Target, and "snaps" into place. 
 * If it's the correct target, an appropriate sound will play. If it's not the 
 * correct target, a different sound will play.
 * 
 * @author Brian Canada, PhD (bcanada@uscb.edu)
 * @version 0.1
 */
public class Square extends Actor
{
    /* FIELD(S) */
    private final int TARGET_DETECTION_THRESHOLD = 25;
    
    /* CONSTRUCTOR(S) */
    
    /* METHOD(S) */
    /**
     * Act - do whatever the Square wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkMouseDrag();
        checkIfDroppedOntoTarget();
    } // end method act
    
    /**
     * If we click on and drag this object using the mouse, then this object 
     * will move along with the mouse until we let go of the mouse button
     */
    public void checkMouseDrag()
    {
        if ( Greenfoot.mouseDragged(this)) 
        {
            setLocation( Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY() );
        } // end if
    } // end method checkMouseDrag
    
    /**
     * 1) When the mouse button is released, see if any targets are 
     *    within a certain distance (the "target detection threshold")
     * 2) Any targets "in range" will be stored in a List (a data structure
     *    that is similar to an array but can grow and shrink in size as needed).
     *    However, if there are no targets in range, then the List will be empty
     *    (the List itself won't be `null`, but the List won't contain any objects)
     * 3) We will then use an *enhanced for loop* to iterate through all the 
     *    target references stored in the list, but we must first check to make
     *    sure that there is at least one Target object in the list (i.e., we
     *    check to see if the reference variable `currentTarget` actually refers
     *    to something -- that's why we check to see if `currentTarget` is NOT null)
     * 4) The dropped Square will "snap" into place so that it is cleanly aligned
     *    with the Target that it overlaps
     * 5) If you have dropped the Square onto the *correct* Target, then a confirmation
     *    sound will play and the count of CORRECT placements will be incremented by 1; 
     *    otherwise, if it's not the correct target, an "ow!" sound 
     *    will play, and the count of INCORRECT placements will be incremented by 1; 
     */
    public void checkIfDroppedOntoTarget() 
    {
        if ( Greenfoot.mouseDragEnded(this)) 
        {       
            List<Target> possibleTargetsInRange 
                = getObjectsInRange( TARGET_DETECTION_THRESHOLD, Target.class );
            
            // Use an enhanced for loop (a.k.a. a "for-each" loop) to iterate
            // over all of the possible Target objects that are in range
            for ( Target currentTarget : possibleTargetsInRange ) 
            {
                // if there are no Target objects in range, then currentTarget will be null
                // (i.e., currentTarget doesn't *refer* to anything), so the condition used
                // in the if-statement will prevent a NullPointerException 
                if ( currentTarget != null ) 
                {
                    setLocation( currentTarget.getX(), currentTarget.getY() );
                    
                    SquareWorld referenceToSquareWorld = (SquareWorld)getWorld();
    
                    if ( currentTarget.isCorrectTarget() )
                    {
                        referenceToSquareWorld.setCorrectPlacementCount(
                           referenceToSquareWorld.getCorrectPlacementCount() + 1 );
                        Greenfoot.playSound( "ping.wav" );
                    } 
                    else if ( !currentTarget.isCorrectTarget() )
                    {
                        referenceToSquareWorld.setIncorrectPlacementCount(
                           referenceToSquareWorld.getIncorrectPlacementCount() + 1 );
                        Greenfoot.playSound( "au.wav" );
                    } // end innermost if/else
                    
                    // if a collision with a target is detected (and handled), then
                    // we can exit the method entirely by using a simple `return` statement
                    return; // `break` works too if you just want to break out of the containing `for` loop
                } // end inner if
            } // end enhanced for loop   

        } // end outer if
    } // end method checkIfDroppedOntoTarget
} // end class Square
