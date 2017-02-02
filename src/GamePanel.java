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

        panel_cage.setLayout(new GridLayout(10,10));
       for(int i=1;i<11;i++){
            for(int k=1;k<11;k++) {
                String s = "";
                panel_cage.add(new JButton(s + i+" "+k));
            }
       }


       JPanel panel_buttons =new JPanel();// creation of right panel with control buttons


       //panel_buttons.setLayout(new GridLayout(8,1));
       panel_buttons.add (new JButton("START"));
       panel_buttons.add (new JButton("NEW"));
       panel_buttons.add (new JButton("SLIDE MODE"));
       panel_buttons.add (new JButton("STEP >"));
       panel_buttons.add (new JButton("STEP <"));
       panel_buttons.add (new JButton("SPEED >"));
       panel_buttons.add (new JButton("SPEED <"));
       panel_buttons.add (new JButton("STOP"));
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
