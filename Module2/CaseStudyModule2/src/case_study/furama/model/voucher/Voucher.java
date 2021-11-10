package case_study.furama.model.voucher;

public class Voucher {
    public static final String VOUCHER_10 = "voucher 10%";
    public static final String VOUCHER_20 = "voucher 20%";
    public static final String VOUCHER_50 = "voucher 50%";
    String type;

    public Voucher(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "type='" + type + '\'' +
                '}';
    }
}
