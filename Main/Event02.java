package Main;

public class Event02 {
    
    GameManager gm;
    String[] currentText;
    int currentTextIndex = 0;
    boolean dialogueOpen = false;
    String name;
    

    public Event02(GameManager gm){
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
        
        gm.ui.nextLabel.setVisible(true);
    }

    //item click or story
    public void lookItem(String itemName) {
        String[] Text;
        String name;
    
        switch(itemName) {
            case "openeddoor":
                Text = new String[]{"Hopefully that's the way out"};
                name = "Carey";
                break;
            case "door":
                Text = new String[]{"Of course it's locked"};
                name = "Carey";
                break;
            case "vent":
                if(gm.player.itemselected==4){
                    gm.ui.bgPanel[6].getComponent(1).setVisible(false);
                    gm.player.hasCB=0;
                    gm.player.updatePlayerStatus();
                    return;
                } else {
                    Text = new String[]{
                        "I see a piece of paper in here",
                        "I need to find something to \npry it off"
                    };
                    name = "Carey"; 
                }
                break;
            case "missingnote":
                Text = new String[]{"It seems like this is the \nmissing note"};
                name = "Carey";
                break;
            case "numpad":
                Text = new String[]{"Great, must find the code \nagain..."};
                name = "Carey";
                gm.ui.inputField.setVisible(true);
                break;
            case "crowbar":
                Text = new String[]{"How does this fit in \nsuch a small box?"};
                name = "Carey";
                break;
            case "wiggles3":
                Text = new String[]{"This is starting to get scary"};
                name = "Carey";
                break;
            case "safe":
                if (gm.player.knowpass == 1) {
                    Text = new String[]{"Let's see"};
                    name = "Carey";
                    gm.ui.inputField2.setVisible(true);
                } else {
                    Text = new String[]{
                        "I only have 3 chances again huh?",
                        "I need more clue"
                    };
                    name = "Carey";
                }
                break;
            case "cd":
                Text = new String[]{"A record...right?"};
                name = "Carey";
                break;
            case "gift":
                if(gm.player.itemselected==3){
                    gm.player.hasSC=0;
                    gm.player.updatePlayerStatus();
                    gm.ui.bgPanel[7].getComponent(4).setVisible(false);
                    return;
                } else {
                    Text = new String[]{"Why can't I unwrap it?"};
                    name = "Carey";
                }
                break;
            case "bluebox":
                if(gm.player.itemselected==2){
                    gm.player.hasBD=0;
                    gm.player.updatePlayerStatus();
                    gm.ui.bgPanel[7].getComponent(0).setVisible(true);
                    gm.ui.bgPanel[7].getComponent(1).setVisible(true);
                    return;
                } else {
                    Text = new String[]{"Another box?"};
                    name = "Carey";
                }
                break;
            case "symbols":
                Text = new String[]{
                    "A triangle, a square and a circle",
                    "These symbols must have \nmeaning"
                };
                name = "Carey";
                break;
            case "notebook":
                if(gm.player.itemselected==5){
                    gm.player.hasMN=0;
                    gm.player.updatePlayerStatus();
                    gm.ui.bgPanel[8].getComponent(0).setVisible(true);
                    gm.player.knowpass=1;
                    return;
                } else {
                    Text = new String[]{
                        "Someone's Notebook",
                        "One page was torn",
                        "On another page it's written:",
                        "'HELLO WORLD!'"
                    };
                    name = "Carey";
                }
                break;
            case "scissors":
                Text = new String[]{"Scissors!"};
                name = "Carey";
                break;
            case "wiggles2":
                Text = new String[]{
                    "It look just like Wiggles",
                    "Except it's crying",
                    "So strange..."
                };
                name = "Carey";
                break;
            case "redbox":
                if(gm.player.itemselected==1){
                    gm.player.hasRD=0;
                    gm.player.updatePlayerStatus();
                    gm.ui.bgPanel[9].getComponent(0).setVisible(true);
                    gm.ui.bgPanel[9].getComponent(1).setVisible(true);
                    return;
                } else {
                    Text = new String[]{"This time it's red"};
                    name = "Carey";
                }
                break;
            case "playrecord":
                int doorcode = gm.ui.getCorrectCode();
                Text = new String[]{
                    "Hey, I'm here again today",
                    "I want you to know that \nyou're not alone",
                    "I have good news",
                    "The lottery winner from your \nfavorite game is ID"+doorcode,
                    "That's you, right? \nCongratulations in advance",
                    "I hope you wake up and \ncelebrate with me",
                    "...brother..."
                };
                name = "Sound from record player";
                break;
            case "playrecord2":
                Text = new String[]{
                    "I remember now",
                    "This is my brother's voice",
                    "...",
                    "I need to hurry"
                };
                name = "Carey";
                break;
            case "recordplayer":
                if(gm.player.itemselected==6){
                    gm.player.hasCD=0;
                    gm.player.updatePlayerStatus();
                    gm.ui.bgPanel[9].getComponent(2).setVisible(true);
                    return;
                } else {
                    Text = new String[]{"This is a record player"};
                    name = "Carey";
                }
                break;
            case "speaker":
                Text = new String[]{"The speakers are set to the \nhighest volume"};
                name = "Carey";
                break;
            case "endroom1":
                Text = new String[]{"Hey! Are you there?"};
                name = "Carey";
                break;
            case "endroom2":
                Text = new String[]{"Yes?"};
                name = "Mysterious voice";
                break;
            case "endroom3":
                Text = new String[]{
                    "I have to wake up now",
                    "There's no time"
                };
                name = "Carey";
                break;
            case "endroom4":
                Text = new String[]{
                    "Okay, fine, you won, \nbut remember...",
                    "I'm always waiting for \nyou here...",
                    "Goodbye...for now"
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
                return "Red Daruma";
            case 2:
                return "Blue Daruma";
            case 3:
                return "Scissors";
            case 4:
                return "Crowbar";
            case 5:
                return "Missing Note";
            case 6:
                return "Record";
            default:
                return "Unknown Item";
        }
    }


    //input code check
    public void handleInput(String input) {
        System.out.println("Handling input: " + input);
        if(input.equalsIgnoreCase(Integer.toString(gm.ui.getCorrectCode()))){
            System.out.println("PASS");
            gm.player.room2pass = 1;
            gm.ui.bgPanel[6].getComponent(0).setVisible(true);
        }
        else{
            gm.player.codeinput++;
            if(gm.player.codeinput==5){
                gm.ui.countdownTimer.stop();
                gm.ui.clearScreen();
                gm.ui.initializeLostScreen();
            }
        }
    }

    //input safe password check
    public void handlePass(String input) {
        System.out.println("Handling password: " + input);
        if(input.equalsIgnoreCase("2314")){
            System.out.println("PASS");
            gm.ui.bgPanel[7].getComponent(2).setVisible(false);
        }
        else{
            gm.player.wrongpass++;
            if(gm.player.wrongpass==3){
                gm.ui.countdownTimer.stop();
                gm.ui.clearScreen();
                gm.ui.initializeLostScreen();
            }
        }
    }

    //next click
    public void handleNext(){

        if(gm.ui.inputField.isVisible()){
            String input = gm.ui.inputField.getText();
            handleInput(input);
        }

        if(gm.ui.inputField2.isVisible()){
            String input = gm.ui.inputField2.getText();
            handlePass(input);
        }

        if (dialogueOpen) {
            currentTextIndex++;
            if (currentTextIndex < currentText.length) {
                gm.ui.messageText.setText(currentText[currentTextIndex]);
            } else {
                gm.ui.messageText.setVisible(false);
                gm.ui.nameText.setVisible(false);
                gm.ui.dialogueLabel.setVisible(false);
                gm.ui.portraitLabel.setVisible(false);
                gm.ui.nextLabel.setVisible(false);
                gm.ui.inputField.setText("ENTER CODE");
                gm.ui.inputField.setVisible(false);
                gm.ui.inputField2.setText("ENTER PASSWORD");
                gm.ui.inputField2.setVisible(false);
                dialogueOpen = false;

                //After text condition
                
                //pick item up
                if (currentText[currentTextIndex - 1].equals("It seems like this is the \nmissing note")) {
                    gm.ui.bgPanel[6].getComponent(2).setVisible(false);
                    gm.player.hasMN=1;
                    gm.player.updatePlayerStatus();
                }

                else if (currentText[currentTextIndex - 1].equals("How does this fit in \nsuch a small box?")) {
                    gm.ui.bgPanel[7].getComponent(0).setVisible(false);
                    gm.player.hasCB=1;
                    gm.player.updatePlayerStatus();
                }

                else if (currentText[currentTextIndex - 1].equals("A record...right?")) {
                    gm.ui.bgPanel[7].getComponent(3).setVisible(false);
                    gm.player.hasCD=1;
                    gm.player.updatePlayerStatus();
                }

                else if (currentText[currentTextIndex - 1].equals("Scissors!")) {
                    gm.ui.bgPanel[9].getComponent(0).setVisible(false);
                    gm.player.hasSC=1;
                    gm.player.updatePlayerStatus();
                }

                //extra after dialogue
                else if (currentText[currentTextIndex - 1].equals("...brother...")) {
                    lookItem("playrecord2");
                }

                else if(currentText[currentTextIndex - 1].equals("Hopefully that's the way out")){
                    gm.ui.countdownTimer.stop();
                    gm.sChanger.showSceneEnd();
                    gm.ui.inventoryPanel.setVisible(false);
                    gm.ui.itemnameLabel.setVisible(false);
                    lookItem("endroom1");
                }

                else if (currentText[currentTextIndex - 1].equals("Hey! Are you there?")) {
                    lookItem("endroom2");
                }

                else if (currentText[currentTextIndex - 1].equals("Yes?")) {
                    lookItem("endroom3");
                }

                else if (currentText[currentTextIndex - 1].equals("There's no time")) {
                    lookItem("endroom4");
                }

                else if (currentText[currentTextIndex - 1].equals("Goodbye...for now")) {
                    gm.ui.initializeWinScreen();
                }
            }
        }
    }
}