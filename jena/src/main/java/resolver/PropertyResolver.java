package resolver;

import model.CustomProperty;
import org.apache.jena.rdf.model.Property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PropertyResolver {

    public static List<CustomProperty> resolveProperties(Collection<Property> properties) {
        List<CustomProperty> result = new ArrayList<>();
        for(Property p : properties) {
            result.add(new CustomProperty(p.getNameSpace(), p.getLocalName()));
        }
        return result;
    }
}
