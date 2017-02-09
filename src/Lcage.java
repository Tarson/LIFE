import javax.swing.*;
import java.awt.*;
import  java.util.*;
import java.util.List;

/**
 * Created by m on 04.02.2017.
 */
public class Lcage {


    JButton b;
    int x;
    int y;
    boolean aLive;


    public static List <Lcage> lcage_list = new ArrayList();



    // creation of CELL with association with button and coordinates x and y
    Lcage(JButton b, int x, int y){

        this.b=b;
        this.x=x;
        this.y=y;
        aLive=true;

       // System.out.println(b.getText()+" "+x+" "+y);

  }

    // method to put CELL object to list array
        public void aDd_cell (Lcage cell){

        lcage_list.add(cell);

    }


    // method for deleting doubles
    public static void dElete_Cell (int xx, int yy){

        for(int i = 0;i<(lcage_list.size());i++){

            Lcage cell = lcage_list.get(i);

                if (xx == cell.x & yy == cell.y){

                lcage_list.remove(cell);

                return;
            }

   }

}


    public  static void pRint_set_of_objects (){

        for (Lcage l:lcage_list){

            System.out.println(" "+l.x+" "+l.y+" "+l.aLive);
        }

        }


     // making one step of life

      public static void tO_step(){



          for (Lcage cell:lcage_list){ // checkimg for quantity of neighbors of the cell

              int count =0;
              for(int i =0; i < lcage_list.size();i++){

                Lcage cellcompare= lcage_list.get(i);

                if (Math.abs(cell.x-cellcompare.x)==1 & Math.abs(cell.y-cellcompare.y)<2 | Math.abs(cell.y-cellcompare.y)==1  & Math.abs(cell.x-cellcompare.x)<2){
                    count++;
                }



              }

              if (count<2 | count > 3) {
                  cell.aLive=false;
              }

              Lambience.tO_create_ambience(cell.x, cell.y);//creation 8 ambiance objects for each cell


          }



            Lambience.tO_checking_birth();// checking ambiance for new birth



         for (int i = 0; i < lcage_list.size();i++){ // deleting of dead cell

              Lcage cell = lcage_list.get(i);
              if (cell.aLive==false) {

                  lcage_list.remove(cell);

                  cell.b.setBackground(Color.WHITE);

                  i--;

              }
              }

          }




        }






