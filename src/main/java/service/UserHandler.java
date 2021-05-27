package service;

import model.FlashUser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class UserHandler implements IUserHandler {

    private FileWriter writer;

    @Override
    public HashSet getFlashUserList() {
        return flashUserList;
    }
    @Override
    public void addUserToList(FlashUser user) {
        flashUserList.add(user);
        try {
            saveUserToList(user);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    @Override
    public void removeUserFromList(FlashUser user) {
        flashUserList.remove(user);

    }
    @Override
    public FlashUser getFlashUserById(String flashID) {
        for (FlashUser flashUser : flashUserList) {
            if(flashUser.getUser().equals(flashID)){
                return flashUser;
            }
        }
        return null;
    }
    @Override
    public void addCoinsToUser(String id, int amount) {
        FlashUser user = getFlashUserById(id);
        int currentCoins = user.getCoins();
        user.setCoins(currentCoins += amount);
    }
    @Override
    public void removeCoinsFromUser(String id, int amount) {
        FlashUser user = getFlashUserById(id);
        int currentCoins = user.getCoins();
        if((currentCoins-amount) >= 0){
            user.setCoins(currentCoins -= amount);
        } else {
            user.setCoins(0);
        }
    }

    public void saveUserToList(FlashUser user) throws IOException{
        Gson gson = new Gson();
        writer = new FileWriter(new File("src/main/resources/backup/user.json"));
        JsonArray userArray = new JsonArray();
        userArray.add(gson.toJson(user));
               
        writer.write(userArray.getAsString());
        
    }
}