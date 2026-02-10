class PrimeCheckTwoNumbers {
    public static void main(String[] args) {

        int[] numbers = {19, 49};

        for (int num : numbers) {
            boolean isPrime = true;

            if (num <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= num / 2; i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                System.out.println(num + " is a Prime number");
            } else {
                System.out.println(num + " is not a Prime number");
            }
        }
    }
}
