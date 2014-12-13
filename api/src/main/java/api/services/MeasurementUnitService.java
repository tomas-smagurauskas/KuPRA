package api.services;

import api.domain.entities.measurementunits.MeasurementUnit;

import java.util.List;

/**
 * Created by tomas on 14.12.13.
 */
public interface MeasurementUnitService {

    public MeasurementUnit getById(Integer id);
    public List<MeasurementUnit> getAll();
    public MeasurementUnit update(MeasurementUnit measurementUnit);
    public void delete(Integer id);
    public MeasurementUnit create(MeasurementUnit measurementUnit);

}
