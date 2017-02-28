import javax.swing.*;
import java.awt.*;

/**
 * Created by m on 27.02.2017.
 */
public class Glass {


    JButton b;
Glass(){


    Tetramino tetramino = new Tetramino();


    toBegin(tetramino);
}








    void toBegin(Tetramino tetramino){

        class StakanThread extends  Thread{


            public  void run() {













                while (true){
                    try {
                        Thread.sleep(300);
                        System.out.println("соседи пидары");


                        b = Glass_GamePanel.buttons_list_tetris.get((Tetramino.y3-1)*10+(Tetramino.x3-1));
                        b.setBackground(Color.WHITE);

                        Tetramino.y3=Tetramino.y3+1;

                        b = Glass_GamePanel.buttons_list_tetris.get((Tetramino.y3-1)*10+(Tetramino.x3-1));
                        b.setBackground(Color.RED);


                        b = Glass_GamePanel.buttons_list_tetris.get((Tetramino.y4-1)*10+(Tetramino.x4-1));
                        b.setBackground(Color.WHITE);

                        Tetramino.y4=Tetramino.y4+1;

                        b = Glass_GamePanel.buttons_list_tetris.get((Tetramino.y4-1)*10+(Tetramino.x4-1));
                        b.setBackground(Color.RED);


                        b = Glass_GamePanel.buttons_list_tetris.get((Tetramino.y1-1)*10+(Tetramino.x1-1));
                        b.setBackground(Color.WHITE);

                        Tetramino.y1=Tetramino.y1+1;

                        b = Glass_GamePanel.buttons_list_tetris.get((Tetramino.y1-1)*10+(Tetramino.x1-1));
                        b.setBackground(Color.RED);



                        b = Glass_GamePanel.buttons_list_tetris.get((Tetramino.y2-1)*10+(Tetramino.x2-1));
                        b.setBackground(Color.WHITE);

                        Tetramino.y2=Tetramino.y2+1;

                        b = Glass_GamePanel.buttons_list_tetris.get((Tetramino.y2-1)*10+(Tetramino.x2-1));
                        b.setBackground(Color.RED);







                    } catch (InterruptedException e) {

                    }
                    ;

                }
            }
        }


        StakanThread  stakan = new StakanThread();

        stakan.start();



    };
}
