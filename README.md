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

  private IUserHandler userHandler;

  public MyNewCommand(){
    this.userHandler = getUserHandler();
    this.setPrefix("!myPrefix");
  }

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
