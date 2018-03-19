package tool;

import java.awt.Shape;
import java.awt.geom.Line2D;


/**
 * Line tool that extends Abstract tool. 
 * 
 * @author Lindsee Purnell
 * @version Pow1
 */
public class LineTool extends AbstractTool {
    
    /** Private line shape. */
    private Line2D myLine;
    
    /** X coordinate. */
    private double myX;
    
    /** Y coordinate. */
    private double myY;

    @Override
    public Shape startingPoint(final double theX, final double theY) {
        myX = theX;
        myY = theY;
        myLine = new Line2D.Double(myX, myY, myX, myY);
        return (Shape) myLine.clone();
    }

    @Override
    public Shape movePoint(final double theX, final double theY) {
        myLine.setLine(myX, myY, theX, theY);
        return (Shape) myLine.clone(); 
    }
    
    @Override
    public Shape endingPoint(final double theX, final  double theY) {
        myLine.setLine(myX, myY, theX, theY);
        return (Shape) myLine.clone();
    }

}

