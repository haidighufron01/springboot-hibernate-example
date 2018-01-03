package com.maryanto.dimas.hibernate.example.hibernateexample.controller;

import com.maryanto.dimas.hibernate.example.hibernateexample.entity.Buku;
import com.maryanto.dimas.hibernate.example.hibernateexample.repository.BukuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buku")
public class BukuController {

    @Autowired
    private BukuDao bukuDao;

    @GetMapping("/list")
    public List<Buku> getList(){
        return this.bukuDao.getList();
    }

    @PostMapping("/new")
    public Buku save(@RequestBody Buku buku){
        return this.bukuDao.save(buku);
    }
}
