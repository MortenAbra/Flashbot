package commands;

import java.io.File;

//https://www.journaldev.com/31602/java-spi-service-provider-interface-and-serviceloader

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import service.IUserHandler;
import service.UserHandler;

public abstract class Command {

    protected String prefix;
    protected IUserHandler userHandler;
    private MessageChannel channel;

    public Command(){
        this.userHandler = new UserHandler();
    }

    public IUserHandler getUserHandler(){
        return userHandler;
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