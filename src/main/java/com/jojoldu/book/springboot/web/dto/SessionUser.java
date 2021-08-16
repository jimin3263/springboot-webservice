package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
    /**
     * User 클래스에 세션 저장하지 않는 이유: 엔티티이므로 다른 관계 형성 가능 -> 직렬화 대상에 자식들도 포함됨
     */
}
