package api.services;

import api.domain.datatransferobjects.UserDTO;
import api.exceptions.NotLoggedInException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tomas on 14.12.7.
 */
public interface SessionService {

    public UserDTO getActiveUser(HttpServletRequest request) throws NotLoggedInException;

}
