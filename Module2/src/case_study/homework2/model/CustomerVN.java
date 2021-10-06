package case_study.homework2.model;

public class CustomerVN extends Customer {
    private String type;
    private int consume;

    public CustomerVN() {
    }

    public CustomerVN(String ID, String name, String type, int consume) {
        super(ID, name);
        this.type = type;
        this.consume = consume;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getConsume() {
        return consume;
    }

    public void setConsume(int consume) {
        this.consume = consume;
    }

    @Override
    public String toString() {
        return super.toString()+ "CustomerVN{" +
                "type='" + type + '\'' +
                ", consume=" + consume +
                '}';
    }

    @Override
    public String toStringToFile() {
        return super.toStringToFile() + "," + type + "," + consume;
    }

}
