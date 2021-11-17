package cg.wbd.grandemonstration.service;

import cg.wbd.grandemonstration.model.Music;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;


@Service
public class MusicService implements IMusicService {
    @Override
    public List<Music> findAll() {

        List<Music> musicList = BaseRepository.entityManager.createQuery("select s from music s", Music.class).getResultList();

        return musicList;
    }

    @Override
    public Music findById(Integer id) {
        return BaseRepository.entityManager.find(Music.class,id);
    }

    @Override
    public void update(Music music) {

    }

    @Override
    public void delete(Integer id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findById(id));
        entityTransaction.commit();
    }

    @Override
    public void addMusic(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }
}
