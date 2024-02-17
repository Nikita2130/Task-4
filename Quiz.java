import java.util.Scanner;

public class Quiz {
    private Question[] questions;
    private int score;

    public Quiz(Question[] questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i].getQuestion());
            for (int j = 0; j < questions[i].getOptions().length; j++) {
                System.out.println((char) ('A' + j) + ". " + questions[i].getOptions()[j]);
            }

            System.out.print("Your answer: ");
            String userAnswer = scanner.next().toUpperCase();

            if (userAnswer.equals(questions[i].getCorrectAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is " + questions[i].getCorrectAnswer());
            }

            try {
                Thread.sleep(2000); // Adjust the time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        displayResult();
    }

    public void displayResult() {
        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score + " / " + questions.length);
        System.out.println("Correct Answers:");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i].getCorrectAnswer());
        }
    }

    public static void main(String[] args) {
        // Example questions
        Question[] questions = {
                new Question("What is the capital of France?", new String[]{"London", "Paris", "Berlin", "Rome"}, "B"),
                new Question("Which planet is known as the Red Planet?", new String[]{"Venus", "Mars", "Jupiter", "Saturn"}, "B"),
                // Add more questions as needed
        };

        Quiz quiz = new Quiz(questions);
        quiz.startQuiz();
    }
}

class Question {
    private String question;
    private String[] options;
    private String correctAnswer;

    public Question(String question, String[] options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
