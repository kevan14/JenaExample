package controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import graph.ModelSingleton;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
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
