package com.sparta.week06.repository;

import com.sparta.week06.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository<엔티티 타입, 식별자 타입>를 상속받아서 기능 구현
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByModifiedAtDesc(); // 수정일자 내림차순으로 Post List 조회
}
