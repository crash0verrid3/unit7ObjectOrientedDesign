import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Write a description of class Square here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackgroundColor extends Shape
{
    // instance variables - replace the example below with your own
    
    private Point2D.Double center;
    private double radius;
    
    public BackgroundColor(Point2D.Double center, double radius, Color color)
    {
        super(center, radius, color);
        this.center = center;
        this.radius = radius;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public boolean isInside(Point2D.Double point)
    {
        return false;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void draw(Graphics2D g2, boolean filled)
    {
        g2.setColor(getColor());
            g2.fillRect((int)(center.getX() - getRadius()), (int)(center.getY() - getRadius()), 2 * (int)(getRadius()), 2 * (int)(getRadius()));
        
    }
    public void move(double x, double y)
    {
        super.move(x, y);
        // put your code here
        this.center = new Point2D.Double(this.center.getX() + x, this.center.getY() + y);
    }
    public boolean isOnBorder(Point2D.Double point, int tolerance){
        return false;
    }
}
