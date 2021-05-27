package commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import service.IUserHandler;

public class FlashUserCoins extends Command{

    private IUserHandler userHandler;
    private Message message;

    public FlashUserCoins(){
        this.userHandler = getUserHandler();
        this.setPrefix("!coins");
    }

    @Override
    public void handle(MessageReceivedEvent event) {
        message = event.getMessage();

        if(event.getMessage().getContentRaw().startsWith(getPreix())){
            System.out.println("Getting user flash coins!");
            System.out.println(userHandler.getFlashUserList().toString());
            sendChannelMessage(event, message.getMentionedMembers().get(0).getAsMention() + ": \n"
                    + "Flash coins: "
                    + userHandler.getFlashUserById(message.getMentionedMembers().get(0).getId()).getCoins(), false, null);
        }
    }
}
