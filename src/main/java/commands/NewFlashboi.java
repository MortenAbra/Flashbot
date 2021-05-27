package commands;

import model.FlashUser;
import model.FlashboiModel;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import service.IUserHandler;

public class NewFlashboi extends Command  {

    private Message message;
    private FlashUser user;
    private IUserHandler userHandler;

    public NewFlashboi(){
        this.setPrefix("!addFlashboi");
        this.userHandler = getUserHandler();
    }

    @Override
    public void handle(MessageReceivedEvent event) {
        message = event.getMessage();

        if(event.getMessage().getContentRaw().startsWith(getPreix())){
            this.user = new FlashboiModel(0, message.getMentionedMembers().get(0).getId());

            for (Role roles : message.getMentionedMembers().get(0).getRoles()) {
                user.getUserRoleIDs().add(roles.getId());
            }
            userHandler.addUserToList(user);
            System.out.println(user.toString());
            sendChannelMessage(event, "Welcome to the Flashbois: " + message.getMentionedMembers().get(0).getAsMention(), false, null);
        }

    }

    @Override
    public String toString() {
        return "NewFlashboi{" +
                "message=" + message +
                ", user=" + user +
                '}';
    }
}