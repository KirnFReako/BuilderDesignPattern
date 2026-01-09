package SqlBuilder;
import  java.util.*;

import java.util.ArrayList;
import java.util.List;


public final class QueryBuilder {
    private final List<String> SelectColumns= new ArrayList<>();
    private String FromTable;
    private List<String> whereConditions = new ArrayList<>();
    private final List<Join> joins = new ArrayList<>();
    private  List<String> orderByColumns = new ArrayList<>();
    private List<String> groupByColumns = new ArrayList<>();

    private Boolean built = false;

    // CHAINING OF ALL THE METHODS

    public QueryBuilder select(String... columns) {
        checkNotBuilt();
        Collections.addAll(this.SelectColumns, columns);
        return this;
    }

    public QueryBuilder from(String table){
        checkNotBuilt();
        this.FromTable = table;
        return this;
    }

    public QueryBuilder where(String condition){
        checkNotBuilt();
        this.whereConditions.add(condition);
        return this;
    }

    public QueryBuilder InnerJoin(String table, String  oncondition){
        checkNotBuilt();
        this.joins.add(new Join("Inner Join",table,oncondition));
        return this;
    }

    public QueryBuilder OuterJoin(String table, String oncondition){
        checkNotBuilt();
        this.joins.add(new Join("outer Join", table,oncondition));
        return this;
    }

    public QueryBuilder OrderBy(String... columns){
        checkNotBuilt();
        Collections.addAll(this.orderByColumns,columns);
        return this;
    }

    public QueryBuilder GroupBy(String... columns){
        checkNotBuilt();
        Collections.addAll((this.groupByColumns), columns);
        return this;

    }

    // BUILD & VALIDATION
    public String Build(){
        checkNotBuilt();
        Validate();
        built = true;

        StringBuilder query= new StringBuilder();

        query.append("SELECT")
                .append(String.join(",", SelectColumns))
                .append("FROM")
                .append(FromTable);

        for( Join join : joins){
            query.append(" ")
                    .append(join.type)
                    .append(" ")
                    .append(join.table)
                    .append("ON")
                    .append(join.oncondition);
        }

        if(!whereConditions.isEmpty()){
            query.append("WHERE")
                    .append(String.join("," , whereConditions));

        }
        if(!groupByColumns.isEmpty()){
            query.append("GROUP BY")
                    .append(String.join(",",groupByColumns));
        }

        if(!orderByColumns.isEmpty()){
            query.append("ORDER BY")
                    .append(String.join(",",orderByColumns));
        }

        return query.toString();

    }


    private void Validate() {

        if (SelectColumns.isEmpty()) {
            throw new IllegalStateException("Select clause is required");
        }

        if (FromTable == null || FromTable.isBlank()) {
            throw new IllegalStateException("from clause is required");
        }

        for (String orderBy : orderByColumns) {
            if (!SelectColumns.contains(orderBy)) {
                throw new IllegalStateException(
                        "order by columns must be appear in Select" + OrderBy()
                );
            }
        }

        if (!groupByColumns.isEmpty()) {
            for (String column : SelectColumns) {
                if (!isAggregate(column) && !groupByColumns.contains(column)) {
                   throw new IllegalStateException(
                           "Non Aggregated column must be IN group by" + column
                   );
                }
            }
        }
    }

        private boolean isAggregate(String column) {
            String upper = column.toUpperCase();
            return upper.contains("COUNT(")
                    || upper.contains("SUM(")
                    || upper.contains("AVG(")
                    || upper.contains("MIN(")
                    || upper.contains("MAX(");
        }


        private void checkNotBuilt() {
        if(built){
            throw new IllegalStateException("Query has already built and is immutable ");
        }
    }
// HELPER CLASS
    private static class Join{
        final String type;
        final String table;
        final String oncondition;

        Join(String type, String table,String oncondition){
            this.type= type;
            this.table=table;
            this.oncondition=oncondition;
        }
    }

}
