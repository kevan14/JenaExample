package controllers;

import resolver.ResourceResolver;
import services.ResourceService;


import com.google.gson.Gson;
import static spark.Spark.*;

public class ResourceController {

    public ResourceController(final ResourceService resourceService) {

        get("/resources/types", (req, res) -> {

            res.type("application/json");

            return new Gson()
                    .toJson(ResourceResolver
                            .resolveResources(resourceService
                                    .getAllDefinedResources()));
        });
    }
}
