import java.util.Scanner;

public class QuizGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] questions = {
                "What is the capital of France?",
                "What is the largest planet in our solar system?",
                "Who painted the Mona Lisa?",
                "In which year did World War II begin?"
        };
        String[][] options = {
                {"London", "Paris", "Berlin", "Rome"},
                {"Earth", "Mars", "Jupiter", "Saturn"},
                {"Leonardo da Vinci", "Michelangelo", "Raphael", "Donatello"},
                {"1914", "1939", "1945", "1918"}
        };
        char[] answers = {'B', 'C', 'A', 'B'};
        int score = 0;

        System.out.println("Welcome to the Quiz Game!");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            System.out.println(questions[i]);
            System.out.println("A) " + options[i][0]);
            System.out.println("B) " + options[i][1]);
            System.out.println("C) " + options[i][2]);
            System.out.println("D) " + options[i][3]);

            System.out.print("Enter your answer (A/B/C/D): ");
            char userAnswer = Character.toUpperCase(scanner.next().charAt(0));

            if (userAnswer == answers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect.");
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Your score: " + score + "/" + questions.length);

        if (score == questions.length) {
            System.out.println("Congratulations! You got a perfect score!");
        } else if (score >= questions.length / 2) {
            System.out.println("Good job! You passed the quiz.");
        } else {
            System.out.println("Better luck next time!");
        }

        scanner.close();
    }
}