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
            boolean element_stopped = false;

            public  void run() {






                while (!element_stopped){
                    try {
                        Thread.sleep(300);
                        //System.out.println("соседи пидары");


                        b = Glass_GamePanel.buttons_list_tetris.get((Tetramino.y3-1)*10+(Tetramino.x3-1));
                        b.setBackground(Color.WHITE);
                        b = Glass_GamePanel.buttons_list_tetris.get((Tetramino.y4-1)*10+(Tetramino.x4-1));
                        b.setBackground(Color.WHITE);
                        b = Glass_GamePanel.buttons_list_tetris.get((Tetramino.y1-1)*10+(Tetramino.x1-1));
                        b.setBackground(Color.WHITE);
                        b = Glass_GamePanel.buttons_list_tetris.get((Tetramino.y2-1)*10+(Tetramino.x2-1));
                        b.setBackground(Color.WHITE);


                        Tetramino.y1=Tetramino.y1+1;

                        b = Glass_GamePanel.buttons_list_tetris.get((Tetramino.y1-1)*10+(Tetramino.x1-1));
                        b.setBackground(Color.RED);

                        Tetramino.y2=Tetramino.y2+1;

                        b = Glass_GamePanel.buttons_list_tetris.get((Tetramino.y2-1)*10+(Tetramino.x2-1));
                        b.setBackground(Color.RED);

                        Tetramino.y3=Tetramino.y3+1;

                        b = Glass_GamePanel.buttons_list_tetris.get((Tetramino.y3-1)*10+(Tetramino.x3-1));
                        b.setBackground(Color.RED);

                        Tetramino.y4=Tetramino.y4+1;

                        b = Glass_GamePanel.buttons_list_tetris.get((Tetramino.y4-1)*10+(Tetramino.x4-1));
                        b.setBackground(Color.RED);

                        System.out.println(Glass_GamePanel.direction);



                        switch (Glass_GamePanel.direction){


                            case 38:// rotate
                                break;
                            case 37:// to the left




                                break;
                            case 39:// to the right





                                break;
                            case 40:// fall
                                break;



                        }



                        Glass_GamePanel.direction=0;











                        for (Tetramino_segments segment : Tetramino_segments.tetramino_segments
                                    ) {

                                if ((Tetramino.y1 + 1 == segment.y & Tetramino.x1 == segment.x )| (Tetramino.y2 + 1 == segment.y & Tetramino.x2 == segment.x) | (Tetramino.y3 + 1 == segment.y & Tetramino.x3 == segment.x )| (Tetramino.y4 + 1 == segment.y & Tetramino.x4 == segment.x)) {


                                    element_stopped = true;


                                }


                            }


                        if(Tetramino.y1 == 20 | Tetramino.y2 == 20 | Tetramino.y3 ==20 | Tetramino.y4 == 20){


                            element_stopped = true;

                        }


                        if(element_stopped==true){


                            Tetramino_segments segment1 = new Tetramino_segments(Tetramino.y1, Tetramino.x1);
                            Tetramino_segments.tetramino_segments.add(segment1);
                            Tetramino_segments segment2 = new Tetramino_segments(Tetramino.y2, Tetramino.x2);
                            Tetramino_segments.tetramino_segments.add(segment2);
                            Tetramino_segments segment3 = new Tetramino_segments(Tetramino.y3, Tetramino.x3);
                            Tetramino_segments.tetramino_segments.add(segment3);
                            Tetramino_segments segment4 = new Tetramino_segments(Tetramino.y4, Tetramino.x4);
                            Tetramino_segments.tetramino_segments.add(segment4);



                        }









                    } catch (InterruptedException e) {

                    }


                }

                for (Tetramino_segments segment : Tetramino_segments.tetramino_segments
                        ) {


                    System.out.println(segment.y+"  " + segment.x);

                }


            }
        }


        StakanThread  stakan = new StakanThread();

        stakan.start();



    };
}
