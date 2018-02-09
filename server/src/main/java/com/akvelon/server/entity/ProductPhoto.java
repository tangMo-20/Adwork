package com.akvelon.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPhoto extends Entity<Integer> {
    private byte[] thumbNailPhoto;
    private String thumbnailPhotoFileName;
    private byte[] largePhoto;
    private String largePhotoFileName;
}