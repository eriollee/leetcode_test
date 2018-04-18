package leetcode;

public class MedianOfTwoSortedArrs {
    public static void main(String[] args) {
        MedianOfTwoSortedArrs m =new  MedianOfTwoSortedArrs();
        //有序数组
        int[] A = {-3,-1,5,7};
        int[] B = {-4,-2,6,8};
        System.out.println(m.findMedianSortedArrays(A,B));
    }

    public double findMedianSortedArrays(int[] A,int[] B){
        int n = A.length;
        int m = B.length;
        if(n>m) return findMedianSortedArrays(B,A);

        int k = (n+m-1)/2;
        System.out.println("k=="+k);

        int l = 0; //左
        int r = Math.min(k,n);//右

        while (l<r){
            int midA = l + (r-l)/2;//
            int midB = k - midA;//
            System.out.println("midA=="+midA);
            System.out.println("midB=="+midB);
            if(A[midA]<B[midB]){
                l=midA+1;
            }else{
                r=midA;
            }
            System.out.println("l==="+l);
            System.out.println("r==="+r);
        }


        int a = Math.max(l>0?A[l-1]:Integer.MIN_VALUE,k-l>=0?B[k-l]:Integer.MIN_VALUE);

        //如果长度之和可以被2整除,则返回a
        if((n+m)%2 ==1) return (double)a;

        int b = Math.min(l<n?A[l]:Integer.MAX_VALUE,k-l+1<m?B[k-l+1]:Integer.MAX_VALUE);

        //如果长度之和不可以被2整除,则返回a+b/2
        return (a+b)/2.0;




    }
}
