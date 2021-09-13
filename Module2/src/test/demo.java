package test;

public class demo {
    public static void main(String[] args) {
        Hinh h1 = new Tron();
        Hinh h2 = new TamGiac();
        Hinh h3 = new ChuNhat();
        h2 = h3;
        Tron h6 = (Tron) h1;
        Hinh h5 = h1;
        System.out.println(h2 instanceof TamGiac);
    }
}

abstract class Hinh {
}

class Tron extends Hinh {
}

abstract class DaGiac extends Hinh {
}

class TamGiac extends DaGiac {
}

class ChuNhat extends DaGiac {
}

