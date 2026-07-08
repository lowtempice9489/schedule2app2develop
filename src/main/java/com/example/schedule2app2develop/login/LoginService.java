package com.example.schedule2app2develop.login;

import com.example.schedule2app2develop.user.entity.User;
import com.example.schedule2app2develop.user.threelayer.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository urRepository;

    @Transactional
    public Long login(LoginRequest request) {
        User user = urRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 이메일입니다.")
        );
        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
        return user.getId();
    }
}
