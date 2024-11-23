package Dita.Library.Service;

import Dita.Library.DTO.LoginDto;
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

}
