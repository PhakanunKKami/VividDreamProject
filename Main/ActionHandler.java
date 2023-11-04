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

            //dialogue
            case "Next":
                if(gm.player.atroom==1)gm.ev1.handleNext();
                if(gm.player.atroom==2)gm.ev2.handleNext();
            break;

            //room1-1
            case "LookDoor1": gm.ev1.lookItem("door");break;
            case "LookLamp": gm.ev1.lookItem("lamp");break;
            case "LookNumPad1": gm.ev1.lookItem("numpad");break;

            //room1-2
            case "WhiteDarumaPick":gm.ev1.lookItem("whitedaruma");break;
            case "BoxLock":gm.ev1.lookItem("lockchest");break;
            case "BoxOpen":gm.ev1.lookItem("openedchest");break;
            case "LookRadio1": gm.ev1.lookItem("radio1");break;
            case "LookDaruma":gm.ev1.lookItem("daruma");break;
            case "LookSnowGlobe":gm.ev1.lookItem("snowglobe");break;

            //room1-3
            case "FixWire": gm.ev1.lookItem("brokenwire");break;
            case "Wire": gm.ev1.lookItem("wire");break;

            case "LookCom": gm.ev1.lookItem("comoff");break;
            case "LockCom": gm.ev1.lookItem("comlock");break;
            case "LookCode": gm.ev1.lookItem("comcode");break;

            case "Drawer": gm.ev1.lookItem("drawer");break;

            //room1-4
            case "SilverKey": gm.ev1.lookItem("silverkey");break;
            case "LookJITB": gm.ev1.lookItem("wiggles");break;
            case "LookCandle": gm.ev1.lookItem("candle");break;
            case "LookCandleL": gm.ev1.lookItem("light");break;
            case "LookCodeP": gm.ev1.lookItem("password");break;
            case "LookHiddenP": gm.ev1.lookItem("bcd");break;

            case "LookWBox": gm.ev1.lookItem("whitebox");break;
            case "LookPapers": gm.ev1.lookItem("papers");break;
            case "LookNoPaper": gm.ev1.lookItem("nopaper");break;
            case "LookHolder": gm.ev1.lookItem("holder");break;

            //room2-1
            case "Vent": gm.ev2.lookItem("vent");break;
            case "MissingNote": gm.ev2.lookItem("missingnote");break;
            case "LookDoor2": gm.ev2.lookItem("door");break;
            case "LookNumPad2": gm.ev2.lookItem("numpad");break;

            //room2-2
            case "Crowbar": gm.ev2.lookItem("crowbar");break;
            case "LookJITB3": gm.ev2.lookItem("wiggles3");break;
            case "Safe": gm.ev2.lookItem("safe");break;
            case "LookCD": gm.ev2.lookItem("cd");break;
            case "Gift": gm.ev2.lookItem("gift");break;
            case "LookBBox": gm.ev2.lookItem("bluebox");break;
            case "Symbol": gm.ev2.lookItem("symbols");break;

            //room2-3
            case "FixedNotebook": gm.sChanger.showScene10();break;
            case "Notebook": gm.ev2.lookItem("notebook");break;

            //room2-4
            case "Scissors": gm.ev2.lookItem("scissors");break;
            case "LookJITB2": gm.ev2.lookItem("wiggles2");break;
            case "trueCDPlayer": gm.ev2.lookItem("playrecord");break;
            case "LookRBox": gm.ev2.lookItem("redbox");break;
            case "CDPlayer": gm.ev2.lookItem("recordplayer");break;
            case "Speaker": gm.ev2.lookItem("speaker");break;

            //room extra
            case "closeHint": gm.sChanger.showScene8();break;

            //item selected room1
            case "WD": gm.ev1.handleItemSelection(1);break;
            case "SK": gm.ev1.handleItemSelection(2);break;
            case "ET": gm.ev1.handleItemSelection(3);break;
            case "MP": gm.ev1.handleItemSelection(4);break;
            case "WC": gm.ev1.handleItemSelection(5);break;
            case "GL": gm.ev1.handleItemSelection(6);break;

            //item selected room2
            case "RD": gm.ev2.handleItemSelection(1);break;
            case "BD": gm.ev2.handleItemSelection(2);break;
            case "SC": gm.ev2.handleItemSelection(3);break;
            case "CB": gm.ev2.handleItemSelection(4);break;
            case "MN": gm.ev2.handleItemSelection(5);break;
            case "CD": gm.ev2.handleItemSelection(6);break;


            case "Ready": gm.ev1.lookItem("breakroom3");break;
            //Change scene
            case "LookOpenDoor1": gm.ev1.lookItem("openeddoor");break;
            case "LookOpenDoor2": gm.ev2.lookItem("openeddoor");break;

            case "goRoom1-1": gm.sChanger.showScene1();break;
            case "goRoom1-2": gm.sChanger.showScene2();break;
            case "goRoom1-3": gm.sChanger.showScene3();break;
            case "goRoom1-4": gm.sChanger.showScene4();break;
            case "goRoom2-1": gm.sChanger.showScene6();break;
            case "goRoom2-2": gm.sChanger.showScene7();break;
            case "goRoom2-3": gm.sChanger.showScene8();break;
            case "goRoom2-4": gm.sChanger.showScene9();break;

        }
    }
    
}
