package commands;

import java.io.File;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public abstract class Command {

    protected String prefix;
    private MessageChannel channel;

    public Command(){
        
    }



    public String getPreix(){
        return prefix;
    }

    public void setPrefix(String newPrefix){
        this.prefix = newPrefix;
    }

    public void sendChannelMessage(MessageReceivedEvent event, String msg, boolean addFile, File file){
        this.channel = event.getChannel();
        if(addFile){
            channel.sendMessage(msg).addFile(file).queue();
        } else {
            channel.sendMessage(msg).queue();
        }
    }

    public abstract void handle(MessageReceivedEvent event);

}