package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<Entity클래스, PK타입>
public interface PostsRepository extends JpaRepository<Posts,Long> {
}
