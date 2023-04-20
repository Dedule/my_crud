package crud.service;

import crud.models.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();
    void save(User user);

    User show(Long id);

    void update(Long id, User updUser);

    void delete(Long id);
}
