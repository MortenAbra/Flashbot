package model;

public class FlashboiTrialModel extends FlashUser{
    /**
     * @param coins
     * @param user
     */
    public FlashboiTrialModel(int coins, String user) {
        super(coins, user);
    }

    @Override
    public String toString() {
        return "Trial member: " + getUser() + " " + getCoins() + " " + getUserRoleIDs();
    }
}
