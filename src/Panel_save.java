import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by m on 11.03.2017.
 */
public class Panel_save extends JDialog {

    String name;
    Integer int_new_score;
    JLabel Old_hero;
    JLabel Old_score;
    JTextField New_hero = new JTextField("New_hero ");
    JLabel New_score;
    JButton yes = new JButton("YES");
    JButton no = new JButton("NO");


    Panel_save(String name,Integer int_new_score,Integer int_old_score ){
        super();
        setSize(200,150);

        this.name = name;
        this.int_new_score=int_new_score;

        JPanel first = new JPanel();
        first.setLayout(new FlowLayout());
        Old_hero =  new JLabel(name);
        first.add(Old_hero);
        Old_score = new JLabel(int_old_score.toString());
        first.add(Old_score);


        JPanel second = new JPanel();
        second.setLayout(new FlowLayout());
        New_score = new JLabel(int_new_score.toString());
        second.add(New_hero);
        second.add(New_score);

        add((first), BorderLayout.NORTH);
        add((second),BorderLayout.CENTER);

        JPanel third = new JPanel();
        third.setLayout(new FlowLayout());
        third.add(yes);

        yes.addActionListener(new Save(yes));
        no.addActionListener(new Save(no));
        third.add(no);

        this.add((third),BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
       // GamePanel_Snake.g.setVis(false);
        GamePanel_Snake.g.reqFocus(false);
        requestFocus(true);







    }



        class Save implements ActionListener{
        JButton b;
        Save (JButton b){

                this.b = b;

            }

            public void actionPerformed(ActionEvent actionEvent){


            if (b.getText()== "YES"){


                 String name =  New_hero.getText() +" "+ int_new_score;


                try (PrintWriter out = new PrintWriter(new FileWriter("d://score.txt"))){

                        out.println(name);
                }


                catch(IOException e){

                    System.out.println("хуюшки при записи");

                }






            }
           if (b.getText()== "NO"){



           }





               setVisible(false);
             //  GamePanel_Snake.g.setVis(true);
                requestFocus(false);
                GamePanel_Snake.g.reqFocus(true);


        }



}

}
