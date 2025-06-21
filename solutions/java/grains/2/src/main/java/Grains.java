import java.math.BigInteger;

class Grains {
    private static final int BOARD_SIZE = 64;

    BigInteger grainsOnSquare(final int square) {
        if (square < 1 || square > BOARD_SIZE) {
            throw new IllegalArgumentException("square must be between 1 and " + BOARD_SIZE);
        }

        return BigInteger.ONE.shiftLeft(square - 1);
    }

    BigInteger grainsOnBoard() {
        return BigInteger.ONE.shiftLeft(BOARD_SIZE).subtract(BigInteger.ONE);
    }
}
