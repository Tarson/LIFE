import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import static java.awt.Color.BLUE;
import static java.awt.Color.RED;

/**
 * Created by m on 07.02.2017.
 */
public class Lambience {






    int x;
    int y;
    int number_of_birth;  // 3 = birth
    static ArrayList <Lambience> lambiance = new ArrayList<>();
    public static Color [] col = new Color [] { RED,BLUE,Color.green,Color.YELLOW, Color.BLACK, Color.MAGENTA, Color.ORANGE,Color.CYAN   };

    Lambience(int x,int y, int number_of_birth){
        this.x = x;
        this.y = y;
       this.number_of_birth = 0;






    }


    public  static void tO_create_ambience(int x, int y){

        tO_delete_doubles_ambiance((x-1),(y+1));

        tO_delete_doubles_ambiance(x,(y+1));

        tO_delete_doubles_ambiance((x+1),(y+1));

        tO_delete_doubles_ambiance((x-1),y);

        tO_delete_doubles_ambiance((x+1),y);

        tO_delete_doubles_ambiance((x-1),(y-1));

        tO_delete_doubles_ambiance(x,(y-1));

        tO_delete_doubles_ambiance((x+1),(y-1));




    }


    public static   void  tO_delete_doubles_ambiance(int xx, int yy){




        for (Lambience lamb:lambiance)
        {
            if(xx == lamb.x & yy == lamb.y){

                return;
            }

        }

        for (Lcage cell :Lcage.lcage_list) {

         if (xx == cell.x & yy ==cell.y)
                {
                   return;
                }


            }


     Lambience lamb = new Lambience(xx, yy, 0);

        lambiance.add(lamb);

        return;

    }



    public static   void tO_checking_birth(){

        for (Lambience lamb:lambiance
             ) {

            for(int i =0; i < Lcage.lcage_list.size();i++) {


                Lcage cell = Lcage.lcage_list.get(i);

                if (Math.abs(cell.x-lamb.x)==1 & Math.abs(cell.y-lamb.y)<2 | Math.abs(cell.y-lamb.y)==1  & Math.abs(cell.x-lamb.x)<2)
                {
                    lamb.number_of_birth++;
                }


            }

        }

            Random random = new Random();
        for (Lambience lamb:lambiance) {

            if(lamb.number_of_birth==3 & lamb.x <150 & lamb.x >-50 & lamb.y <150 & lamb.y >-50)
            {


               if(lamb.x <101 & lamb.x > 0  & lamb.y <101 & lamb.y >0 )
               {  int number_of_button = (lamb.x-1)*100+(lamb.y-1);

                JButton b = GamePanel.buttons_list.get(number_of_button);


                b.setBackground(col[random.nextInt(8)]);


                Lcage cell = new Lcage(b,lamb.x,lamb.y);

                Lcage.lcage_list.add(cell);

               continue;

               }
            else
               { Lcage.lcage_list.add(new Lcage(lamb.x, lamb.y));}

            }


        }


        lambiance.clear();



    }



}







