public class test {
    public static void main(String[] args) {
        int[] A= new int[]{7,2,5,3,5,3};
        int[] B= new int[]{7,2,5,4,6,3,5,3};
        int[] c = solution(B,A);


    }

    static int[] solution(int[] a, int[] b) {
        int n= a.length;
        int m= b.length;
        int c = 0;

        for (int i = 0; i < n; i++)
        {
            int j = 0;
            for (; j < m; j++)
                if (a[i] == b[j])
                    break;
            if (j == m) {
                c++;
            }

        }
        int[] d = new int[c];
        int e = 0;
        for (int i = 0; i < n; i++)
        {
            int j = 0;
            for (; j < m; j++)
                if (a[i] == b[j])
                    break;
            if (j == m) {
                d[e] = a[i];
                e++;
            }
        }
        return d;
    }
}
