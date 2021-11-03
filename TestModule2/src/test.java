import java.util.*;

public class test {
    public static void main(String[] args) {
        int [] a =  new int[]{1, 2, 2, 1};
        System.out.println(foo(a));

    }

    static boolean foo(int[] arr) {
        int[] a = new int[9];
        int prev = 0;
        int count = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != prev) {
                count++;
                a[count] = 1;
            } else {
                a[count]= a[count]++;
            }
            prev = arr[i];
        }

        for (int i = 0; i < a.length; i++){
            if (a[i]==0){
                break;
            }
            if (a[i]!=a[0]){
                return false;
            }
        }
        return true;
    }


//a[1,2,3]
//b[1,2,1]

// [1, 2, 2, 3, 3, 3, 1, 3],
//        var a = [], b = [], prev;
//
//        arr.sort();
//        for ( var i = 0; i < arr.length; i++ ) {
//            if ( arr[i] !== prev ) {
//                a.push(arr[i]);
//                b.push(1);
//            } else {
//                b[b.length-1]++;
//            }
//            prev = arr[i];
//        }
//
//        return [a, b];

}
