package cg.wbd.grandemonstration.service;

import cg.wbd.grandemonstration.model.Music;

import java.util.List;

public interface IMusicService {
    public List<Music> findAll();

    public Music findById(Integer id);

    public void update(Music music);

    public void delete(Integer id);

    public void addMusic(Music music);
}
