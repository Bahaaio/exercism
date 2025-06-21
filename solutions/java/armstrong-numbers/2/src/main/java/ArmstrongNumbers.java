class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        final int numberOfDigits = (int) Math.log10(numberToCheck) + 1;

        int sum = 0;
        for (int num = numberToCheck; num > 0; num /= 10) {
            final int digit = num % 10;
            sum += (int) Math.pow(digit, numberOfDigits);
        }

        return numberToCheck == sum;
    }

}
