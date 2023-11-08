package Main;

import java.awt.Color;

public class Event01 {
    
    GameManager gm;
    String[] currentText;
    int currentTextIndex = 0;
    boolean dialogueOpen = false;
    String name;
    

    public Event01(GameManager gm){
        this.gm=gm;
    }

    public void setDialogue(String[] text, String name) {
        String nm = name+" :";
        currentText = text;
        currentTextIndex = 0;
        dialogueOpen = true;
        gm.ui.messageText.setText(currentText[currentTextIndex]);
        gm.ui.messageText.setVisible(true);
        gm.ui.nameText.setText(nm);
        gm.ui.nameText.setVisible(true);
        gm.ui.dialogueLabel.setVisible(true);

        if(name == "Carey"){
          gm.ui.portraitLabel.setVisible(true);  
        }
        if(name == "Mysterious voice"){
        gm.ui.portraitLabel1.setVisible(true); 
        }
        
        gm.ui.nextLabel.setVisible(true);
    }

    //item click or story
    public void lookItem(String itemName) {
        String[] Text;
        String name;
    
        switch(itemName) {
            case "start":
                Text = new String[]{"Hello! Welcome to my game"};
                name = "Mysterious voice";
                break;
            case "start2":
                Text = new String[]{"Who are you? Where am I? \nGame?"};
                name = "Carey";
                break;
            case "start3":
                Text = new String[]{
                    "I'm just a lonely kid who \nwants to play a game",
                    "The rules are very simple:",
                    "You have 5 minutes to get from \none room to the next",
                    "Each room has a numpad \nYou need to enter 6 digits code",
                    "DO NOT enter the wrong code \nmore than 5 times",
                    "Got it?"
                };
                name = "Mysterious voice";
                break;
            case "start4":
                Text = new String[]{"Um...Yes?"};
                name = "Carey";
                break;
            case "start5":
                Text = new String[]{"Great! Now let's start"};
                name = "Mysterious voice";
                break;
            case "openeddoor":
                if(gm.player.knowcode==0){
                    Text = new String[]{"Let's go"};
                        name = "Carey";
                } else{
                    if(gm.player.hasRD == 1 && gm.player.hasBD == 1) {
                        Text = new String[]{"Let's go"};
                        name = "Carey";
                    } else {
                        Text = gm.player.count1 == 0 ?
                            new String[]{"Take the Daruma with you...","You need them"} :
                            new String[]{"I should go look at the daruma \non the shelf"};
                        name = gm.player.count1 == 0 ? "Mysterious voice" : "Carey";
                    }
                }
                break;
            case "door":
                Text = new String[]{"Looks like it's locked"};
                name = "Carey";
                break;
            case "lamp":
                Text = new String[]{
                    "Just a lamp",
                    "Normal lamp"
                };
                name = "Carey";
                break;
            case "numpad":
                Text = new String[]{"They said 'Don't enter the \nwrong code 5 times'"};
                name = "Carey";
                gm.ui.inputField.setVisible(true);
                gm.ui.okbutton.setBounds(555, 300, 80, 80);
                gm.ui.okbutton.setVisible(true);
                break;
            case "lockchest":
                if(gm.player.itemselected == 2) {
                    gm.player.hasSK = 0;
                    gm.player.itemselected=0;
                    gm.player.updatePlayerStatus();
                    gm.ui.bgPanel[2].getComponent(1).setVisible(false);
                    return;
                } else {
                    Text = new String[]{"I need a key to open it"};
                    name = "Carey";
                }
                break;
            case "openedchest":
                if(gm.player.usebox == 0) {
                    Text = new String[]{"There's something in it"};
                    name = "Carey";
                    gm.player.usebox = 1;
                } else {
                    Text = new String[]{"This chest is empty"};
                    name = "Carey";
                }
                break;
            case "whitedaruma":
                Text = new String[]{
                    "Looks like this one can be \npicked up",
                    "I'll keep it"
                };
                name = "Carey";
                break;
            case "radio1":
                Text = new String[]{
                    "I really miss you",
                    "It's been a long time \nsince we last talked",
                    "Please....",
                    "..wake.....up"
                };
                name = "Sound from radio";
                break;
            case "radio2":
                Text = new String[]{"The voice sounded very familiar"};
                name = "Carey";
                break;
            case "daruma":
                if(gm.player.room1pass == 1 && gm.player.knowcode==1) {
                    Text = new String[]{"It looks like the glue has \ncome off"};
                    name = "Carey";
                } else {
                    Text = new String[]{
                        "Interesting looking Daruma",
                        "It's glued to the shelf"
                    };
                    name = "Carey";
                }
                break;
            case "snowglobe":
                Text = new String[]{"Ordinary snow globe"};
                name = "Carey";
                break;
            case "brokenwire":
                if(gm.player.itemselected==3){
                    gm.ui.bgPanel[3].getComponent(0).setVisible(false);
                    gm.ui.bgPanel[3].getComponent(1).setVisible(true);
                    gm.player.hasET=0;
                    gm.player.itemselected=0;
                    gm.player.updatePlayerStatus();
                    gm.ui.bgPanel[3].getComponent(3).setVisible(true);
                    return;
                } else {
                    Text = new String[]{"I need to find something to fix it"};
                    name = "Carey";
                }
                break;
            case "wire":
                Text = new String[]{"It works again"};
                name = "Carey";
                break;
            case "comoff":
                Text = new String[]{"This computer won't turn on"};
                name = "Carey";
                break;
            case "comlock":
                if (gm.player.knowpass == 1) {
                    Text = new String[]{"I hope this work"};
                    name = "Carey";
                    gm.ui.inputField1.setVisible(true);
                    gm.ui.okbutton.setBounds(605, 300, 80, 80);
                    gm.ui.okbutton.setVisible(true);
                } else {
                    Text = new String[]{
                        "The computer is locked",
                        "'Don't enter the wrong password \n3 times or it'll lock forever'",
                        "I should look for more hints"
                    };
                    name = "Carey";
                }
                break;
            case "comcode":
                int doorcode = gm.ui.getCorrectCode();
                Text = new String[]{
                    "This is windows XP wallpaper",
                    "There is a message that says",
                    "'CODE "+doorcode+"'"
                };
                name = "Carey";
                gm.player.knowcode=1;
                break;
            case "drawer":
                if(gm.player.usedrawer==0){
                    Text = new String[]{
                        "There's a candle and a lighter \nin here",
                        "These things might come in \nhandy"
                    };
                    name = "Carey";
                    gm.player.usedrawer=1;
                } else {
                    Text = new String[]{"This drawer is empty"};
                    name = "Carey";
                }
                break;
            case "silverkey":
                Text = new String[]{"A key?"};
                name = "Carey";
                break;
            case "wiggles":
                Text = new String[]{"I'll call this doll 'Wiggles'"};
                name = "Carey";
                break;
            case "whitebox":
                if(gm.player.itemselected == 1){
                    gm.ui.bgPanel[4].getComponent(0).setVisible(true);
                    gm.ui.bgPanel[4].getComponent(1).setVisible(true);
                    gm.player.hasWD = 0;
                    gm.player.itemselected=0;
                    gm.player.updatePlayerStatus();
                    return;
                } else {
                    Text = new String[]{
                        "A white box",
                        "Same color as Daruma",
                    };
                    name = "Carey";
                }
            break;
            case "papers":
                Text = new String[]{"These papers are blank"};
                name = "Carey";
                break;
            case "nopaper":
                if(gm.player.itemselected == 4){
                    gm.ui.bgPanel[4].getComponent(5).setVisible(true);
                    gm.player.hasMP = 0;
                    gm.player.itemselected=0;
                    gm.player.placepaper = 1;
                    gm.player.updatePlayerStatus();
                    if(gm.player.candlelight == 1){
                        gm.ui.bgPanel[4].getComponent(4).setVisible(true);
                        gm.player.knowpass = 1;
                    }
                    return;
                } else {
                    Text = new String[]{"This one has no paper"};
                    name = "Carey";
                }
                break;
            case "holder":
                if(gm.player.itemselected == 5){
                    gm.ui.bgPanel[4].getComponent(3).setVisible(true);
                    gm.player.hasWC = 0;
                    gm.player.itemselected=0;
                    gm.player.updatePlayerStatus();
                    return;
                } else {
                    Text = new String[]{"Why is there a candle holder \nhere?"};
                    name = "Carey";
                }
                break;
            case "candle":
                if(gm.player.itemselected == 6){
                    gm.ui.bgPanel[4].getComponent(2).setVisible(true);
                    gm.player.candlelight = 1;
                    gm.player.hasGL = 0;
                    gm.player.itemselected=0;
                    gm.player.updatePlayerStatus();
                    if(gm.player.placepaper == 1){
                        gm.ui.bgPanel[4].getComponent(4).setVisible(true);
                        gm.player.knowpass = 1;
                    }
                    gm.ui.bgPanel[4].getComponent(6).setVisible(true);
                    return;
                } else {
                    Text = new String[]{"I should try lighting a candle"};
                    name = "Carey";
                }
                break;
            case "light":
                Text = new String[]{"This candle has been lit"};
                name = "Carey";
                break;
            case "password":
                Text = new String[]{"'1001 0101 0110 0011'"};
                name = "Carey";
                break;
            case "bcd":
                Text = new String[]{"'BCD-8421' and a drawing \nthat looks like a computer"};
                name = "Carey";
                break;
            case "breakroom1":
                Text = new String[]{"It's dark"};
                name = "Carey";
                break;
            case "breakroom2":
                Text = new String[]{
                    "You can rest first",
                    "Tell me when you're ready"
                };
                name = "Mysterious voice";
                break;
            case "breakroom3":
                Text = new String[]{"I'm ready"};
                name = "Carey";
                gm.ui.bgPanel[5].getComponent(0).setVisible(false);
                break;
            case "luckyend1":
                Text = new String[]{
                    "You think you're lucky?",
                    "Then you probably don't \nneed my help",
                    "I'll let you rest",
                    "As for all the items, \nif you bring them, \nI'll confiscate them",
                    "Tell me when you're ready"
                };
                name = "Mysterious voice";
                break;
            default:
                Text = new String[]{"No text here"};
                name = "KKami";
                break;
        }
    
        setDialogue(Text, name);
    }

    //itembar
    public void handleItemSelection(int selectedItem) {
        System.out.println("Item" + selectedItem + " selected");
        gm.player.itemselected = selectedItem;
        String itemName = getItemName(selectedItem);
        gm.ui.itemnameLabel.setText(itemName);
        gm.ui.itemnameLabel.setVisible(true);
        gm.ui.Highlight.setVisible(true);
        gm.ui.Highlight.setBounds(20 + (selectedItem - 1) * 92, 12, 72, 80);
    }
    
    private String getItemName(int selectedItem) {
        switch (selectedItem) {
            case 1:
                return "White Daruma";
            case 2:
                return "Silver Key";
            case 3:
                return "Electrical Tape";
            case 4:
                return "Mystery Paper";
            case 5:
                return "White Candle";
            case 6:
                return "Gray Lighter";
            default:
                return "Unknown Item";
        }
    }


    //input code check
    public void handleInput(String input) {
        System.out.println("Handling input: " + input);
        if(input.equals("WRONG CODE")||input.equals("ENTER CODE")){
            //nothing
        }
        else{
            if(input.equalsIgnoreCase(Integer.toString(gm.ui.getCorrectCode()))){
                System.out.println("PASS");
                gm.ui.bgPanel[1].getComponent(0).setVisible(true);
                gm.player.room1pass = 1;
                handleNext();
            }
            else{
                gm.ui.inputField.setPlaceholder("WRONG CODE");
                gm.ui.inputField.setForeground(Color.RED);
                gm.ui.inputField.setText("WRONG CODE");
                gm.player.codeinput++;
                if(gm.player.codeinput==5){
                    gm.ui.countdownTimer.stop();
                    gm.ui.clearScreen();
                    gm.ui.initializeLostScreen();
                }
            }
        }
        
    }

    //input computer password check
    public void handlePass(String input) {
        System.out.println("Handling password: " + input);
        if(input.equals("WRONG PASSWORD")||input.equals("ENTER PASSWORD")){
            //nothing
        }
        else{
            if(input.equalsIgnoreCase("9563")){
            System.out.println("PASS");
            gm.ui.bgPanel[3].getComponent(2).setVisible(true);
            handleNext();
        }
        else{
            gm.ui.inputField1.setPlaceholder("WRONG PASSWORD");
            gm.ui.inputField1.setForeground(Color.RED);
            gm.ui.inputField1.setText("WRONG PASSWORD");
            gm.player.wrongpass++;
            if(gm.player.wrongpass==3){
                gm.ui.countdownTimer.stop();
                gm.ui.clearScreen();
                gm.ui.initializeLostScreen();
            }
        }
        }
        
    }

    //next click
    public void handleNext(){
        if (dialogueOpen) {
            currentTextIndex++;
            if (currentTextIndex < currentText.length) {
                gm.ui.messageText.setText(currentText[currentTextIndex]);
            } else {
                gm.ui.messageText.setVisible(false);
                gm.ui.nameText.setVisible(false);
                gm.ui.dialogueLabel.setVisible(false);
                gm.ui.portraitLabel.setVisible(false);
                gm.ui.portraitLabel1.setVisible(false);
                gm.ui.nextLabel.setVisible(false);
                gm.ui.inputField.setPlaceholder("ENTER CODE");
                gm.ui.inputField.setForeground(Color.WHITE);
                gm.ui.inputField.setText("ENTER CODE");
                gm.ui.inputField.setVisible(false);
                gm.ui.inputField1.setPlaceholder("ENTER PASSWORD");
                gm.ui.inputField1.setForeground(Color.BLACK);
                gm.ui.inputField1.setText("ENTER PASSWORD");
                gm.ui.inputField1.setVisible(false);
                gm.ui.okbutton.setVisible(false);
                dialogueOpen = false;

                //After text condition
                
                //pick item up
                if (currentText[currentTextIndex - 1].equals("I'll keep it")) {
                    gm.ui.bgPanel[2].getComponent(0).setVisible(false);
                    gm.player.hasWD=1;
                    gm.player.updatePlayerStatus();
                }

                else if (currentText[currentTextIndex - 1].equals("There's something in it")) {
                    gm.player.hasMP=1;
                    gm.player.hasET=1;
                    gm.player.updatePlayerStatus();
                }

                else if (currentText[currentTextIndex - 1].equals("These things might come in \nhandy")) {
                    gm.player.hasWC=1;
                    gm.player.hasGL=1;
                    gm.player.updatePlayerStatus();
                }

                else if (currentText[currentTextIndex - 1].equals("A key?")) {
                    gm.ui.bgPanel[4].getComponent(0).setVisible(false);
                    gm.player.hasSK=1;
                    gm.player.updatePlayerStatus();
                }

                else if (currentText[currentTextIndex - 1].equals("It looks like the glue has \ncome off")) {
                    gm.ui.bgPanel[2].getComponent(4).setVisible(false);
                    gm.player.hasRD=1;
                    gm.player.hasBD=1;
                    gm.player.updatePlayerStatus();
                }

                //extra after dialogue
                else if (currentText[currentTextIndex - 1].equals("Hello! Welcome to my game")) {
                    lookItem("start2");
                }

                else if (currentText[currentTextIndex - 1].equals("Who are you? Where am I? \nGame?")) {
                    lookItem("start3");
                }

                else if (currentText[currentTextIndex - 1].equals("Got it?")) {
                    lookItem("start4");
                }

                else if (currentText[currentTextIndex - 1].equals("Um...Yes?")) {
                    lookItem("start5");
                }

                else if (currentText[currentTextIndex - 1].equals("Great! Now let's start")) {
                    gm.sChanger.showScene1();
                    gm.ui.inventoryPanel.setVisible(true);
                    gm.player.playtime=1;
                    gm.ui.countdownTimer.start();
                }

                else if (currentText[currentTextIndex - 1].equals("..wake.....up")) {
                    lookItem("radio2");
                }

                else if (currentText[currentTextIndex - 1].equals("You need them")) {
                    gm.player.count1=1;
                }

                else if(currentText[currentTextIndex - 1].equals("Let's go")){
                    gm.ui.countdownTimer.stop();
                    gm.sChanger.showScene5();
                    gm.ui.inventoryPanel.setVisible(false);
                    gm.ui.itemnameLabel.setVisible(false);
                    gm.ui.Highlight.setVisible((false));
                    if(gm.player.knowcode==0){
                        gm.player.hasWD = 0;
                        gm.player.hasSK = 0;
                        gm.player.hasET = 0;
                        gm.player.hasMP = 0;
                        gm.player.hasWC = 0;
                        gm.player.hasGL = 0;
                        gm.player.updatePlayerStatus();
                        lookItem("luckyend1");
                    }else{
                        lookItem("breakroom1");
                    }
                    
                }

                else if (currentText[currentTextIndex - 1].equals("It's dark")) {
                    lookItem("breakroom2");
                }

                else if (currentText[currentTextIndex - 1].equals("Tell me when you're ready")) {
                    gm.ui.bgPanel[5].getComponent(0).setVisible(true);
                }

                else if (currentText[currentTextIndex - 1].equals("I'm ready")) {
                    gm.ui.countdownValue += 300;
                    gm.sChanger.showScene6();
                    gm.ui.inventoryPanel.setVisible(true);
                    gm.player.itemselected = 0;
                    gm.player.wrongpass=0;
                    gm.player.codeinput=0;
                    gm.player.knowpass=0;
                    gm.ui.randomCorrectCode();
                    gm.player.atroom=2;
                    gm.ui.countdownTimer.start();
                }
            }
        }
    }
}