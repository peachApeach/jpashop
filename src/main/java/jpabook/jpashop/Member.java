package jpabook.jpashop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter     // getter setter 자동 생성
public class Member {
    @Id
    @GeneratedValue     // DB 자동 생성
    private Long id;
    private String username;
}
