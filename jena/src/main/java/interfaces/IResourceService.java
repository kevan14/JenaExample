package interfaces;

import model.CustomResource;
import org.apache.jena.rdf.model.Resource;

import java.util.Collection;

public interface IResourceService {

    Collection<Resource> getAllDefinedResources();

    boolean defineNewResource(CustomResource newResource);
}
