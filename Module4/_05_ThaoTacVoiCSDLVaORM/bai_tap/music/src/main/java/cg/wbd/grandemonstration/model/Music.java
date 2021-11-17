package cg.wbd.grandemonstration.model;

import javax.persistence.*;

@Entity(name = "music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_of_song")
    private String nameOfSong;

    @Column(name = "singer")
    private String singer;

    @Column (name = "type")
    private String type;

    @Column (name = "path")
    private String path;

    public Music() {
    }

    public Music(String nameOfSong, String singer, String type, String path) {
        this.nameOfSong = nameOfSong;
        this.singer = singer;
        this.type = type;
        this.path = path;
    }

    public Music(Integer id, String nameOfSong, String singer, String type, String path) {
        this.id = id;
        this.nameOfSong = nameOfSong;
        this.singer = singer;
        this.type = type;
        this.path = path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfSong() {
        return nameOfSong;
    }

    public void setNameOfSong(String nameOfSong) {
        this.nameOfSong = nameOfSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
