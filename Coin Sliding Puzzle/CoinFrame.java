import javax.swing.*;
public class CoinFrame extends JFrame
{

    
    public CoinFrame()
    {
        super("Coin-sliding Puzzle");   //call one-agrument constructor of JFrame
        setBounds(0,0,400,600);
        CoinPuzzle panel = new CoinPuzzle();
        add(panel);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

  
    public static void main(String[] args)
    {
        JFrame frown = new CoinFrame();
    }
}