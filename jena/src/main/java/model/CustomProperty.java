package model;

public class CustomProperty {

    private String nameSpace;
    private String predicate;


    public CustomProperty(String nameSpace, String predicate) {
        this.nameSpace = nameSpace;
        this.predicate = predicate;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }
}
