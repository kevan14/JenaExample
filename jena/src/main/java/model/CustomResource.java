package model;

public class CustomResource {

    private String nameSpace;
    private String className;

    public CustomResource(String nameSpace, String className) {
        this.nameSpace = nameSpace;
        this.className = className;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
