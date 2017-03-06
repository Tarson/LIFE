import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by m on 27.02.2017.
 */
public class Tetramino_segments {


    int y;
    int x;

    static ArrayList <Tetramino_segments>  tetramino_segments = new ArrayList<>();
    static  int score = 0;

    Tetramino_segments(int y, int x){

        this.y =y;
        this.x=x;

    }



    static  Boolean toCheck_intersection(int[] coord_array){
        Boolean b;
        int count =0;

        for (int i =0; i< coord_array.length;i++){

            int yy = coord_array[i];
            int xx = coord_array [i+1];
            i++;
            if (xx < 1 | xx > 10 ){count++;}

           for (Tetramino_segments segment:tetramino_segments
                ) {
               if (yy == segment.y & xx == segment.x){count++;}
            }



        }


        System.out.println(count);
        if (count>0){b=true;}else {b=false;}

        return b;}




        static void checking_deletion_row (){


            Set<Integer> rows = new HashSet<Integer>() {
            };
            Set<Integer> rows_for_delete = new HashSet<Integer>() {
            };


            rows.add(Tetramino.y1);
            rows.add(Tetramino.y2);
            rows.add(Tetramino.y3);
            rows.add(Tetramino.y4);



            for (Integer k:rows
                 ) {

                int count = 0;
                for (Tetramino_segments segment: tetramino_segments
                     ) {

                    if(segment.y == k){count++;}

                }

                    if(count==10){rows_for_delete.add(k);}


            }

            for (Integer k:rows_for_delete
                    ) {


                for (int i = 0;i<tetramino_segments.size();i++) {


                    Tetramino_segments segment = tetramino_segments.get(i);

                    if(segment.y == k){tetramino_segments.remove(i); i--;}



                  }

                int row_fall = k-1;
                for (Tetramino_segments segment: tetramino_segments
                        ) {

                    if(segment.y <= row_fall){segment.y=segment.y+1;}

                }



            }

            score = score+rows_for_delete.size();
            Glass_GamePanel.Score.setText(""+score);


                for (JButton b:Glass_GamePanel.buttons_list_tetris ) {

                    b.setBackground(Color.WHITE);

            }

                    JButton b;

                for (Tetramino_segments segment: tetramino_segments
                        ) {


                    b = Glass_GamePanel.buttons_list_tetris.get((segment.y-1)*10+(segment.x-1));
                    b.setBackground(Color.RED);



                }




      }






}
