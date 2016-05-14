import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.JColorChooser;

/**
 * Write a description of class DrawingPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DrawingPanel extends JPanel
{
    /** description of instance variable x (add comment for each instance variable) */
    private ArrayList<Shape> shapeList = new ArrayList<Shape>();
    private Shape activeShape;
    private Color color;
    private JPanel frame;

    /**
     * Default constructor for objects of class DrawingPanel
     */
    public DrawingPanel(Dimension preferredFrameSize)
    {
        // initialise instance variables
        frame = new JPanel();
        frame.setBackground(Color.white);
        frame.setPreferredSize(preferredFrameSize);
        this.add(frame);
    }
    
    public void pickColor(){
        Color c = JColorChooser.showDialog(this, "Pick a color", this.color);
        this.color = c != null ? c : this.color;
    }
    public Color getColor(){
        return this.color;
    }

    /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     *
     * @pre     preconditions for the method
     *          (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *          (what the method guarantees upon completion)
     * @param   y   description of parameter y
     * @return  description of the return value
     */
    public void addCircle()
    {
        // put your code here
        Circle circle = new Circle(new Point2D.Double(500,500), Math.random()*180, this.color);
        this.shapeList.add(circle);
        
        activeShape = circle;
    }

        /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     *
     * @pre     preconditions for the method
     *          (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *          (what the method guarantees upon completion)
     * @param   y   description of parameter y
     * @return  description of the return value
     */
    public void addSquare()
    {
        // put your code here
        Square square = new Square(new Point2D.Double(500,500), Math.random()*180, this.color);
        this.shapeList.add(square);
        
        activeShape = square;
    }
    
    public void update(){
        paintComponent(this.frame.getGraphics());
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void paintComponent(Graphics g)
    {
        // put your code here
        Graphics2D g2 = (Graphics2D)g;
        int count = 0;
        for (int i = shapeList.size()-1; i >= 0; i--)
        {
            if (activeShape.equals(shapeList.get(i)))


            {
                count++;
            }
            else
            {
                shapeList.get(i).draw(g2, false);
            }
            if (count > 0)
            {
                activeShape.draw(g2, true);
            }
        }
    }
}