package cg.wbd.grandemonstration.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class MusicForm {

    private Integer id;

    private String nameOfSong;

    private String singer;

    private String type;

    private MultipartFile path;

    public MusicForm() {
    }

    public MusicForm(String nameOfSong, String singer, String type, MultipartFile path) {
        this.nameOfSong = nameOfSong;
        this.singer = singer;
        this.type = type;
        this.path = path;
    }

//    public MusicForm(Integer id, String nameOfSong, String singer, String type, MultipartFile path) {
//        this.id = id;
//        this.nameOfSong = nameOfSong;
//        this.singer = singer;
//        this.type = type;
//        this.path = path;
//    }

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

    public MultipartFile getPath() {
        return path;
    }

    public void setPath(MultipartFile path) {
        this.path = path;
    }
}
