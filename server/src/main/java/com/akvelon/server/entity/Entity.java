package com.akvelon.server.entity;

import lombok.Data;

@Data
public class Entity<T> {
    private T id;
}
