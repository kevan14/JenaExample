
import graph.ModelSingleton;
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.RDF;
import org.apache.log4j.varia.NullAppender;

public class Tester {

    public static void main(String[] args) {

        org.apache.log4j.BasicConfigurator.configure(new NullAppender());

        // some namespace URLs. Here we can read about the "types"
        String genderNamespace = "http://genders-ns#";
        String relationshipNamespace = "http://relationship-ns#";

        // Mapping of namespace to prefix
        ModelSingleton.getInstance().setNamespacePrefix("g", genderNamespace);
        ModelSingleton.getInstance().setNamespacePrefix("rel", relationshipNamespace);

        // create the resources - this case we model genders as "classes" / "subjects"
        ModelSingleton.getInstance().createUniqueResourceType(genderNamespace, "Male");
        ModelSingleton.getInstance().createUniqueResourceType(genderNamespace, "Female");

        // Create the properties - this case we define exact "predicates"
        ModelSingleton.getInstance().createUniquePropertyType(relationshipNamespace, "isMarriedTo");

        //Creating the actual "Subjects" to the model. NOTE they have URIs (unique) !!!
        Resource maleInstance = ModelSingleton.getInstance().createResourceNode("http://males/1");
        Resource femaleInstance = ModelSingleton.getInstance().createResourceNode("http://females/1");

        // Classifications - the actual mapping of Nodes. THIS WILL BECOME THE GRAPH
        maleInstance.addProperty(RDF.type, ModelSingleton.getInstance().getResourceByClassname("Male"));
        femaleInstance.addProperty(RDF.type, ModelSingleton.getInstance().getResourceByClassname("Female"));
        maleInstance.addProperty(ModelSingleton.getInstance().getPropertyByPredicatename("isMarriedTo"), femaleInstance);
        femaleInstance.addProperty(ModelSingleton.getInstance().getPropertyByPredicatename("isMarriedTo"), maleInstance); //Not that the predicate property is not symmetric (bidirectional)...


        // list the statements in the Model
        print(ModelSingleton.getInstance().getModel());


        //Writes model as a output stream as rdf:XML
       ModelSingleton.getInstance().getModel().write(System.out);


    }

    public static void print(Model m) {
        // list the statements in the Model
        StmtIterator iter = m.listStatements();

        // print out the predicate, subject and object of each statement
        while (iter.hasNext()) {
            Statement stmt = iter.nextStatement();  // get next statement

            //The triple...
            Resource subject = stmt.getSubject();     // get the subject
            Property predicate = stmt.getPredicate();   // get the predicate
            RDFNode object = stmt.getObject();      // get the object

            System.out.println("subject: " + subject.getNameSpace());
            System.out.println("predicate: " + predicate.toString());

            if (object instanceof Resource) {
                System.out.println("object: as Resource " + object.toString());
            } else {
                // object is a literal
                System.out.println( "object: as Literal " +"'"+ object.toString() +"'");
            }

            System.out.println("-END-");
        }
    }


}
