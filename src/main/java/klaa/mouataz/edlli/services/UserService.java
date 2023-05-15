package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.model.User;

import java.util.List;

public interface UserService {
    User getById(Integer id);
    List<User> getAll();
    User save(User user);
    void deleteById(Integer id);
    User updateUser(User user);
}
