package com.example.schedule2app2develop.user.threelayer;

import com.example.schedule2app2develop.user.dto.*;
import com.example.schedule2app2develop.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository urRepository;

    @Transactional
    public UserCreateResponse create(UserCreateRequest request) {
        User Ur = new User(
                request.getUsername(),
                request.getEmail()

        );
        User created = urRepository.save(Ur);
        return new UserCreateResponse(
                created.getId(),
                created.getUsername(),
                created.getEmail(),
                created.getCreatedAt(),
                created.getModifiedAt()
        );
    }
    @Transactional(readOnly = true)
    public List<UserGetAllResponse> getAll() {
        List<User> urs = urRepository.findAll();
        return urs.stream()
                .map(user -> new UserGetAllResponse(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getCreatedAt(),
                        user.getModifiedAt()
                )).toList();

    }
    @Transactional(readOnly = true)
    public UserGetOneResponse getOne(Long userId) {
        User user = urRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 유저입니다.")
        );
        return new UserGetOneResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }
    @Transactional
    public UserUpdateResponse update(Long userId, UserUpdateRequest request) {
        User user = urRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 유저입니다.")
        );
        user.update(request.getUsername(), request.getEmail());
        return new UserUpdateResponse(user.getId(), user.getUsername(), user.getEmail(), user.getModifiedAt());
    }
    @Transactional
    public void delete(Long userId) {
        boolean existence = urRepository.existsById(userId);
        if (!existence) {
            throw new IllegalStateException("없는 유저입니다.");
        }
        urRepository.deleteById(userId);
    }
}
