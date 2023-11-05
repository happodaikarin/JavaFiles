public class Ordenamiento {






    public static void main(String[] args) {
        int[] A = {5,4,3,2,7,8,0,4};

        System.out.println(A[0]);
        System.out.println(A[1]);
        System.out.println(A.length);

        for (int j = 0; j < A.length-1; j++) {
            for (int i = 0; i < A.length-1-j; i++) {
            if (A[i] > A[i+1]) {
                int temp = A[i];
                A[i] = A[i+1];
                A[i+1] = temp;
            }
            }
        }
        System.out.println();

        for (int i = 0; i < A.length; i++){
            System.out.println(A[i]);
        }



    }
}
