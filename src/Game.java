import java.util.Scanner;

public class Game {
    private int remainingTries;
    private final String[] words = new String[]{"ADLER", "CHAOS", "GAUDI", "KEINS", "MUHEN", "PFOTE"};
    private String word;
    private boolean gameOver;

    public Game() {
        resetGame();
    }

    public static void main(String[] args) {
        Game g = new Game();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first guess (5 letters)");
        do {
            String guess = sc.nextLine();
            g.guess(guess);
        } while (!g.gameOver);
    }

    private void resetGame() {
        gameOver = false;
        remainingTries = 6;
        word = words[(int)(Math.random()*words.length)];
    }

    public void guess(String guess) {
        System.out.println(guess);
        int rightCharactersCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess.toUpperCase().charAt(i)) {
                System.out.print("+");
                rightCharactersCount++;
            } else if (word.contains("" + guess.toUpperCase().charAt(i))) {
                System.out.print("-");
            } else {
                System.out.print(" ");
            }
        }
        System.out.print("\n");

        if (--remainingTries == 0) {
            System.out.println("Game Over! You Lose!");
            gameOver = true;
        } else if (rightCharactersCount == 5) {
            System.out.println("Game Over! YOU WIN!!!!");
            gameOver = true;
        } else {
            System.out.println("Remaining tries: " + remainingTries);
        }
    }
}
