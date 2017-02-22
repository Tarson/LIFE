import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by m on 16.02.2017.
 */
public class Snake_body extends Snake  {


    int x;
    int y;

    static ArrayList <Snake_body>  snake_bodie = new ArrayList<>();


    Snake_body(int y, int x){

        super(1);
        this.y=y;
        this.x=x;



    };

    public  static  void toMove(){

        int headY = Snake.headY;
        int headX = Snake.headX;

        JButton b;

        for (Snake_body segment:snake_bodie
             ) {




            int yy =segment.y;
            int xx = segment.x;

            segment.y = headY;
            segment.x=headX;

            b = GamePanel_Snake.buttons_list_snake.get((segment.y-1)*20+(segment.x-1));
            b.setBackground(Color.PINK);


            headY = yy;
            headX=xx;


        }

        if(!Snake.rabbit_eaten){
            b = GamePanel_Snake.buttons_list_snake.get((headY-1)*20+(headX-1));

        b.setBackground(Color.WHITE);
              }
        else
        {
            Snake_body segment_new = new  Snake_body(headY,headX);
            snake_bodie.add(segment_new);
            Snake.rabbit_eaten=false;

        }
    }


}
