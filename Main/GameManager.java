package Main;

import java.net.URL;

public class GameManager {
    
    ActionHandler aHandler = new ActionHandler(this);
    public UI ui = new UI(this, aHandler);
    public Player player = new Player(this);
    public SceneChanger sChanger =  new SceneChanger(this);

    public Event01 ev1 = new Event01(this);

    public URL menubgm = getClass().getClassLoader().getResource("Resources/Sound/MenuBGM.wav");
    public static void main(String[] args){

        new GameManager();

    }
    public GameManager(){


    }

}
