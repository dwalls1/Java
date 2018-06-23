import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CoinPuzzle extends JPanel
{
    // A GUI for the H --> O coin puzzel
    //(x[i],y[i]) is the corner point of a bounding square for circle i
    private int [] x = {100, 100, 100, 150, 200, 250, 250, 250};
    private int [] y = {100, 150, 200, 150, 150, 100, 150, 200};
    
    private final int RADIUS = 50; //radius of each coin
    private JButton reset,exit;
    int circleNumber; //-1 for no circle

    public CoinPuzzle()
    {
        setLayout(null); //no layout manager for the panel
        setBackground(Color.WHITE);
        
        reset = new JButton("Reset");
        reset.setBounds(20,500,100,500);
        
        exit = new JButton("Exit");
        exit.setBounds(200,500,100,50);
        
        add(reset);
        add(exit);
        circleNumber = -1; //No circle
        
        //register listeners
        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseHandler());
        
        reset.addActionListener(new ButtonHandler());
        exit.addActionListener(new ButtonHandler());
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial",Font.BOLD, 20));
        g.drawString(" Transform the H to an O", 20, 470);
        
        //Draw 8 circles
        //Uper left corner of bounding box for circle -i is (x[i],y[i])
        
        for(int i = 0; i<8; i++)
            g.fillOval(x[i],y[i], RADIUS, RADIUS);
            
            g.setColor(Color.WHITE);
            
            //Make lables for the coins
            String[]numbers = {"0","1","2","3","4","5","6","7"};
            //Place a number on each coin
            for(int i = 0; i<8; i++)
                g.drawString(numbers[i],x[i] + 20,y[i] + 30);
            
    }
    
  
    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        if(e.getSource()==reset) //reset corner points to the original arrangement
        {
            x[0] = 100; x[1] = 100; x[2] = 100; x[3] = 150; x[4] = 200; x[5] = 250; x[6] = 250; x[7] = 250;
            y[0] = 100; y[1] = 150; y[2] = 200; y[3] = 150; y[4] = 150; y[5] = 100; y[6] = 150; y[7] = 200;
            circleNumber = -1;
            repaint();
        }
        if(e.getSource()==exit)
            System.exit(0);
      }
   }

    
     
    private class MouseHandler implements MouseListener,MouseMotionListener
    {
    public void mouseReleased(MouseEvent e)
        {
            circleNumber = -1; //done dragging a circle
            
        }
        
        public void mousePressed(MouseEvent e)
        {
            int newX = e.getX();
            int newY = e.getY();
            for(int i = 0; i<8; i++)
                //if the mouse is in the bounding square of a circle
                if(newX <= x[i] + 50 && newX >= x[i] && newY >= y[i] && newY <= y[i] + 50)
                {
                    circleNumber = i; //circle i can be dragged
                    break;
                }
    }

    public void mouseDragged(MouseEvent e)
    {
        if(circleNumber >= 0)
        {       //change the upper corner of the bounding rectangle
            x[circleNumber] = e.getX();
            y[circleNumber] = e.getY();
            repaint();
            
        }
    }
    public void mouseMoved(MouseEvent e){} //empty method
    public void mouseEntered(MouseEvent e){} //empty method
    public void mouseExited(MouseEvent e){} //empty method
    public void mouseClicked(MouseEvent e){} //empty method
   }
}   

