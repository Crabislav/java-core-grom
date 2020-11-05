package lesson36.controller;

import lesson36.Session;
import lesson36.exceptions.AuthorizationException;
import lesson36.exceptions.BadRequestException;
import lesson36.service.UserService;
import lesson36.model.User;

//presentation layer
public class UserController extends Controller {
    private UserService userService = new UserService();

    //TODO: test
    public User registerUser(User user) throws Exception {
        return userService.registerUser(user);
    }

    //TODO: test
    public void login(String userName, String password) throws Exception {
        userService.login(userName, password);
    }

    public void logout() throws BadRequestException {
        if (Session.getAuthorizedUser() == null) {
            throw new BadRequestException("Can't do logout for null user");
        }
        userService.logout();
    }
}
