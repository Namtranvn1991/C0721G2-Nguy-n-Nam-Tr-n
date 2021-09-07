package test.btnhom;

public class test {
    public static void main(String[] args) {
        String str = "a123";
        System.out.println(countUniqueCharacters(str));


    }
    public static int countUniqueCharacters(String s) {
        char[] a= s.toCharArray();
        int c=0;
        for (int i=1; i < a.length; i++) {
            if(a[i] != a[0]) {
                c+=1;
            }
        }
        return c;
    }
}
