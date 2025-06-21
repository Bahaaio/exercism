class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        final int digits = (int) Math.log10(numberToCheck) + 1;

        int num = numberToCheck, sum = 0;
        while (num > 0) {
            sum += (int) Math.pow(num % 10, digits);
            num /= 10;
        }

        return numberToCheck == sum;
    }

}
