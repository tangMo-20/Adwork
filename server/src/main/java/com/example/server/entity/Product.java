package com.example.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends Entity<Integer> {
    private String name;
    private String productNumber;
    //private Boolean makeFlag;
    private Boolean finishedGoodsFlag;
    private String color;
    //private Integer safetyStockLevel;
    //private Integer reorderPoint;
    //private Double standardCost;
    private Double listPrice;
    //private Integer daysToManufacture;
    private String productSize;
    private Double productWeight;
    private String productLine;
    private String productClass;
    private String productStyle;
    //private Integer productSubcategory;
    //private Integer productModelID;
    //private Calendar sellStartDate;
    //private Calendar sellEndDate;
    //private Calendar discontinuedDate;
    private List<ProductPhoto> productPhotos;
    //private List<ProductReview> productReviews;
}