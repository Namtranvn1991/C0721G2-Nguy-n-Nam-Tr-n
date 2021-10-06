package case_study.homework.model;

public class Brand {
    private String brandID;
    private String brandName;
    private String country;

    public Brand() {
    }

    public Brand(String brandID, String brandName, String country) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.country = country;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandID='" + brandID + '\'' +
                ", brandName='" + brandName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
