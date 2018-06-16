package controllers;

import interfaces.IResourceService;
import model.CustomResource;
import resolver.ResourceResolver;


import com.google.gson.Gson;
import response.StandardResponse;


import static spark.Spark.*;

public class ResourceController {

    public ResourceController(final IResourceService resourceService) {

        post("/properties", (req, res) -> {

            res.type("application/json");

            CustomResource cr = new Gson()
                    .fromJson(req.body(), CustomResource.class);

            if(resourceService.defineNewResource(cr)) {
                res.status(201);
                return new Gson().toJson(new StandardResponse("Created", new Gson().toJsonTree(cr)));
            } else {
                res.status(406);
                return new Gson().toJson(new StandardResponse("Exists", new Gson().toJsonTree(cr)));
            }
        });

        get("/resources", (req, res) -> {

            res.type("application/json");

            return new Gson()
                    .toJson(ResourceResolver
                            .resolveResources(resourceService
                                    .getAllDefinedResources()));
        });
    }
}
