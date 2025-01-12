import java.util.Scanner;

public class TicTacToe {

    public static final int X = 1;
    public static final int O = -1;
    public static final int EMPTY = 0;

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        initializeBoard(board);
        int currentPlayer = X;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard(board);

            System.out.println("Player " + (currentPlayer == X ? "X" : "O") + "'s turn.");
            System.out.print("Enter row (1-3): ");
            int row = scanner.nextInt() - 1;
            System.out.print("Enter column (1-3): ");
            int col = scanner.nextInt() - 1;

            if (isValidMove(board, row, col)) {
                makeMove(board, row, col, currentPlayer);

                int result = checkWinner(board);
                if (result == X) {
                    printBoard(board);
                    System.out.println("Player X wins!");
                    break;
                } else if (result == O) {
                    printBoard(board);
                    System.out.println("Player O wins!");
                    break;
                } else if (result == 0 && isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("It's a draw!");
                    break;
                }

                currentPlayer = -currentPlayer; // Switch players
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }

    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    private static void makeMove(char[][] board, int row, int col, int player) {
        board[row][col] = (player == X) ? 'X' : 'O';
    }

    private static int checkWinner(char[][] board) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return (board[i][0] == 'X') ? X : O;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return (board[0][j] == 'X') ? X : O;
            }
        }

        // Check diagonals
        if ((board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
            return (board[1][1] == 'X') ? X : O;
        }

        return 0; // No winner
    }

    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}