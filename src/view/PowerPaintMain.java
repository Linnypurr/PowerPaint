package view;

import java.awt.EventQueue;

/**
 * This is the main class, it cannot be inherited and it runs
 * the PowerPaint program. 
 * 
 * @author Lindsee Purnell
 * @version November 7, 2017
 */
public final class PowerPaintMain {
    
    /**
     * Private constructor to stop instantiation. 
     */
    private PowerPaintMain() {
        throw new IllegalStateException(); 
    }
    
    /**
     * Main method to run the PowerPaint program. 
     * 
     * @param theArgs command line arguments. 
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PowerPaintGUI().start(); 
            }
        });

    }

}
