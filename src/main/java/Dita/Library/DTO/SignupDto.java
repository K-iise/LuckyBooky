package Dita.Library.DTO;

import Dita.Library.Entity.Users;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SignupDto {
    @NotEmpty(message = "아이디는 필수 항목입니다.")
    @Size(min = 3, max = 20, message = "아이디는 3자 이상, 20자 이하로 입력해주세요.")
    private String userId;

    @NotEmpty(message = "비밀번호는 필수 항목입니다.")
    @Size(min = 4, message = "비밀번호는 4자 이상이어야 합니다.")
    private String password;

    @NotEmpty(message = "비밀번호를 재입력해주세요.")
    @Size(min = 4, message = "비밀번호는 4자 이상이어야 합니다.")
    private String passwordchk;

    @NotEmpty(message = "이름을 입력해주세요.")
    private String username;

    @NotEmpty(message = "필명을 입력해주세요.")
    private String nickname;

    @NotEmpty(message = "주민등록번호를 입력해주세요.")
    private String residentNumber;

    @NotEmpty(message = "휴대폰번호를 입력해주세요.")
    private String phoneNumber;

    // 비밀번호와 비밀번호 확인이 일치하는지 검증하는 로직
    @AssertTrue(message = "비밀번호와 비밀번호 확인이 일치하지 않습니다.")
    public boolean isPasswordMatched() {
        return this.password != null && this.password.equals(this.passwordchk);
    }

    // Entity로 변환하는 메서드
    public Users toEntity() {
        return Users.builder()
                .userId(this.userId)
                .password(this.password)
                .username(this.username)
                .nickname(this.nickname)
                .residentNumber(this.residentNumber)
                .phoneNumber(this.phoneNumber)
                .build();
    }
}
