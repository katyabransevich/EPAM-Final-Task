package by.epam.finaltask.facultative.controller.helper;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.CommandName;
import by.epam.finaltask.facultative.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandHelp {
    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandHelp(){

        commands.put(CommandName.LOGIN, new AuthorizationCommand());
        commands.put(CommandName.REGISTRATION, new RegistrationCommand());
        commands.put(CommandName.APPLY, new ApplyCommand());
        commands.put(CommandName.STUDENTGROUP, new GroupStudentCommand());
        commands.put(CommandName.COURSE, new ViewCourseCommand());
        commands.put(CommandName.UPDATE, new UpdateMarkCommentCommand());
        commands.put(CommandName.BACKVIEWCOURSESTUDENT, new BackViewCourseStudentCommand());
        commands.put(CommandName.SIGN_OUT, new SignOutCommant());
        commands.put(CommandName.UPDATE_USER, new UpdateStudent());
        commands.put(CommandName.SAVE_USER, new SaveStudent());




    }


    public Command getCommand(String commandName){
        Command command = null;
        CommandName key = null;

        commandName = commandName.replace('-', '_').toUpperCase();
        key = CommandName.valueOf(commandName);

        command = commands.get(key);

        if(command == null){
            command =  new UnknownCommand();
        }

        return command;
    }

}
