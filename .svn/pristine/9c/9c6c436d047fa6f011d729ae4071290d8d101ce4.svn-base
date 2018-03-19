package tool;

import java.awt.Color;
import java.awt.Shape;
import view.PowerPaintGUI;

/**
 * The ShapeTool class holds the final form of a shape
 * with the correct color and fill if necessary. 
 * 
 * @author Lindsee Purnell  
 * @version Pow1
 */
public class ShapeTool {
    
    /** The line width. */
    public static final int LINE_WIDTH = 5;
        
    /** Holds the original shape drawn. */
    private Shape myShape; 
    
    /** Holds the color of the stroke. */
    private Color mySelectedColor; 
    
    /** Holds the thickness of the stroke. */
    private int myStroke;
    
    /** boolean to determine if the shape is fillable. */
    private boolean myFill; 
    
    /** The color if it is fillable. */
    private Color myFillColor; 
    
    /**
     * Constructor for ShapeTool class to hold the final shape.
     * 
     * @param theShape currently drawn shape. 
     * @param theColor color of stroke. 
     * @param theStroke thickness of stroke. 
     * @param theFill if it is fillable. 
     */
    public ShapeTool(final Shape theShape, final Color theColor, 
                     final int theStroke, final boolean theFill) {
        myShape = theShape; 
        mySelectedColor = theColor; 
        myStroke = theStroke; 
        myFill = theFill; 
        myFillColor = PowerPaintGUI.getFillColor(); 
    }
    
    /** 
     * Set the original shape. 
     * 
     * @param theShape original shape. 
     */
    public void setShape(final Shape theShape) {
        myShape = theShape; 
    }
    
    /** 
     * Returns original shape. 
     * 
     * @return myShape variable. 
     */
    public Shape getShape() {
        return myShape; 
    }
    
    /**
     * Sets the Fill color. 
     * 
     * @param theFillColor color to fill shape. 
     */
    public void setFillColor(final Color theFillColor) {
        if (myFill) {
            myFillColor = theFillColor; 
        }
    }
    
    /**
     * Sets the stroke color. 
     * 
     * @param theShapeColor new stroke color. 
     */
    public void setShapeColor(final Color theShapeColor) {
        mySelectedColor = theShapeColor; 
    }
    
    /**
     * Returns the stroke color. 
     * 
     * @return mySelectedColor. 
     */
    public Color getShapeColor() {
        return mySelectedColor; 
    }
    
    /** 
     * Gets the fill Color from the color chooser
     * in the PowerPaintGUI method. 
     * 
     * @return chosen color from JColorChooser. 
     */
    public Color getFillColor() {
        return myFillColor; 
    }
    
    /**
     * Boolean for if it is filled. 
     * 
     * @return myFill variable. 
     */
    public boolean getFilled() {
        return myFill; 
    }
    
    /**
     * Set if the variable can be filled. 
     * 
     * @param theFill sets boolean. 
     */
    public void setFilled(final boolean theFill) {
        myFill = theFill; 
    }
    
    /**
     * Returns the thickness of the stroke.
     * 
     * @return myStroke variable. 
     */
    public int getStroke() {
        return myStroke; 
    }
    
    /**
     * Sets the stroke thickness. 
     * 
     * @param theStroke integer of thickness. 
     */
    public void setStroke(final int theStroke) {
        myStroke = theStroke; 
    }
    
}


