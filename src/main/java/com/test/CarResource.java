package com.test;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("cars")
public class CarResource {

    private static List<Car> CARS = new ArrayList<>();

    static {
        CARS.add(new Car(1L, "Volkswagen"));
        CARS.add(new Car(2L, "Volkswagen"));
    }

    @Operation(description = "List cars.")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = Car.class))),
            @APIResponse(responseCode = "400", description = "Bad Request")})
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Car> getCars() {
        return CARS;
    }

    @Operation(description = "Add a car.")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = Car.class))),
            @APIResponse(responseCode = "400", description = "Bad Request")})
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Car add(Car car) {
        CARS.add(car);
        return car;
    }
}
