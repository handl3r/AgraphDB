import java.util.Date;

public class Source {
    private String link;
    private String time;

    public Source(String link, String time) {
        this.link = link;
        this.time = time;

    }

    public String getLink() {
        return this.link;
    }

    public String getTime() {
        return this.time;
    }
}