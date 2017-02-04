import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by m on 01.02.2017.
 */
public class GamePanel extends JFrame{

   GamePanel(){
       super("GAME LIFE");
     //  setLayout(new FlowLayout());
       setSize(840,900);

       JPanel panel_cage =new JPanel();// creation of left panel with game field 100 x 100

        panel_cage.setLayout(new GridLayout(100,100));
        JButton b;
       for(int i=1;i<101;i++){
            for(int k=1;k<101;k++) {
                String s = "";
                b = new JButton(s + i+" "+k);
                panel_cage.add(b);
                b.addActionListener(new Button_Handler(b,i,k));
            }
       }


       JPanel panel_buttons =new JPanel();// creation of right panel with control buttons


       // control buttons

       JButton sTart = new JButton("START");
       panel_buttons.add (sTart);
       JButton nEw = new JButton("NEW");
       panel_buttons.add (nEw);
       JButton sLide_Mode = new JButton("SLIDE MODE");
       panel_buttons.add (sLide_Mode);
       JButton sTep_Back = new JButton("STEP >");
       panel_buttons.add (sTep_Back);
       JButton sTep_Forvard = new JButton("STEP <");
       panel_buttons.add (sTep_Forvard);
       JButton sPeed_Up = new JButton("SPEED >");
       panel_buttons.add (sPeed_Up);
       JButton sPeed_Down = new JButton("SPEED <");
       panel_buttons.add (sPeed_Down);
       JButton sTop = new JButton("STOP");
       panel_buttons.add (sTop);

        // Action listeners for control buttons
        sTart.addActionListener(new Button_Handler(sTart));
        nEw.addActionListener(new Button_Handler(nEw));
        sLide_Mode.addActionListener(new Button_Handler(sLide_Mode));
        sTep_Back.addActionListener(new Button_Handler(sTep_Back));
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
