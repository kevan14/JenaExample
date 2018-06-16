package services;

import com.google.gson.JsonElement;
import graph.ModelSingleton;
import interfaces.IResourceService;
import model.CustomResource;
import org.apache.jena.rdf.model.Resource;
import java.util.Collection;

public class ResourceService implements IResourceService {

    @Override
    public Collection<Resource> getAllDefinedResources()  {
        return ModelSingleton.getInstance().getDefinedResourceTypes();
    }

    @Override
    public boolean defineNewResource(CustomResource newResource) {
        System.out.println("Created new Resource class: " + newResource.getClassName());
        return ModelSingleton.getInstance().createUniqueResourceType(newResource.getNameSpace(), newResource.getClassName());
    }


}
