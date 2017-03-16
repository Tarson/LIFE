import com.sun.javafx.collections.SetListenerHelper;
import com.sun.xml.internal.ws.transport.http.server.ServerAdapterList;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
/**
 * Created by m on 27.02.2017.
 */
public class Glass {
    static boolean end_0f_game = false;
    static  int delay;
    JButton b;
Glass(){


    Tetramino tetramino = new Tetramino();


    toBegin(tetramino);
}








    void toBegin(Tetramino tetramino){

        class StakanThread extends  Thread {
            boolean element_stopped = false;


            public void run() {
                Glass_GamePanel.nnew.setEnabled(false);
                int small_delay = 2;
                int [] tetramint_coord  = new int [8];
                 boolean intersection = false;

                   while (!end_0f_game){//big cycle to check end of game

                       delay = 500;

                while (!element_stopped) { //small cycle to check fall of one tetramino
                    try {

                        Thread.sleep(delay);
                        //System.out.println("соседи пидары");



                      //  System.out.println(Glass_GamePanel.direction);
                        Tetramino.ImageClearing();

                        if(delay==300){small_delay++;}
                        if (small_delay>2)
                        {   Tetramino.y1 = Tetramino.y1 + 1;
                            Tetramino.y2 = Tetramino.y2 + 1;
                            Tetramino.y3 = Tetramino.y3 + 1;
                            Tetramino.y4 = Tetramino.y4 + 1;
                            small_delay=0;
                        }
                        if (delay==500| delay==80){
                            Tetramino.y1 = Tetramino.y1 + 1;
                            Tetramino.y2 = Tetramino.y2 + 1;
                            Tetramino.y3 = Tetramino.y3 + 1;
                            Tetramino.y4 = Tetramino.y4 + 1;
                        }


                        Tetramino.ImageDrawing();













                        switch (Glass_GamePanel.direction) {


                            case 38:// rotate

                             //   System.out.println("соседи пидары");
                                Tetramino.ImageClearing();



                                tetramint_coord [0] = Tetramino.y1;
                                tetramint_coord [1] = Tetramino.x1;
                                tetramint_coord [2] = Tetramino.y2;
                                tetramint_coord [3] = Tetramino.x2;
                                tetramint_coord [4] = Tetramino.y4;
                                tetramint_coord [5] = Tetramino.x4;
                                tetramint_coord [6] = Tetramino.y3;
                                tetramint_coord [7] = Tetramino.x3;




                                int Y_central = Tetramino.y3;
                                int X_central = Tetramino.x3;


                                for(int i = 0; i <6 ; i++){




                                     int Y_current = tetramint_coord[i];
                                     i++;
                                      int X_current = tetramint_coord[i];

                                      int Y_temp = Y_current-Y_central;
                                       int X_temp = X_current-X_central  ;

                                     int Ynext=0;
                                     int Xnext=0;


                                       int sWitch = Math.abs(Y_temp)+Math.abs(X_temp);
                                       if ((Math.abs(Y_temp)|Math.abs(X_temp))==2){sWitch=1;}

                                  //  System.out.println(sWitch);

                                      switch (sWitch)
                                     {

                                           case  1:

                                              if (Y_temp == 0) {Xnext = 0; Ynext = -X_temp;} else {Xnext = Y_temp; Ynext = 0;}

                                               tetramint_coord[i-1]= Ynext + Y_central;
                                               tetramint_coord[i] = Xnext + X_central;




                                               break;

                                          case 2 :


                                              if (Y_temp == -1 & X_temp == 1) {Ynext = -1 ; Xnext = -1;}
                                              if (Y_temp == -1 & X_temp == -1) {Ynext = 1 ; Xnext = -1;}
                                              if (Y_temp == 1 & X_temp == -1) {Ynext = 1 ; Xnext = 1;}
                                              if (Y_temp == 1 & X_temp == 1) {Ynext = -1 ; Xnext = 1;}



                                              tetramint_coord[i-1]= Ynext + Y_central;
                                              tetramint_coord[i] = Xnext + X_central;


                                        }


                                 }


                                intersection = Tetramino_segments.toCheck_intersection(tetramint_coord);

                                if (!intersection) {

                                    Tetramino.y1=tetramint_coord [0];
                                    Tetramino.x1=tetramint_coord [1];
                                    Tetramino.y2=tetramint_coord [2];
                                    Tetramino.x2=tetramint_coord [3];
                                    Tetramino.y4=tetramint_coord [4];
                                    Tetramino.x4=tetramint_coord [5];
                                    Tetramino.y3=tetramint_coord [6];
                                    Tetramino.x3=tetramint_coord [7];

                                }




                                Tetramino.ImageDrawing();
                             //   delay = 500;

                                break;
                            case 37:// to the left



                                Tetramino.ImageClearing();

                                tetramint_coord [0] = Tetramino.y1;
                                tetramint_coord [1] = Tetramino.x1-1;
                                tetramint_coord [2] = Tetramino.y2;
                                tetramint_coord [3] = Tetramino.x2-1;
                                tetramint_coord [4] = Tetramino.y4;
                                tetramint_coord [5] = Tetramino.x4-1;
                                tetramint_coord [6] = Tetramino.y3;
                                tetramint_coord [7] = Tetramino.x3-1;


                                intersection = Tetramino_segments.toCheck_intersection(tetramint_coord);

                                if (!intersection) {

                                   Tetramino.x1 =  tetramint_coord [1];
                                   Tetramino.x2 =  tetramint_coord [3];
                                   Tetramino.x4 =  tetramint_coord [5];
                                   Tetramino.x3 =  tetramint_coord [7];
                                }

                                Tetramino.ImageDrawing();


                            //    delay = 500;
                                break;
                            case 39:// to the right

                                Tetramino.ImageClearing();

                                tetramint_coord [0] = Tetramino.y1;
                                tetramint_coord [1] = Tetramino.x1+1;
                                tetramint_coord [2] = Tetramino.y2;
                                tetramint_coord [3] = Tetramino.x2+1;
                                tetramint_coord [4] = Tetramino.y4;
                                tetramint_coord [5] = Tetramino.x4+1;
                                tetramint_coord [6] = Tetramino.y3;
                                tetramint_coord [7] = Tetramino.x3+1;


                                intersection = Tetramino_segments.toCheck_intersection(tetramint_coord);

                                if (!intersection) {

                                    Tetramino.x1 =  tetramint_coord [1];
                                    Tetramino.x2 =  tetramint_coord [3];
                                    Tetramino.x4 =  tetramint_coord [5];
                                    Tetramino.x3 =  tetramint_coord [7];
                                }









                        }


                        Glass_GamePanel.direction = 0;










                        Tetramino.ImageDrawing();







                        for (Tetramino_segments segment : Tetramino_segments.tetramino_segments
                                ) {

                            if ((Tetramino.y1 + 1 == segment.y & Tetramino.x1 == segment.x) | (Tetramino.y2 + 1 == segment.y & Tetramino.x2 == segment.x) | (Tetramino.y3 + 1 == segment.y & Tetramino.x3 == segment.x) | (Tetramino.y4 + 1 == segment.y & Tetramino.x4 == segment.x)) {


                                element_stopped = true;

                            }


                        }


                        if (Tetramino.y1 == 20 | Tetramino.y2 == 20 | Tetramino.y3 == 20 | Tetramino.y4 == 20) {


                            element_stopped = true;


                        }


                        if (element_stopped == true) {


                            Tetramino_segments segment1 = new Tetramino_segments(Tetramino.y1, Tetramino.x1,Tetramino.c);
                            Tetramino_segments.tetramino_segments.add(segment1);
                            Tetramino_segments segment2 = new Tetramino_segments(Tetramino.y2, Tetramino.x2,Tetramino.c);
                            Tetramino_segments.tetramino_segments.add(segment2);
                            Tetramino_segments segment3 = new Tetramino_segments(Tetramino.y3, Tetramino.x3,Tetramino.c);
                            Tetramino_segments.tetramino_segments.add(segment3);
                            Tetramino_segments segment4 = new Tetramino_segments(Tetramino.y4, Tetramino.x4,Tetramino.c);
                            Tetramino_segments.tetramino_segments.add(segment4);

                            if((Tetramino.y1 | Tetramino.y2 | Tetramino.y3 | Tetramino.y4)==3){end_0f_game=true;}

                            Tetramino_segments.checking_deletion_row();

                        }












                    } catch (InterruptedException e) {

                    }


                }




                element_stopped=false;
                       Tetramino tetramino = new Tetramino();


            }

                Glass_GamePanel.nnew.setEnabled(true);



                   try(ObjectInputStream objIS = new ObjectInputStream(new FileInputStream("d://tetris.txt"))){
                       Player player = (Player)objIS.readObject();

                       if(player.score < Tetramino_segments.score){

                           Panel_save panel_save = new Panel_save(player);


                       }
                   }
                  catch (Exception e){

                       System.out.println("хуюшки с открытием тетриса");
                       System.out.println(e.toString());
                       Player player = new Player("", 0);

                       try(ObjectOutputStream objOS = new ObjectOutputStream((new FileOutputStream("d://tetris.txt")))){

                           objOS.writeObject(player);

                       }

                       catch(IOException er){

                           System.out.println("хуюшки с cериализацией");

                       }


                  }



            // end of game

        }
        }


        StakanThread  stakan = new StakanThread();

        stakan.start();



    };
}
