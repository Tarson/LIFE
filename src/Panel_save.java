import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by m on 11.03.2017.
 */
public class Panel_save extends JDialog {

    Player player;
    String name;
    Integer int_new_score;
    JLabel Old_hero;
    JLabel Old_score;
    JTextField New_hero = new JTextField("New_hero ");
    JLabel New_score;
    JButton yes = new JButton("YES");
    JButton no = new JButton("NO");


    Panel_save(String name,Integer int_new_score,Integer int_old_score ) {
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

        GamePanel_Snake.g.reqFocus(false);
        requestFocus(true);


  }


    Panel_save(Player player ) {
        super();
        setSize(200,150);


        this.player = player;
        JPanel first = new JPanel();
        first.setLayout(new FlowLayout());
        Old_hero =  new JLabel(player.name);
        first.add(Old_hero);



        String s ="";
        s= s+ player.score;;
        Old_score = new JLabel(s);
        first.add(Old_score);


        JPanel second = new JPanel();
        second.setLayout(new FlowLayout());

        String ss ="";
        ss= ss+Tetramino_segments.score;
        New_score = new JLabel(ss);
        second.add(New_hero);
        second.add(New_score);

        add((first), BorderLayout.NORTH);
        add((second),BorderLayout.CENTER);

        JPanel third = new JPanel();
        third.setLayout(new FlowLayout());
        third.add(yes);

        yes.addActionListener(new SaveObj(yes));
        no.addActionListener(new SaveObj(no));
        third.add(no);

        this.add((third),BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);

       Glass_GamePanel.g.reqFocus(false);
        requestFocus(true);


    }










        class Save implements ActionListener {
            JButton b;

            Save(JButton b) {

                this.b = b;

            }

            public void actionPerformed(ActionEvent actionEvent) {


                if (b.getText() == "YES") {

                    name =  New_hero.getText() +" "+ int_new_score;


                    try (PrintWriter out = new PrintWriter(new FileWriter("d://score.txt"))) {

                        out.println(name);
                    } catch (IOException e) {

                        System.out.println("хуюшки при записи");

                    }


                }
                if (b.getText() == "NO") {


                }


                setVisible(false);

                requestFocus(false);
                GamePanel_Snake.g.reqFocus(true);


            }


        }

            class SaveObj implements ActionListener{
                JButton b;
                SaveObj (JButton b){

                    this.b = b;

                }

                public void actionPerformed(ActionEvent actionEvent){


                    if (b.getText()== "YES"){

                        Player player = new Player(New_hero.getText(),Tetramino_segments.score);



                        try(ObjectOutputStream objOS = new ObjectOutputStream((new FileOutputStream("d://tetris.txt")))){

                            objOS.writeObject(player);

                        }

                        catch(IOException er){

                            System.out.println("хуюшки с cериализацией");

                        }






                    }
                    if (b.getText()== "NO"){



                    }





                    setVisible(false);

                    requestFocus(false);
                  //  GamePanel_Snake.g.reqFocus(true);


                }

}

}
