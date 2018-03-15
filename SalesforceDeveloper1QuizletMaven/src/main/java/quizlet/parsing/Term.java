package quizlet.parsing;

public class Term implements Comparable<Term> {
    public String id;
    public String term;
    public String definition;
    public Integer rank;



    public int compareTo(Term o) {
        if (!this.term.toUpperCase().contains("\nA.") || !o.term.toUpperCase().contains("\nA.")) return 0;
        String termCompareThis = this.term;
        String termCompareO = o.term;
        if (termCompareThis.indexOf("?") != -1 && termCompareO.indexOf("?") != -1) {
            termCompareThis = termCompareThis.substring(0, termCompareThis.indexOf("?"));
            termCompareO = termCompareO.substring(0, termCompareO.indexOf("?"));

            return termCompareThis.toUpperCase().
                    replace(" ","").
                    compareTo(termCompareO.toUpperCase().
                            replace(" ",""));
        }
        try {
            return this.term.toUpperCase().
                    substring(0, this.term.toUpperCase().indexOf("\nA.")).
                    replace(" ", "").
                    compareTo(o.term.toUpperCase().
                            substring(0, o.term.toUpperCase().indexOf("\nA.")).
                            replace(" ", ""));
        } catch (Exception ex) {
            System.out.println("Exception "+ex.getMessage()+"\nThis.term: "+this.term+"\nO.term: "+o.term+"\n------------------------\n");
            return 0;
        }
    }


    public void validate(){
        if (!term.contains("\nA.")) return;
        String[] termSplit = term.substring(0, term.indexOf("\nA.")).split("\\.");
        if (termSplit.length > 1) {
            try {
                Integer numberQuestion = Integer.parseInt(termSplit[0]);
                String numberString = String.valueOf(numberQuestion);
                term = term.substring(term.indexOf(numberString+'.')+numberString.length()+2);
            } catch (Exception ex) {
            }
        }
    }


    @Override
    public String toString() {
        return "\n----------------------------------------------------\nQuestion: "
                +term+"\n\nAnswer:\n"+definition+
                "\n----------------------------------------------------\n";
    }
}
