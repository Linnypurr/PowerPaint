package tool;

import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;

/**
 * Pencil tool extends abstract tool. 
 * 
 * @author Lindsee Purnell
 * @version Pow1
 */
public class PencilTool extends AbstractTool {
    
    /** Path shape. */
    private Path2D myPath; 
    
    /** X coordinate. */
    private double myX; 
    
    /** Y coordinate. */
    private double myY; 

    @Override
    public Shape startingPoint(final double theX, final double theY) {
        myX = theX;
        myY = theY; 
        myPath = new Path2D.Double(PathIterator.WIND_EVEN_ODD); 
        myPath.moveTo(myX, myY);
        return (Shape) myPath.clone(); 
    }

    @Override
    public Shape movePoint(final double theX, final double theY) {
        myPath.lineTo(theX, theY);  
        return (Shape) myPath.clone(); 
    }

    @Override
    public Shape endingPoint(final double theX, final double theY) {
        myPath.lineTo(theX, theY);
        myPath.closePath(); 
        return (Shape) myPath.clone();
    }

}
