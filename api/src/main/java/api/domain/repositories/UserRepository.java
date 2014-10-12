package api.domain.repositories;

import api.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tomas on 14.10.12.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByAsdLike(String like);
}
