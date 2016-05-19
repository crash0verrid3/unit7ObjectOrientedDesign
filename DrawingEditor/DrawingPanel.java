import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
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
    private Color color = Color.BLACK;
    private JPanel frame;
    private Color bgColor = Color.WHITE;
    private boolean border = false;

    /**
     * Default constructor for objects of class DrawingPanel
     */
    public DrawingPanel(Dimension preferredFrameSize)
    {
        // initialise instance variables
        frame = new JPanel();
        frame.setPreferredSize(preferredFrameSize);
        this.add(frame);
        BackgroundColor bg = new BackgroundColor(new Point2D.Double(-10, -10), 660, bgColor);
        this.shapeList.add(bg);
        
        this.addMouseListener(new MousePressListener(){
            public void mousePressed(MouseEvent e){
                if(s != null){
                    if(border){
                        double distance = Math.sqrt((s.getCenter().getX()-e.getX())*(s.getCenter().getX()-e.getX())+(s.getCenter().getY()-e.getY())*(s.getCenter().getY()-e.getY()));
                        s.setRadius(distance);
                    } else{
                        s.move(e.getX()-s.getCenter().getX(), e.getY()-s.getCenter().getY());
                    }
                    s = null;
                    activeShape = null;
                } else{
                    for(Shape sh : shapeList){
                        if(sh.isOnBorder(new Point2D.Double(e.getX(), e.getY()), 10)){
                            s = sh;
                            border = true;
                        } else if(sh.isInside(new Point2D.Double(e.getX(), e.getY()))){
                            s = sh;
                            activeShape = sh;
                            border = false;
                        }
                    }
                }
            }
      });
    }
    
    public void pickColor(){
        Color c = JColorChooser.showDialog(this, "Pick a color", this.color);
        this.color = c != null ? c : this.color;
        activeShape.setColor(c);
        update();
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
        Circle circle = new Circle(new Point2D.Double(250, 250), Math.random()*160+20, this.color);
        this.shapeList.add(circle);
        
        activeShape = circle;
        update();
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
        Square square = new Square(new Point2D.Double(250, 250), Math.random()*160+20, this.color);
        this.shapeList.add(square);
        
        activeShape = square;
        update();
    }
    
    public void update(){
        Graphics2D g2 = ((Graphics2D)this.frame.getGraphics());
        g2.setBackground(bgColor);
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
        boolean count = false;
        for (int i = 0; i < shapeList.size(); i++)
        {
            if (shapeList.get(i) == activeShape)


            {
                count = true;
            }
            else
            {
                shapeList.get(i).draw(g2, true);
            }
            if (count)
            {
                activeShape.draw(g2, false);
            }
        }
    }
    
        class MousePressListener implements MouseListener
    {
        Shape s = null;
        int clicks = 0;
        public void mousePressed(MouseEvent event){}
        public void mouseReleased(MouseEvent event) {}
        public void mouseClicked(MouseEvent event) {}
        public void mouseEntered(MouseEvent event) {}
        public void mouseExited(MouseEvent event) {}
    }
}