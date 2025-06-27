public class patterns {

    public static void Square(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    public static void UpperTriangle(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    public static void LowerTriangle(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i + 1; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    public static void HallowSquare(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || i == 0 || j == n - 1 || i == n - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void HallowUprighttriange(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || j == i || i == n - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");

                }

            }
            System.out.println();
        }
    }

    public static void Epattern(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 || j == 0 || i == n - 1 || i == n / 2)
                    System.out.print("*");
                else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }

    }

    public static void HallowXPLusPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || i == 0 || j == n - 1 || i == n - 1 || i == j || i + j == n - 1 || j == n / 2
                        || i == n / 2) {
                    System.out.print("*");

                } else {
                    System.out.print(" ");

                }
            }
            System.out.println();

        }
    }

    public static void LeftMOuntain(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void Mountain(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("Printing....");

        // Square(5);

        // UpperTriangle(5);

        // LowerTriangle(5);

        // HallowSquare(5);

        // HallowUprighttriange(5);

        // Epattern(5);

        // HallowXPLusPattern(11);

        // LeftMOuntain(10);

        // Mountain(10);

    }
}
