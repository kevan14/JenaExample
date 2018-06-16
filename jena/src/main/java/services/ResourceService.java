package services;

import graph.ModelSingleton;
import org.apache.jena.rdf.model.Resource;
import java.util.Collection;

public class ResourceService {

    public Collection<Resource> getAllDefinedResources() {
        return ModelSingleton.getInstance().getDefinedResourceTypes();
    }


}
