import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PencilDrawing extends JFrame
{
    
    private JButton eraseButton; //clears screen
    private JButton colorButton; //changes color
    private JButton exitButton; //ends application
    private JPanel paper; //the drawing surface
    private JPanel buttonPanel; //holds 3 buttons
    private PointData points; //manages the data for the application
    
    public PencilDrawing() //default constructor
    {
        
        super("Pencil Draw");
        
        Toolkit tk = Toolkit.getDefaultToolkit(); //so that the frame fills the screen
        Dimension dim = tk.getScreenSize();
        setBounds(0,0, dim.width, dim.height);
        points = new PointData();
        
        //place buttons
        buttonPanel = new JPanel();
        eraseButton = new JButton("Erase");
        colorButton = new JButton("Color");
        exitButton = new JButton("Exit");
        buttonPanel.add(eraseButton);
        buttonPanel.add(colorButton);
        buttonPanel.add(exitButton);
        add(buttonPanel, BorderLayout.SOUTH);
        
        //place the drawing panel in the frame
        paper = new JPanel();
        add(paper);
        
        //register the mouse listners
        addMouseListener(new MouseButtonListener());
        addMouseMotionListener(new MoveMouseListener());
        
        //register the button listener
        eraseButton.addActionListener(new ButtonListener());
        colorButton.addActionListener(new ButtonListener());
        exitButton.addActionListener(new ButtonListener());
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    
    public void paint(Graphics g)
    {
        buttonPanel.repaint();
        //get the graphics context for the drawing
        g = paper.getGraphics();
        //recreate the image from the PointHistory object points
        
        for(int i = 0; i < points.size() - 1; i++)
        if(points.get(i + 1)!=null && points.get(i)!=null)
        {
         g.setColor(points.get(i).getColor());
         g.drawLine(points.get(i).getX(),points.get(i).getY(),
                points.get(i + 1).getX(),points.get(i + 1).getY());
        }
    
   }
   
    private class ButtonListener implements ActionListener
    {
        
        public void actionPerformed(ActionEvent e)
        {
         String options[] = {"Black", "Red", "Blue", "Green", "Magenta", "Pink", "Yellow"};
         if(e.getSource() == colorButton)
         {
             String drawColor = 
             (String) JOptionPane.showInputDialog(null,"Choose a color",
                                  "ColorChooser",JOptionPane.QUESTION_MESSAGE,null,
                                   options, "BLACK");
                                   
             if(drawColor!=null)//cancel returns null
                points.setColor(drawColor);
            }
            else if(e.getSource() == eraseButton)
            {
                points = new PointData(); //empty the history
                paper.repaint(); //repaint the single JPanel
            }
            else
              System.exit(0); //exit Button
        }
    
   }
   private class MouseButtonListener implements MouseListener
        {
         public void mouseClicked(MouseEvent e)
         {} //required by MouseListener interface but does nothing
         public void mouseEntered(MouseEvent e)
         {} //required by MouseListener interface but does nothing
         public void mouseExited(MouseEvent e)
         {} //required by MouseListener interface but does nothing
         public void mouseReleased(MouseEvent e)
         {
             //add a null ColorPoint to the points
             //to signify the end of a continuous
             //section when redrawing the image
             points.add(null);
            }
        public void mousePressed(MouseEvent e)
         {
             //thiss is where drawing starts
             points.setX(e.getX());
             points.setY(e.getY());
            }
        }
   private class MoveMouseListener implements MouseMotionListener
   {
       public void mouseMoved(MouseEvent e)
       {}
       public void mouseDragged(MouseEvent e)
       {
           Graphics g = paper.getGraphics();
           g.setColor(points.getColor());
           int x1 = points.getX(); //get start point
           int y1 = points.getY();
           int x2 = e.getX(); //get current mouse-over point
           int y2 = e.getY();
           g.drawLine(x1,y1,x2,y2);
           //add the last point to the list of points
           points.add(new ColorPoint(x1,y1,points.getColor()));
           
           points.setX(x2); //update the start point with the last point
           points.setY(y2);
        }
    }
    
    public static void main(String[]args)
    {
        PencilDrawing d = new PencilDrawing();
        
    }
}
