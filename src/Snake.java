import javax.swing.*;
import java.awt.*;
import  java.io.*;

import java.io.File;
import java.util.ArrayList;

import static com.sun.deploy.cache.Cache.exists;

/**
 * Created by m on 16.02.2017.
 */
public class Snake   {

    static int headX =10;
    static int headY=10;
    JButton b;

    static Boolean  snake_dead = false;
    static Boolean rabbit_eaten=false;
    static Rabbits rabbit_dead;




  //  static FileReader fr;

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
        b = GamePanel_Snake.buttons_list_snake.get((10-1)*20+(8-1));
        b.setBackground(Color.PINK);

      Snake_body.snake_bodie.add(segment1);




    }


     public  static  void toMove (int i) {
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


             static void toKillSnake() {
              snake_dead = true;
              GamePanel_Snake.neww.setEnabled(true);
                 String s ="";
                 StringBuilder sb = new StringBuilder();
                 int c;
                 try(BufferedReader in = new BufferedReader( new FileReader("d://score.txt"))){



                     while ((s = in.readLine())!=null){
                         sb.append(s+"\n");

                     }



                     s = sb.toString();
         }


                 catch(IOException e){

                     System.out.println("хуюшки при чтении");


                 }


                 String str [] = s.split(" ", 2);

                 String name = str[0];


                     try{
                  c = Integer.parseInt(str[1].trim());


                      }
                      catch (NumberFormatException e) {

                         c=0;
                        }

                        catch (ArrayIndexOutOfBoundsException e){
                         c= 0;
                        };

                System.out.println(name);
                System.out.println(c);

                 if (c < Rabbits.Score){

                     Panel_save save = new Panel_save(name,Rabbits.Score, c);

                 }





















              }




}
