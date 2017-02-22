import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by m on 15.02.2017.
 */
public class Button_Handler_Snake implements ActionListener {
    JButton b;




    // buttons handler constructor for game field


    // buttons handler constructor for control buttons
    Button_Handler_Snake(JButton b){

        this.b = b;

    }






    // action performer for button NEW

    public void actionPerformed(ActionEvent actionEvent) {



        if (b.getText().equals("NEW")) {



            // checking for new cycle
            if(Snake.snake_dead){
                for(JButton b: GamePanel_Snake.buttons_list_snake){

                    b.setBackground(Color.WHITE);
                    Rabbits.rabbit_list.clear();

                }

                Snake.snake_dead=false;
                Snake.headX=10;
                Snake.headY = 10;
                Snake_body.snake_bodie.clear();

                GamePanel_Snake.neww.setEnabled(false);
                GamePanel_Snake.previous_direction=39;
                GamePanel_Snake.direction=39;


            }


            GamePanel_Snake.neww.setEnabled(false);



            Snake snake = new Snake();

            for(int j = 0; j < 10;j++){
                Rabbits r = new Rabbits();

            }

            // thread for snake moving
            class snakeMoveThread extends Thread{

                public void run(){
                    while (!Snake.snake_dead){

                        try {Thread.sleep(500);}
                        catch (InterruptedException e)
                        {}


                        Snake_body.toMove();
                        Snake.toMove(GamePanel_Snake.direction);



                }

                }

            }

            Thread snakemove = new snakeMoveThread();

            snakemove.start();



                        return;

        }




    }

}


