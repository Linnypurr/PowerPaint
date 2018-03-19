package tool;

import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

/**
 * Tool class that extends abstract tool specifically for
 * the Round Rectangle shape. 
 * 
 * @author Lindsee Purnell
 * @version Pow1
 */
public class RoundRectangleTool extends AbstractTool {
    
    /** Constant for arc width of rectangle.*/
    private static final double ARC_WIDTH = 22.0;
    
    /** Constant for arc height of rectangle. */
    private static final double ARC_HEIGHT = 18.0;
    
    /** Round rectangle shape. */
    private RoundRectangle2D myRoundRect; 
    
    /** Double for setting x coordinate. */
    private double myX; 
    
    /** Double for setting y coordinate. */ 
    private double myY; 

    @Override
    public Shape startingPoint(final double theX, final double theY) {
        myX = theX; 
        myY = theY; 
        myRoundRect = new RoundRectangle2D.Double(myX, myY, myX, myY, ARC_WIDTH, ARC_HEIGHT);
        return (Shape) myRoundRect.clone();
    }

    @Override
    public Shape movePoint(final double theX, final double theY) {
        myRoundRect.setFrameFromDiagonal(myX, myY, theX, theY);
        return (Shape) myRoundRect.clone(); 
    }

    @Override
    public Shape endingPoint(final double theX, final double theY) {
        myRoundRect.setFrameFromDiagonal(myX, myY, theX, theY);
        return (Shape) myRoundRect.clone();
    }

}
