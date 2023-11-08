package Main;

public class Player {

    GameManager gm;

    public int itemselected;

    //item in inventory 1
    public int hasWD; //white daruma
    public int hasSK; //silver key
    public int hasET; //electricle tape
    public int hasMP; //mystery paper
    public int hasWC; //white candle
    public int hasGL; //grey lighter

    //item in inventory 2
    public int hasRD; //red daruma
    public int hasBD; //blue daruma
    public int hasSC; //scissors
    public int hasCB; //crowbar
    public int hasMN; //missing note
    public int hasCD; //CD

    //others
    public int placepaper; //paper place or not
    public int candlelight; // candle light or not

    public int knowpass; // know password or not
    public int knowcode; // know code or not (for lucky player)

    public int wrongpass; // count wrong pass
    public int codeinput; // count code input

    public int usebox; //check if use
    public int usedrawer; //check if use

    public int room1pass; //check if pass room 1
    public int room2pass; //check if pass room 2

    public int count1; //for additional dialogue

    public int atroom; //check what room player at

    public int playtime=0; //check if play first time or not
    
    
    public Player(GameManager gm){
        this.gm = gm;
    }

    public void setPlayerDefaultStatus(){
        // 0 = dont have 1 = have

        atroom=1;
        //item selected
        itemselected=0;
        //itembar 1
        hasWD = 0;
        hasSK = 0;
        hasET = 0;
        hasMP = 0;
        hasWC = 0;
        hasGL = 0;
        //itembar 2
        hasRD = 0;
        hasBD = 0;
        hasSC = 0;
        hasCB = 0;
        hasMN = 0;
        hasCD = 0; 

        //other
        placepaper = 0;
        candlelight = 0;

        knowpass = 0;
        knowcode = 0;

        wrongpass = 0;
        codeinput = 0;

        usebox = 0;
        usedrawer = 0;

        room1pass = 0;
        count1 = 0;
        

        room2pass = 0;

        //time
        gm.ui.countdownValue = 300;

        gm.ui.bgPanel[1].getComponent(0).setVisible(false);//opened door1
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

        gm.ui.bgPanel[5].getComponent(0).setVisible(false);//ready button

        gm.ui.bgPanel[6].getComponent(0).setVisible(false);//opened door2
        gm.ui.bgPanel[7].getComponent(0).setVisible(false);//crowbar
        gm.ui.bgPanel[7].getComponent(1).setVisible(false);//doll3
        gm.ui.bgPanel[8].getComponent(0).setVisible(false);//fixed notebook
        gm.ui.bgPanel[9].getComponent(0).setVisible(false);//scissors
        gm.ui.bgPanel[9].getComponent(1).setVisible(false);//doll2
        gm.ui.bgPanel[9].getComponent(2).setVisible(false);//record player with cd

        updatePlayerStatus();
    }

    public void updatePlayerStatus(){

        if(itemselected==0){
            gm.ui.Highlight.setVisible(false);
            gm.ui.itemnameLabel.setVisible(false);
        }

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

        //check rd
        if(hasRD==0){
            gm.ui.RedDarumaInv.setVisible(false);
        }
        if(hasRD==1){
            gm.ui.RedDarumaInv.setVisible(true);
        }

        //check bd
        if(hasBD==0){
            gm.ui.BlueDarumaInv.setVisible(false);
        }
        if(hasBD==1){
            gm.ui.BlueDarumaInv.setVisible(true);
        }

        //check sc
        if(hasSC==0){
            gm.ui.ScissorsInv.setVisible(false);
        }
        if(hasSC==1){
            gm.ui.ScissorsInv.setVisible(true);
        }

        //check cb
        if(hasCB==0){
            gm.ui.CrowBarInv.setVisible(false);
        }
        if(hasCB==1){
            gm.ui.CrowBarInv.setVisible(true);
        }

        //check mn
        if(hasMN==0){
            gm.ui.MissingNoteInv.setVisible(false);
        }
        if(hasMN==1){
            gm.ui.MissingNoteInv.setVisible(true);
        }

        //check cd
        if(hasCD==0){
            gm.ui.CDInv.setVisible(false);
        }
        if(hasCD==1){
            gm.ui.CDInv.setVisible(true);
        }
    }
}
