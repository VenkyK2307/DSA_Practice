public class booths {

    // Original shift-and-add multiplication (positive only)
    public static int shiftAddMultiply(int multiplicand, int multiplier) {
        int product = 0;
        int multiplicandBits = Integer.toBinaryString(Math.abs(multiplicand)).length(); // abs to avoid issues

        for (int i = 0; i < multiplicandBits; i++) {
            int currentBit = multiplicand & 0b1;
            if (currentBit == 1) {
                product += multiplier;
            }
            multiplier <<= 1;
            multiplicand >>>= 1; // unsigned right shift
        }

        // Note: This does NOT handle negative numbers correctly
        return product;
    }

    public static void main(String[] args) {
        // Multiple test cases (including negative numbers)
        int[][] testCases = {
                { 4, 2 }, { 5, 3 }, { 6, 7 }, { -3, 4 }, { 4, -3 }, { -5, -6 },
                { 7, -8 }, { -9, 9 }, { 12, -12 }, { 8, 8 }, { 10, 10 }, { -20, 5 }
        };

        System.out.println("------------------------------------------------------------");
        System.out.println("   Multiplicand   Multiplier   Algo_Result   Actual_Result");
        System.out.println("------------------------------------------------------------");

        for (int[] test : testCases) {
            int multiplicand = test[0];
            int multiplier = test[1];
            int algoResult = shiftAddMultiply(multiplicand, multiplier);
            int actualResult = multiplicand * multiplier;

            System.out.printf("%10d %12d %13d %15d%n", multiplicand, multiplier, algoResult, actualResult);
        }

        System.out.println("------------------------------------------------------------");
        System.out.println("NOTE:");
        System.out.println("❌ Shift-add algorithm gives wrong result for negative numbers");
        System.out.println("✅ Matching positive numbers are correct");
    }
}
