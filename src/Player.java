import java.io.Serializable;

/**
 * Created by m on 15.03.2017.
 */
public class Player implements Serializable{

    String game;
    String name;

    int score;


    Player(){};
    Player(String name, int score){


       // this.game=game;
        this.name=name;
        this.score=score;




    }

}
