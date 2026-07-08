package com.example.schedule2app2develop.user.threelayer;

import com.example.schedule2app2develop.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
