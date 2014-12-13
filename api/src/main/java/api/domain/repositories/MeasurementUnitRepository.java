package api.domain.repositories;

import api.domain.entities.measurementunits.MeasurementUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tomas on 14.12.13.
 */
@Repository
public interface MeasurementUnitRepository extends JpaRepository<MeasurementUnit, Integer> {
}
