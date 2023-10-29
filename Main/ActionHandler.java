package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{
    GameManager gm;

    public ActionHandler(GameManager gm){

        this.gm=gm;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String yourchoice = e.getActionCommand();
        switch(yourchoice){

            //menu
            case "Play":gm.sChanger.showScene1();

            //dialogue
            case "Next":gm.ev1.handleNext();break;

            //room1-1
            case "LookDoor1": gm.ev1.lookDoor1();break;
            case "LookNumPad1": gm.ev1.lookNumPad1();break;
            case "LookLamp": gm.ev1.Lamp();break;

            //room1-2
            case "WhiteDarumaPick":gm.ev1.pickupdaruma();break;
            case "BoxLock":gm.ev1.boxlock();break;

            case "BoxOpen":gm.ev1.boxopen();break;

            case "LookRadio1": gm.ev1.radio1();break;
            case "LookDarumas":gm.ev1.darumas();break;
            case "LookSnowGlobe":gm.ev1.snowglobe();break;

            //room1-3
            case "FixWire": gm.ev1.fixwire();break;
            case "Wire": gm.ev1.wire();break;

            case "LookCom": gm.ev1.lookcom();break;
            case "LockCom": gm.ev1.lockcom();break;
            case "LookCode": gm.ev1.lookcode();break;

            case "Drawer": gm.ev1.drawer();break;

            //room1-4
            case "SilverKey": gm.ev1.pickupsilverkey();break;
            case "LookJITB": gm.ev1.lookjitb();break;
            case "LookCandle": gm.ev1.lookcandle();break;
            case "LookCandleL": gm.ev1.looklight();break;
            case "LookCodeP": gm.ev1.lookpass();break;
            case "LookHiddenP": gm.ev1.lookbcd();break;

            case "LookWBox": gm.ev1.lookwbox();break;
            case "LookPapers": gm.ev1.lookpapers();break;
            case "LookNoPaper": gm.ev1.looknopaper();break;
            case "LookHolder": gm.ev1.lookholder();break;

            //item selected room1
            case "WD": gm.ev1.wditembar();break;
            case "SK": gm.ev1.skitembar();break;
            case "ET": gm.ev1.etitembar();break;
            case "MP": gm.ev1.mpitembar();break;
            case "WC": gm.ev1.wcitembar();break;
            case "GL": gm.ev1.glitembar();break;


            //Change scene
            case "LookOpenDoor1": gm.ev1.door1open();break;

            case "goRoom1-1": gm.sChanger.showScene1();break;
            case "goRoom1-2": gm.sChanger.showScene2();break;
            case "goRoom1-3": gm.sChanger.showScene3();break;
            case "goRoom1-4": gm.sChanger.showScene4();break;

        }
    }
    
}
