package com.example.server.service.API;

public interface Service<K, V> {

    K addNewProduct(V value);

    String deleteItem(String value);
}