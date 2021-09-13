package _10_dsa_list.exercise.implement_the_methods_of_arraylist;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(11);
        listInteger.add(22);
        listInteger.add(33);
        listInteger.add(44);
        listInteger.add(55);
        listInteger.add(66);
        listInteger.add(77);
        for (int i = 0; i < listInteger.size(); i++) {
            System.out.println(listInteger.get(i));
        }
        System.out.println(listInteger.contains(888));
        MyList<Integer> newList = listInteger.clone();
        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i));
        }


    }
}