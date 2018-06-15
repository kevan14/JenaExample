package graph;

import org.apache.jena.rdf.model.*;

import java.util.HashMap;
import java.util.Map;

public class ModelSingleton {
    private static ModelSingleton ourInstance = new ModelSingleton();
    private Model model = ModelFactory.createDefaultModel();

    //Types
    private Map<String, Resource> resourceTypeMap = new HashMap<String, Resource>();
    private Map<String, Property> propertyTypeMap = new HashMap<String, Property>();

    //Actual nodes
    private Map<String, Resource> resources = new HashMap<String, Resource>();


    public static ModelSingleton getInstance() {
        return ourInstance;
    }

    private ModelSingleton() {
    }

    public Resource createResourceNode(String URI) {
        Resource r =  model.createResource(URI);
        resources.put(URI, r);
        return r;
    }

    public Resource getResourceNodeFromURI(String URI) {
        return model.getResource(URI);
    }

    public void createUniqueResourceType(String nameSpace, String classname) {
        resourceTypeMap.put(classname, ResourceFactory.createResource(nameSpace + classname));
    }

    public void createUniquePropertyType(String nameSpace, String predicate) {
        propertyTypeMap.put(predicate, ResourceFactory.createProperty(nameSpace, predicate));
    }

    public Resource getResourceByClassname(String className) {
        return resourceTypeMap.get(className);
    }

    public Property getPropertyByPredicatename(String predicateName) {
        return propertyTypeMap.get(predicateName);
    }

    public void setNamespacePrefix(String namespacePrefix, String url) {
        model.setNsPrefix(namespacePrefix, url);
    }


    public Model getModel() {
        return model;
    }


}
