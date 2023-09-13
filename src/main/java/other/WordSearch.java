package other;

public class WordSearch {
    char [][] board;
    final int rowsLength;
    final int colsLength;

    WordSearch(char [][] board) {
        this.board = board;
        rowsLength = board.length;
        colsLength = board[0].length;
    }

    class WordSeeker {
        char [] word;
        final int rowSeekLastIndex;
        final int colSeekLastIndex;

        WordSeeker(char [] word) {
           this.word = word;
           rowSeekLastIndex = rowsLength - word.length;
           colSeekLastIndex = colsLength - word.length;
        }

        private void reverseWord() {
            char aux;

            for(int a = 0, b = word.length - 1; a < b; ++a, --b) {
                aux = word[a];
                word[a] = word[b];
                word[b] = aux;
            }

            System.out.println("Reversed");
        }

        public boolean hasWord() {
            if (lookInRows() || lookInColumns()) {
                return true;
            }

            reverseWord();

            return lookInRows() || lookInColumns();
        }

        private boolean lookInRows() {
            if (word.length > colsLength) {
                //System.out.println("Longer than no. of columns");
                return false;
            }

            for (int row = 0; row < rowsLength ; ++row) {

                colums_loop:
                for (int col = 0; col <= colSeekLastIndex; ++col) {

                    for (int curCol = col, i = 0; i < word.length; ++curCol, ++i) {
                        if (board[row][curCol] != word[i]) {
                            continue colums_loop;
                        }
                    }

                    return true;
                }
            }

            return false;
        }

        private boolean lookInColumns() {
            if (word.length > rowsLength) {
                //System.out.println("Longer than no. of rows");
                return false;
            }

            for (int col = 0; col < colsLength; ++col) {

                rows_loop:
                for (int row = 0; row <= rowSeekLastIndex; ++row) {

                    for (int curRow = row, i = 0; i < word.length; ++curRow, ++i) {
                        if (board[curRow][col] != word[i]) {
                            continue rows_loop;
                        }
                    }

                    return true;
                }
            }

            return false;
        }
    }

    public boolean contains(String word) {
        if (word.isEmpty()) {
            return false;
        }

        return contains(word.toUpperCase().toCharArray());
    }

    public boolean contains(char[] word) {
        var seeker = new WordSeeker(word);
        return seeker.hasWord();
    }

    public static void main(String[] args) {
        char[][] board = {
                "XXTSDAF".toCharArray(),
                "EAATOBG".toCharArray(),
                "ATCTGCH".toCharArray(),
                "LEXCHES".toCharArray(),
                "AEXOFEJ".toCharArray()
        };

        var game = new WordSearch(board);
        System.out.println(game.contains("CAT"));
    }
}
