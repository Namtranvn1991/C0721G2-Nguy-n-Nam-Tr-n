package case_study.practice.model;

import java.util.Date;

public class Showtime {
    private String id;
    private Film film;
    private Date release;
    private int quantity;

    public Showtime() {
    }

    public Showtime(String id, Film film, Date release, int quantity) {
        this.id = id;
        this.film = film;
        this.release = release;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Showtime{" +
                "id='" + id + '\'' +
                ", film=" + film +
                ", release=" + release +
                ", quantity=" + quantity +
                '}';
    }

    public String toStringToFile() {
        return id + "," + film.getName() +
                "," + release.getDate() + "/" + (release.getMonth()+1) + "/" + (release.getYear()+1900) +
                "," + quantity;
    }
}
