package com.maryanto.dimas.hibernate.example.hibernateexample;

import com.maryanto.dimas.hibernate.example.hibernateexample.entity.Buku;
import com.maryanto.dimas.hibernate.example.hibernateexample.repository.BukuDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateExampleApplicationTests {

	@Autowired
	private BukuDao bukuDao;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSimpanData(){
		Buku buku = new Buku();
		buku.setId(1);
		buku.setJudulBuku("Pemograman Java");
		buku.setPengarang("Dimas Maryanto");
		buku.setTangalPublish(Date.valueOf(LocalDate.of(2017, 4, 10)));
		bukuDao.save(buku);
	}

}
