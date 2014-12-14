package api.domain.repositories;

import api.domain.entities.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tomas on 14.12.14.
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
