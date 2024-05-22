package com.trioshop.model.dto.admin;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PurchaseListModel {
    private Long purchaseCode;
    private Long itemCode;
    private Integer purchaseQty;
    private String factoryCode;
    private String itemName;
    private String categoryName;
    private String itemSize;
    private String itemColor;
}
