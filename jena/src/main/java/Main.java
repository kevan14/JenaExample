
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.VCARD;
import org.apache.log4j.varia.NullAppender;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static Resource addResource(Property NS, Model model, String URL, String firstName, String lastName) {
        return model.createResource(URL + firstName + lastName).addProperty(NS, firstName + " " +lastName);
    }


    public static void main(String[] args) {

        org.apache.log4j.BasicConfigurator.configure(new NullAppender());

        // some definitions
        String personURL = "http://persons/";


        // create an empty Model
        Model model = ModelFactory.createDefaultModel();

        // Resources
        List<Resource> resourceList = new ArrayList();

        // create the resource and add property
        resourceList.add(addResource(VCARD.FN, model, personURL, "Kennet", "Vangsgaard"));

        // list the statements in the Model
        StmtIterator iter = model.listStatements();

        // print out the predicate, subject and object of each statement
        while (iter.hasNext()) {
            Statement stmt = iter.nextStatement();  // get next statement

            //The triple...
            Resource subject = stmt.getSubject();     // get the subject
            Property predicate = stmt.getPredicate();   // get the predicate
            RDFNode object = stmt.getObject();      // get the object

            System.out.println("subject: " + subject.toString());
            System.out.println("predicate: " + predicate.toString());

            if (object instanceof Resource) {
                System.out.print("object: as Resource " + object.toString());
            } else {
                // object is a literal
                System.out.println( "object: as Literal " +"'"+ object.toString() +"'");
            }

        }

    }

}
