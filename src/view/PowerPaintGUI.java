package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import tool.EllipseTool;
import tool.LineTool;
import tool.PencilTool;
import tool.RectangleTool;
import tool.RoundRectangleTool;
import tool.ToolInterface;

/**
 * GUI class that sets up everything in the GUI and
 * returns users chosen values. 
 * 
 * @author Lindsee Purnell
 * @version Pow1
 */
public class PowerPaintGUI {
    
    /** Avoiding magic number. */
    private static final int FIVE = 5; 
    
    /** Avoiding magic number. */
    private static final int TWENTY_FIVE = 25; 
    
    /** Dimension size of GUI. */
    private static final Dimension SIZE = new Dimension(600, 600);  
    
    /** Quick access to w.gif for multiple use. */
    private static final String W_GIF = "./resources/w.gif";
    
    /**Constant of the UW purple color. */ 
    private static final Color UW_PURPLE = new Color(51, 0, 111); 
    
    /**Constant of the UW gold color. */
    private static final Color UW_GOLD = new Color(232, 211, 162); 
  //(145, 123, 76) metallic gold (much prettier!)
    
    /** JSlider for thickness. */
    private static  JSlider mySlider = new JSlider(SwingConstants.HORIZONTAL,
                                                 0, TWENTY_FIVE, 1);  
    
    /** Initial Color for all shapes drawn. */
    private static Color myStrokeColor = UW_PURPLE;
    
    /** Initial fill color for fillable shapes. */
    private static Color myFillColor = UW_GOLD; 
    
    /** Current tool for selecting. */
    private static ToolInterface myTool; 
    
    /** ArrayList of ToolActions.  */
    private static ArrayList<ToolAction> myToolButtons = new ArrayList<ToolAction>();
    
    /** Boolean to determine if they want to fill Shape. */
    private static boolean isFilled; 
    
    /** PowerPaint GUI frame. */
    private final JFrame myMainFrame = new JFrame("PowerPaint"); 
    
    /**
     * Starts the Gui and sets up the tool buttons array. 
     */
    public void start() {
        myMainFrame.setVisible(true); 
        myMainFrame.setLocationRelativeTo(null);
        myMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myMainFrame.setLayout(new BorderLayout());
        myMainFrame.setSize(SIZE);
        myMainFrame.setMinimumSize(SIZE);
        myMainFrame.setResizable(true);
        myMainFrame.add(new DrawingPanel(), BorderLayout.CENTER); 
        final ImageIcon icon = new ImageIcon(W_GIF); 
        myMainFrame.setIconImage(icon.getImage());
        
        myToolButtons.add(new ToolAction(new LineTool())); 
        myToolButtons.add(new ToolAction(new RectangleTool())); 
        myToolButtons.add(new ToolAction(new RoundRectangleTool())); 
        myToolButtons.add(new ToolAction(new EllipseTool()));
        myToolButtons.add(new ToolAction(new PencilTool())); 
      
        final JMenuBar menuBar = new JMenuBar(); 
        menuBar.add(optionsMenu()); 
        menuBar.add(toolsMenu()); 
        menuBar.add(helpMenu()); 
        myMainFrame.add(menuBar, BorderLayout.NORTH);
        myMainFrame.add(createToolBar(), BorderLayout.SOUTH); 
        myMainFrame.pack();
        
    }
    
    /**
     * Helper method to create the Options menu,
     * includes JSlider and JColorChooser creations. 
     * 
     * @return the completed optionsMenu. 
     */
    private JMenu optionsMenu() {
        final JMenu optionsMenu = new JMenu("Options"); 
        final JMenu thickness = new JMenu("Thickness");
        mySlider.setMajorTickSpacing(FIVE);
        mySlider.setMinorTickSpacing(1);
        mySlider.setPaintTicks(true);
        mySlider.setPaintLabels(true);
        mySlider.setValue(FIVE);
        thickness.add(mySlider); 
        optionsMenu.add(thickness); 
        optionsMenu.addSeparator();
        //Color
        final JColorChooser pickColor = new JColorChooser(); 
        final JMenuItem drawColor = new JMenuItem("Draw Color..."); 
        drawColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final Color pickedColor = JColorChooser.showDialog(pickColor,
                                      "Choose a color", UW_PURPLE); 
                myStrokeColor = pickedColor; 
            }
        });
        optionsMenu.add(drawColor); 
        // Fill Color
        final JColorChooser pickFillColor = new JColorChooser(); 
        final JMenuItem fillColor = new JMenuItem("Fill Color...");
        fillColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final Color pickedFillColor = JColorChooser.showDialog(pickFillColor,
                                   "Choose a fill color", UW_GOLD); 
                myFillColor = pickedFillColor; 
            }
        });
        optionsMenu.addSeparator();
        optionsMenu.add(fillColor);
        optionsMenu.addSeparator();
        final JCheckBoxMenuItem fillCheckBox = new JCheckBoxMenuItem("Fill"); 
        fillCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                isFilled = fillCheckBox.getState(); 
            }
        });
        optionsMenu.add(fillCheckBox); 
        final JMenu clear = new JMenu("Clear");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
               myMainFrame.add(new DrawingPanel());  
            }
        });
        optionsMenu.addSeparator();
        clear.setEnabled(true);
        optionsMenu.add(clear); 
        return optionsMenu; 
        
    }
    
    /**
     * Helper method to create the tool menu, 
     * which is just radio buttons that correspond to a tool. 
     * 
     * @return toolMenu called Tools. 
     */
    private JMenu toolsMenu() {
        final JMenu toolMenu = new JMenu("Tools"); 
        final ButtonGroup btngrp = new ButtonGroup();
        
        for (final ToolAction tool : myToolButtons) {
            final JRadioButtonMenuItem btn = new JRadioButtonMenuItem(tool);
            btngrp.add(btn);
            toolMenu.add(btn);
        }
        return toolMenu;
    }
    
    /**
     * Private helper method to create Help menu.
     *  
     * @return JMenu with appropriate Items. 
     */
    private JMenu helpMenu() {
        final ImageIcon icon = new ImageIcon(W_GIF); 
        final JMenu help = new JMenu("Help");
        final JMenu about = new JMenu("About...");
        about.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(null, "TCSS 305 PowerPaint"
                                + "\n Autumn 2017 \n Lindsee Purnell",
                                "About", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        
        });
        help.add(about); 
        return help; 
    }
    
    /** 
     * Private helper method to create tool bar. 
     * 
     * @return the Tool Bar to pick tools. 
     */
    public JToolBar createToolBar() {
        final JToolBar toolBar = new JToolBar(); 
        toolBar.setFloatable(true);
        toolBar.addSeparator();
        
        final ButtonGroup btngrp = new ButtonGroup();
        for (final ToolAction tool : myToolButtons) {
            final JToggleButton tb = new JToggleButton(tool); 
            //tb.setIcon(tool.getIcon());
            btngrp.add(tb);
            toolBar.add(tb);
        }
        
        return toolBar; 
    }
    
    /**
     * Method to set the tool being used. 
     * 
     * @param theTool tool that was being used. 
     */
    public static void setTool(final ToolInterface theTool) {
        myTool = theTool;
    }
    
    /**
     * Returns the tool being used. 
     * 
     * @return myTool variable. 
     */
    public static ToolInterface getTool() {
        return myTool;
    }
    
    /**
     * Takes in thickness from JSlider. 
     * 
     * @return the integer value from the JSlider. 
     */
    public static int getStroke() {
        return mySlider.getValue();
    }
    
    /**
     * Gets the Stroke color from JColorChooser. 
     * 
     * @return color for the stroke. 
     */
    public static Color getStrokeColor() {
        return myStrokeColor; 
    }
    
    /**
     * Gets the fill color from the JColorChooser. 
     * 
     * @return fill color variable. 
     */
    public static Color getFillColor() {
        return myFillColor; 
    }
    
    /**
     * Boolean if it is fillable. 
     * 
     * @return boolean variable if it is fillable. 
     */
    public static boolean isFillable() {
        return isFilled; 
    }
    
    //Inner class
    /**
     * Private inner class to give action to the tool buttons. 
     *  
     * @author Lindsee Purnell
     * @version Pow1
     */
    private class ToolAction extends AbstractAction {
        
        /**
         * Default serial ID. 
         */
        private static final long serialVersionUID = 1L;
        
        /**
         * Tool variable to be assigned to a button. 
         */
        private final ToolInterface myTool; 
        
        /**
         * Tool action constructor.
         * 
         * @param theTool takes in a tool argument. 
         */
        ToolAction(final ToolInterface theTool) {
            super(theTool.getToolName()); 
            myTool = theTool; 
        }
        
        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            PowerPaintGUI.setTool(myTool); 
        }
        
//        //Fix
//        /**
//         * Little helper method to help set an icon. 
//         * 
//         * @return ImageIcon of tool image. 
//         */
//        public ImageIcon getIcon() {
//            final ImageIcon icon;
//            final String imageName = myTool.getToolImage().toLowerCase();
//            icon = new ImageIcon(imageName); 
//            final Image img = icon.getImage(); 
//            final Image newImg = img.getScaledInstance(10, 10, 0);
//            final ImageIcon reIcon = new ImageIcon(newImg); 
//            return reIcon;
//        }
        
    }
}
