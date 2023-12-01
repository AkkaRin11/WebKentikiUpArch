package org.kentiki.servise;

import lombok.RequiredArgsConstructor;
import org.kentiki.domain.User;
import org.kentiki.repository.ImgRepository;
import org.kentiki.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public void insert(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void update(int id, String name, int currentAction) {
        User img = User.builder()
                .id(id)
                .name(name)
                .currentAction(currentAction)
                .build();
        userRepository.save(img);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
