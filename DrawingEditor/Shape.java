import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Abstract class Shape - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Shape
{
    // instance variables - replace the example below with your own
    private Point2D.Double center;
    private double radius;
    private Color color;
    public Shape(Point2D.Double center, double radius, Color color)
    {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the sum of x and y 
     */
    public Point2D.Double getCenter()
    {
        // put your code here
        return this.center;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public double getRadius()
    {
        // put your code here
        return this.radius;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void move(double x, double y)
    {
        // put your code here
        this.center = new Point2D.Double(this.center.getX() + x, this.center.getY() + y);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void setRadius(double r)
    {
        // put your code here
        this.radius = r;
    }
    public abstract boolean isInside(Point2D.Double point);
    public abstract void draw(Graphics2D g2, boolean filled);

}