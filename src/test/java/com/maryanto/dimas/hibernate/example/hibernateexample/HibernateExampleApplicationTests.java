package com.maryanto.dimas.hibernate.example.hibernateexample;

import com.maryanto.dimas.hibernate.example.hibernateexample.entity.Buku;
import com.maryanto.dimas.hibernate.example.hibernateexample.repository.BukuDao;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class HibernateExampleApplicationTests extends TestCase {

    @Autowired
    private BukuDao bukuDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSimpanData() {
        Buku pemogramanJava = new Buku();
        pemogramanJava.setId(1);
        pemogramanJava.setJudulBuku("Pemograman Java");
        pemogramanJava.setPengarang("Dimas Maryanto");
        pemogramanJava.setTangalPublish(Date.valueOf(LocalDate.of(2017, 4, 10)));
        bukuDao.save(pemogramanJava);

        Buku pemogramanWeb = new Buku();
        pemogramanWeb.setId(2);
        pemogramanWeb.setJudulBuku("Pemograman Web");
        pemogramanWeb.setPengarang("Dimas");
        pemogramanWeb.setTangalPublish(Date.valueOf(LocalDate.of(2016, 4, 10)));
        bukuDao.save(pemogramanWeb);

        pemogramanJava.setJudulBuku("Pemograman");
        bukuDao.update(pemogramanJava);
        pemogramanJava = bukuDao.findById(1);
        assertEquals(pemogramanJava.getJudulBuku(), "Pemograman");

        List<Buku> listBuku = bukuDao.getList();
        assertEquals(listBuku.size(), 2);

        bukuDao.delete(pemogramanWeb);
        bukuDao.delete(pemogramanJava);

        listBuku = bukuDao.getList();
        assertEquals(listBuku.size(), 0);
    }

}
