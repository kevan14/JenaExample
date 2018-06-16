package controllers;

import com.google.gson.Gson;
import interfaces.IPropertyService;
import model.CustomProperty;
import resolver.PropertyResolver;
import response.StandardResponse;

import static spark.Spark.*;

public class PropertyController {

    public PropertyController(final IPropertyService propertyService) {

        post("/properties", (req, res) -> {

            res.type("application/json");

            CustomProperty cp = new Gson()
                    .fromJson(req.body(), CustomProperty.class);

            if(propertyService.defineNewProperty(cp)) {
                res.status(201);
                return new Gson().toJson(new StandardResponse("Created", new Gson().toJsonTree(cp)));
            } else {
                res.status(406);
                return new Gson().toJson(new StandardResponse("Exists", new Gson().toJsonTree(cp)));
            }

        });

        get("/properties", (req, res) -> {

            res.type("application/json");

            return new Gson()
                    .toJson(PropertyResolver
                            .resolveProperties(propertyService
                                    .getAllDefinedProperties()));
        });
    }


}
