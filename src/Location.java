public class Location extends ParentObject {
    private String country;

    public Location(int id, String label, String description, Source source, String type) {
        super(id, label, description, source, type);
    }

    public Location(int id, String label, String description, Source source, String type, String country) {
        super(id, label, description, source, type);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public void displayInfor() {
        super.displayInfor();
        if (country != null)
            System.out.println("country : "+ country);

    }
}
