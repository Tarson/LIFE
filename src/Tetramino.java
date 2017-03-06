import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by m on 27.02.2017.
 */
public class Tetramino {

   static  int y1, y2, y3, y4;
   static int x1, x2, x3, x4;

    JButton b;


    Random random = new Random();

    Tetramino(){




        int i = random.nextInt(10)+1;

        switch (i){


            case 1:
                y1 = 1; x1 = 6;
                y3 = 1; x3 = 5;   //   XX
                y2 = 2; x2 = 4;   //  XX
                y4 = 2; x4 = 5;
                break;
            case 2:
                y1 = 1 ; x1 = 4;
                y2 = 1; x2 = 5;       //  XX
                y3 = 2; x3 = 5;       //   XX
                y4 = 2; x4 = 6;


                break;
            case 3:
                y1 = 1; x1 = 4;
                y2 = 1; x2 = 5;       // XXXX
                y3 = 1; x3 = 6;
                y4 = 1; x4 = 7;


                break;
            case 4:
                y1 = 1; x1 = 4;
                y2 = 1; x2 = 5;       //XXXX
                y3 = 1; x3 = 6;
                y4 = 1; x4 = 7;
                break;
            case 5:
                y1 = 1; x1 = 5;
                y2 = 1; x2 = 7;     //   X
                y3 = 1; x3 = 6;     //  XXX
                y4 = 2; x4 = 6;
                break;

            case 6:
                y1 = 1; x1 = 4;
                y2 = 1; x2 = 6;     //   X
                y3 = 1; x3 = 5;     //  XXX
                y4 = 2; x4 = 5;

                break;

            case 7:
                y1 = 1; x1 = 4;
                y2 = 1; x2 = 6;
                y3 = 1; x3 = 5;
                y4 = 2; x4 = 4;
                break;

            case 8:
                y1 = 1; x1 = 7;
                y2 = 1; x2 = 5;
                y3 = 1; x3 = 6;
                y4 = 2; x4 = 7;
                break;

            case 9:
                y1 = 1; x1 = 5;
                y2 = 1; x2 = 6;
                y3 = 2; x3 = 5;
                y4 = 2; x4 = 6;

                break;

            case 10:
                y1 = 1; x1 = 5;
                y2 = 1; x2 = 6;
                y3 = 2; x3 = 5;
                y4 = 2; x4 = 6;

                break;



        }



            ImageDrawing();

    }



        static void ImageClearing(){

            JButton b;

            if(y3>=1) {
                b = Glass_GamePanel.buttons_list_tetris.get((y3 - 1) * 10 + (x3 - 1));
            b.setBackground(Color.WHITE);}
            if(y4>=1){
            b = Glass_GamePanel.buttons_list_tetris.get((y4 - 1) * 10 + (x4 - 1));
            b.setBackground(Color.WHITE);}
            if(y1>=1){
            b = Glass_GamePanel.buttons_list_tetris.get((y1 - 1) * 10 + (x1 - 1));
            b.setBackground(Color.WHITE);}
            if(y2>=1){
            b = Glass_GamePanel.buttons_list_tetris.get((y2 - 1) * 10 + (x2 - 1));
            b.setBackground(Color.WHITE);}

        }

    static void ImageDrawing(){

        JButton b;
        if(y1>=1){
        b = Glass_GamePanel.buttons_list_tetris.get((y1-1)*10+(x1-1));
        b.setBackground(Color.RED);}
        if(y2>=1){
        b = Glass_GamePanel.buttons_list_tetris.get((y2-1)*10+(x2-1));
        b.setBackground(Color.RED);}
        if(y3>=1) {
        b = Glass_GamePanel.buttons_list_tetris.get((y3-1)*10+(x3-1));
        b.setBackground(Color.RED);}
        if(y4>=1){
        b = Glass_GamePanel.buttons_list_tetris.get((y4-1)*10+(x4-1));
        b.setBackground(Color.RED);}



        }


}
