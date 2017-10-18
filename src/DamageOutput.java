/**
 * Created by Hamza on 2017-09-22.
 */
/*A doc comment is written in HTML and must precede a class, field, constructor or method declaration. It is made up of
 two parts -- a description followed by block tags. In this example, the block tags are @param, @return, and @see.

Javadoc makes an API documentation of your own class using your own descriptions
*/


/**
 * This class's purpose is to output the maximum damage a Player can do based on their
 * stats. Its sole purpose is to calculate the damage and nothing else.
 *
 * @author Hamza Khurram *
 * @version 1.0
 * @since 2017-10-03
 */
public final class DamageOutput {
    // DOUBLE CONSTANTS
    private static final double BURST_OF_STRENGTH_MULTIPLIER = 1.05;
    private static final double SUPERHUMAN_STRENGTH_MULTIPLIER = 1.10;
    private static final double ULTIMATE_STRENGTH_MULTIPLIER = 1.15;
    private static final double CHIVALRY_MULTIPLIER = 1.18;
    private static final double PIETY_MULTIPLIER = 1.23;
    // INTEGER CONSTANTS
    private static final int AMULET_OF_FURY_STR_BONUS = 8;
    private static final int AMULET_OF_STRENGTH_STR_BONUS = 10;
    private static final int AMULET_OF_GLORY_STR_BONUS = 6;
    private static final int AMULET_OF_TORTURE_STR_BONUS = 10;
    private static final int DRAGON_BOOTS_STR_BONUS = 4;
    private static final int RUNE_BOOTS_STR_BONUS = 2;
    private static final int CLIMBING_BOOTS_STR_BONUS = 2;
    private static final int INFERNAL_CAPE_STR_BONUS = 8;
    private static final int FIRE_CAPE_STR_BONUS = 4;
    private static final int BARROWS_GLOVES_STR_BONUS = 12;
    private static final int DRAGON_GLOVES_STR_BONUS = 9;
    private static final int RUNE_GLOVES_STR_BONUS = 8;
    private static final int MITHRIL_GLOVES_STR_BONUS = 6;
    private static final int COMBAT_BRACELET_STR_BONUS = 6;
    private static final int BERSERKER_RING_IMBUED_STR_BONUS = 8;
    private static final int BERSERKER_RING_STR_BONUS = 4;
    private static final int GODSWORD_STR_BONUS = 132;
    private static final int DRAGON_CLAWS_STR_BONUS = 56;
    private static final int GRANITE_MAUL_STR_BONUS = 79;
    private static final int DHAROK_AXE_STR_BONUS = 105;
    private static final int PRIMORDIAL_BOOTS_STR_BONUS = 5;

    // Ensures class cannot be instantiated
    private DamageOutput (){}
    /**
     * The {@code getSuperStrengthPotionBonus} consumes an integer, {@code strength}, to produce an integer which
     * depicts the extra strength levels a super strength potion will give the player.
     *
     * @param strength
     * @return The integer value of the strength bonus a super strength potion will yield, given the Player's strength
     * level.
     */
    private static int getSuperStrengthPotionBonus(int strength){
        int potionStrengthBonus = (int) (5 + (0.15 * strength));
        System.out.println("The Player's strength level after potting is boosted by: " + potionStrengthBonus);
        return potionStrengthBonus;
    }

    /**
     * The {@code getEquipmentStrBonus} method consumes a String {@code Equipment} to produce an integer that represents
     * the strength bonus of the item specified by {@code Equipment}.
     * <p>
     * Note: This has been fully tested and works perfectly.
     *
     * @param Equipment
     * @return The strength bonus of the associated parameter. It defaults to 0 if an unknown String value is given.
     */
    public static int getEquipmentStrBonus(String Equipment) {
        int equipmentStrengthBonus;

        switch (Equipment.toLowerCase()) {
            case "dragon boots":
                equipmentStrengthBonus = DRAGON_BOOTS_STR_BONUS;
                break;
            case "rune/climbing boots":
                equipmentStrengthBonus = RUNE_BOOTS_STR_BONUS;
                break;
            case "infernal cape":
                equipmentStrengthBonus = INFERNAL_CAPE_STR_BONUS;
                break;
            case "fire cape":
                equipmentStrengthBonus = FIRE_CAPE_STR_BONUS;
                break;
            case "barrow gloves":
                equipmentStrengthBonus = BARROWS_GLOVES_STR_BONUS;
                break;
            case "dragon gloves":
                equipmentStrengthBonus = DRAGON_GLOVES_STR_BONUS;
                break;
            case "rune gloves":
                equipmentStrengthBonus = RUNE_GLOVES_STR_BONUS;
                break;
            case "combat bracelet":
                equipmentStrengthBonus = COMBAT_BRACELET_STR_BONUS;
                break;
            case "torture amulet":
                equipmentStrengthBonus = AMULET_OF_TORTURE_STR_BONUS;
                break;
            case "fury amulet":
                equipmentStrengthBonus = AMULET_OF_FURY_STR_BONUS;
                break;
            case "glory amulet":
                equipmentStrengthBonus = AMULET_OF_GLORY_STR_BONUS;
                break;
            case "strength amulet":
                equipmentStrengthBonus = AMULET_OF_STRENGTH_STR_BONUS;
                break;
            case "ags":
                equipmentStrengthBonus = GODSWORD_STR_BONUS;
                break;
            case "claws":
                equipmentStrengthBonus = DRAGON_CLAWS_STR_BONUS;
                break;
            case "granite maul":
                equipmentStrengthBonus = GRANITE_MAUL_STR_BONUS;
                break;
            case "berserker ring (i)":
                equipmentStrengthBonus = BERSERKER_RING_IMBUED_STR_BONUS;
                break;
            case "dharok axe":
                equipmentStrengthBonus = DHAROK_AXE_STR_BONUS;
                break;
            case "berserker ring":
                equipmentStrengthBonus = BERSERKER_RING_STR_BONUS;
                break;
            case "primordial boots":
                equipmentStrengthBonus = PRIMORDIAL_BOOTS_STR_BONUS;
                break;
            default:
                equipmentStrengthBonus = 0;
                break;
        }
        System.out.println(Equipment + " has a str bonus of: " + equipmentStrengthBonus);
        return equipmentStrengthBonus;
    }

    /**
     * The {@code calculateDamage} method is the central method that does the main calculation.
     * <p>
     * It consumes three integers, {@code strength}, {@code prayer} and {@code wornStrengthBonus},
     * to produce an integers that outputs the maximum damage possible.
     *
     * @param strength The Player's strength level
     * @param prayer The Player's prayer level
     * @param wornStrengthBonus The Player's strength bonus from their equipment level
     * @return The maximum possible damage output the player can produce, given their stats and equipment.
     */
    public static int calculateMaxDamage(int strength, int prayer, int wornStrengthBonus){
        // Must have it as 640.0 otherwise the division will automatically floor the value, which is stupid.
        double damage =  0.5 + (effectiveLevel(strength, prayer) * ((wornStrengthBonus + 64) / 640.0));
        System.out.println("The calculateDamage method aka maxhit produced: " + damage);
        return (int) damage;
    }

    /**
     * The {@code effectiveLevel} method consumes two integers, {@code strength} and {@code prayer}, to produce an
     * integer value representing the player's effective strength level.
     * <p>
     * Note: Identical to the website's formula, checked already.
     *
     * @param strength
     * @param prayer
     * @return The effective strength level of the Player.
     */
    private static int effectiveLevel(int strength, int prayer){
        int physicalLevel = ((((int) ((strength + getSuperStrengthPotionBonus(strength)) *
                getPrayerBonusMultiplier(prayer))) + 3) + 8);

        return physicalLevel;
    }

    /**
     * {@code getPrayerBonusMultiplier} consumes an integer, prayer, to produce a double which represents the
     * strength level multiplier the given player possesses, based on their prayer level.
     *
     * @param prayer
     * @return The appropriate prayer multiplier based on your prayer level.
     */
    private static double getPrayerBonusMultiplier(int prayer){
        double multiplier;

        if (prayer >= 70){
            multiplier = PIETY_MULTIPLIER;
        }else if (prayer >= 60){
            multiplier = CHIVALRY_MULTIPLIER;
        }else if (prayer >= 31){
            multiplier = ULTIMATE_STRENGTH_MULTIPLIER;
        }else if (prayer >= 13){
            multiplier = SUPERHUMAN_STRENGTH_MULTIPLIER;
        }else if (prayer >= 4){
            multiplier = BURST_OF_STRENGTH_MULTIPLIER;
        } else {
            multiplier = 1;
        }
        return multiplier;
    }

    /**
     * {@code dharokDamageMultiplier} consumes two ints, {@code currentHP} and {@code maxHP}, to produce a double that
     * represents the bonus damage multiplier the Dharok armour offers.
     *
     * @param currentHP
     * @param maxHP
     * @return The Dharok-set damage multiplier.
     */
    private static double dharokDamageMultiplier(int currentHP, int maxHP){
        return (1 + ((maxHP - currentHP)/100.0 * maxHP/100.0));
    }

    /**
     * {@code calculateMaximumDharokDamage} consumes 5 ints, {@code str}, {@code pray}, {@code currentHP}, {@code maxHP}
     * and {@code wornStrengthBonus}, to produce the maximum damage possible, based on these parameters.
     *
     * @param str
     * @param pray
     * @param currentHP
     * @param maxHP
     * @param wornStrengthBonus
     * @return Maximum damage possible with given parameters.
     */
    public static int calculateMaximumDharokDamage(int str, int pray, int currentHP, int maxHP, int wornStrengthBonus){
        return (int) (calculateMaxDamage(str, pray, wornStrengthBonus) * dharokDamageMultiplier(currentHP, maxHP));
    }

    /**
     * {@code dharokDamageIntervals}is a recurssive method that consumes 6 ints, {@code str}, {@code pray},
     * {@code currentHP}, {@code maxHP} , {@code wornStrengthBonus} and {@code i} to produce a String that will output
     * the maximum damage possible, with 5hp intervals.
     *
     * @param str
     * @param pray
     * @param currentHP
     * @param maxHP
     * @param wornStrBonus
     * @param counter counter that tracks how many times the recursive method reiterates.
     * @return 5HP intervals of maximum possible damage.
     */
    public static String dharokDamageIntervals(int str, int pray, int currentHP, int maxHP, int wornStrBonus,
                                               int counter){
        // Checks to see if the number has 5 as a factor.
        if (currentHP % 5 != 0){
            // The division statement truncates the value (i.e. 54/5 = 10) and multiplying value by 5, giving a clean
            //  and closest number that is less than original HP that is also divisible by 5. This is the return value
            //   we Recurse.
            return "" + currentHP + " HP: " +
                    ("" + calculateMaximumDharokDamage(str, pray, currentHP, maxHP, wornStrBonus)) + " DMG" +
                    lineFormatter(currentHP, counter) + dharokDamageIntervals(str, pray, (5 * (currentHP / 5)), maxHP,
                    wornStrBonus, ++counter);
            // Desired Output should be: "currentHP HP: MaxHit DMG"
        // The very last if statement that is to be executed at the end.
        }else if (currentHP == 0){
            // If HP is 0, display the damage outputted when HP is 1.
            return (" 1 HP: " + "" + calculateMaximumDharokDamage(str, pray, 1,maxHP, wornStrBonus) + " DMG");
        } else if (currentHP % 5 == 0){
            // currentHP value is already what we want it to be so calculate damage using it, then recurse it back,
            //  but smaller.
            return "" + currentHP + " HP: " +
                    ("" + calculateMaximumDharokDamage(str, pray, currentHP, maxHP, wornStrBonus)) + " DMG" +
                    lineFormatter(currentHP, counter) + dharokDamageIntervals(str, pray, (currentHP - 5), maxHP,
                    wornStrBonus, ++counter);
        } else {
            // Something messed up so send that.
            return "Interval Error";
        }
    }

    /**
     * {@code lineFormatter} consumes 2 ints, {@code hp} and {@code i} to produce a String that formats the intervals
     * of dharok damage.
     *
     * @param hp
     * @param counter
     * @return String that helps formatting the intervals of the dharok damages
     */
    private static String lineFormatter(int hp, int counter){
        // Check if divisible by 3 and if > 0. Line break if so.
        if (counter > 0 && counter % 3 == 0){
            return "\n";
        } else {
            return "             ";
        }
    }

    /**
     * {@code getDragonClawsSpecDMG} consumes an integer, {@code maxHit}, to produce the maximum damage the dragon claws
     * special attack should output.
     * <p>
     * Note: This may be slightly inaccurate. Haven't really tested. Read some weird shit about dragon claws damage.
     *
     * @param maxHit
     * @return Max hit Dragon Claws can spec out.
     */
    public static int getDragonClawsSpecDMG(int maxHit){
        return maxHit + (maxHit / 2) + ((maxHit/4)*2);
    }

    /**
     * {@code getAGSSpecDMG} consumes an integer, {@code maxHit}, to produce the maximum damage the AGS
     * special attack should output.
     *
     * @param maxHit
     * @return Max hit AGS can spec out.
     */
    public static int getAGSSpecDMG(int maxHit){
        return (int) ((Math.floor(maxHit * 1.1))*1.25);
    }
}
