package com.example.server.DAO.API;

import java.util.List;

public interface dao<K, V> {
    List<V> getAll();
    K create(V value);
    V read(K key);
//    void update(V value);
//    void delete(K key);
    <T> V readBy(String fieldName, T value);
    <T> List<V> readAllBy(String fieldName, T value);
}