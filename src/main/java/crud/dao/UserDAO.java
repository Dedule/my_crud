package crud.dao;

import crud.models.User;

import java.util.List;

public interface UserDAO {
    List<User> index();

    User show(Long id);

    void save(User user);

    void update(Long id, User updUser);

    void delete(Long id);
}
