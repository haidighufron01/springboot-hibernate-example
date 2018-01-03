package com.maryanto.dimas.hibernate.example.hibernateexample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "master_buku")
public class Buku {

    @Id
    @Column(name = "kode_buku")
    private Integer id;
    @Column(name = "judul", nullable = false, unique = true, length = 50)
    private String judulBuku;
    @Column(name = "nama_pengarang", length = 150)
    private String pengarang;
    @Column(name = "publish", nullable = false)
    private Date tangalPublish;

}
