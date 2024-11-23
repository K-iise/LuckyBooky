package Dita.Library.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "users")  // 테이블명 소문자로 지정
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_no;

    @Column(name = "user_id")  // 데이터베이스 컬럼명: user_id
    private String userId;      // 자바 필드명: userId

    private String username;

    @Column(name = "password")
    private String password;

    private String nickname;

    private Timestamp updated_at;

    private String phoneNumber;

    private String residentNumber;


}
