package com.jojoldu.book.springboot.domain.user;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email); //이미 가입한 사용자인지 판단하기 위함

}
