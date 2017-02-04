import javax.swing.*;

/**
 * Created by m on 04.02.2017.
 */
public class Lcage {


    JButton b;
    int x;
    int y;
    boolean aLive;

    // creation of CELL with association with button and coordinates x and y
    Lcage(JButton b, int x, int y){
        this.b=b;
        this.x=x;
        this.y=y;
        aLive=true;

        System.out.println(b.getText()+" "+x+" "+y);

  }

  // method to put CELL object to list array

}
