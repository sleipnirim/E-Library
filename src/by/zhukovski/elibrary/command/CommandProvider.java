package by.zhukovski.elibrary.command;

import by.zhukovski.elibrary.command.impl.*;

import java.util.HashMap;

/**
 * Created by sleipnir on 18.1.17.
 */
public class CommandProvider {
    private final static CommandProvider INSTANCE = new CommandProvider();

    public static CommandProvider getInstance() {

        return INSTANCE;
    }

    private HashMap<String, Command> commands = new HashMap();

    private CommandProvider() {
        commands.put("add", new AddBook());
        commands.put("index", new Index());
        commands.put("show", new ShowBook());
        commands.put("download", new Download());
        commands.put("delete", new Delete());
        commands.put("edit", new EditBook());
        commands.put("cookies", new GetCookies());
    }

    public Command getCommand (String command){
        return commands.get(command);
    }



}
