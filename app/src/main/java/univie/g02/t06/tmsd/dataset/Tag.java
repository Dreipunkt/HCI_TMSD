package univie.g02.t06.tmsd.dataset;

public class Tag {
    private String name;
    private int weight;

    Tag(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
