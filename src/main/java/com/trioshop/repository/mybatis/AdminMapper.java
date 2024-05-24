package com.trioshop.repository.mybatis;

import com.trioshop.model.dto.admin.*;
import com.trioshop.model.dto.item.ItemCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdminMapper {

    void itemSave(AddItemModel ItemModel);
    void storeSave(StoreItemModel ItemModel);
    void purchaseSave(PurchaseItemModel ItemModel);

    List<PurchaseListModel> purchaseFindAll(ItemCondition itemCondition);
    Optional<PurchaseListModel> purchaseFindByCode(Long purchaseCode);

    List<StoresListModel> storesFindAll(ItemCondition itemCondition);
    Optional<StoresListModel> storesFindByCode(Long storeCode);

    List<StockModel> stockFindAll(ItemCondition itemCondition);
    Optional<StockModel> stockFindByCode(Long itemCode);

    Optional<ItemQtyModel> itemFindByCode(Long itemCode);

    void updateItem(UpdateItemModel ItemModel);
    void addItemQty(Long itemCode, Integer qty);
    void deletePurchaseByCode(Long purchaseCode);
    void deleteStoresByCode(Long storeCode);
}
