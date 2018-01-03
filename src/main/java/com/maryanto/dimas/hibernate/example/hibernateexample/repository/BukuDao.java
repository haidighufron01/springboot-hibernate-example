package com.maryanto.dimas.hibernate.example.hibernateexample.repository;

import com.maryanto.dimas.hibernate.example.hibernateexample.entity.Buku;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Query;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class BukuDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Buku buku){
        this.sessionFactory.getCurrentSession().save(buku);
    }

    @Transactional
    public void update(Buku buku){
        this.sessionFactory.getCurrentSession().update(buku);
    }

    @Transactional
    public void delete(Buku buku){
        this.sessionFactory.getCurrentSession().delete(buku);
    }

    public Buku findById(Integer id){
        return this.sessionFactory.getCurrentSession().get(Buku.class, id);
    }

    public List<Buku> getList(){
        Query query = this.sessionFactory.getCurrentSession().createQuery("from Buku");
        return query.list();
    }
}
