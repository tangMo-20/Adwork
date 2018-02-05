package com.example.server.service;

import com.example.server.DAO.API.dao;
import com.example.server.entity.Entity;
import com.example.server.service.API.Service;

import java.util.List;

@org.springframework.stereotype.Service
public abstract class mainService<V extends Entity<Integer>> implements Service<Integer, V> {
    private dao<Integer, V> dao;

    protected mainService(dao<Integer, V> dao) {
        this.dao = dao;
    }

    @Override
    public List<V> getAll() {
        return dao.getAll();
    }

    @Override
    public Integer create(V value) {
        return dao.create(value);
    }

    @Override
    public V read(Integer key) {
        return dao.read(key);
    }

//    @Override
//    public void update(V value) {
//        dao.update(value);
//    }
//
//    @Override
//    public void delete(Integer key) {
//        dao.delete(key);
//    }

    @Override
    public <T> V readBy(String fieldName, T value) {
        return dao.readBy(fieldName, value);
    }

    @Override
    public <T> List<V> readAllBy(String fieldName, T value) {
        return dao.readAllBy(fieldName, value);
    }
}