import controllers.PropertyController;
import controllers.ResourceController;
import services.PropertyService;
import services.ResourceService;

public class Launcher {

    public static void main(String[] args) {

        //Instantiate controllers with theirs services'
        new PropertyController(new PropertyService());
        new ResourceController(new ResourceService());
    }
}
