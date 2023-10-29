package Main;

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
        
        gm.ui.nextLabel.setVisible(true);
    }

    //room1-1
    public void door1open(){
        String[] Text = {
            "It open",
        };
        setDialogue(Text,"Carey");
    }

    public void lookDoor1(){
        String[] Text = {
            "Looks like it's locked.",
            // Add additional text lines if needed
        };
        setDialogue(Text,"Carey");
    }

    public void Lamp(){
        String[] Text = {
            "Just a lamp.",
            "Normal lamp.",
        };
        setDialogue(Text,"Carey");
    }

    public void lookNumPad1(){
        String[] Text = {
            "I need a code."
        };
        setDialogue(Text,"Carey");

        //test
        System.out.println(gm.ui.getCorrectCode());
    
        // Show the input field
        gm.ui.inputField.setVisible(true);
    }

    //room 1-2

    public void boxlock(){
        if(gm.player.gm.player.itemselected==2){
            System.out.println("Box unlock");
            gm.player.hasSK=0;
            gm.player.updatePlayerStatus();
            gm.ui.bgPanel[2].getComponent(1).setVisible(false);
        }
        else{
            String[] Text = {
            "I need a key to open it",
        };
        setDialogue(Text,"Carey");
        }
    }

    public void boxopen(){
        if(gm.player.usebox==0){
           String[] Text = {
            "There's something in it",
        };
        setDialogue(Text,"Carey");
        gm.player.usebox=1;
        System.out.println("Silver Key and Paper to inventory"); 
        }
        else{
            String[] Text = {
            "This chest is empty",
        };
        setDialogue(Text,"Carey");
        }
        

    }

    public void pickupdaruma(){
        String[] Text = {
            "Looks like this one can be \npicked up",
            "I'll keep it"
        };
        setDialogue(Text,"Carey");
        
        System.out.println("White Daruma to Inventory");
    }

    public void radio1(){
        String[] Text = {
            "I really miss you",
            "It's been a long time since we \nlast talked",
            "Please....",
            "..wake.....up"
        };
        setDialogue(Text,"Sound from radio");
    }

    public void radio11(){
        String[] Text = {
            "The voice sounded very familiar",
        };
        setDialogue(Text,"Carey");
    }

    public void darumas(){
        String[] Text = {
            "Interesting looking Daruma",
            "It's glued to the shelf",
        };
        setDialogue(Text,"Carey");

    }

    public void snowglobe(){
        String[] Text = {
            "Ordinary snow globe",
        };
        setDialogue(Text,"Carey");

    }

    //room 1-3

    public void fixwire(){
        if(gm.player.itemselected==3){
            gm.ui.bgPanel[3].getComponent(0).setVisible(false);
            gm.ui.bgPanel[3].getComponent(1).setVisible(true);
            gm.player.hasET=0;
            gm.player.updatePlayerStatus();
            gm.ui.bgPanel[3].getComponent(3).setVisible(true);
        }
        else{
            String[] Text = {
                "I need to find something to fix it",
            };
            setDialogue(Text,"Carey");
        }
    
    }

    public void wire(){
        String[] Text = {
            "It works again",
        };
        setDialogue(Text,"Carey");  
    }

    public void lookcom(){
           String[] Text = {
            "This computer won't turn on",
        }; 
        setDialogue(Text,"Carey");
        
    }

    public void lockcom(){
        if(gm.player.knowpass1==1){
            String[] Text = {
            "I hope this work",
        };
        setDialogue(Text,"Carey");

        gm.ui.inputField1.setVisible(true);
        }

        else{
            String[] Text = {
            "The computer is locked",
            "If I enter the wrong password \n3 times",
            "The computer won't let me enter any password again",
            "I should look for more hints"
        };
        setDialogue(Text,"Carey");
        }
        
        
    }

    public void lookcode(){
        int doorcode = gm.ui.getCorrectCode();
        String[] Text = {
            "This is windows XP wallpaper",
            "There is a message that says",
            "'CODE "+doorcode+"'"
        };
        setDialogue(Text,"Carey");
    }

    public void drawer(){
        if(gm.player.usedrawer==0){
           String[] Text = {
            "There's a candle and a lighter \nin here",
            "These things might come in \nhandy"
        };
        gm.player.usedrawer=1;
        setDialogue(Text,"Carey");
        }
        else{
            String[] Text = {
            "This drawer is empty"
        };
        setDialogue(Text,"Carey");
        }
        
        
    }

    //room 1-4

    public void pickupsilverkey(){
        String[] Text = {
            "A key?",
        };
        setDialogue(Text,"Carey");
        
        System.out.println("White Daruma to Inventory");
    }

    public void lookjitb(){
        String[] Text = {
                "I'll call this doll 'Wiggles'"
            };
            setDialogue(Text,"Carey");
    }

    public void lookwbox(){
        if(gm.player.itemselected==1){
            gm.ui.bgPanel[4].getComponent(0).setVisible(true);
            gm.ui.bgPanel[4].getComponent(1).setVisible(true);
            gm.player.hasWD=0;
            gm.player.updatePlayerStatus();
        }
        else{
            String[] Text = {
                "A white box",
                "Same color as Daruma",
            };
            setDialogue(Text,"Carey");
        }
    }

    public void lookpapers(){
        String[] Text = {
                "These papers are blank"
            };
            setDialogue(Text,"Carey");
    }

    public void looknopaper(){
        if(gm.player.itemselected==4){
            gm.ui.bgPanel[4].getComponent(5).setVisible(true);
            gm.player.hasMP=0;
            gm.player.placepaper=1;
            gm.player.updatePlayerStatus();
            if(gm.player.candlelight==1){
                gm.ui.bgPanel[4].getComponent(4).setVisible(true);
                gm.player.knowpass1 = 1;
            }
        }
        else{
            String[] Text = {
                "This one has no paper"
            };
            setDialogue(Text,"Carey");
        }
    }

    public void lookholder(){
        if(gm.player.itemselected==5){
            gm.ui.bgPanel[4].getComponent(3).setVisible(true);
            gm.player.hasWC=0;
            gm.player.updatePlayerStatus();
        }
        else{
            String[] Text = {
                "Why is there a candle holder \nhere?"
            };
            setDialogue(Text,"Carey");
        }
    }

    public void lookcandle(){
        if(gm.player.itemselected==6){
            gm.ui.bgPanel[4].getComponent(2).setVisible(true);
            gm.player.candlelight=1;
            gm.player.hasGL=0;
            gm.player.updatePlayerStatus();
            if(gm.player.placepaper==1){
                gm.ui.bgPanel[4].getComponent(4).setVisible(true);
                gm.player.knowpass1 = 1;
            }
            gm.ui.bgPanel[4].getComponent(6).setVisible(true);
        }
        else{
            String[] Text = {
                "I should try lighting a candle"
            };
            setDialogue(Text,"Carey");
        }
    }

    public void looklight(){
        String[] Text = {
                "This candle has been lit"
            };
            setDialogue(Text,"Carey");
    }

    public void lookpass(){
        String[] Text = {
                "'1001 0101 0110 0011'"
            };
            setDialogue(Text,"Carey");
    }

    public void lookbcd(){
        String[] Text = {
                "'BCD-8421' and a drawing \nthat looks like a computer",
            };
            setDialogue(Text,"Carey");
    }

    //itembar
    public void wditembar(){
        System.out.println("Item1 selected");
        gm.player.itemselected=1;
        gm.ui.itemnameLabel.setText("White Daruma");
        gm.ui.itemnameLabel.setVisible(true);
        gm.ui.Highlight.setVisible(true);
        gm.ui.Highlight.setBounds(20, 12, 72, 80);
    }

    public void skitembar(){
         System.out.println("Item2 selected");
         gm.player.itemselected=2;
         gm.ui.itemnameLabel.setText("Silver Key");
        gm.ui.itemnameLabel.setVisible(true);
         gm.ui.Highlight.setVisible(true);
        gm.ui.Highlight.setBounds(112, 12, 72, 80);
    }

    public void etitembar(){
        System.out.println("Item3 selected");
        gm.player.itemselected=3;
        gm.ui.itemnameLabel.setText("Electrical Tape");
        gm.ui.itemnameLabel.setVisible(true);
        gm.ui.Highlight.setVisible(true);
        gm.ui.Highlight.setBounds(204, 12, 72, 80);

    }

    public void mpitembar(){
         System.out.println("Item4 selected");
         gm.player.itemselected=4;
         gm.ui.itemnameLabel.setText("Mystery Paper");
        gm.ui.itemnameLabel.setVisible(true);
         gm.ui.Highlight.setVisible(true);
        gm.ui.Highlight.setBounds(296, 12, 72, 80);

    }

    public void wcitembar(){
         System.out.println("Item5 selected");
         gm.player.itemselected=5;
         gm.ui.itemnameLabel.setText("White Candle");
        gm.ui.itemnameLabel.setVisible(true);
         gm.ui.Highlight.setVisible(true);
        gm.ui.Highlight.setBounds(388, 12, 72, 80);
 
    }

    public void glitembar(){
         System.out.println("Item6 selected");
         gm.player.itemselected=6;
         gm.ui.itemnameLabel.setText("Gray Lighter");
        gm.ui.itemnameLabel.setVisible(true);
         gm.ui.Highlight.setVisible(true);
        gm.ui.Highlight.setBounds(480, 12, 72, 80);

    }

    

    //input code check
    public void handleInput(String input) {
        System.out.println("Handling input: " + input);
        if(input.equalsIgnoreCase(Integer.toString(gm.ui.getCorrectCode()))){
            System.out.println("PASS");
            gm.ui.bgPanel[1].getComponent(0).setVisible(true);
            gm.ui.randomCorrectCode();
        }
    }

    public void handlePass(String input) {
        System.out.println("Handling password: " + input);
        if(input.equalsIgnoreCase("9563")){
            System.out.println("PASS");
            gm.ui.bgPanel[3].getComponent(2).setVisible(true);
        }
        else{
            gm.player.wrongpass++;
            if(gm.player.wrongpass==3){
                gm.ui.clearScreen();
                gm.ui.initializeLostScreen();
            }
        }
    }
    

    public void handleNext(){

        if(gm.ui.inputField.isVisible()){
            String input = gm.ui.inputField.getText();
            handleInput(input);
        }

        if(gm.ui.inputField1.isVisible()){
            String input = gm.ui.inputField1.getText();
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
                gm.ui.inputField1.setText("ENTER PASSWORD");
                gm.ui.inputField1.setVisible(false);
                dialogueOpen = false;

                //After text condition

                //pick item up
                if (currentText[currentTextIndex - 1].equals("I'll keep it")) {
                    gm.ui.bgPanel[2].getComponent(0).setVisible(false);
                    gm.player.hasWD=1;
                    gm.player.updatePlayerStatus();
                }

                if (currentText[currentTextIndex - 1].equals("There's something in it")) {
                    gm.player.hasMP=1;
                    gm.player.hasET=1;
                    gm.player.updatePlayerStatus();
                }

                if (currentText[currentTextIndex - 1].equals("These things might come in \nhandy")) {
                    gm.player.hasWC=1;
                    gm.player.hasGL=1;
                    gm.player.updatePlayerStatus();
                }

                if (currentText[currentTextIndex - 1].equals("A key?")) {
                    gm.ui.bgPanel[4].getComponent(0).setVisible(false);
                    gm.player.hasSK=1;
                    gm.player.updatePlayerStatus();
                }

                //extra after dialogue
                if (currentText[currentTextIndex - 1].equals("..wake.....up")) {
                    radio11();
                }

                if(currentText[currentTextIndex - 1].equals("It open")){
                    gm.ui.countdownTimer.stop();
                    //go to chapter 2
                }
            }
        }
    }
}