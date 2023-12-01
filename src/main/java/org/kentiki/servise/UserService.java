package org.kentiki.servise;

import org.kentiki.domain.User;

import java.util.List;

public interface UserService {

    void insert(User user);

    List<User> getAll();

    User getById(int id);

    void update(int id, String name, int currentAction);

    void deleteById(int id);
}
