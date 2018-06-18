import java.util.*;
import java.awt.*;
/**
 * @author (Darion Walls)
 */
public class PointData
{
    private ArrayList<ColorPoint>pointHistory; //drawn points
    private final int capacity = 1000; // inital capacity of ArrayList
    private ColorPoint startPoint;

    public PointData()
    {
        pointHistory = new ArrayList<ColorPoint>(capacity);
        startPoint = new ColorPoint();
        
    }

    public ColorPoint get(int i)
    {
        
        return pointHistory.get(i);
        
    }
    
    public void setColor(Color c)
    {
        
        startPoint.setColor(c);
        
    }
    
    public void setColor(String c)
    {
        
        startPoint.setColor(c);
        
    }
    
    public void add(ColorPoint p)
    {
        
        pointHistory.add(p);
        
    }
    
    public void setX(int x)
    {
        
        startPoint.setX(x);
        
    }
    
    public void setY(int y)
    {
        
        startPoint.setY(y);
        
    }
    
    public int getX()
    {
        
        return startPoint.getX();
        
    }
    
    public int getY()
    {
        
        return startPoint.getY();
        
    }
    
    public Color getColor()
    {
        
        return startPoint.getColor();
        
    }
    
    public int size()
    {
        
        return pointHistory.size();
        
    }
}
