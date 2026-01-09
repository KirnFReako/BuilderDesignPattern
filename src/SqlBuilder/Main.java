package SqlBuilder;

public class Main {
    public static void main(String[] args) {

        String query = new QueryBuilder()
                .select(" name"," age ")
                .from(" users ")
                .where(" age > 30 ")
                .Build();

        System.out.print( query + " ");
    }
}
