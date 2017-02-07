import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.util.*;

/**
 * Created by m on 03.02.2017.
 */
public class Button_Handler implements ActionListener {

    String bUtton_text;
    JButton b;
    int i;
    int k;



    Button_Handler(JButton b,int i , int k){
       this.b=b;// pressed button
       this.i=i;//  X coordinate
       this.k=k;//  Y coordinate

    }

    Button_Handler(JButton b){
      this.b = b;

    }






    @Override
    public void actionPerformed(ActionEvent actionEvent) {


        // processing of COMMAND BUTTONS

        if (b.getText().equals("START")){
            System.out.println(b.getText());


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
            System.out.println(b.getText());

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

            System.out.println(b.getText());

            return;
        }

        if (b.getText().equals("STEP")){

            Lcage.pRint_set_of_objects();
            System.out.println(b.getText());

            Lcage.tO_step(); // making one step of life



            return;
        }



        if (b.getText().equals("SPEED >")){

            System.out.println(b.getText());

            return;
        }

        if (b.getText().equals("SPEED <")){

            System.out.println(b.getText());

            return;
        }

        if (b.getText().equals("STOP")){

            System.out.println(b.getText());

            return;
        }



        // processing of GAME PANEL BUTTONS



       if(b.getBackground().equals(Color.RED)) {
           b.setBackground(Color.WHITE);

           Lcage.dElete_Cell(i,k);// deleting object Lcage
           return;
            }

             b.setBackground(Color.RED);

             Lcage lcage = new Lcage(b,i,k);

            lcage.aDd_cell(lcage);

            return;


    }
}
