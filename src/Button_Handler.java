import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            return;
        }

        if (b.getText().equals("NEW")){
            System.out.println(b.getText());
            return;
        }

        if (b.getText().equals("SLIDE MODE")){
            System.out.println(b.getText());
            return;
        }

        if (b.getText().equals("STEP >")){
            System.out.println(b.getText());
            return;
        }

        if (b.getText().equals("STEP <")){
            System.out.println(b.getText());
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
           return;
       }

       b.setBackground(Color.RED);

       Lcage lcage = new Lcage(b,i,k);



      //

    }
}
