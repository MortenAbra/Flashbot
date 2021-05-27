package commands;

import java.util.Iterator;

import model.FlashUser;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import service.IUserHandler;

public class TotalFlashCoins extends Command{

    private IUserHandler userHandler;


    public TotalFlashCoins(){
        this.userHandler = getUserHandler();
        this.setPrefix("!totalFlashCoins");
    }

    @Override
    public void handle(MessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().startsWith(getPreix())){
            System.out.println("Getting all flash coins on server!");
            Iterator it = userHandler.getFlashUserList().iterator();
            int sum = 0;
            while(it.hasNext()){
                FlashUser getUser = (FlashUser) it.next();
                sum += getUser.getCoins();
            }
            sendChannelMessage(event, "Total amount of Flash Coins: " + sum, false, null);
        }
    }
}
