import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by m on 15.02.2017.
 */
public class GamePanel_Snake extends  JFrame   {



    public static ArrayList<JButton> buttons_list_snake = new ArrayList<>();
    static JTextField Score = new JTextField(" ",5);
    static JButton neww = new JButton("NEW");
    static int direction = 39;
    static int previous_direction=39;
    JLabel label = new JLabel("SCORE");


    GamePanel_Snake() {

        super("SNAKE");

        setSize(500, 580);


        JPanel panel_cage_snake = new JPanel();// creation of left panel with game field 15 x 15

        panel_cage_snake.setLayout(new GridLayout(20, 20));
        JButton b;


        for(int i=1;i<21;i++){// creation of the game field from the small buttons 400 pcs
            for(int k=1;k<21;k++) {

                b = new JButton();

                b.setEnabled(false);

                panel_cage_snake.add(b);



                buttons_list_snake.add(b);
            }
        }






        JPanel panel_buttons =new JPanel();// creation of right panel with control buttons


        // control buttons


        panel_buttons.add (neww);
        panel_buttons.add(label);
        panel_buttons.add(Score);

        neww.addActionListener(new Button_Handler_Snake(neww));



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
           if (!Snake.snake_dead){

                int i =keyEvent.getKeyCode();
            switch (i) {


                case (40):
                    if (previous_direction == 38) {
                        direction = 38;
                    } else {
                        direction = i;
                    }
                    previous_direction = direction;
                    break;


                case(38):  if ( previous_direction == 40) {
                        direction = 40;
                    } else {
                        direction = i;
                    }

                      previous_direction = direction;

                    break;

               case(37):  if ( previous_direction == 39) {
                   direction = 39;
               } else {
                   direction = i;
               }

                   previous_direction = direction;

                   break;

                case(39):  if ( previous_direction == 37) {
                    direction = 37;
                } else {
                    direction = i;
                }

                    previous_direction = direction;

                    break;






           }


           }


                 }

            @Override
            public void keyReleased(KeyEvent keyEvent) {  }
        });

        // for returning focus to keys
        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent focusEvent) {
                super.focusLost(focusEvent);
                requestFocus();
            }
        });


        setLocationRelativeTo(null);
        setVisible(true);

       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }






}
