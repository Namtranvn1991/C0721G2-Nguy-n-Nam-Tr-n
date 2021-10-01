package case_study.furama.util;

import case_study.furama.model.facility.Facility;

import java.util.Scanner;

public class FacilityInput {
    static Scanner scanner = new Scanner(System.in);

    //-	Mã dịch vụ phải đúng định dạng: SVXX-YYYY, với YYYY là các số từ 0-9, XX là:
    //-	Nếu là Villa thì XX sẽ là VL
    //-	Nếu là House thì XX sẽ là HO
    //-	Nếu Room thì XX sẽ là RO
    public static String inputName() {
        while (true) {
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            if (validateFacilityName(name)) {
                return name;
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static double inputUsingArea() {
        while (true) {
            System.out.println("Enter Using Area");
            String usingArea = scanner.nextLine();
            if (isStringDouble(usingArea)) {
                return Double.parseDouble(usingArea);
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static double inputCost() {
        while (true) {
            System.out.println("Enter cost");
            String cost = scanner.nextLine();
            if (isStringDouble(cost)) {
                if(Double.parseDouble(cost)>0){
                    return Double.parseDouble(cost);
                }else {
                    System.out.println("Enter again");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }


    public static int inputMaximumPerson() {
        while (true) {
            System.out.println("Enter Maximum Person");
            String maximumPerson = scanner.nextLine();
            if (isStringInt(maximumPerson)) {
                return Integer.parseInt(maximumPerson);
            } else {
                System.out.println("Enter again");
            }
        }
    }


    public static String inputTypeOfRent() {
        while (true) {
            System.out.println("Type Of Rent 1.Hourly Rental 2.Daily Rental 3.Monthly Rental 4.Yearly Rental");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    return Facility.HOURLY_RENTAL;
                case "2":
                    return Facility.DAILY_RENTAL;
                case "3":
                    return Facility.MONTHLY_RENTAL;
                case "4":
                    return Facility.YEARLY_RENTAL;
                default:
                    System.out.println("Enter again");
            }
        }
    }


    static public boolean isStringDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    static public boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    static public boolean validateFacilityName(String facilityName) {
        String regex = "(SV)(VL||HO||RO)-\\d{4}";
        return facilityName.matches(regex);
    }
}
