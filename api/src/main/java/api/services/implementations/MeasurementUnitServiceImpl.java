package api.services.implementations;

import api.domain.entities.measurementunits.MeasurementUnit;
import api.domain.repositories.MeasurementUnitRepository;
import api.services.MeasurementUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tomas on 14.12.13.
 */
@Service
public class MeasurementUnitServiceImpl implements MeasurementUnitService {

    @Autowired
    MeasurementUnitRepository measurementUnitRepository;

    @Override
    public MeasurementUnit getById(Integer id) {
        return measurementUnitRepository.findOne(id);
    }

    @Override
    public List<MeasurementUnit> getAll() {
        return measurementUnitRepository.findAll();
    }

    @Override
    public MeasurementUnit update(MeasurementUnit measurementUnit) {
        measurementUnitRepository.saveAndFlush(measurementUnit);
        return measurementUnit;
    }

    @Override
    public void delete(Integer id) {
        measurementUnitRepository.delete(id);
        return;
    }

    @Override
    public MeasurementUnit create(MeasurementUnit measurementUnit) {
        measurementUnit = measurementUnitRepository.saveAndFlush(measurementUnit);
        return measurementUnit;
    }
}
