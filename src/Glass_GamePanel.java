import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by m on 27.02.2017.
 */
public class Glass_GamePanel extends JFrame {

    static JTextField Score = new JTextField("   ",5);
    static int direction=0;
    JLabel label = new JLabel("SCORE");


        public static ArrayList<JButton> buttons_list_tetris = new ArrayList<>();

        static JButton nnew = new JButton("NEW");

        Glass_GamePanel() {

        super("TETRIS");

        setSize(245, 580);


        JPanel panel_cage_snake = new JPanel();// creation of left panel with game field 15 x 15

        panel_cage_snake.setLayout(new GridLayout(20, 10));
        JButton b;


        for (int i = 1; i < 11; i++)

        {// creation of the game field from the small buttons 400 pcs
            for (int k = 1; k < 21; k++) {

                b = new JButton();

                b.setEnabled(false);

                panel_cage_snake.add(b);


                buttons_list_tetris.add(b);
            }
        }


            JPanel panel_buttons =new JPanel();// creation of right panel with control buttons


            // control buttons



            panel_buttons.add (nnew);
            panel_buttons.add (label);

            panel_buttons.add (Score);



            nnew.addActionListener(new Tetramino_BattonHandler(nnew));



            Box width1 = Box.createHorizontalBox();

            width1.add(Box.createVerticalStrut(15));

            width1.add(Box.createHorizontalStrut(5));

            panel_buttons.add(width1);

            add ((panel_buttons),BorderLayout.NORTH);

            add ((panel_cage_snake),BorderLayout.CENTER);

            panel_cage_snake.setBorder(new LineBorder(Color.BLACK,2));

            panel_buttons.setBorder(new LineBorder(Color.BLACK,2));

            this.setFocusable(true);



            this.addKeyListener(new KeyListener() {



                public void keyTyped(KeyEvent keyEvent) {


                }


                @Override
                public void keyPressed(KeyEvent keyEvent) {

                    // not to perform snake to go back in any direction


                        direction =keyEvent.getKeyCode();


                        if (direction==37|direction==39|direction==38){Glass.delay=300;}


                    }




                @Override
                public void keyReleased(KeyEvent keyEvent) {


                    if (direction==37|direction==39|direction==38){Glass.delay=500;}

                }
            });

            // for returning focus to keys
            this.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent focusEvent) {
                    super.focusLost(focusEvent);
                    requestFocus();
                }
            });









        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }










}
