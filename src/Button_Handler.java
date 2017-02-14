import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import  java.util.*;

//import javax.swing.Timer;
/**
 * Created by m on 03.02.2017.
 */
public class Button_Handler implements ActionListener {

    String bUtton_text;
    JButton b;
    int i;
    int k;
    static int speed_ofScrolling=1;
    static  String textScrolling = "     1";
    static boolean slide_mode = false;


    // buttons handler constructor for game field
    Button_Handler(JButton b,int i , int k){

       this.b=b;// pressed button
       this.i=i;//  X coordinate
       this.k=k;//  Y coordinate

    }

    // buttons handler constructor for control buttons
    Button_Handler(JButton b){

      this.b = b;

    }





    @Override
    public void actionPerformed(ActionEvent actionEvent) {


        // processing of CONTROL BUTTONS

        if (b.getText().equals("START")){



            if(Lcage.lcage_list.isEmpty()==true){
                return;
            }


            for (JButton b:GamePanel.buttons_list){

                b.setEnabled(false);}


                GamePanel.sPeed_Down.setEnabled(false);

                GamePanel.sTop.setEnabled(false);

                GamePanel.sPeed_Up.setEnabled(false);

                GamePanel.sLide_Mode.setEnabled(true);

                GamePanel.sTep_Forvard.setEnabled(true);

             return;
        }

        if (b.getText().equals("NEW")){



            if(Lcage.lcage_list.isEmpty()!=true){ // clearance of list of cells

            Lcage.lcage_list.clear();}

                for (JButton b:GamePanel.buttons_list){

                    b.setBackground(Color.white);

                    b.setEnabled(true);
                }

                 GamePanel.sTart.setEnabled(true);

                 GamePanel.sPeed_Down.setEnabled(false);

                 GamePanel.sTop.setEnabled(false);

                 GamePanel.sPeed_Up.setEnabled(false);

                 GamePanel.sLide_Mode.setEnabled(false);

                 GamePanel.sTep_Forvard.setEnabled(false);

                 return;
        }

        if (b.getText().equals("SLIDE MODE")){



            GamePanel.sTart.setEnabled(false);

            GamePanel.sPeed_Down.setEnabled(true);

            GamePanel.sTop.setEnabled(true);

            GamePanel.sPeed_Up.setEnabled(true);

            GamePanel.sTep_Forvard.setEnabled(false);

            GamePanel.nEw.setEnabled(false);

            GamePanel.sLide_Mode.setEnabled(false);

            slide_mode = true;

            class SLideThread extends Thread {
                        public void run() {

                            while (slide_mode)
                            {Lcage.tO_step();

                            try {Thread.sleep(1000/speed_ofScrolling);}
                            catch (InterruptedException e)
                            {}

                            }
                        }
                    }


            Thread slide = new SLideThread();
            slide.start();

            return;
      //  }
    }


        if (b.getText().equals("STEP")){

            slide_mode = false;
         //   Lcage.pRint_set_of_objects();

            GamePanel.sTart.setEnabled(false);
            GamePanel.sLide_Mode.setEnabled(true);

            Lcage.tO_step(); // making one step of life

            return;
        }



        if (b.getText().equals("SPEED >")){

            speed_ofScrolling++;
            if(speed_ofScrolling>20){
                speed_ofScrolling=20;
            }
            String s = "   ";
            textScrolling = s+String.valueOf(speed_ofScrolling);
            GamePanel.Speed.setText(textScrolling);

            return;
        }

        if (b.getText().equals("SPEED <")){

            speed_ofScrolling--;
            if(speed_ofScrolling<1){
                speed_ofScrolling=1;
            }
            String s = "   ";
            textScrolling = s+String.valueOf(speed_ofScrolling);
            GamePanel.Speed.setText(textScrolling);

            return;
        }

        if (b.getText().equals("STOP")){

          slide_mode = false;
            GamePanel.sTep_Forvard.setEnabled(true);
            GamePanel.nEw.setEnabled(true);

            return;
        }



        // processing of GAME PANEL BUTTONS



       if(b.getBackground().equals(Color.BLUE)) {

           b.setBackground(Color.WHITE);

           Lcage.dElete_Cell(i,k);// deleting object Lcage
           return;
            }

             b.setBackground(Color.BLUE);

             Lcage lcage = new Lcage(b,i,k);

            lcage.aDd_cell(lcage);

            return;


    }
}
