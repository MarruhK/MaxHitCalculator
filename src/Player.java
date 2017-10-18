/**
 * Created by Hamza on 2017-10-04.
 */


/**
 * This {@code Player} class is used to store information about the Player in question.
 *
 * @author Hamza Khurram
 * @version 1.0
 * @since 2017-10-04
 */
public class Player {
    // INSTANCE VARIABLES
    private int strengthLevel;
    private int prayLevel;
    private int hpLevel;
    private int totalEquipmentStrengthBonusSpec;
    private int totalEquipmentStrengthBonusAxe;
    private int maxHitSpec;
    private String specWeapon;
    private String dharokMaxHitIntervals;

    /**
     * The constructor initializes the instance variables.
     *
     * @param JTextFields
     * @param JComboBox
     */
    public Player(String[] JTextFields, String[] JComboBox){
        // JTextField has 3 Strings rep' the str, hp and prayer. The instance variables representing the player's
        //  stats are now initialized after this method call.
        setStats(JTextFields);

        // JComboBox has some Strings representing the str bonus from the equipment the player is wearing. The
        //  below method obtains the total equipment strength bonus the player has on.
        setTotalEquipmentStrengthBonuses(JComboBox);

        // Set the Player's maximum hit for Dharok axe and spec weapon.
        setMaxHitSpec();
        setDharokMaxHitIntervals();
    }

    // SETTERS/MUTATORS
    /**
     * The {@code setStats} consumes an array of Strings, {@code Stats}, and uses it to set some of the Player's stats.
     * <p>
     * The argument {@code Stats} is a String array that contains the integers, in String value, of some of the Player's
     * stats. The purpose of this method is to convert those string value into integers and assign it to the appropriate
     * integer instance variables.
     *
     * @param Stats An array of Strings containing integer values of some of the Player's stats
     */
    private void setStats(String[] Stats){
        // This assumes that the strings in the array are in the order of HP, Str, and then prayer.
        for (int i = 0; i < Stats.length; i++) {
            if (i==0){
                setHitPointsLevel(Integer.parseInt(Stats[i]));
            } else if (i==1) {
                setStrengthLevel(Integer.parseInt(Stats[i]));;
            } else if (i==2) {
                setPrayerLevel(Integer.parseInt(Stats[i]));
            } else {
                // Testing else clause to output an error msg just in case.
                System.out.print("The setStats method had some sort of error.");
            }
        }
    }

    /**
     * The {@code setTotalEquipmentStrengthBonus} method extracts the data from the argument, {@code StrBonuses} and
     * uses it to obtain the total strength bonuses based on the player's worn equipment.
     *
     * @param StrBonuses
     */
    private void setTotalEquipmentStrengthBonuses(String[] StrBonuses){
        int totalStrengthBonus = 0;

        for (int i = 0; i < StrBonuses.length; i++) {
            // The last value in the array is the special attack weapon. We need to create two total str bonus vars.
            //  One with the spec wep, one with the dharok axe. Create them here while also obtaining the special
            //   attack weapon and storing it.
            if (i+1 == StrBonuses.length){
                totalEquipmentStrengthBonusSpec = totalStrengthBonus + DamageOutput.getEquipmentStrBonus(StrBonuses[i]);
                totalEquipmentStrengthBonusAxe = totalStrengthBonus + DamageOutput.getEquipmentStrBonus("Dharok Axe");
                setSpecWeapon(StrBonuses[i]);
            // Only the last argument of array is different. Everything else, leading up to it should be added.
            } else {
                int tempStrBonus = DamageOutput.getEquipmentStrBonus(StrBonuses[i]);
                totalStrengthBonus = totalStrengthBonus + tempStrBonus;
            }
        }
        System.out.println("The Player's total str bonus from eqmnt is: " + totalEquipmentStrengthBonusSpec);
        System.out.println("The Player's total str bonus from eqmntAxe is: " + totalEquipmentStrengthBonusAxe);
    }

    private void setStrengthLevel(int str){
        strengthLevel = str;
        System.out.println("The Player's strength level is: " + strengthLevel);
    }

    private void setPrayerLevel(int pray){
        prayLevel = pray;
        System.out.println("The Player's prayer level is: " + prayLevel);
    }

    private void setHitPointsLevel(int hp){
        hpLevel = hp;
        System.out.println("The Player's HP level is: " + hpLevel);
    }

    private void setMaxHitSpec(){
        int maxHit = DamageOutput.calculateMaxDamage(strengthLevel, prayLevel, totalEquipmentStrengthBonusSpec);

        if (specWeapon == "Claws"){
            maxHitSpec = DamageOutput.getDragonClawsSpecDMG(maxHit);
        } else if (specWeapon == "AGS"){
            maxHitSpec = DamageOutput.getAGSSpecDMG(maxHit);
        } else if (specWeapon == "Granite Maul"){
            maxHitSpec = maxHit;
        } else {
            System.out.println("setMaxHitSpec weapon has got an error in it.");
        }
    }

    private void setSpecWeapon (String weapon){
        specWeapon = weapon;
    }

    private void setDharokMaxHitIntervals(){
        dharokMaxHitIntervals = DamageOutput.dharokDamageIntervals
                (strengthLevel, prayLevel, hpLevel, hpLevel, totalEquipmentStrengthBonusAxe, 1);
    }

    // GETTERS/ACCESSORS
    public int getMaxHitSpec(){ return maxHitSpec; }
    public int getStrengthLevel(){
        return strengthLevel;
    }
    public int getHitpointsLevel(){
        return hpLevel;
    }
    public int getPrayerLevel(){
        return prayLevel;
    }
    public int getTotalEquipmentStrengthBonus(){
        return totalEquipmentStrengthBonusSpec;
    }
    public String getSpecWeapon() { return specWeapon; }
    public String getDharokMaxHitIntervals(){ return dharokMaxHitIntervals; }
}
