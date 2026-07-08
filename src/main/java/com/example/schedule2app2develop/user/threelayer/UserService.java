package com.example.schedule2app2develop.user.threelayer;

import com.example.schedule2app2develop.user.dto.UserCreateRequest;
import com.example.schedule2app2develop.user.dto.UserCreateResponse;
import com.example.schedule2app2develop.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
