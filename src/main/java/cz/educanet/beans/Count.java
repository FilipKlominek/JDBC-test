package cz.educanet.beans;

public class Count {
    private final String publisher;
    private final int count;

    public Count(String publisher, int count) {
        this.publisher = publisher;
        this.count = count;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getCount() {
        return count;
    }
}
