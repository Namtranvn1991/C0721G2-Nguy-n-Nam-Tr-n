package case_study.homework2.model;

public class CustomerNN extends Customer{
    private String country;

    public CustomerNN() {
    }

    public CustomerNN(String ID, String name, String country) {
        super(ID, name);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return super.toString()+ "CustomerNN{" +
                "country='" + country + '\'' +
                '}';
    }

    @Override
    public String toStringToFile() {
        return super.toStringToFile() + "," + country;
    }
}
