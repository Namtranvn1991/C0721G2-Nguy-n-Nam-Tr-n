package test;

import java.lang.reflect.Array;
import java.util.Scanner;

public class code {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Nhập số vào mảng:");
        n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("");
            nums[i] = sc.nextInt();
        }
        dayConLienTiep(nums);
    }
    static void dayConLienTiep(int a[])
    {
        int sum=0,dau=0,cuoi=0,max=sum-1,temp=0;
        for(int i=0;i<a.length;i++)
        {
            sum+=a[i];
            if(sum>max)
            {
                max=sum;
                dau=temp;
                cuoi=i;
            }
            if(sum<0)
            {
                temp=i+1;
                sum=0;
            }
        }
        for(int i=dau;i<=cuoi;i++)
            System.out.println(a[i]);
        System.out.println("Max="+max);
    }
}
