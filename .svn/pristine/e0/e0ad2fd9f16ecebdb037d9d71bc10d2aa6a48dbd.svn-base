package tool;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * Tool class that extends abstract tool for the 
 * rectangle shape. 
 *  
 * @author Lindsee Purnell
 * @version Pow1
 */
public class RectangleTool extends AbstractTool {
    
    /** Rectangle shape. */
    private Rectangle2D myRectangle; 
    
    /** X coordinate. */
    private double myX; 
    
    /** Y coordinate. */
    private double myY; 
    
    @Override
    public Shape startingPoint(final double theX, final double theY) {
        myX = theX; 
        myY = theY; 
        myRectangle = new Rectangle2D.Double(myX, myY, 0, 0);
        return (Shape) myRectangle.clone(); 
    }

    @Override
    public Shape movePoint(final double theX, final double theY) {
        myRectangle.setFrameFromDiagonal(myX, myY, theX, theY);
        return (Shape) myRectangle.clone();
    }

    @Override
    public Shape endingPoint(final double theX, final double theY) {
        myRectangle.setFrameFromDiagonal(myX, myY, theX, theY);
        return (Shape) myRectangle.clone();
    }

}
