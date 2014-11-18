package api.domain.repositories;

import api.domain.entities.authentication.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tomas on 14.10.12.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByIdEquals(int id);
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);

}
