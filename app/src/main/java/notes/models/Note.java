package notes.models;

public class Note {

    private String title;
    private String body;

    public Note(String body, String title) {
        this.body = body;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
