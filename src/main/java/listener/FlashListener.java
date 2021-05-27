package listener;

import java.util.ServiceLoader;

import commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class FlashListener extends ListenerAdapter {

    private ServiceLoader<Command> loader;

    public FlashListener() {
        this.loader = ServiceLoader.load(Command.class);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (!event.getAuthor().isBot()) {
            for (Command command : loader) {
                command.handle(event);
            }
        }
    }
}