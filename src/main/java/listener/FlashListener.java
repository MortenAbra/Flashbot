package listener;

import java.io.File;
import java.util.ServiceLoader;

import commands.Command;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class FlashListener extends ListenerAdapter {

    private String adminRoleID = "845057230196965376";
    private Role role;
    private File file = new File("src/main/resources/images/yikes.jpeg");
    private MessageChannel channel;
    private ServiceLoader<Command> loader;

    public FlashListener() {
        this.loader = ServiceLoader.load(Command.class);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        this.channel = event.getChannel();
        role = event.getGuild().getRoleById(adminRoleID);
        boolean hasRole = event.getMessage().getMember().getRoles().contains(role);

        if (!event.getAuthor().isBot() && hasRole) {
            for (Command command :
                    loader) {
                command.handle(event);
            }
        } else if(!event.getAuthor().isBot()){
            channel.sendMessage("Yikes. \n You need the right permissions to do that!").addFile(file).queue();
        }
    }

}