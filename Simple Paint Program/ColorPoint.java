import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/**
 * Write a description of class ColorPoint here.
 *
 * @author (Darion Walls)
 * 
 */
public class ColorPoint
{
    private Color color;
    private int x; //horizontal coordinate
    private int y; //vertical coordinate
    

    /**
     * Constructor for objects of class ColorPoint
     */
    public ColorPoint()
    {
        color = Color.BLACK;
        x = 0;
        y = 0;
        
    }

    
    /**
     * three-argument constructor
     */
    public ColorPoint(int x,int y, Color color)
    {
        
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    public void setX(int x)
    {
        this.x = x;
        
    }
    
        public void setY(int y)
    {
        this.y = y;
        
    }
    
        public void setColor(Color c)
    {
        color = c;
        
    }
    
        public void setColor(String c) //set Color from a String description
    {                                     //lists just a few possible colors
        if (c.equals("Red"))
            color = Color.RED;
        else if (c.equals("Blue"))
            color = Color.BLUE;
        else if (c.equals("Black"))
            color = Color.BLACK;   
        else if (c.equals("Green"))
            color = Color.GREEN;
        else if (c.equals("Magenta"))
            color = Color.MAGENTA;
        else if (c.equals("Pink"))
            color = Color.PINK;
        else if (c.equals("Yellow"))
            color = Color.YELLOW; //etc
    }
   
    public int getX()
    {
        return x;
        
    }
    
    public int getY()
    {
        return y;
        
    }
    
    public Color getColor()
    {
        return color;
        
    }
}
