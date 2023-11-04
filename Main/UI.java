package Main;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import javax.swing.*;

public class UI {

    GameManager gm;
    ActionHandler aHandler;
    JFrame window;
    Font Pixel;
    JLabel itemnameLabel;
    public JTextArea messageText;
    public JTextArea nameText;
    public PlaceholderTextField inputField;
    public PlaceholderTextField inputField1;
    public PlaceholderTextField inputField2;
    public JLabel dialogueLabel;
    public JLabel nextLabel;
    public JLabel portraitLabel;
    public JLabel itembarLabel;
    public JPanel bgPanel[] = new JPanel[15];
    public JLabel bgLabel[] = new JLabel[15];
    private JLabel countdownLabel;
    public int countdownValue;
    public Timer countdownTimer;
    private Random random;
    private int correctCode;

    JButton playButton;
    JButton exitButton;

    //player UI
    JPanel inventoryPanel;
    JLabel inventoryLabel;
    //room1 items
    public JLabel WhiteDarumaInv,SilverKeyInv,ElectricalTapeInv,MysteryPaperInv,WhiteCandleInv,GreyLighterInv;
    //room2 items
    public JLabel RedDarumaInv,BlueDarumaInv,ScissorsInv,CrowBarInv,MissingNoteInv,CDInv;

    public JLabel Highlight;

    public UI(GameManager gm, ActionHandler aHandler){
      this.gm = gm;
      this.aHandler = aHandler;

      // Load custom cursor image
      ImageIcon cursorImage = new ImageIcon(getClass().getResource("Resources/Gui/Cursor.png"));
      Image cursorImage1 = cursorImage.getImage();

      // Create a custom cursor
      Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(
          cursorImage1, new Point(0, 0), "CustomCursor"
      );

      random = new Random();
      randomCorrectCode();
      
      try {
        InputStream is = getClass().getResourceAsStream("Resources/Fonts/x12y16pxMaruMonica.ttf");
        Pixel = Font.createFont(Font.TRUETYPE_FONT, is);
      } catch (FontFormatException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }

      createWindow();
      initializeTitleScreen();

        window.setVisible(true);
        // Set the custom cursor for the window
        window.setCursor(customCursor);
    }

    public void initializeTitleScreen() {
      // Create title screen panel
      JPanel titlePanel = new JPanel();
      titlePanel.setBounds(100, 0, 680, 680);
      titlePanel.setBackground(null);
      titlePanel.setLayout(null);

      JLabel titleLabel = new JLabel();
      titleLabel.setBounds(0,0,680,680);

      ImageIcon titlebg = new ImageIcon(getClass().getResource("Resources/Gui/MenuBG.gif"));

      titleLabel.setIcon(titlebg);

      ImageIcon playIcon = new ImageIcon(getClass().getResource("Resources/Gui/PlayButton.png"));
      ImageIcon exitIcon = new ImageIcon(getClass().getResource("Resources/Gui/ExitButton.png"));

      // Create buttons
      playButton = new JButton();
      playButton.setIcon(playIcon);
      exitButton = new JButton();
      exitButton.setIcon(exitIcon);

      playButton.setBounds(228,280,224,96);
      exitButton.setBounds(228,420,224,96);

      playButton.setBackground(null);
      exitButton.setBackground(null);

      playButton.setFocusPainted(false);
      exitButton.setFocusPainted(false);

      playButton.setBorderPainted(false);
      exitButton.setBorderPainted(false);

      playButton.setContentAreaFilled(false);
      exitButton.setContentAreaFilled(false);

      // Add action listeners
      playButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              titlePanel.setVisible(false);
              createPlayerField();
              createMainField();
              generateScene();
              if(gm.player.playtime==0){
                countdownTimer.stop();
                inventoryPanel.setVisible(false);
                gm.sChanger.showSceneStart();
                gm.ev1.lookItem("start");
              }
              else{
                gm.sChanger.showScene1();
              }
              gm.player.setPlayerDefaultStatus();
          }
      });

      exitButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              System.exit(0);
          }
      });

      

      // Add buttons to the title screen panel
      titlePanel.add(playButton);
      titlePanel.add(exitButton);
      titlePanel.add(titleLabel);
      // Add the title screen panel to the window
      
      window.add(titlePanel);
  }

  public void initializeLostScreen() {
    JPanel lostPanel = new JPanel();
    lostPanel.setBounds(100, 0, 680, 680);
    lostPanel.setBackground(null);
    lostPanel.setLayout(null);

    JLabel lostLabel = new JLabel();
    lostLabel.setBounds(0, 0, 680, 680);
    ImageIcon lostbg = new ImageIcon(getClass().getResource("Resources/Gui/LostBG.gif"));
    lostLabel.setIcon(lostbg);

    JButton backButton = new JButton();
    backButton.setBounds(228, 420, 224, 96);
    ImageIcon backIcon = new ImageIcon(getClass().getResource("Resources/Gui/BackButton.png"));
    backButton.setIcon(backIcon);

    backButton.setBackground(null);
    backButton.setFocusPainted(false);
    backButton.setBorderPainted(false);
    backButton.setContentAreaFilled(false);

    backButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Return to the main menu
            initializeTitleScreen();
            lostPanel.setVisible(false);
        }
    });

    lostPanel.add(backButton);
    lostPanel.add(lostLabel);

    window.add(lostPanel);
}

public void initializeWinScreen() {
    JPanel winPanel = new JPanel();
    winPanel.setBounds(100, 0, 680, 680);
    winPanel.setBackground(null);
    winPanel.setLayout(null);

    JLabel winLabel = new JLabel();
    winLabel.setBounds(0, 0, 680, 680);
    ImageIcon winbg = new ImageIcon(getClass().getResource("Resources/Gui/LostBG.gif"));
    winLabel.setIcon(winbg);

    JButton backButton = new JButton();
    backButton.setBounds(228, 420, 224, 96);
    ImageIcon backIcon = new ImageIcon(getClass().getResource("Resources/Gui/BackButton.png"));
    backButton.setIcon(backIcon);

    backButton.setBackground(null);
    backButton.setFocusPainted(false);
    backButton.setBorderPainted(false);
    backButton.setContentAreaFilled(false);

    backButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Return to the main menu
            initializeTitleScreen();
            winPanel.setVisible(false);
        }
    });

    winPanel.add(backButton);
    winPanel.add(winLabel);

    window.add(winPanel);
}



    public void randomCorrectCode(){
      correctCode = random.nextInt(900000)+100000;
    }

    public int getCorrectCode(){
      return correctCode;
    }

    public void createWindow(){
      window = new JFrame();
        window.setSize(900, 720); // Increase the size to accommodate the scaled image
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setLocationRelativeTo(null);
    }

    public void createMainField(){
        

        ImageIcon dialoguebox = new ImageIcon(getClass().getResource("Resources/Gui/DialogueBox.png"));

        dialogueLabel = new JLabel(dialoguebox);

        dialogueLabel.setBounds(100, 0, 680, 680);

        ImageIcon nextbutton = new ImageIcon(getClass().getResource("Resources/Gui/Next.png"));

        nextLabel = new JLabel(nextbutton);

        nextLabel.setBounds(100, 0, 680, 680);

        nextLabel.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
              ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Next");
              aHandler.actionPerformed(mockEvent);
          }
      });

      ImageIcon portraitIcon = new ImageIcon(getClass().getResource("Resources/Gui/Carey.png"));

        portraitLabel = new JLabel(portraitIcon);

        portraitLabel.setBounds(100, 0, 680, 680);

        itemnameLabel = new JLabel("Made By Phakanun AKA KKami");
        itemnameLabel.setBounds(380, 120, 120, 30);
        itemnameLabel.setForeground(Color.decode("#bf8e5a"));
        itemnameLabel.setFont(Pixel.deriveFont(Font.BOLD,20));
        itemnameLabel.setOpaque(false); // Make the label transparent
        itemnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        

        messageText = new JTextArea("Made By Phakanun AKA KKami");
        messageText.setBounds(350, 500, 500, 300); // Adjusted bounds for the text area
        messageText.setForeground(Color.decode("#bf8e5a"));
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(Pixel.deriveFont(Font.BOLD,30));

        nameText = new JTextArea("Made By Phakanun AKA KKami");
        nameText.setBounds(350, 460, 500, 300); // Adjusted bounds for the text area
        nameText.setForeground(Color.decode("#bf8e5a"));
        nameText.setEditable(false);
        nameText.setLineWrap(true);
        nameText.setWrapStyleWord(true);
        nameText.setFont(Pixel.deriveFont(Font.BOLD,30));

        //for codepad 1 & 2
        inputField = new PlaceholderTextField("ENTER CODE");
        inputField.setBounds(290, 300, 300, 80);
        inputField.setForeground(Color.WHITE);
        inputField.setBackground(Color.BLACK);
        inputField.setFont(Pixel.deriveFont(Font.BOLD,60));
        inputField.setHorizontalAlignment(JTextField.CENTER); 

        //for computer
        inputField1 = new PlaceholderTextField("ENTER PASSWORD");
        inputField1.setBounds(240, 300, 400, 80);
        inputField1.setForeground(Color.BLACK);
        inputField1.setBackground(Color.WHITE);
        inputField1.setFont(Pixel.deriveFont(Font.BOLD,60));
        inputField1.setHorizontalAlignment(JTextField.CENTER);

        //for safe
        inputField2 = new PlaceholderTextField("ENTER PASSWORD");
        inputField2.setBounds(240, 300, 400, 80);
        inputField2.setForeground(Color.WHITE);
        inputField2.setBackground(Color.BLACK);
        inputField2.setFont(Pixel.deriveFont(Font.BOLD,60));
        inputField2.setHorizontalAlignment(JTextField.CENTER); 

        messageText.setOpaque(false);
        nameText.setOpaque(false);

        window.add(portraitLabel);
        window.add(inputField);
        window.add(inputField1);
        window.add(inputField2);
        window.add(nextLabel);
        window.add(messageText);
        window.add(nameText);
        window.add(dialogueLabel);
        window.add(itemnameLabel);
        
        itemnameLabel.setVisible(false);
        messageText.setVisible(false);
        nameText.setVisible(false);
        dialogueLabel.setVisible(false);
        nextLabel.setVisible(false);
        portraitLabel.setVisible(false);
        inputField.setVisible(false);
        inputField1.setVisible(false);
        inputField2.setVisible(false); 
    }

    public void createBackground(int bgNum, String bgfilename){

      bgPanel[bgNum] = new JPanel();
      bgPanel[bgNum].setBounds(0,0,900,680);
      bgPanel[bgNum].setBackground(null);
      bgPanel[bgNum].setLayout(null);
      window.add(bgPanel[bgNum]);

      bgLabel[bgNum] = new JLabel();
      bgLabel[bgNum].setBounds(100,0,680,792);

      ImageIcon bgIcon = new ImageIcon(getClass().getResource(bgfilename));

      bgLabel[bgNum].setIcon(bgIcon);

    }

    public void createObject(int bgNum,int objx, int objy,int objw, int objh, String objfilename, String ActionCommand){

      JLabel objectLabel = new JLabel();
      objectLabel.setBounds(objx,objy, objw, objh);

      ImageIcon objectIcon = new ImageIcon(getClass().getResource(objfilename));

      objectLabel.setIcon(objectIcon);

      objectLabel.addMouseListener(new MouseListener() {

        public void mouseClicked(MouseEvent e) {
          
          if(SwingUtilities.isLeftMouseButton(e)){
            ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ActionCommand);
            aHandler.actionPerformed(mockEvent);
          }
          
        }

        public void mousePressed(MouseEvent e) {}

        public void mouseReleased(MouseEvent e) {}

        public void mouseEntered(MouseEvent e) {}

        public void mouseExited(MouseEvent e) {}
        
      });

      bgPanel[bgNum].add(objectLabel);
      

    }

    public void createButton(int bgNum, int x, int y, int width, int height, String filename, String command){
      ImageIcon buttonIcon = new ImageIcon(getClass().getResource(filename));

      JButton Button = new JButton();
      Button.setBounds(x,y,width,height);
      Button.setBackground(null);
      Button.setContentAreaFilled(false);
      Button.setFocusPainted(false);
      Button.setIcon(buttonIcon);
      Button.addActionListener(gm.aHandler);
      Button.setActionCommand(command);
      Button.setBorderPainted(false);

      bgPanel[bgNum].add(Button);
    }

    public void addItemToInventory(JLabel itemLabel, int x, int y, int width, int height, String itemFilename, String... actionCommand) {
      itemLabel.setBounds(x, y, width, height);
  
      ImageIcon itemIcon = new ImageIcon(getClass().getResource(itemFilename));
      itemLabel.setIcon(itemIcon);
  
      if (actionCommand.length > 0) {
          itemLabel.addMouseListener(new MouseListener() {
              public void mouseClicked(MouseEvent e) {
                  if(SwingUtilities.isLeftMouseButton(e)){
                      ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, actionCommand[0]);
                      aHandler.actionPerformed(mockEvent);
                  }
              }
  
              public void mousePressed(MouseEvent e) {}
              public void mouseReleased(MouseEvent e) {}
              public void mouseEntered(MouseEvent e) {}
              public void mouseExited(MouseEvent e) {}
          });
      }
  
      inventoryPanel.add(itemLabel);
  }
  

    public void createPlayerField(){

      //inventory
      ImageIcon inventoryIcon = new ImageIcon(getClass().getResource("Resources/Gui/Itembar.png"));
      inventoryLabel = new JLabel(inventoryIcon);
      inventoryLabel.setBounds(0,0,680,112);
      
      inventoryPanel = new JPanel();
      inventoryPanel.setLayout(null);
      inventoryPanel.setBounds(100, 0, 680, 112);
      inventoryPanel.setBackground(null);

      countdownLabel = new JLabel();
      countdownLabel.setBounds(600, 50, 100, 50); // Adjust position and size as needed
      countdownLabel.setForeground(Color.decode("#bf8e5a"));
      countdownLabel.setFont(Pixel.deriveFont(Font.BOLD,35));

      countdownTimer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            updateCountdown();
        }
      });
      countdownTimer.start();

      
      //items room1
      WhiteDarumaInv = new JLabel();
      addItemToInventory(WhiteDarumaInv, 20, 12, 72, 80, "Resources/ItemBar/DarumaItemBar.png", "WD");

      SilverKeyInv = new JLabel();
      addItemToInventory(SilverKeyInv, 112, 12, 72, 80, "Resources/ItemBar/SilverKeyItemBar.png", "SK");

      ElectricalTapeInv = new JLabel();
      addItemToInventory(ElectricalTapeInv, 204, 12, 72, 80, "Resources/ItemBar/WireTapeItemBar.png","ET");

      MysteryPaperInv = new JLabel();
      addItemToInventory(MysteryPaperInv, 296, 12, 72, 80, "Resources/ItemBar/PaperItemBar.png", "MP");

      WhiteCandleInv = new JLabel();
      addItemToInventory(WhiteCandleInv, 388, 12, 72, 80, "Resources/ItemBar/CandleItemBar.png", "WC");

      GreyLighterInv = new JLabel();
      addItemToInventory(GreyLighterInv, 480, 12, 72, 80, "Resources/ItemBar/LighterItemBar.png", "GL");

      //item room2
      RedDarumaInv = new JLabel();
      addItemToInventory(RedDarumaInv, 20, 12, 72, 80, "Resources/ItemBar/RedDarumaItemBar.png", "RD");

      BlueDarumaInv = new JLabel();
      addItemToInventory(BlueDarumaInv, 112, 12, 72, 80, "Resources/ItemBar/BlueDarumaItemBar.png", "BD");

      ScissorsInv = new JLabel();
      addItemToInventory(ScissorsInv, 204, 12, 72, 80, "Resources/ItemBar/ScissorsItemBar.png","SC");

      CrowBarInv = new JLabel();
      addItemToInventory(CrowBarInv, 296, 12, 72, 80, "Resources/ItemBar/CrowbarItemBar.png", "CB");

      MissingNoteInv = new JLabel();
      addItemToInventory(MissingNoteInv, 388, 12, 72, 80, "Resources/ItemBar/MissingNoteItemBar.png", "MN");

      CDInv = new JLabel();
      addItemToInventory(CDInv, 480, 12, 72, 80, "Resources/ItemBar/CDItemBar.png", "CD");


      //itemhighlight
      Highlight = new JLabel();
      addItemToInventory(Highlight, 20, 12, 72, 80, "Resources/Gui/SelectedItem.png");

      //inventory background
      inventoryPanel.add(countdownLabel);
      inventoryPanel.add(inventoryLabel);
      window.add(inventoryPanel);
    }

    private void updateCountdown() {
    if (countdownValue == 0) {
      System.out.println("countdown 0");
      countdownTimer.stop();
      clearScreen();
      initializeLostScreen();
    }else {
      int minutes = countdownValue / 60; // Calculate minutes
      int seconds = countdownValue % 60; // Calculate seconds

      String timeString = String.format("%02d:%02d", minutes, seconds); // Format the time string

      countdownLabel.setText(timeString);
    }
    countdownValue--;
  }

  public void clearScreen() {
    Component[] components = window.getContentPane().getComponents();
    for (Component component : components) {
        window.getContentPane().remove(component);
    }
    window.revalidate();
    window.repaint();
}


    public void generateScene(){
      // Room1-1
      createBackground(1, "Resources/Room1/Room1-1.png");
      //can pick up or need to change visible
      createObject(1, 340, 196, 200, 400, "Resources/Room1/Door1Open.png", "LookOpenDoor1");

      createObject(1,340, 196, 200, 400,"Resources/Room1/Door1.png","LookDoor1");
      createObject(1,556, 340, 52, 76,"Resources/Room1/NumPad1.png","LookNumPad1");
      createObject(1,168, 254, 175, 340,"Resources/Room1/Lamp1.png","LookLamp");
      //arrow
      createButton(1, 136, 360, 24, 36, "Resources/Gui/LeftArrow.png", "goRoom1-4");
      createButton(1, 720, 360, 24, 36, "Resources/Gui/RightArrow.png", "goRoom1-2");
      bgPanel[1].add(bgLabel[1]);

      //Room1-2
      createBackground(2, "Resources/Room1/Room1-2.png");
      //can pick up or need to change visible
      createObject(2, 568, 380, 36, 36, "Resources/Room1/WhiteDarumaItem.png", "WhiteDarumaPick");
      createObject(2, 512, 540, 76, 44, "Resources/Room1/BoxClose.png", "BoxLock");

      createObject(2, 512, 552, 76, 32, "Resources/Room1/BoxOpen.png", "BoxOpen");

      createObject(2, 268, 396, 84, 76, "Resources/Room1/Radio.png", "LookRadio1");
      createObject(2, 472, 380, 84, 36, "Resources/Room1/Darumas.png", "LookDaruma");
      createObject(2, 584, 320, 32, 40, "Resources/Room1/SnowGlobe.png", "LookSnowGlobe");
      //arrow
      createButton(2, 136, 360, 24, 36, "Resources/Gui/LeftArrow.png", "goRoom1-1");
      createButton(2, 720, 360, 24, 36, "Resources/Gui/RightArrow.png", "goRoom1-3");
      bgPanel[2].add(bgLabel[2]);

      //Room1-3
      createBackground(3, "Resources/Room1/Room1-3.png");
      //can pick up or need to change visible
      createObject(3, 488, 512, 20, 116, "Resources/Room1/BrokenWire.png", "FixWire");
      createObject(3, 492, 512, 144, 40, "Resources/Room1/FixedWire.png", "Wire");
      
      createObject(3, 356, 296, 164, 124, "Resources/Room1/CodeScreen.png", "LookCode");
      createObject(3, 356, 296, 164, 124, "Resources/Room1/LockScreen.png", "LockCom");
      createObject(3, 356, 296, 164, 124, "Resources/Room1/Computer.png", "LookCom");
      

      createObject(3,324,436,228,40,"Resources/Room1/Drawer.png","Drawer");
      //arrow
      createButton(3, 136, 360, 24, 36, "Resources/Gui/LeftArrow.png", "goRoom1-2");
      createButton(3, 720, 360, 24, 36, "Resources/Gui/RightArrow.png", "goRoom1-4");
      bgPanel[3].add(bgLabel[3]);

      //Room1-4
      createBackground(4, "Resources/Room1/Room1-4.png");
      //can pick up or need change visible
      createObject(4, 536, 388, 108, 120, "Resources/Room1/SilverKeyItem.png", "SilverKey");
      createObject(4, 536, 408, 96, 96, "Resources/Room1/WigglesInTheBox.png", "LookJITB");
      createObject(4,188,300,72,120,"Resources/Room1/FireItem.png","LookCandleL");
      createObject(4,188,328,72,92,"Resources/Room1/CandleItem.png","LookCandle");
      createObject(4,172,188,84,120,"Resources/Room1/CodePaper.png","LookCodeP");
      createObject(4,172,180,84,120,"Resources/Room1/PaperItem.png","LookPapers");
      createObject(4,280,180,192,120,"Resources/Room1/CodeHangingPaper.png","LookHiddenP");

      createObject(4,540,504,136,88,"Resources/Room1/WhiteBox.png","LookWBox");
      createObject(4,280,180,192,120,"Resources/Room1/HangingPaper.png","LookPapers");
      createObject(4,172,180,84,120,"Resources/Room1/NoPaperHere.png","LookNoPaper");
      createObject(4,188,392,72,28,"Resources/Room1/CandleHolder.png","LookHolder");
      //arrow
      createButton(4, 136, 360, 24, 36, "Resources/Gui/LeftArrow.png", "goRoom1-3");
      createButton(4, 720, 360, 24, 36, "Resources/Gui/RightArrow.png", "goRoom1-1");
      bgPanel[4].add(bgLabel[4]);

      //Break
      createBackground(5, "Resources/Room2/BlackBG.png");
      //ready button
      createButton(5, 292, 300, 312, 60, "Resources/Gui/ReadyButton.png", "Ready");
      bgPanel[5].add(bgLabel[5]);

      //Room2-1
      createBackground(6, "Resources/Room2/Room2-1.png");
      //can pick up or need change visible
      createObject(6, 340, 196, 200, 400, "Resources/Room1/Door1Open.png", "LookOpenDoor2");
      createObject(6, 144, 460, 148, 80, "Resources/Room2/VentCover.png", "Vent");
      createObject(6, 204, 504, 36, 16, "Resources/Room2/MissingNoteItem.png", "MissingNote");

      createObject(6,340, 196, 200, 400,"Resources/Room1/Door1.png","LookDoor2");
      createObject(6,556, 340, 52, 76,"Resources/Room1/NumPad1.png","LookNumPad2");
      //arrow
      createButton(6, 136, 360, 24, 36, "Resources/Gui/LeftArrow.png", "goRoom2-4");
      createButton(6, 720, 360, 24, 36, "Resources/Gui/RightArrow.png", "goRoom2-2");
      bgPanel[6].add(bgLabel[6]);

      //Room2-2
      createBackground(7, "Resources/Room2/Room2-2.png");
      //can pick up or need change visible
      createObject(7, 478, 408, 172, 96, "Resources/Room2/CrowbarItem.png", "Crowbar");
      createObject(7, 516, 408, 96, 96, "Resources/Room2/WigglesInTheBox3.png", "LookJITB3");
      createObject(7, 196, 416, 195, 176, "Resources/Room2/Safe.png", "Safe");
      createObject(7, 252, 532, 84, 36, "Resources/Room2/CDItem.png", "LookCD");
      createObject(7,520,504,136,88,"Resources/Room2/GiftBox.png","Gift");

      createObject(7,520,504,136,88,"Resources/Room2/BlueBox.png","LookBBox");
      createObject(7, 320, 200, 180, 128, "Resources/Room2/Symbol.png", "Symbol");
      //arrow
      createButton(7, 136, 360, 24, 36, "Resources/Gui/LeftArrow.png", "goRoom2-1");
      createButton(7, 720, 360, 24, 36, "Resources/Gui/RightArrow.png", "goRoom2-3");
      bgPanel[7].add(bgLabel[7]);
      
      //Room2-3
      createBackground(8, "Resources/Room2/Room2-3.png");
      //can pick up or need change visible
      createObject(8, 384, 340, 116, 80, "Resources/Room2/FixedNoteBook.png", "FixedNotebook");

      createObject(8, 384, 340, 116, 80, "Resources/Room2/NoteBook.png", "Notebook");
      //arrow
      
      createButton(8, 136, 360, 24, 36, "Resources/Gui/LeftArrow.png", "goRoom2-2");
      createButton(8, 720, 360, 24, 36, "Resources/Gui/RightArrow.png", "goRoom2-4");
      bgPanel[8].add(bgLabel[8]);
      
      //Room2-4
      createBackground(9, "Resources/Room2/Room2-4.png");
      //can pick up or need change visible
      createObject(9, 216, 384, 132, 120, "Resources/Room2/ScissorsItem.png", "Scissors");
      createObject(9, 216, 408, 96, 96, "Resources/Room2/WigglesInTheBox2.png", "LookJITB2");
      createObject(9, 500, 448, 96, 24, "Resources/Room2/CDRecordPlayer.png", "trueCDPlayer");
      
      createObject(9,220,504,136,88,"Resources/Room2/RedBox.png","LookRBox");
      createObject(9, 500, 448, 96, 24, "Resources/Room2/RecordPlayer.png", "CDPlayer");
      createObject(9, 622,488, 64, 104, "Resources/Room2/Speaker.png", "Speaker");
      createObject(9, 408,488, 64, 104, "Resources/Room2/Speaker.png", "Speaker");
      //arrow
      createButton(9, 136, 360, 24, 36, "Resources/Gui/LeftArrow.png", "goRoom2-3");
      createButton(9, 720, 360, 24, 36, "Resources/Gui/RightArrow.png", "goRoom2-1");
      bgPanel[9].add(bgLabel[9]);

      //Room2-3-extra
      createBackground(10, "Resources/Room2/Room2-3.png");

      //extra arrow for close hint
      createButton(10, 422, 620, 36, 24, "Resources/Gui/DownArrow.png", "closeHint");

      createObject(10, 248, 160, 380, 472, "Resources/Room2/Hint.png", "Hint");
      bgPanel[10].add(bgLabel[10]);

      //start game story
      createBackground(11, "Resources/Room2/BlackBG.png");

      //finish game
      createBackground(12, "Resources/Room2/BlackBG.png");
 
    }

    

}


