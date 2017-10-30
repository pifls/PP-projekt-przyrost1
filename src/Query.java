public class Query implements Comparable<Query> {

    private Integer nr_query;
    private String ex_query;

    public Query(int nr_query, String ex_query) {
        this.nr_query = nr_query;
        this.ex_query = ex_query;
    }

    public int getNr() {
        return nr_query;
    }

    public String getEx() {
        return ex_query;
    }

    @Override
    public int compareTo(Query o) {
        return this.nr_query.compareTo(o.getNr());
    }
}