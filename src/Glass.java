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

        class StakanThread extends  Thread {
            boolean element_stopped = false;


            public void run() {


                   while (true){//big cycle to check end of game


                while (!element_stopped) { //small cycle to check fall of one tetramino
                    try {
                        Thread.sleep(300);
                        //System.out.println("соседи пидары");

                        Tetramino.ImageClearing();



                        Tetramino.y1 = Tetramino.y1 + 1;
                        Tetramino.y2 = Tetramino.y2 + 1;
                        Tetramino.y3 = Tetramino.y3 + 1;
                        Tetramino.y4 = Tetramino.y4 + 1;


                       Tetramino.ImageDrawing();

                        System.out.println(Glass_GamePanel.direction);


                        switch (Glass_GamePanel.direction) {


                            case 38:// rotate


                                Tetramino.ImageClearing();

                                int [] tetramint_coord  = new int [6];

                                tetramint_coord [0] = Tetramino.y1;
                                tetramint_coord [1] = Tetramino.x1;
                                tetramint_coord [2] = Tetramino.y2;
                                tetramint_coord [3] = Tetramino.x2;
                                tetramint_coord [4] = Tetramino.y4;
                                tetramint_coord [5] = Tetramino.x4;




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
                                       if ((Math.abs(Y_temp)|Math.abs(X_temp))==2){sWitch=3;}

                                    System.out.println(sWitch);

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
                                           break;

                                         case 3 :

                                             if (Y_temp == 0) {Xnext = 0; Ynext = -X_temp;} else {Xnext = Y_temp; Ynext = 0;}

                                             tetramint_coord[i-1]= Ynext + Y_central;
                                             tetramint_coord[i] = Xnext + X_central;
                                             break;

                                        }


                                 }

                                Tetramino.y1=tetramint_coord [0];
                                Tetramino.x1=tetramint_coord [1];
                                Tetramino.y2=tetramint_coord [2];
                                Tetramino.x2=tetramint_coord [3];
                                Tetramino.y4=tetramint_coord [4];
                                Tetramino.x4=tetramint_coord [5];


                                Tetramino.ImageDrawing();


                                break;
                            case 37:// to the left

                                Tetramino.ImageClearing();

                                Tetramino.x1=Tetramino.x1-1; if(Tetramino.x1<1){Tetramino.x1=1;}
                                else{
                                Tetramino.x2=Tetramino.x2-1; if(Tetramino.x2<1){Tetramino.x2=1;Tetramino.x1++;}
                                else{
                                Tetramino.x3=Tetramino.x3-1; if(Tetramino.x3<1){Tetramino.x3=1;Tetramino.x2++;Tetramino.x1++;}
                                else {
                                Tetramino.x4=Tetramino.x4-1; if(Tetramino.x4<1){Tetramino.x4=1;Tetramino.x3++;Tetramino.x2++;Tetramino.x1++;}}}}

                                Tetramino.ImageDrawing();



                                break;
                            case 39:// to the right

                                Tetramino.ImageClearing();

                                Tetramino.x1=Tetramino.x1+1; if(Tetramino.x1>10){Tetramino.x1=10;}
                                 else{
                                Tetramino.x2=Tetramino.x2+1; if(Tetramino.x2>10){Tetramino.x2=10;Tetramino.x1--;}
                                else{
                                Tetramino.x3=Tetramino.x3+1; if(Tetramino.x3>10){Tetramino.x3=10;Tetramino.x2--;Tetramino.x1--;}
                                else {
                                Tetramino.x4=Tetramino.x4+1; if(Tetramino.x4>10){Tetramino.x4=10;Tetramino.x3--;Tetramino.x2--;Tetramino.x1--;}}}}

                                Tetramino.ImageDrawing();






                                break;
                            case 40:// fall
                                break;


                        }


                        Glass_GamePanel.direction = 0;


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


                    System.out.println(segment.y + "  " + segment.x);

                }


                element_stopped=false;
                       Tetramino tetramino = new Tetramino();


            }

        }
        }


        StakanThread  stakan = new StakanThread();

        stakan.start();



    };
}
