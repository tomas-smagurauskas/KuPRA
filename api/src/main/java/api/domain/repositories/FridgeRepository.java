package api.domain.repositories;

import api.domain.entities.fridge.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tomas on 14.12.14.
 */
public interface FridgeRepository extends JpaRepository<Fridge, Integer> {
}
