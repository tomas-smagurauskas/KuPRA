package api.controllers;

import api.domain.entities.measurementunits.MeasurementUnit;
import api.services.MeasurementUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.RestUrls;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by tomas on 14.12.13.
 */
@RestController
@RequestMapping(RestUrls.APP_MAPPING)
public class MeasurementUnitController {

    @Autowired
    MeasurementUnitService measurementUnitService;

    @RequestMapping(value = RestUrls.MEASUREMENT_UNITS, method = RequestMethod.GET)
    @ResponseBody
    public List<MeasurementUnit> getMeasurementUnits(HttpServletResponse response) {
        List<MeasurementUnit> measurementUnits;

        try {
            measurementUnits = measurementUnitService.getAll();
        }
        catch (Exception e) {
            response.setStatus(500);
            return null;
        }

        return measurementUnits;
    }

    @RequestMapping(value = RestUrls.MEASUREMENT_UNITS + "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MeasurementUnit getMeasurementUnit(@PathVariable(value = "id") String id, HttpServletResponse response) {
        MeasurementUnit measurementUnit = null;

        try {
            measurementUnit = measurementUnitService.getById(Integer.parseInt(id));
        }
        catch (Exception e) {
            response.setStatus(500);
            return null;
        }

        return measurementUnit;
    }

    @RequestMapping(value = RestUrls.MEASUREMENT_UNITS, method = RequestMethod.POST)
    @ResponseBody
    public MeasurementUnit createMeasurementUnit(@RequestBody MeasurementUnit measurementUnit, HttpServletResponse response) {

        try {
            measurementUnit = measurementUnitService.create(measurementUnit);
        }
        catch (Exception e) {
            response.setStatus(500);
            return null;
        }

        return measurementUnit;
    }

    @RequestMapping(value = RestUrls.MEASUREMENT_UNITS + "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public MeasurementUnit updateMeasurementUnit(@PathVariable(value = "id") Integer id, @RequestBody MeasurementUnit measurementUnit,
                                                 HttpServletResponse response) {

        return null;
    }

}
