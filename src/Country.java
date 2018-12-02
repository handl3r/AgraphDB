public class Country extends ParentObject {
    private int population = -1; // if population = -1 , it's nothing

    public Country(int id, String label, String description, Source source, String type) {
        super(id, label, description, source, type);
    }

    public Country(int id, String label, String description, Source source, String type, int population) {
        super(id, label, description, source, type);
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public void displayInfor() {
        super.displayInfor();
        if (population != -1 )
        System.out.println("population : " + population);
    }
}
