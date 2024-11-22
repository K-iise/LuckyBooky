package Dita.Library.Repository;

import Dita.Library.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUserIdAndPassword(String userId, String password);  // userId로 수정
}
