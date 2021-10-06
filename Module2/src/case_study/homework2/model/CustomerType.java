package case_study.homework2.model;

public class CustomerType {
    String typeID;
    String type;

    public CustomerType() {
    }

    public CustomerType(String typeID, String type) {
        this.typeID = typeID;
        this.type = type;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CustomerType{" +
                "typeID='" + typeID + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
