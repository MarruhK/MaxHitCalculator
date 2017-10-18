import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.BoxLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Hamza on 2017-09-14.
 */
        /* There are two types of GUI elements, containers and components.
        Components are elementary GUI entities and Containers hold components
        in a specific manner. Components must be kept in a container.

        Top-Level containers, like frames, are the main window for GUI apps. THey
        have a title bar, an optional menu bar and the content display area. When
        we make a GUI we usually begin by extending the Frame class to inherit its
        properties.

        Layout managers are objects that implement the LayoutManager interface. It
        determines the size and position of components within a container. Layout Managers
        can override the requested size components want to have. Depending on the manager,
        they may alter only its width, height, or even both along with nothing.

        GridBagLayout is known as the most flexible and powerful layout manager.

        JPanels and content panes are generally the only containers that you would want to alter in
        terms of layout manager. JPanel objects are by default Flowlayout while contentPanes are
        BorderLayout. The code to alter a JPanel layout manager is as followed:

        JPanel panel = new JPanel(new BorderLayout());

        More specific containers may have method in their API that is more appropriate to adding comp
        to it.

        You can set the components min/max sizes; however, depending on the layout manager, it may disregard
        the component's request. Along with this, you can choose to align certain components with eachother.
        To do this, you invoke the component's setAlignmentX and setAlignmentY. Most layouts generally ignore
        this, but BoxLayout doesn't.


        Spaces between components ~~~~
        Three factors influence it:
            1) The Layout manager
                Some managers automatically put space in between, some dont and some even ask u if u want space
            2) Invisible Components
                Can create unseen components to add space, typically used for BoxLayout.
            3) Empty Borders
                Similar to invisible components, you can add a border to add space



        GridBagLayout
        gridx and gridy
        This I.V is used to specify where you want to place the component, with respect to the layout. For example, the
        top-left box is (0,0) with the very next one to the right being (1,0), etc.

        gridwidth and gridheight
        Specify how many columns/rows the component will take up. These represent the cells of the layout.

        fill
        Used when the component is smaller than the allotted cell size.
        Valid values include NONE, HORIZONTAL, AND VERTICAL (i.e. c.fill = GridBagConstaints.HORIZONTAL

        ipadx, ipady
        Specified the internal padding. It has a default value of 0 pixels.

        insets
        External padding between outside of components and cell of display area. Value is specified as an Insets Object and
        has a default value of 0 (i.e c.insets =  new Insets(top, left, bottom, right);)

        anchor
        Used when the component is smaller than the display area cell. It is used to determine where in the cell to place the
        component.Valid values (defined as GridBagConstraints constants) are CENTER (the default), PAGE_START, PAGE_END,
        LINE_START, LINE_END, FIRST_LINE_START, FIRST_LINE_END, LAST_LINE_END, and LAST_LINE_START.

        FIRST_LINE_START	    PAGE_START	    FIRST_LINE_END
        LINE_START	              CENTER	        LINE_END
        LAST_LINE_START	         PAGE_END	     LAST_LINE_END

        weightx, weighty

        */

    // Make it so that variables are decalred
    public class MaxHitCalculator extends JFrame implements ActionListener{
    // MaxHitCalculator IS-A JFrame and IS-A ActionListener
    // private variables
    private JPanel mainPanel;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JPanel panel8;
    private JPanel panel9;

    private JLabel prayerLabel;
    private JLabel strengthLabel;
    private JLabel hitpointsLabel;
    private JLabel picLabel;

    private JTextField prayerText;
    private JTextField strengthText;
    private JTextField hitpointsText;

    private JTextArea textArea;

    private JButton button;

    private BufferedImage image;

    String[] amulets = { "", "Torture Amulet", "Strength Amulet", "Fury Amulet", "Glory Amulet" };
    String[] capes = { "", "Infernal Cape", "Fire Cape", "None" };
    String[] gloves = { "", "Barrow Gloves", "Dragon Gloves", "Rune Gloves", "Combat Bracelet" };
    String[] boots = { "", "Primordial Boots", "Dragon Boots", "Rune/Climbing Boots" };
    String[] specWeps = { "", "AGS", "Claws", "Granite Maul" };
    String[] rings = { "", "Berserker Ring (i)", "Berserker Ring", "None"};

    JComboBox amuletJcb;
    JComboBox bootJcb;
    JComboBox gloveJcb;
    JComboBox capeJcb;
    JComboBox specWepJcb;
    JComboBox ringJcb;

    // Constructor to setup the GUI components
    public MaxHitCalculator() {
        // Initialize Panels.
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();
        panel9 = new JPanel();
        mainPanel = new JPanel();

        // Adding spaces allows there to be equal space between all the JLabel and JTextField pairs.
        prayerLabel = new JLabel("Prayer Level:         ");
        prayerLabel.setForeground(Color.white);
        strengthLabel = new JLabel("Strength Level:     ");
        strengthLabel.setForeground(Color.white);
        hitpointsLabel = new JLabel("HP Level:                ");
        hitpointsLabel.setForeground(Color.white);

        // Add text field that are 5 column wide
        prayerText = new JTextField(5);
        strengthText = new JTextField(5);
        hitpointsText = new JTextField(5);

        // Combo Boxes
        amuletJcb= new JComboBox(amulets);
        bootJcb = new JComboBox(boots);
        gloveJcb = new JComboBox(gloves);
        capeJcb = new JComboBox(capes);
        specWepJcb = new JComboBox(specWeps);
        ringJcb = new JComboBox(rings);

        // This is the bottom JTextArea that displays the Dharok Damage and Special Weapon max hits.
        textArea = new JTextArea();
        textArea.setBorder(BorderFactory.createLineBorder(Color.black)); // Make it have a black border.
        textArea.setLineWrap(true);

        // Add the JLabel and JTextField components to the first 3 sub-panels.
        panel1.add(prayerLabel);
        panel1.add(prayerText);
        panel1.setBackground(new Color(32, 37, 43));
        panel2.add(strengthLabel);
        panel2.add(strengthText);
        panel2.setBackground(new Color(32, 37, 43));
        panel3.add(hitpointsLabel);
        panel3.add(hitpointsText);
        panel3.setBackground(new Color(32, 37, 43));

        // Add these 3 sub-panels to the main-panel. It will have a box-layout so that the panels stack on top of one
        //  another. A 15-pixel gap will be put in between panel3 and the next sub-panel
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(Box.createRigidArea(new Dimension(0,10)));
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        mainPanel.add(Box.createRigidArea(new Dimension(0,15))); // 15 pixel gap

        // The first 3 sub-panels are good to go. Add relevant components to the other sub-panels and put them on the
        //  main panel as well. Add 20-pixel gap between panel9 and the JTextField that will display the damage output.
        addJcbToPanel(panel4, "Cape.png", capeJcb);
        addJcbToPanel(panel5, "Amulet.png", amuletJcb);
        addJcbToPanel(panel6, "Weapon.png", specWepJcb);
        addJcbToPanel(panel7, "Gloves.png", gloveJcb);
        addJcbToPanel(panel8, "Boots.png", bootJcb);
        addJcbToPanel(panel9, "Ring.png", ringJcb);
        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
        mainPanel.add(textArea);
        mainPanel.setBackground(new Color(32, 37, 43)); // Sets background colours of the rigidAreas.


        // Initialize JButton and tell the button you are interested in it by telling it to add you to the list of
        //  listeners
        button = new JButton("Get Max Hit");
        button.addActionListener(this);

        // The main container and button are added to the frame. Main panel holds the other panels so that it can
        //  organize the other panels in the wanted manner.
        getContentPane().add(BorderLayout.CENTER, mainPanel);
        getContentPane().add(BorderLayout.SOUTH, button);

        // General needed JFrame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dharok Damage Calculator");
        setSize(354, 624);
        setMinimumSize(new Dimension(354, 614));
        setVisible(true);
    }

    public static void main(String args[]) {
        new MaxHitCalculator(); // Invoke constructor to set up GUI.
    }

    /**
     * The {@code getTextFieldLevel} consumes an int, {@code lowerBound}, and two Strings, {@code textLevel} and
     * {@code fieldName} which are used to check if the value of the JTextField is valid
     * number.
     * <p>
     * A valid number is an integer from 1-99 or 10-99 depending on if
     *
     * @param lowerBound
     * @param textLevel
     * @param fieldName
     */
    public void getTextFieldLevel(int lowerBound, String textLevel, String fieldName){
        int level; // Will be used to change TextLevel to integer value.
        // Make sure the value in the Text Field is a NUMBER between either 1-99 or 10-99 based on lowerBound.
        //  Give the user a few attempts to input proper values, after which entire program closes.
        try {
            level = Integer.parseInt(textLevel);
            // Ensure the integer is between 1-99 or 10-99, based on the String lowerBound.
            if (level > 99 || level < lowerBound){
                // Invalid number. Make sure to give the proper number.
                invalidTextInput(fieldName, lowerBound);
            }
        // The value is valid and in between the range we want it. Execute the rest of the method as if everything
        //  went according to plan. We have the value, now find out it's relevance to the max hit.
        } catch (NumberFormatException ex) {
            // User has inputted a value that is not a number in the text field. Create a dialog box that tells them
            //  to fix their mistake.
            invalidTextInput(fieldName, lowerBound);
        }
    }

    /**
     * {@code closeProgram} closes the program.
     * <p>
     * Note: Useless as of now, but I kept just in case
     */
    private void closeProgram(){
        // Close the program since user failed to input proper value.
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    /**
     * {@code invalidTextInput} consumes a String, {@code fieldName} and an int, {@code lowerBound}, and creates a
     * message dialog box when an invalid value is entered in one of the textfields.
     * <p>
     * It creates a dialog box telling the user to enter a proper value, based on the parameter, fieldName, that is
     * sent.
     *
     * @param fieldName Corresponding JTextField name
     * @param lowerBound Lowest possible integer value that is allowed
     */
    private void invalidTextInput(String fieldName, int lowerBound){
        JOptionPane.showMessageDialog(this, "Please input a value of "
                                                + lowerBound
                                                + "-99 in the "
                                                + fieldName
                                                + " Text Field",
                                            "Invalid Input",
                                            JOptionPane.WARNING_MESSAGE);
    }

    // Code that is run when button is pressed.
    @Override
    public void actionPerformed(ActionEvent e) {
        // Declare some local variables for the purpose of sending them as arguments for the DamageOutput class
        String hpLvl;
        String strengthLvl;
        String prayerLvl;
        String wornCape;
        String wornBoots;
        String wornSpecWeapon;
        String wornAmulet;
        String wornGloves;
        String wornRing;

        // Get max hit. Check Each text field 1by1 then the combo boxes 1by1
        //  To retrieve value of JTextFields, use .getText()
        hpLvl = hitpointsText.getText();
        strengthLvl = strengthText.getText();
        prayerLvl = prayerText.getText();

        // Ensure proper values enetered
        getTextFieldLevel(10, hpLvl, "Hitpoints");
        getTextFieldLevel(1, strengthLvl, "Strength");
        getTextFieldLevel(1, prayerLvl, "Prayer");

        // To retrieve String value of JComboBox, use .getSelectedItem().toString()
        wornBoots = bootJcb.getSelectedItem().toString();
        wornCape = capeJcb.getSelectedItem().toString();
        wornAmulet = amuletJcb.getSelectedItem().toString();
        wornGloves = gloveJcb.getSelectedItem().toString();
        wornSpecWeapon = specWepJcb.getSelectedItem().toString();
        wornRing = ringJcb.getSelectedItem().toString();

        // All GUI values have been obtained and stored into local variables. Send this to the DamageOutput constructor.
        String[] GUIJTextFieldValues = {hpLvl, strengthLvl, prayerLvl};
        String[] GUIJComboBoxValues = {wornBoots, wornCape, wornAmulet, wornGloves, wornRing, wornSpecWeapon};
        // The above string arrays must be sent to DamageOutput class to determine the max hits.
;
        // After the above, it must be shown to the user their max hits. Creating a Player object will make it easier
        //  access the player's information and manipulate it to get the max hit.
        Player player = new Player (GUIJTextFieldValues, GUIJComboBoxValues);

        // The text area will display the dharok max hits based on the hp. It will be shown in intervals of 5hp.
        textArea.setText(player.getDharokMaxHitIntervals());
        textArea.append("\n"); // Empty Line
        textArea.append("\n");
        textArea.append("The max hit of the Player's " + player.getSpecWeapon() + " special attack is: "
                + player.getMaxHitSpec());

        System.out.print("Size of the frame: " + this.getSize());
    }

    /**
     * {code getImageLabel} consumes a String, {@code imageName}, to produce a JLabel that displays an image, based on
     * {@code imageName}.
     *
     * @param imageName A String that represents the name of the image in the directory.
     * @return JLabel that holds an image of the worn equipment.
     * @throws IOException Thrown when unable to retrieve the image from the directory.
     */
    private JLabel getImageLabel(String imageName) throws IOException{
        BufferedImage myPicture = ImageIO.read(new File("images/" + imageName));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        return picLabel;
    }

    /**
     * {@code addJcbToPanel} consumes a JPanel, panel, a String, imageString and a JComboBox, jComboBox, which are used
     * to construct the sub-panel holding JComboBox and adds it to the main panel.
     *
     * @param panel The sub-panel
     * @param imageString Name of the image file
     * @param jComboBox Corresponding JComboBox that will be added to sub-panel
     */
    private void addJcbToPanel(JPanel panel, String imageString, JComboBox jComboBox ){
        jComboBox.setPrototypeDisplayValue("-------------------------------------");
        try {
            panel.add(getImageLabel(imageString));
        } catch(IOException ex){
            System.out.println("Unable to find the image in the directory.");
        }

        panel.add(Box.createRigidArea(new Dimension(20, 0)));
        panel.add(jComboBox);
        panel.setBackground(new Color(32, 37, 43));
        mainPanel.add(panel);
    }

}
