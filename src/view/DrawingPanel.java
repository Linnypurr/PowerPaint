package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import tool.ShapeTool;
import tool.ToolInterface;


/**
 * Drawing Panel is the canvas of powerpaint extends JPanel. 
 * 
 * @author Lindsee Purnell
 * @version November 7, 2017
 */
public class DrawingPanel extends JPanel {
    
    /** Number to set the preferred size, to avoid magic number. */
    public static final int PREFERRED_PIXEL = 200; 
    
    /** The line width. */
    public static final int LINE_WIDTH = 5;
    
    /** Generated serial ID. */
    private static final long serialVersionUID = 3983851631630867891L;
    
    /** ArrayList of shapes that were previously drawn. */
    private ArrayList<ShapeTool> myShapesDrawn = new ArrayList<ShapeTool>();
    
    /** ToolInterface myTool of current tool used.*/
    private ToolInterface myTool;
    
    /** Shape of currentShape uses myTool. */
    private Shape myCurrentShape;
    
    /** To ensure there is a shape drawn. */ 
    private boolean myHasShape;
    
    /** Constructor for the JPanel sets up canvas for painting. */
    public DrawingPanel() {
        setBackground(Color.WHITE); 
        setPreferredSize(new Dimension(PREFERRED_PIXEL, PREFERRED_PIXEL)); 
        final MyMouseListener mouseListener = new MyMouseListener();
        addMouseListener(mouseListener); 
        addMouseMotionListener(mouseListener);
    }
    
    /**
     * Paints the current path.
     * 
     * @param theGraphics The graphics context to use for painting.
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        //Current Shape
        if (myHasShape) {
            g2d.setStroke(new BasicStroke(PowerPaintGUI.getStroke()));
            if (PowerPaintGUI.isFillable()) {
                g2d.setStroke(new BasicStroke(PowerPaintGUI.getStroke()));
                g2d.setColor(PowerPaintGUI.getFillColor()); 
                g2d.fill(myCurrentShape);
            } 
            g2d.setColor(PowerPaintGUI.getStrokeColor());
            g2d.draw(myCurrentShape);   
        }
        
        //Old Shapes
        for (final ShapeTool shape : myShapesDrawn) {
            g2d.setStroke(new BasicStroke(shape.getStroke()));
            g2d.setColor(shape.getShapeColor());
            if (shape.getFilled()) {
                g2d.setColor(shape.getFillColor());
                g2d.fill(shape.getShape());
                g2d.setColor(shape.getShapeColor());
                g2d.draw(shape.getShape()); 
            } else {
                g2d.setColor(shape.getShapeColor());
                g2d.draw(shape.getShape()); 
            }  
        }
       
    }
    
    /**
     * For clearing the drawing panel. 
     */
    public void clearShapes() {
        myShapesDrawn.clear();
        repaint(); 
    }
    
    /**
     * Listens for mouse clicks, to draw on our panel.
     */
    private class MyMouseListener extends MouseAdapter {
        
        /**
         * For getting the right cursor. 
         */
        @Override
        public void mouseEntered(final MouseEvent theEvent) {
            setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR)); 
        }
        
        /**
         * Starts the current point of the shape. 
         */
        @Override
        public void mousePressed(final MouseEvent theEvent) {
            if (!myHasShape) {
                myHasShape = true;
                myTool = PowerPaintGUI.getTool();
                myCurrentShape = myTool.startingPoint(theEvent.getX(), theEvent.getY());
            }
        }
        
        /**
         * Makes the shape capable of moving. 
         */
        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            if (myHasShape) {
                myCurrentShape = myTool.movePoint(theEvent.getX(), theEvent.getY());
                repaint();                
            }
        }
        
        /**
         * Ends the shape. 
         */
        @Override
        public void mouseReleased(final MouseEvent theEvent) {
            if (myHasShape) {
                myCurrentShape = myTool.movePoint(theEvent.getX(), theEvent.getY());
                myShapesDrawn.add(new ShapeTool(myCurrentShape, PowerPaintGUI.getStrokeColor(),
                                                PowerPaintGUI.getStroke(),
                                                PowerPaintGUI.isFillable()));
            }
            myHasShape = false;
            
        }
    }
}
