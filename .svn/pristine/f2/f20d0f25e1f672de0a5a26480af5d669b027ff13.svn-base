package tool;

import java.awt.Shape;

/**
 * General interface for the abstract tool class will 
 * implement. 
 * 
 * @author Lindsee Purnell
 * @version Pow1 
 */
public interface ToolInterface {

    /** Will return the name of the Tool. 
     * 
     * @return String of Tool name. 
     */
    String getToolName();
    
    /** Will return image associated with Tool.
     * 
     * @return String of image name. 
     */
    String getToolImage(); 
    
    /**
     * Shapes initial starting point. 
     * 
     * @param theX coordinate in point.
     * @param theY coordinate in point.
     * @return initial starting shape. 
     */
    Shape startingPoint(double theX, double theY); 
    
    /**
     * Movement of shape. 
     * 
     * @param theX coordinate in point.
     * @param theY coordinate in point. 
     * @return shape in motion. 
     */
    Shape movePoint(double theX, double theY);
    
    /**
     * Shapes final ending point. 
     * 
     * @param theX coordinate in point. 
     * @param theY coordinate in point. 
     * @return final ending shape. 
     */
    Shape endingPoint(double theX, double theY); 
}
