package by.bsuir.hotel.command.factory;

import by.bsuir.hotel.command.Command;
import by.bsuir.hotel.command.user.LoginUserCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public enum CommandFactory {
    INSTANCE;

    public Command defineCommand(HttpServletRequest request){
        Command current = null;
        String commandName = request.getParameter("command");
        if(commandName == null){
            HttpSession session = request.getSession();
            String userType = (String)session.getAttribute("userType");
            if(userType != null) {
                if (userType.equals("ROLE_ADMIN")) {
                    commandName = "SHOWADMINPAGE";
                } else if (userType.equals("ROLE_CLIENT")) {
                    commandName = "SHOWCLIENTPAGE";
                }
            }
        }
        try{
            CommandType type = CommandType.valueOf(commandName.toUpperCase());
            current = type.getCurrentCommand();
        }
        catch(NullPointerException e){
            current = new LoginUserCommand();
        }
        catch(IllegalArgumentException e){
            current = new LoginUserCommand();
        }
        return current;
    }
}
