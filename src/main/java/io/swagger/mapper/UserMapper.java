package io.swagger.mapper;

import io.swagger.Exception.ApiException;
import io.swagger.model.Garage;
import io.swagger.model.InlineResponse2002;
import io.swagger.model.InlineResponse2003;
import io.swagger.model.User;
import io.swagger.repository.GarageDao;
import io.swagger.repository.UserDao;
import io.swagger.repository.specification.SearchCriteria;
import io.swagger.repository.specification.UserSpecification;
import io.swagger.security.MD5Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public class UserMapper {

    @Autowired
    private UserDao userDao;

    @Autowired
    private GarageDao garageDao;

    public UserMapper() {
    }

    public User createUser(@Valid User body) throws Exception {
        try {
            if (!userDao.findAll(Specification.where(new UserSpecification(new SearchCriteria("username", ":",
                    body.getUsername())))).isEmpty()) {
                throw new ApiException(400, "Username already exists");
            }
            body.setPassword(MD5Hashing.hash(body.getPassword()));
            body.setId(null);
            userDao.save(body);
            return body;
        } catch (Exception e) {
            throw new ApiException(400, e.getMessage());
        }
    }

    public void deleteUserById(Integer id) throws ApiException {
        if (userDao.existsById(id)) {
            userDao.deleteById(id);
            List<Garage> list = garageDao.findAll();
            for (Garage garage : list) {
                if (garage.getIdPartner().equals(id)) {
                    garageDao.deleteById(garage.getId());
                }
            }
        } else throw new ApiException(404, "User not found");

    }

    public InlineResponse2002 getUser(@Valid String name, @Valid String username, @Valid String email, @Valid String status) {
        UserSpecification spec1 = null;
        UserSpecification spec2 = null;
        UserSpecification spec3 = null;
        UserSpecification spec4 = null;
        if (name != null) {
            spec1 = new UserSpecification(new SearchCriteria("name", ":", name));
        }
        if (username != null) {
            spec2 = new UserSpecification(new SearchCriteria("username", ":", username));
        }
        if (email != null) {
            spec3 = new UserSpecification(new SearchCriteria("email", ":", email));
        }
        if (status != null) {
            spec4 = new UserSpecification(new SearchCriteria("status", ":", User.StatusEnum.fromValue(status)));
        }
        InlineResponse2002 inlineResponse2002 = new InlineResponse2002();
        inlineResponse2002.setData(userDao.findAll(Specification.where(spec1).and(spec2).and(spec3).and(spec4)));
        return inlineResponse2002;
    }

    public InlineResponse2003 getUserById(Integer id) throws ApiException {

        if (userDao.existsById(id)) {
            Optional<User> user = userDao.findById(id);
            InlineResponse2003 inlineResponse2003 = new InlineResponse2003();
            user.ifPresent(inlineResponse2003::setData);
            return inlineResponse2003;
        } else throw new ApiException(404, "User not Found");
    }

    public User updateUserById(Integer id, @Valid User body) throws Exception {
        if (id.equals(body.getId()) && userDao.existsById(id)) {
            Optional<User> user = userDao.findById(id);
            if (user.isPresent()) {
                if (!(user.get().getPassword().equals(body.getPassword()))) {
                    body.setPassword(MD5Hashing.hash(body.getPassword()));
                }
            }
            List<User> luser = userDao.findAll(Specification.where(new UserSpecification(new SearchCriteria("username", ":", body.getUsername()))));
            if (!luser.isEmpty()) throw new ApiException(400, "Username already exists");
            userDao.save(body);
            user = userDao.findById(id);
            if (user.isPresent()) {
                return user.get();
            } else throw new ApiException(400, "Bad Request");
        } else throw new ApiException(404, "User not Found");
    }

    public void login(User body) throws Exception {
        UserSpecification spec2 = new UserSpecification(new SearchCriteria("username", ":", body.getUsername()));
        List<User> users = userDao.findAll(Specification.where(spec2));
        if (!(users.isEmpty())) {
            if (MD5Hashing.hash(body.getPassword()).equals(users.get(0).getPassword())) {
                return;
            }
        }
        throw new ApiException(401, "Bad Credentials");
    }

}
