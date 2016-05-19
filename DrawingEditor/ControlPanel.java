import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;

/**
 * Write a description of class ControlPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlPanel extends JPanel


{
    // instance variables - replace the example below with your own
    private JButton colorButton;
    private JButton circleButton;
    private JButton squareButton;
    private JButton displayButton;
    
    private JPanel panel;
    
    private static Color color;
    
    private MouseListener listener1;
    private MouseListener listener2;
    private MouseListener listener3;
    
    private DrawingPanel canvas;

    /**
     * Constructor for objects of class ControlPanel
     */
    public ControlPanel(DrawingPanel dpanel)
    {
        // initialise instance variables
        colorButton = new JButton("Pick Color");
        circleButton = new JButton("Add Circle");
        squareButton = new JButton("Add Square");
        displayButton = new JButton(" ");
        
        this.add(colorButton);
        this.add(circleButton);
        this.add(squareButton);
        this.add(displayButton);
        
        panel = new JPanel();
        
        canvas = dpanel;
        this.add(canvas);
        color = canvas.getColor();
        
        listener1 = new MousePressListener1();
        listener2 = new MousePressListener2();
        listener3 = new MousePressListener3();
        
        colorButton.addMouseListener(listener1);
        circleButton.addMouseListener(listener2);
        squareButton.addMouseListener(listener3);
    }

    class MousePressListener1 implements MouseListener
    {
        public void mousePressed(MouseEvent event)
        {
            canvas.pickColor();
            color = canvas.getColor();
            displayButton.setBackground(color);
        }
        public void mouseReleased(MouseEvent event) {}
        public void mouseClicked(MouseEvent event) {}
        public void mouseEntered(MouseEvent event) {}
        public void mouseExited(MouseEvent event) {}
    }
    
        class MousePressListener2 implements MouseListener
    {
        public void mousePressed(MouseEvent event)
        {
            canvas.addCircle();
        }
        public void mouseReleased(MouseEvent event) {}
        public void mouseClicked(MouseEvent event) {}
        public void mouseEntered(MouseEvent event) {}
        public void mouseExited(MouseEvent event) {}
    }
    
        class MousePressListener3 implements MouseListener
    {
        public void mousePressed(MouseEvent event)
        {
            canvas.addSquare();
        }
        public void mouseReleased(MouseEvent event) {}
        public void mouseClicked(MouseEvent event) {}
        public void mouseEntered(MouseEvent event) {}
        public void mouseExited(MouseEvent event) {}
    }
}
