package de.btu.flight_service.endpoints;

import de.btu.flight_service.interfaces.IFlightService;
import de.btu.flight_service.models.FlightAddRequest;
import de.btu.flight_service.models.FlightGetRequest;
import de.btu.flight_service.models.FlightResponse;
import de.btu.flight_service.models.IcaoListResponse;
import de.btu.flight_service.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightEndpoint implements IFlightService {

    final
    FlightService flightService;

    public FlightEndpoint(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    @CrossOrigin
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public boolean add(@RequestBody FlightAddRequest request) {
        return flightService.add(request);
    }

    @Override
    @CrossOrigin
    @RequestMapping(value = "/get", method = {RequestMethod.POST})
    public List<FlightResponse> get(@RequestBody FlightGetRequest request) {
        return flightService.get(request);
    }

    @Override
    @CrossOrigin
    @RequestMapping(value = "/getLast", method = {RequestMethod.POST})
    public FlightResponse getLast(@RequestBody FlightGetRequest request) {
        return flightService.getLast(request);
    }

    @Override
    @CrossOrigin
    @RequestMapping(value = "/getAll", method = {RequestMethod.POST})
    public List<FlightResponse> getAll() {
        return flightService.getAll();
    }

    @Override
    @CrossOrigin
    @RequestMapping(value = "/icao", method = {RequestMethod.POST})
    public IcaoListResponse listIcao() {
        return flightService.listIcao();
    }
}
