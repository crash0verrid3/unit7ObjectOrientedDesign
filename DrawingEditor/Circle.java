import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circle extends Shape
{
    // instance variables - replace the example below with your own
    
    private Point2D.Double center;
    private double radius;
    
    public Circle(Point2D.Double center, double radius, Color color)
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
        return Math.pow(point.getX() - center.getX(), 2) + Math.pow(point.getY() - center.getY(), 2) < Math.pow(getRadius(), 2);
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
        if(filled){
            g2.fillOval((int)(center.getX() - getRadius()), (int)(center.getY() - getRadius()), 2 * (int)radius, 2 * (int)radius);
        } else{
            g2.drawOval((int)(center.getX() - getRadius()), (int)(center.getY() - getRadius()), 2 * (int)radius, 2 * (int)radius);
        }
        
    }
    public void move(double x, double y)
    {
        super.move(x, y);
        // put your code here
        this.center = new Point2D.Double(this.center.getX() + x, this.center.getY() + y);
    }
    public boolean isOnBorder(Point2D.Double point, int tolerance){
        boolean a = new Circle(center, radius-tolerance, null).isInside(point);
        boolean b = new Circle(center, radius+tolerance, null).isInside(point);
        return !a && b;
    }
}