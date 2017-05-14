package univie.g02.t06.tmsd.subsetdata;


public class SubsetTag {
    private String name;
    private int weight;

    SubsetTag(String name, int weight) {
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
