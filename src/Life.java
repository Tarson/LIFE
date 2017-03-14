import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by m on 30.01.2017.
 */
public class Life extends  JFrame{



    Life(){
        super ("GAMES");

        JLabel label = new JLabel("ВЫБЕРИТЕ ИГРУ");
        JButton life = new JButton("\"ЖИЗНЬ\"");
        JButton snake = new JButton("ЗМЕЙКА");
        JButton tetris = new JButton("ТЕТРИС");


        add((label), BorderLayout.NORTH);
        add((life), BorderLayout.WEST);
        add((snake), BorderLayout.CENTER);
        add((tetris), BorderLayout.EAST);


        tetris.addActionListener(new Choice(tetris));
        snake.addActionListener(new Choice(snake));
        life.addActionListener(new Choice(life));


        setLocationRelativeTo(null);// to place window to the center of the screen
        setSize(300, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }




    public static void main (String [] args) {


        Life life = new Life();


//


    }
        class Choice implements ActionListener {
            JButton b;
            Choice(JButton b){

                this.b = b;

            }


            public void actionPerformed(ActionEvent actionEvent) {



                if (b.getText().equals("\"ЖИЗНЬ\"")){
                    setVisible(false);
                    GamePanel lIfePanel = new GamePanel();

                }
                if (b.getText().equals("ЗМЕЙКА")){

                    setVisible(false);
                    GamePanel_Snake snakePanel = new GamePanel_Snake();
                }
                if (b.getText().equals("ТЕТРИС")){
                    setVisible(false);
                    Glass_GamePanel glass = new Glass_GamePanel();
                }





            }
        }






    }