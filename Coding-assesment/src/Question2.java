//From Given Integer Array Y move all X  to right and find the index and value for multiple of Z.
public class Question2 {

    static int[] moveAllXToRight(int[] arr, int X) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != X) {
                arr[count++] = arr[i];
            }
        }
        for (int i = count; i < arr.length; i++) {
            arr[i] = X;
        }
        return arr;
    }

    static void printAllMultiplierOfZ(int[] arr, int Z) {
        System.out.println("\nMultiplier of " + Z + " are");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % Z == 0) {
                System.out.println("index " + i + " and value " + arr[i]);
            }
        }
    }

    public static void main(String[] args) {

        int[] Y = {10, 77, 92, 1, 30, 81, 1, 4, 1, 20, 17, 1, 16, 33};
        int X = 1;
        int Z = 10;
        int[] ans = moveAllXToRight(Y, X);
        System.out.println("output after moving all "+ X +" to right");
        for (int a : ans) {
            System.out.print(a + " ");
        }

        printAllMultiplierOfZ(Y, 10);
    }
}
