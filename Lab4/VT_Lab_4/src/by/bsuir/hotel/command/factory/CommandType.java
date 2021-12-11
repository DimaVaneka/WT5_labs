package by.bsuir.hotel.command.factory;

import by.bsuir.hotel.command.Command;
import by.bsuir.hotel.command.admin.AddHotelCommand;
import by.bsuir.hotel.command.admin.DeleteHotelCommand;
import by.bsuir.hotel.command.admin.ShowAdminPageCommand;
import by.bsuir.hotel.command.client.CancelReservationCommand;
import by.bsuir.hotel.command.client.ReserveHotelCommand;
import by.bsuir.hotel.command.client.ShowClientHotelsCommand;
import by.bsuir.hotel.command.user.LoginUserCommand;
import by.bsuir.hotel.command.user.LogoutUserCommand;
import by.bsuir.hotel.command.util.LocalizationCommand;

public enum CommandType {

    //user commands
    LOGIN, LOGOUT,

    //client commands
    RESERVEHOTEL, SHOWCLIENTPAGE, CANCELRESERVATION,

    //admin commands
    ADDHOTEL, SHOWADMINPAGE, DELETEHOTEL,

    //util
    LOCALIZATION;

    public Command getCurrentCommand() throws EnumConstantNotPresentException{
        switch (this){
            case LOGIN:
                return new LoginUserCommand();

            case LOGOUT:
                return new LogoutUserCommand();

            case RESERVEHOTEL:
                return new ReserveHotelCommand();

            case SHOWCLIENTPAGE:
                return new ShowClientHotelsCommand();

            case ADDHOTEL:
                return new AddHotelCommand();

            case SHOWADMINPAGE:
                return new ShowAdminPageCommand();

            case CANCELRESERVATION:
                return new CancelReservationCommand();

            case DELETEHOTEL:
                return new DeleteHotelCommand();

            case LOCALIZATION:
                return new LocalizationCommand();

            default:
                throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name());
        }
    }

}
