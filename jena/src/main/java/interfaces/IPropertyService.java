package interfaces;

import model.CustomProperty;
import org.apache.jena.rdf.model.Property;

import java.util.Collection;

public interface IPropertyService {

    Collection<Property> getAllDefinedProperties();

    boolean defineNewProperty(CustomProperty newProperty);
}
