package commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import service.IUserHandler;

public class AddCoins extends Command {

    private IUserHandler userHandler;
    private Message message;

    public AddCoins(){
        this.userHandler = getUserHandler();
        this.setPrefix("!addCoins");
    }


    private void addCoinsToUser(MessageReceivedEvent event, Message message){
        String msg = event.getMessage().getContentDisplay().trim().replaceAll(" +", " ");
        String[] split = msg.split(" ");
        userHandler.addCoinsToUser(message.getMentionedMembers().get(0).getId(), Integer.valueOf(split[2]));
        sendChannelMessage(event, split[2] + " Flash coins has been added to: " + message.getMentionedMembers().get(0).getAsMention(), false, null);
    }

    private boolean getRequirements(MessageReceivedEvent event){
        boolean roles = event.getMessage().getContentRaw().startsWith(getPreix()) && !message.getContentRaw().isBlank() && !message.getMentionedMembers().isEmpty() && message.getMentionedMembers().size() == 1;
        return roles;
    }


    @Override
    public void handle(MessageReceivedEvent event) {
        this.message = event.getMessage();
        if(getRequirements(event) == true){
            System.out.println("Mentioned member size: " + message.getMentionedMembers().size());
            addCoinsToUser(event, message);
        }
    }
}
