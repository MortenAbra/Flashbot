package service;

import model.FlashUser;

import java.util.HashSet;

public interface IUserHandler {

    HashSet<FlashUser> flashUserList = new HashSet<>();

    HashSet getFlashUserList();

    void addUserToList(FlashUser user);

    void removeUserFromList(FlashUser user);

    FlashUser getFlashUserById(String userID);

    void addCoinsToUser(String id, int amount);

    void removeCoinsFromUser(String id, int amount);

}