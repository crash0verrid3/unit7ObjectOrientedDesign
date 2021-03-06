import javax.swing.*;
import java.util.*;
import java.awt.*;

/**
 * Write a description of class DrawingEditor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DrawingEditor
{
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Drawing Editor - Alex Anderson");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        DrawingPanel d = new DrawingPanel(new Dimension(640, 480));
        ControlPanel c = new ControlPanel(d);
        frame.getContentPane().add(c);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
