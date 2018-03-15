package mock_exam;

import quizlet.parsing.Term;

import java.util.*;

public class QuizCreator {


    public static List<Term> makeQuizRandomQuestions(List<Term> termsDatabase, Integer capacity) {
        if (termsDatabase == null) {
            System.out.println("No terms found!!!");
            return null;
        }

        Set<Integer> questionsSetIndexes = new LinkedHashSet<Integer>();
        Random random = new Random();

        while (questionsSetIndexes.size() < capacity) {
            Integer randValue = random.nextInt(termsDatabase.size()-1);
            questionsSetIndexes.add(randValue);
        }

        List<Term> termsToReturn = new ArrayList<Term>();

        for (Integer index : questionsSetIndexes) {
            termsToReturn.add(termsDatabase.get(index));
        }
        return termsToReturn;
    }



    public static void makeQuizLogic(List<Term> terms){
        System.out.println("\n\n\n__________________________QUIZ-STARTED__________________________\n\n\n");
        for (Term term : terms) {
            System.out.println(term.term);
            System.out.println("Your answer: ");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine()     ;
            String [] symbols = answer.split(",");
            for (String symbol : symbols) {
                //Integer answerCount =
                if (term.definition.indexOf("\nRef:") != -1) {
                    term.definition = term.definition.substring(0, term.definition.indexOf("\nRef:"));
                }
                if (term.definition.contains(symbol.toUpperCase()+".")) {

                }
            }
            System.out.println("Answer => "+term.definition);
            System.out.println("\n____________________________________________________\n");
        }

    }

}
