package Dita.Library.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(force = true) // force = true로 기본 생성자 생성
@AllArgsConstructor
@Table(name = "users")  // 테이블명 소문자로 지정
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_no_seq")
    @SequenceGenerator(name = "user_no_seq", sequenceName = "user_no_seq", allocationSize = 1)
    private Long user_no;

    @Column(name = "user_id", unique = true)  // 데이터베이스 컬럼명: user_id
    private String userId;                    // 자바 필드명: userId

    private String username;

    @Column(name = "password")
    private String password;

    private String nickname;

    private Timestamp updated_at;

    private String phoneNumber;

    private String residentNumber;


}
