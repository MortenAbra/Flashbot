package commands;

import model.FlashUser;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import service.IUserHandler;

import java.util.Iterator;

public class AllFlashbois extends Command {

    private IUserHandler userHandler;

    public AllFlashbois(){
        this.userHandler = getUserHandler();
        this.setPrefix("!allFlashbois");
    }

    @Override
    public void handle(MessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().startsWith(getPreix())){
            sendChannelMessage(event, "Members are: ", false, null);

            Iterator it = userHandler.getFlashUserList().iterator();
            while(it.hasNext()){
                FlashUser user = (FlashUser) it.next();
                sendChannelMessage(event, event.getJDA().getUserById(user.getUser()).getAsMention() + "\n", false, null);
            }
        }
    }
}
