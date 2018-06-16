package resolver;

import model.CustomProperty;
import model.CustomResource;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ResourceResolver {

    public static List<CustomResource> resolveResources(Collection<Resource> resources) {
        List<CustomResource> result = new ArrayList<>();
        for(Resource r : resources ) {
            result.add(new CustomResource(r.getNameSpace(), r.getLocalName()));
        }
        return result;
    }
}
