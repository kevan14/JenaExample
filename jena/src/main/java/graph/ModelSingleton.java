package graph;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

import java.util.ArrayList;
import java.util.List;

public class ModelSingleton {
    private static ModelSingleton ourInstance = new ModelSingleton();
    private Model model = ModelFactory.createDefaultModel();
    private List<Resource> namespaces = new ArrayList<Resource>();

    public static ModelSingleton getInstance() {
        return ourInstance;
    }

    private ModelSingleton() {
    }

    public Resource addResource(Property NS, String URL, String firstName, String lastName) {
        return model.createResource(URL + firstName + lastName)
                .addProperty(NS, firstName + " " +lastName);
    }

    /**
     * Return the base model/graph
     * @return
     */
    public Model getModel() {
        return model;
    }

    /**
     * Add namespace here with is shortname and URL root
     * @param name
     * @param url
     */
    public void setNamespace(String name, String url) {
        model.setNsPrefix(name, url);
    }

    /**
     * Return new empty Resource. Is a "Node" with an ID.
     * @return
     */
    public Resource createEmptyResource() {
        return model.createResource();
    }


}
