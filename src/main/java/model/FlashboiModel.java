package model;

public class FlashboiModel extends FlashUser {

    public FlashboiModel(int coins, String user) {
        super(coins, user);
        //TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Flashboi: " + getUser() + " " + getCoins() + " " + getUserRoleIDs();
    }



}