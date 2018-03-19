package tool;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * Ellipse tool that extends abstract tool. 
 * 
 * @author Lindsee Purnell
 * @version Pow1
 */
public class EllipseTool extends AbstractTool {
    
    /** Ellipse shape. */
    private Ellipse2D myEllipse; 
    
    /** X coordinate. */
    private double myX; 
    
    /** Y Coordinate. */ 
    private double myY; 

    @Override
    public Shape startingPoint(final double theX, final double theY) {
        myX = theX; 
        myY = theY; 
        myEllipse = new Ellipse2D.Double(myX, myY, myX, myY);
        return (Shape) myEllipse.clone(); 
    }

    @Override
    public Shape movePoint(final double theX, final double theY) {
        myEllipse.setFrameFromDiagonal(myX, myY, theX, theY);
        return (Shape) myEllipse.clone(); 
    }

    @Override
    public Shape endingPoint(final double theX, final double theY) {
        myEllipse.setFrameFromDiagonal(myX, myY, theX, theY);
        return (Shape) myEllipse.clone(); 
    }

}
