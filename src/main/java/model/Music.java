package model;

public class Music {
    private int id;
    private String title;
    private String band;
    private String genre;
    private int durationSec;
    private String album;

    public Music(){}

    public Music(int id, String title, String band, String genre, int durationSec, String album) {
        this.id = id;
        this.title = title;
        this.band = band;
        this.genre = genre;
        this.durationSec = durationSec;
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDurationSec() {
        return durationSec;
    }

    public void setDurationSec(int durationSec) {
        this.durationSec = durationSec;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", band='" + band + '\'' +
                ", genre='" + genre + '\'' +
                ", durationSec=" + durationSec +
                ", album='" + album + '\'' +
                '}';
    }
}
