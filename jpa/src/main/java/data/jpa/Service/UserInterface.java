package data.jpa.Service;

import data.jpa.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserInterface {

    Optional<User> findById(int id);
    void createUser(User user);
    void deleteById(int id);
    List<User> findAll();
}
