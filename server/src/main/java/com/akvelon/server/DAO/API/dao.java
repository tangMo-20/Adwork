package com.akvelon.server.DAO.API;

import java.util.List;

public interface dao<K, V> {
    K addNewProduct(V value);
    String deleteItem(String value);
    V read(K key);
    <T> V readBy(String fieldName, T value);
    <T> List<V> readAllBy(String fieldName, T value);
}