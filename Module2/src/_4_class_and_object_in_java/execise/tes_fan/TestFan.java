package _4_class_and_object_in_java.execise.tes_fan;


public class TestFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan(Fan.MEDIUM,true,10,"yellow");
        System.out.println(fan1.display());
        System.out.println(fan2.display());
        fan1.status = true;
        System.out.println(fan1.display());

    }
}
