package Main;

public class Player {

    GameManager gm;

    public int itemselected;

    //item in inventory
    public int hasWD; //white daruma
    public int hasSK; //silver key
    public int hasET; //electricle tape
    public int hasMP; //mystery paper
    public int hasWC; //white candle
    public int hasGL; //grey lighter

    public int placepaper; //paper place or not
    public int candlelight; // candle light or not

    public int knowpass1; // know com password or not
    public int knowpass2; // know safe password or not

    public int wrongpass; // count wrong pass

    public int usebox; //check if use
    public int usedrawer; //check if use
    
    public Player(GameManager gm){
        this.gm = gm;
    }

    public void setPlayerDefaultStatus(){
        // 0 = dont have 1 = have
        //item selected
        itemselected=0;
        //itembar
        hasWD = 0;
        hasSK = 0;
        hasET = 0;
        hasMP = 0;
        hasWC = 0;
        hasGL = 0;

        placepaper = 0;
        candlelight = 0;

        knowpass1 = 0;
        knowpass2 = 0;

        wrongpass = 0;

        usebox = 0;
        usedrawer = 0;

        //time
        gm.ui.countdownValue = 300;

        gm.ui.bgPanel[1].getComponent(0).setVisible(false);
        gm.ui.bgPanel[2].getComponent(0).setVisible(true);//daruma
        gm.ui.bgPanel[2].getComponent(1).setVisible(true);//box close
        gm.ui.bgPanel[3].getComponent(1).setVisible(false);//wire
        gm.ui.bgPanel[3].getComponent(2).setVisible(false);//code screen
        gm.ui.bgPanel[3].getComponent(3).setVisible(false);//lock screen
        gm.ui.bgPanel[4].getComponent(0).setVisible(false);//silver key
        gm.ui.bgPanel[4].getComponent(1).setVisible(false);//doll
        gm.ui.bgPanel[4].getComponent(2).setVisible(false);//fire
        gm.ui.bgPanel[4].getComponent(3).setVisible(false);//candle
        gm.ui.bgPanel[4].getComponent(4).setVisible(false);//code
        gm.ui.bgPanel[4].getComponent(5).setVisible(false);//paper
        gm.ui.bgPanel[4].getComponent(6).setVisible(false);//code hanging paper

        updatePlayerStatus();
    }

    public void updatePlayerStatus(){

        if(hasWD==0 && hasSK==0 && hasET==0 && hasMP==0 && hasWC==0 && hasGL ==0){
            gm.ui.Highlight.setVisible(false);
            gm.ui.itemnameLabel.setVisible(false);
        }

        //check wd
        if(hasWD==0){
            gm.ui.WhiteDarumaInv.setVisible(false);
            
        }
        if(hasWD==1){
            gm.ui.WhiteDarumaInv.setVisible(true);
        }

        //check sk
        if(hasSK==0){
            gm.ui.SilverKeyInv.setVisible(false);
        }
        if(hasSK==1){
            gm.ui.SilverKeyInv.setVisible(true);
        }

        //check et
        if(hasET==0){
            gm.ui.ElectricalTapeInv.setVisible(false);

        }
        if(hasET==1){
            gm.ui.ElectricalTapeInv.setVisible(true);
        }

        //check mp
        if(hasMP==0){
            gm.ui.MysteryPaperInv.setVisible(false);
        }
        if(hasMP==1){
            gm.ui.MysteryPaperInv.setVisible(true);
        }

        //check wc
        if(hasWC==0){
            gm.ui.WhiteCandleInv.setVisible(false);
        }
        if(hasWC==1){
            gm.ui.WhiteCandleInv.setVisible(true);
        }

        //check gl
        if(hasGL==0){
            gm.ui.GreyLighterInv.setVisible(false);
        }
        if(hasGL==1){
            gm.ui.GreyLighterInv.setVisible(true);
        }
    }
}
