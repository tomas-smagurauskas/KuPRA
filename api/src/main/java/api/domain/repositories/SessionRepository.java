package api.domain.repositories;

import api.domain.entities.authentication.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by tomas on 14.11.12.
 */
@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {

    public ArrayList<Session> findByToken(String token);

}
