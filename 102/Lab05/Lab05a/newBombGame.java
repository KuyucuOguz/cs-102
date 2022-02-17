/**Plays a potluck game
 * @author Oğuz Kuyucu
 * @version 31.03.2021
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
public class newBombGame extends JFrame implements ActionListener{
    /**
	 *
	 */
	//private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
    private JPanel jpanel;
    public static void main(String[] args) { 
      
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                newBombGame frame = new newBombGame();
                frame.setVisible(true);
            
            }
        });
    }
      
   
    JButton   prizeButton;
    JButton   bombOneButton;
    JButton   bombTwoButton;
    int       locationOfPrize;
    int       locationOfBomb1;
    int       locationOfBomb2;
    int       clickSoFar;
    JLabel    jlabel;
    final int ROW = 5;
    final int COLUMN = 5;
    EmptyBorder emptyBorder;
    String star = "\u2605";
    Component comp = new Component();
    Component comp2 = new Component();
    //Constructor
    /**
     * Creates newBombGame with 2 bomb and 1 star
     */
    public newBombGame() {
        //create content panel
        setTitle("BombGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        mainPanel = new JPanel();
        emptyBorder = new EmptyBorder(ROW, ROW, COLUMN, COLUMN);
        mainPanel.setBorder(new EmptyBorder(ROW, ROW, COLUMN, COLUMN));
        mainPanel.setLayout(new BorderLayout(0, 0));
        setContentPane(mainPanel);
        //create panel
        jpanel = new JPanel();
        mainPanel.add(jpanel, BorderLayout.CENTER);
        jpanel.setLayout(new GridLayout(ROW, COLUMN, ROW*2, COLUMN*2));
        //create buttons
        locatePrizeAndBombs();
        clickSoFar = 0;
        createButtons();
        //update label
        jlabel = new JLabel("YOU CLICKED "+clickSoFar+" times\r\n");
        jlabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(jlabel, BorderLayout.NORTH);
    }
    /**
     * Locates bombs and prize
     */
    private void locatePrizeAndBombs(){
        while (locationOfPrize == locationOfBomb1 ||  locationOfPrize == locationOfBomb2 ||locationOfBomb1 == locationOfBomb2){
            locationOfPrize = (int)(Math.random()*(ROW*COLUMN));
            locationOfBomb1 = (int)(Math.random()*(ROW*COLUMN));
            locationOfBomb2 = (int)(Math.random()*(ROW*COLUMN));
        }
    }
    /**
     * Creates 1 prize button, 2 bomb buttons and 22 empty buttons
     */
    private void createButtons(){
        for(int buttonSoFar = 0; buttonSoFar < (ROW*COLUMN); buttonSoFar++){ 
            if(locationOfPrize == buttonSoFar){
                prizeButton = new JButton();
                prizeButton.addActionListener(this);
                jpanel.add(prizeButton);
                prizeButton.setText(String.valueOf(buttonSoFar + 1));
              }
            else if  (locationOfBomb1 ==buttonSoFar ){
                bombOneButton = new JButton();
                bombOneButton.addActionListener(this);
                jpanel.add(bombOneButton);
                bombOneButton.setText(String.valueOf(buttonSoFar + 1));
            }
            else if  (locationOfBomb2 ==buttonSoFar ){
                bombTwoButton = new JButton();  
                bombTwoButton.addActionListener(this);
                jpanel.add(bombTwoButton);
                bombTwoButton.setText(String.valueOf(buttonSoFar + 1));
            }
            else{
                JButton button = new JButton();
                jpanel.add(button);
                button.addActionListener(this);
                button.setText(String.valueOf(buttonSoFar + 1));
            }
        }
    }

    public void actionPerformed( ActionEvent e)
    {
        //if empty buttons are clicked, make them unclickable
        if ( e.getSource() != prizeButton && e.getSource() != bombOneButton && e.getSource() != bombTwoButton){
            clickSoFar ++;
            ((JButton) e.getSource()).setEnabled(false);
            jlabel.setText("YOU CLICKED " + clickSoFar + " times");
            System.out.println("1");
        }
        //if prize button is clicked, end the game
        else if ( e.getSource() == prizeButton){ 
            jlabel.setText("You got it in " + (clickSoFar + 1) + " attempts!" );
            endGame();
            for(int buttons = 0; buttons < (ROW*COLUMN); buttons++){
                if(jpanel.getComponent(buttons) != prizeButton){
                    ((JButton) jpanel.getComponent(buttons)).setEnabled(false);   
                
                }
            }
        }
        //if bomb buttons are clicked, end the game
        else{
            jlabel.setText("Sorry! You are blown up at attempt " + (clickSoFar + 1));
            endGame();
            for(int buttons = 0; buttons < (ROW*COLUMN); buttons++){
                if(jpanel.getComponent(buttons) != prizeButton || jpanel.getComponent(buttons) != bombOneButton || jpanel.getComponent(buttons) != bombTwoButton){
                    ((JButton) jpanel.getComponent(buttons)).setEnabled(false);   
    
                }
            }
        }
    }
    /**
     * Makes bombs and prize visible
     */
    public void endGame(){
        prizeButton.setText(star);
        prizeButton.setFont(prizeButton.getFont().deriveFont(50.0f));
        prizeButton.setForeground(Color.BLUE );
        prizeButton.setOpaque( true );
        bombOneButton.add(comp);
        bombTwoButton.add(comp2);
    }

}
//Draw a bomb
@SuppressWarnings("serial")
class Component extends JComponent
{
    @Override
    public void paintComponent( Graphics graph )
    { 
        super.paintComponent(graph);
        graph.fillOval( 15, 27, 30, 30);
        graph.setColor( Color.BLACK );
        graph.drawLine( 28, 19, 35, 15);
        graph.setColor( Color.RED );
        graph.fillRect( 20, 19, 20, 8);
        graph.setColor( new Color(64, 64, 64 ));
    }
}
