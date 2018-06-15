
import graph.ModelSingleton;
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.VCARD;
import org.apache.log4j.varia.NullAppender;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        org.apache.log4j.BasicConfigurator.configure(new NullAppender());

        // some definitions
        String personURL = "http://persons/";

        // Resources
        List<Resource> personResources = new ArrayList();

        // create the resource and add property
        personResources.add(ModelSingleton.getInstance().addResource(VCARD.FN, personURL, "Kennet", "Vangsgaard"));
        personResources.add(ModelSingleton.getInstance().addResource(VCARD.FN, personURL, "Lars", "Hansen"));

        /**
        // list the statements in the Model
        StmtIterator iter = ModelSingleton.getInstance().getModel().listStatements();

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

         */

        ModelSingleton.getInstance().setNamespace("cat", "http://someplace/here#");

        //Writes model as a output stream as rdf:XML
        ModelSingleton.getInstance().getModel().write(System.out);

    }

}
