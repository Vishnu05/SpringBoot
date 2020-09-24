package data.jpa.Service;

import data.jpa.Entity.User;
import data.jpa.Interface.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserServices implements UserInterface{

    // autowired
    public UserRepository userRepository;

    // constructor injection
    public UserServices (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(int id) {

        return userRepository.findById(id);
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
