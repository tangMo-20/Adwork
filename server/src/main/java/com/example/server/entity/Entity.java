package com.example.server.entity;

import lombok.Data;

@Data
public class Entity<T> {
    private T id;
}
