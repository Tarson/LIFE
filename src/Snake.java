import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by m on 16.02.2017.
 */
public class Snake {

    static int headX =10;
    static int headY=10;
    JButton b;

    static Boolean  snake_dead = false;
    static Boolean rabbit_eaten=false;
    static Rabbits rabbit_dead;

    Snake(int i){}


    Snake(){


        // constructor of the snake and two snake's  segments

        b = GamePanel_Snake.buttons_list_snake.get((headY-1)*20+(headX-1));
        b.setBackground(Color.RED);


        Snake_body segment0 = new Snake_body(10,9);



        b = GamePanel_Snake.buttons_list_snake.get((10-1)*20+(9-1));
        b.setBackground(Color.PINK);

        Snake_body.snake_bodie.add(segment0);


        Snake_body segment1 = new Snake_body(10,8);



        for (Rabbits r:  Rabbits.rabbit_list  ) {

            if(r.y==9&r.x==10){Rabbits.del(r);}

        }

        b = GamePanel_Snake.buttons_list_snake.get((10-1)*20+(8-1));
        b.setBackground(Color.PINK);

      Snake_body.snake_bodie.add(segment1);





    }


     public  static  void toMove (int i){
         JButton b;
    switch (i)

    {

        case (38)://up
            headY--;
            if(headY==0){ toKillSnake(); return; }

            b = GamePanel_Snake.buttons_list_snake.get((headY-1)*20+(headX-1));
            b.setBackground(Color.RED);
            GamePanel_Snake.direction=38;



          break;
          case (39):// right

            headX++;
            if(headX==21){ toKillSnake();return; }
            b = GamePanel_Snake.buttons_list_snake.get((headY-1)*20+(headX-1));
            b.setBackground(Color.RED);
            GamePanel_Snake.direction=39;


            break;


        case (37)://left



            headX--;
            if(headX==0){ toKillSnake();return; }
            b = GamePanel_Snake.buttons_list_snake.get((headY-1)*20+(headX-1));
            b.setBackground(Color.RED);
            GamePanel_Snake.direction=37;


            break;





        case (40)://down



            headY++;
            if(headY==21){ toKillSnake();return; }
            b = GamePanel_Snake.buttons_list_snake.get((headY-1)*20+(headX-1));
            b.setBackground(Color.RED);
            GamePanel_Snake.direction=40;



            break;



        }

        // checking for crossing head and segments of the snake
          for (Snake_body segment:Snake_body.snake_bodie
              ) {

                if(headY==segment.y & headX == segment.x){
                    toKillSnake();
                }

         }




         // code to check is the rabbit have eaten

        for (Rabbits rabbit: Rabbits.rabbit_list
                ) {
            if(headY==rabbit.y & headX == rabbit.x){

                rabbit_eaten= true;
                rabbit_dead=rabbit;


            }


             }
               if(rabbit_eaten){Rabbits.rAbbit_birth();}
               Rabbits.del(rabbit_dead);



             }


             static void toKillSnake(){
              snake_dead = true;
              GamePanel_Snake.neww.setEnabled(true);

              }


}
