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
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
    }

    public void showScene2(){
        System.out.println("Room1-2");
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(true);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
    }

    public void showScene3(){
        System.out.println("Room1-3");
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(true);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
    }

    public void showScene4(){
        System.out.println("Room1-4");
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(true);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
    }

    public void showScene5(){
        System.out.println("Room break");
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(true);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
    }

    public void showScene6(){
        System.out.println("Room 2-1");
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(true);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
    }

    public void showScene7(){
        System.out.println("Room 2-2");
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(true);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
    }

    public void showScene8(){
        System.out.println("Room 2-3");
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(true);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
    }

    public void showScene9(){
        System.out.println("Room 2-4");
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(true);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
    }

    public void showScene10(){
        System.out.println("Room extra");
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(true);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
    }

    public void showSceneStart(){
        System.out.println("Start");
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(true);
        gm.ui.bgPanel[12].setVisible(false);
    }

    public void showSceneEnd(){
        System.out.println("End");
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(true);
    }
}
