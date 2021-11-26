package com.codegym.service;

import com.codegym.model.Song;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class SongService implements ISongService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static {
        try {
            sessionFactory=new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
            entityManager=sessionFactory.createEntityManager();
        }catch (HibernateError e){
            e.printStackTrace();
        }
    }
    @Override
    public List<Song> findAllSong() {
        TypedQuery<Song> typedQuery=entityManager.createQuery("select s from Song AS s",Song.class);
        return typedQuery.getResultList();
    }

    @Override
    public Song findById(int id) {
        TypedQuery<Song> typedQuery=entityManager.createQuery("select s from Song AS s where s.id= :id",Song.class);
        typedQuery.setParameter("id",id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void remove(int id) {
        Session session=null;
        Transaction transaction=null;
        Song song=findById(id);
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        session.delete(song);
        transaction.commit();
    }

    @Override
    public void save(Song song) {
        Session session =null;
        Transaction transaction=null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(song);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!=null){
                transaction.rollback();
            }
        }

    }
}
