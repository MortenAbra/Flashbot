package bot;
import listener.FlashListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

import io.github.cdimascio.dotenv.Dotenv;

public class FlashBot {

    private JDA bot;

    public FlashBot() throws LoginException {
        Dotenv env = Dotenv.load();
        bot = JDABuilder.createDefault(env.get("TOKEN")).build();
        bot.addEventListener(new FlashListener());
    }

    public static void main(String[] args) throws LoginException {
        new FlashBot();
    }
}