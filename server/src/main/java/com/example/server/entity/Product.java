package com.example.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends Entity<Integer> {
    private String name;
    private String productNumber;
    private Boolean finishedGoodsFlag;
    private String color;
    private Double listPrice;
    private String productSize;
    private Double productWeight;
    private String productLine;
    private String productClass;
    private String productStyle;
    private List<ProductPhoto> productPhotos;
}