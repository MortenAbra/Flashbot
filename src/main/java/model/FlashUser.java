package model;

import java.util.HashSet;

public abstract class FlashUser {

    private int coins;
    private String user;
    private HashSet<String> userRoleIDs;
    /**
     * @return the coins
     */
    public int getCoins() {
        return coins;
    }
    /**
     * @param coins the coins to set
     */
    public void setCoins(int coins) {
        this.coins = coins;
    }
    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + coins;
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((userRoleIDs == null) ? 0 : userRoleIDs.hashCode());
        return result;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        FlashUser other = (FlashUser) obj;
        if (coins != other.coins) {
            return false;
        }
        if (user == null) {
            if (other.user != null) {
                return false;
            }
        } else if (!user.equals(other.user)) {
            return false;
        }
        if (userRoleIDs == null) {
            if (other.userRoleIDs != null) {
                return false;
            }
        } else if (!userRoleIDs.equals(other.userRoleIDs)) {
            return false;
        }
        return true;
    }
    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }
    /**
     * @return the userRoleIDs
     */
    public HashSet<String> getUserRoleIDs() {
        return userRoleIDs;
    }
    /**
     * @param userRoleIDs the userRoleIDs to set
     */
    public void setUserRoleIDs(HashSet<String> userRoleIDs) {
        this.userRoleIDs = userRoleIDs;
    }
    /**
     * @param coins
     * @param user
     */
    public FlashUser(int coins, String user) {
        this.coins = coins;
        this.user = user;
        this.userRoleIDs = new HashSet<>();
    }


}