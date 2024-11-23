package Dita.Library.Service;

import Dita.Library.DTO.LoginDto;
import Dita.Library.DTO.SignupDto;
import Dita.Library.Entity.Users;
import Dita.Library.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * 로그인
     */
    public Boolean checklogin(LoginDto loginDto) {
        // 한 번의 쿼리로 아이디와 비밀번호를 동시에 확인
        Optional<Users> user = usersRepository.findByUserIdAndPassword(
                loginDto.getUser_id(),
                loginDto.getPassword()
        );

        return user.isPresent(); // 조회 결과가 있으면 true, 없으면 false
    }

    /**
     * 회원가입
     */
    public Boolean registerUser(SignupDto signupDto) {

        // 1. 아이디 중복 검사
        Optional<Users> existingUser = usersRepository.findByUserId(signupDto.getUserId());
        if (existingUser.isPresent()) {
            return false; // 아이디가 이미 존재하면 가입 실패
        }

        // 2. 사용자 엔티티 생성 및 저장
        Users newUser = signupDto.toEntity(); // SignupDto에서 Users 엔티티로 변환
        usersRepository.save(newUser); // DB에 저장

        // 3. 회원가입 성공
        return true;
    }
}
