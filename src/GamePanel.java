import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by m on 01.02.2017.
 */
public class GamePanel extends JFrame{


    public static ArrayList<JButton> buttons_list = new ArrayList<>();

    // Control buttons
    static JButton sTart = new JButton("START");
    static JButton nEw = new JButton("NEW");
    static JButton sLide_Mode = new JButton("SLIDE MODE");
    static JButton sTep_Forvard = new JButton("STEP");
    static JButton sPeed_Up = new JButton("SPEED >");
    static JButton sPeed_Down = new JButton("SPEED <");
    static JButton sTop = new JButton("STOP");

    static JTextField Speed = new JTextField("   1",5);




   GamePanel(){

       super("GAME LIFE");
       //  setLayout(new FlowLayout());
       setSize(840,900);

       JPanel panel_cage =new JPanel();// creation of left panel with game field 100 x 100

        panel_cage.setLayout(new GridLayout(100,100));
        JButton b;

        sTart.setEnabled(false);

        sLide_Mode.setEnabled(false);

        sPeed_Down.setEnabled(false);

        sPeed_Up.setEnabled(false);

        sLide_Mode.setEnabled(false);

        sTep_Forvard.setEnabled(false);

        sTop.setEnabled(false);

       for(int i=1;i<101;i++){// creation of the game field from the small buttons 10 000 pcs
            for(int k=1;k<101;k++) {

                b = new JButton();

                b.setEnabled(false);

                panel_cage.add(b);

                b.addActionListener(new Button_Handler(b,i,k));

               buttons_list.add(b);
            }
       }


       JPanel panel_buttons =new JPanel();// creation of right panel with control buttons


       // control buttons


       panel_buttons.add (sTart);

       panel_buttons.add (nEw);

       panel_buttons.add (sLide_Mode);

       panel_buttons.add (sTep_Forvard);

       panel_buttons.add (sPeed_Up);

       panel_buttons.add (sPeed_Down);

       panel_buttons.add (Speed);

       Speed.setBorder(new LineBorder(Color.BLACK,1));

       panel_buttons.add (sTop);



        // Action listeners for control buttons

        sTart.addActionListener(new Button_Handler(sTart));

        nEw.addActionListener(new Button_Handler(nEw));

        sLide_Mode.addActionListener(new Button_Handler(sLide_Mode));

        sTep_Forvard.addActionListener(new Button_Handler(sTep_Forvard));

        sPeed_Up.addActionListener(new Button_Handler(sPeed_Up));

        sPeed_Down.addActionListener(new Button_Handler(sPeed_Down));

        sTop.addActionListener(new Button_Handler(sTop));


       Box width1 = Box.createHorizontalBox();

       width1.add(Box.createVerticalStrut(15));

       width1.add(Box.createHorizontalStrut(5));

        panel_buttons.add(width1);

       add ((panel_buttons),BorderLayout.NORTH);

       add ((panel_cage),BorderLayout.CENTER);

       panel_cage.setBorder(new LineBorder(Color.BLACK,2));

       panel_buttons.setBorder(new LineBorder(Color.BLACK,2));


       setVisible(true);

       setDefaultCloseOperation(EXIT_ON_CLOSE);

}


}
