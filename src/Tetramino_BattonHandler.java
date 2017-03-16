import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by m on 27.02.2017.
 */
public class Tetramino_BattonHandler implements ActionListener {

    JButton b;




    // buttons handler constructor for game field


    // buttons handler constructor for control buttons
    Tetramino_BattonHandler(JButton b){

        this.b = b;

    }






    // action performer for button NEW

    public void actionPerformed(ActionEvent actionEvent) {


            if (b.getText().equals("NEW")) {

                for (JButton b:Glass_GamePanel.buttons_list_tetris ) {

                    b.setBackground(Color.WHITE);

                }

                Tetramino_segments.tetramino_segments.clear();
                Glass.end_0f_game=false;

                Tetramino_segments.score=0;



                Glass stacan = new Glass();

                Glass_GamePanel.g.reqFocus(true);




        }
    }
}