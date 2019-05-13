package io.swagger.mapper;

import io.swagger.Exception.ApiException;
import io.swagger.model.InlineResponse2002;
import io.swagger.model.InlineResponse2003;
import io.swagger.model.User;
import io.swagger.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.Optional;

public class UserMapper {

    @Autowired
    private UserDao userDao;

    public UserMapper() {
    }

    public User createUser(@Valid User body) throws Exception {
        try {
            userDao.save(body);
            return body;
        } catch (Exception e) {
            throw new ApiException(400, e.getMessage());
        }
    }

    public void deleteUserById(Integer id) throws ApiException {
        if (userDao.existsById(id)) {
            userDao.deleteById(id);
        }
        throw new ApiException(404, "User not found");

    }

    public InlineResponse2002 getUser(@Valid String searchByName, @Valid String username, @Valid String email, @Valid String status) {
        InlineResponse2002 inlineResponse2002 = new InlineResponse2002();
        inlineResponse2002.setData(userDao.findAll());
        return inlineResponse2002;
    }

    public InlineResponse2003 getUserById(Integer id) throws ApiException {

        if (userDao.existsById(id)) {
            Optional<User> user = userDao.findById(id);
            InlineResponse2003 inlineResponse2003 = new InlineResponse2003();
            inlineResponse2003.setData(user.get());
            return inlineResponse2003;
        } else throw new ApiException(404, "User not Found");
    }

    public User updateUserById(Integer id, @Valid User body) throws ApiException {
        if (id.equals(body.getId()) && userDao.existsById(id)) {
            userDao.deleteById(id);
            userDao.save(body);
            return body;
        } else throw new ApiException(404, "User not Found");
    }

}
