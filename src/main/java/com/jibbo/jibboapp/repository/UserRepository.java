package com.jibbo.jibboapp.repository;

import com.jibbo.jibboapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // 여기에 아무것도 안 써도 됨! (Spring이 자동 구현)
}
