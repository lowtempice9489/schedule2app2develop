package com.example.schedule2app2develop.user.threelayer;

import com.example.schedule2app2develop.schedule.dto.SdGetAllResponse;
import com.example.schedule2app2develop.user.dto.UserCreateRequest;
import com.example.schedule2app2develop.user.dto.UserCreateResponse;
import com.example.schedule2app2develop.user.dto.UserGetAllResponse;
import com.example.schedule2app2develop.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository urRepository;

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
                .map(User -> new UserGetAllResponse(
                        User.getId(),
                        User.getUsername(),
                        User.getEmail(),
                        User.getCreatedAt(),
                        User.getModifiedAt()
                )).toList();

    }
}
