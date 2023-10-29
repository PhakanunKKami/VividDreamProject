package Main;

public class SceneChanger {

    GameManager gm;

    public SceneChanger(GameManager gm){

        this.gm = gm;
    }

    public void showScene1(){
        System.out.println("Room1-1");
        gm.ui.bgPanel[1].setVisible(true);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
    }

    public void showScene2(){
        System.out.println("Room1-2");
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(true);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
    }

    public void showScene3(){
        System.out.println("Room1-3");
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(true);
        gm.ui.bgPanel[4].setVisible(false);
    }

    public void showScene4(){
        System.out.println("Room1-4");
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(true);
    }
}
