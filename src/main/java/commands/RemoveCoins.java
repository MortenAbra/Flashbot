package commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import service.IUserHandler;

public class RemoveCoins extends Command{

    private IUserHandler userHandler;
    private Message message;

    public RemoveCoins(){
        this.userHandler = getUserHandler();
        this.setPrefix("!removeCoins");
    }
    @Override
    public void handle(MessageReceivedEvent event) {
        this.message = event.getMessage();

        String msg = event.getMessage().getContentDisplay();
        String[] split = msg.split(" ");
        if(event.getMessage().getContentRaw().startsWith(getPreix())){
            System.out.println(split[2]);
            userHandler.removeCoinsFromUser(message.getMentionedMembers().get(0).getId(), Integer.valueOf(split[2]));
            sendChannelMessage(event, split[2] + " Flash coins has been removed from: " + message.getMentionedMembers().get(0).getAsMention(), false, null);
        }

    }
}
