import java.util.Date;

public class Source {
    private String link;
    private Date time;

    public Source(String link, Date time) {
        this.link = link;
        this.time = time;

    }

    public String getLink() {
        return this.link;
    }

    public Date getTime() {
        return this.time;
    }
}