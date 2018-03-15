import com.google.gson.Gson;
import mock_exam.QuizCreator;
import quizlet.http.QuizletHttp;
import quizlet.parsing.QuizletSet;
import quizlet.parsing.Term;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {

        /*File f = new File("IdsOfSalesforceDeveloper1_Page_2_6.txt");

        FileReader fileReader = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<String> ids = new ArrayList<String>();
        String line = "";

        while ((line = bufferedReader.readLine()) != null) {
            ids.add(line);
        }

        bufferedReader.close();
        fileReader.close();

        System.out.println(ids);

        List<Term> terms = new ArrayList<Term>();

        for (String id : ids) {
            QuizletSet quizletSet = QuizletHttp.getQuizletSetQuestionsHttp(id);
            terms.addAll(quizletSet.terms);
        }



        System.out.println(terms.size());
        */




        File file = new File("quizlet_salesforce_developer1_pages/page1/SalesforceDeveloper1_JSON_Quizlet_Page_1_FIXED.json");
        QuizletSet quizletSet = getAllTermsForDeveloper1FromFile(file);
        List<Term> termsPage1 = quizletSet.terms;

        for (Term term : termsPage1) {
            term.validate();
        }

        Set<Term> termSet = new TreeSet<Term>();
        termSet.addAll(termsPage1);


        termsPage1 = new ArrayList<Term>();
        termsPage1.addAll(termSet);

        System.out.println(termsPage1);





        file = new File("quizlet_salesforce_developer1_pages/page2_6/SalesforceDeveloper1_JSON_Quizlet_Page_2-6_FIXED.json");
        quizletSet = getAllTermsForDeveloper1FromFile(file);
        List<Term> termsPage2_6 = quizletSet.terms;

        for (Term term : termsPage2_6) {
            term.validate();
        }

        termSet = new TreeSet<Term>();
        termSet.addAll(termsPage2_6);


        termsPage2_6 = new ArrayList<Term>();
        termsPage2_6.addAll(termSet);

        System.out.println(termsPage2_6);

        System.out.println(termsPage1.size());
        System.out.println(termsPage2_6.size());

        List<Term> termsMixed = new ArrayList<Term>();
        termsMixed.addAll(termsPage1);
        termsMixed.addAll(termsPage2_6);

        Set<Term> mixedSet = new TreeSet<Term>();
        mixedSet.addAll(termsMixed);

        System.out.println(mixedSet.size());

        termsMixed = new ArrayList<Term>();
        termsMixed.addAll(mixedSet);



        file = new File("quizlet_salesforce_developer1_pages/mixed/All_Questions_Developer1.json");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("{  \"terms\": " + new Gson().toJson(termsMixed) +"}");
        fileWriter.close();


//        Set<Term> terms = new TreeSet<Term>();
//
//        for (QuizletSet quizletSet : quizletSetList) {
//            for (Term term : quizletSet.terms) {
//                terms.add(term);
//            }
//        }
//
//        System.out.println("terms size : "+terms.size());
//
//        for (Term term : terms) {
//            System.out.println(term);
//        }
//
//        List<Term> termsList = new ArrayList<Term>();
//        termsList.addAll(terms);
//
//




        /*File file = new File("quizlet_salesforce_developer1_pages/page1/SalesforceDeveloper1_JSON_Quizlet_Page_1_FIXED.json");

        List<Term> termsList = getAllTermsForDeveloper1FromFile(file).terms;
        System.out.println(termsList.size());

        for (Term t : termsList) {
            t.validate();
        }


        Set<Term> termSet = new TreeSet<Term>();
        termSet.addAll(termsList);
        System.out.println(termSet.size());



        termsList = new ArrayList<Term>();
        termsList.addAll(termSet);*/

//        File fileFixed = new File("quizlet_salesforce_developer1_pages/page1/SalesforceDeveloper1_JSON_Quizlet_Page_1_FIXED.json");
//        FileWriter fileWriter = new FileWriter(fileFixed);
//        fileWriter.write("{  \"terms\": " + new Gson().toJson(termsList) +"}");
//        fileWriter.close();


        /*List<Term> termsForQuiz = QuizCreator.makeQuizRandomQuestions(termsList, 60);
        QuizCreator.makeQuizLogic(termsForQuiz);*/


//        String answer = "Answer:\n" +
//                "C. Namespace D. Time\n" +
//                "Ref: https://help.salesforce.com/apex/HTViewHelpDoc?\n" +
//                "i d=code_dev_consol e_tab_checkpoi nts. htm&l anguage=en_US";
//        if (answer.indexOf("\nRef:") != -1) {
//            System.out.println(answer.substring(0, answer.indexOf("\nRef:")));
//        }


    }


    public static QuizletSet getAllTermsForDeveloper1FromFile(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = "";
        String content = "";

        while ((line = bufferedReader.readLine()) != null) {
            content+=line;
        }

        bufferedReader.close();
        fileReader.close();
        return new Gson().fromJson(content, QuizletSet.class);
    }


}
