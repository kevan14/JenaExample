package services;

import graph.ModelSingleton;
import org.apache.jena.rdf.model.Property;

import java.util.Collection;

public class PropertyService {

    public Collection<Property> getAllDefinedProperties() {
        return ModelSingleton.getInstance().getDefinedPropertyTypes();
    }
}
