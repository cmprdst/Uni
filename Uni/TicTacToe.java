public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
                {'x', 'o', ' '},
                {' ', 'x', 'o'},
                {' ', ' ', 'x'},
        };

        boolean gewinnerO = false;
        boolean gewinnerX = false;

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'x' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) gewinnerX = true;
            if (board[0][i] == 'x' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) gewinnerX = true;
            if (board[i][0] == 'o' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) gewinnerO = true;
            if (board[0][i] == 'o' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) gewinnerO = true;
        }
        if (board[0][0] == 'x' && board [0][0] == board[1][1] && board[0][0] == board[2][2]) gewinnerX = true;
        if (board[2][0] == 'x' && board [2][0] == board[1][1] && board[2][0] == board[0][2]) gewinnerX = true;
        if (board[0][0] == 'o' && board [0][0] == board[1][1] && board[0][0] == board[2][2]) gewinnerO = true;
        if (board[2][0] == 'o' && board [2][0] == board[1][1] && board[2][0] == board[0][2]) gewinnerO = true;

        if (!gewinnerO && !gewinnerX) System.out.println("Niemand hat gewonnen.");
        if (gewinnerX && !gewinnerO) System.out.println("Der Spieler mit den 'x' hat gewonnen!");
        if (gewinnerO && !gewinnerX) System.out.println("Der Spieler mit den 'o' hat gewonnen!");
        if (gewinnerX && gewinnerO) System.out.println("Es kann nur einer gewinnen.");
    }
}