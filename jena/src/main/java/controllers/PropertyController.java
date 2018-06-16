package controllers;

import com.google.gson.Gson;
import resolver.PropertyResolver;
import services.PropertyService;

import static spark.Spark.*;

public class PropertyController {

    public PropertyController(final PropertyService propertyService) {


        get("/properties/types", (req, res) -> {

            res.type("application/json");

            return new Gson()
                    .toJson(PropertyResolver
                            .resolveProperties(propertyService
                                    .getAllDefinedProperties()));
        });
    }


}
