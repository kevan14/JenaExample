package services;

import graph.ModelSingleton;
import interfaces.IPropertyService;
import model.CustomProperty;
import org.apache.jena.rdf.model.Property;

import java.util.Collection;

public class PropertyService implements IPropertyService {

    @Override
    public Collection<Property> getAllDefinedProperties() {
        return ModelSingleton.getInstance().getDefinedPropertyTypes();
    }

    @Override
    public boolean defineNewProperty(CustomProperty newProperty) {
        System.out.println("Created new Property type: " + newProperty.getPredicate());
        return ModelSingleton.getInstance().createUniquePropertyType(newProperty.getNameSpace(), newProperty.getPredicate());
    }
}
