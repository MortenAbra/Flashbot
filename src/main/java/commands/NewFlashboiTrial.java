package commands;

import model.FlashboiTrialModel;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import service.IUserHandler;

public class NewFlashboiTrial extends Command {

    private IUserHandler userHandler;
    private Message message;

    public NewFlashboiTrial(){
        this.userHandler = getUserHandler();
        this.setPrefix("!addTrialMember");
    }

    @Override
    public void handle(MessageReceivedEvent event) {
        message = event.getMessage();
        if(event.getMessage().getContentRaw().startsWith(getPreix())){
            userHandler.addUserToList(new FlashboiTrialModel(0, message.getMentionedMembers().get(0).getId()));
            sendChannelMessage(event, "Welcome to the trial membershib program for Flashbois: "
                    + message.getMentionedMembers().get(0).getAsMention(), false, null);
        }

    }
}
