## Welcome to FlashBot

FlashBot is a discord bot developed with the Java Discord Wrapper (JDA).

### Setup
Create a ".env" file in the resources folder with the following tags:

```java
TOKEN="Insert_Discord_Bot_token_here"
```

### Extendability
The FlashBot is developed with extendability in mind. 
By utilizing the Java ServiceProvider we enable new custom Commands.

To add new commands do the following:
```java
public class MyNewCommand extends Command {

  public MyNewCommand(){}

  @Override
  public void handle(MessageReceivedEvent event){
    //Perform your command
  }  
}
```

Afterwards, add the command as a service in the "META-INF/services/commands.Command"

```java
commands.MyNewCommand
```

Build and run the bot.


## Examples
A simple command which replies to a user message with prefix: !hello
```java
public class MyNewCommand extends Command {
  
  private MessageChannel channel;
  private String prefix;

  public MyNewCommand(){
    this.prefix = "!hello";
  }

  @Override
  public void handle(MessageReceivedEvent event){
    this.channel = event.getChannel();
    if(event.getMessage().getContentRaw().startsWith(prefix)){
      channel.sendMessage("Hello:" + event.getAuthor().getAsMention()).queue();
    }
  }  
}
```
Following example will reply with:
```
ExampleUser message: !hello
Bot reply: Hello ExampleUser
```
