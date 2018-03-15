package quizlet.parsing;

import com.google.gson.Gson;

import java.util.List;

public class QuizletSet {
    public String id;
    public String url;
    public String title;
    public List<Term> terms;


    @Override
    public String toString() {
       return new Gson().toJson(this);
    }
}
