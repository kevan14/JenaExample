package graph;

import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.RDF;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

public class ModelSingleton {
    private static ModelSingleton ourInstance = new ModelSingleton();
    private Model model = ModelFactory.createDefaultModel();

    //Types
    private Map<String, Resource> resourceTypeMap = new Hashtable<>();
    private Map<String, Property> propertyTypeMap = new Hashtable<>();


    public static ModelSingleton getInstance() {
        return ourInstance;
    }

    private ModelSingleton() {
        //Just test data for API...
        createUniquePropertyType("http://namespaces.com/relationship#", "isFriendTo");
        createUniquePropertyType("http://namespaces.com/relationship#", "isMarriedTo");
        createUniqueResourceType("http://namespaces.com/genders#", "Male");
        createUniqueResourceType("http://namespaces.com/genders#", "Female");
    }

    public Collection<Property> getDefinedPropertyTypes() {
        return propertyTypeMap.values();
    }

    public Collection<Resource> getDefinedResourceTypes() {
        return resourceTypeMap.values();
    }

    public Resource createResourceNode(String URI) {
        return  model.createResource(URI);
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
