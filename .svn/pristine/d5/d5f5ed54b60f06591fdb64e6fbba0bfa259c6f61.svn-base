package tool;

import java.awt.Shape;

/**
 * Abstract tool that implements the ToolInterface. 
 * 
 * @author Lindsee Purnell
 * @version Pow1
 */
public abstract class AbstractTool implements ToolInterface {
    
    /** String constant Tool, to remove from class names. */
    private static final String TOOL_SUFFIX = "Tool"; 
    
    /** String tool name that gets class name. */ 
    private String myToolName = getClass().getSimpleName(); 
    
    /**
     * Overrides ToolInterface method to return the correct version of the name. 
     * 
     * @return myToolName variable. 
     */
    @Override
    public String getToolName() {
        myToolName = myToolName.substring(0, myToolName.length() - TOOL_SUFFIX.length()); 
        return myToolName;
    }
    
    /**
     * Overrides ToolInterface method to return image name for the tool. 
     * 
     * @return string of image file path. 
     */
    @Override
    public String getToolImage() {
        final StringBuilder imageName = new StringBuilder(25);  
        imageName.append("./"); 
        imageName.append("resources/");
        imageName.append(getToolName().toLowerCase()); 
        imageName.append(".gif"); 
        return imageName.toString();
    }

    @Override
    public abstract Shape startingPoint(double theX, double theY);
   
    @Override
    public abstract Shape movePoint(double theX, double theY);

    @Override
    public abstract Shape endingPoint(double theX, double theY);

}
