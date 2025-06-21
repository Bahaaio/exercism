import java.math.BigInteger;
import java.util.Arrays;

class Grains {
    private static final int BOARD_SIZE = 64;
    private final BigInteger[] board = new BigInteger[BOARD_SIZE];

    public Grains() {
        Arrays.setAll(board, BigInteger.ONE::shiftLeft);
    }

    BigInteger grainsOnSquare(final int square) {
        if (square > 64 || square < 1) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }

        return board[square - 1];
    }

    BigInteger grainsOnBoard() {
        return Arrays.stream(board).reduce(BigInteger.ZERO, BigInteger::add);
    }
}
