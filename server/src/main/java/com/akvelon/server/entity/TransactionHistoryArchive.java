package com.akvelon.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionHistoryArchive extends Entity<Integer> {
    private Integer TransactionID;
    private Integer ProductID;
}