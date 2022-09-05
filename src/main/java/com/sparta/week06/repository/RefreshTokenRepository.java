package com.sparta.week06.repository;


import com.sparta.week06.domain.RefreshToken;
import com.sparta.week06.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
  Optional<RefreshToken> findByUser(User user);
}
