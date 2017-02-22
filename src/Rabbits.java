import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by m on 15.02.2017.
 */
public class Rabbits {

    int x;
    int y;
    JButton b;
    boolean bool;
    public static ArrayList<Rabbits> rabbit_list = new ArrayList();


        // constructor of rabbit object on free space of the game field  not to interfere snake body and other rabbits
    Rabbits(){
        int number_of_button;
        Random random_= new Random();
        bool=true;

       while (bool) {
           int count=0;
           int xx = random_.nextInt(20)+1;
           int yy = random_.nextInt(20)+1;




               for (Rabbits rabbit : rabbit_list ) {
                   if (rabbit.x == xx & rabbit.y == yy) {
                       count++;
                   }

                    if(xx==Snake.headX & yy==Snake.headY)
                    { count++; }

                       for (Snake_body segment :Snake_body.snake_bodie
                            ) {
                        if(xx==segment.x & yy == segment.y){
                            count++;}

                       }




               }

                        if(count==0)
                   {

                       x = xx;
                       y = yy;

                       number_of_button=(y-1)*20+(x-1);
                       rabbit_list.add(this);
                       b = GamePanel_Snake.buttons_list_snake.get(number_of_button);
                       b.setBackground(Color.BLUE);

                    bool = false;}



           if (rabbit_list.size()>=400) {bool=false;}
       }
    }


        // if snake eats  rabbit
              public static  void del (Rabbits r)   {
//
                rabbit_list.remove(r);

              }


        // method for new rabbit

            public static void rAbbit_birth()
            {

               Rabbits rabbit = new Rabbits();


            }

}
