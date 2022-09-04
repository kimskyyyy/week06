package com.sparta.week06.repository;

import com.sparta.week06.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> { // JpaRepository<엔티티 타입, 식별자 타입>를 상속받아서 기능 구현
}
