package crud.dao;

import crud.models.User;

import java.util.List;

public interface UserDAO {
    public List<User> index();

    public User show(Long id);

    public void save(User user);

    public void update(Long id, User updUser);

    public void delete(Long id);
}
