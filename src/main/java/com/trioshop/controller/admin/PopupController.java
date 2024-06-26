package com.trioshop.controller.admin;

import com.github.pagehelper.PageInfo;
import com.trioshop.model.dto.admin.FactoryCondition;
import com.trioshop.model.dto.admin.FactoryEntity;
import com.trioshop.model.dto.admin.PurchaseListModel;
import com.trioshop.model.dto.item.ItemCondition;
import com.trioshop.model.dto.popup.PopupItemModel;
import com.trioshop.service.admin.PopupService;
import com.trioshop.service.admin.PurchaseService;
import com.trioshop.utils.business.CategoryList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PopupController {
    private final PopupService popupService;
    private final PurchaseService purchaseService;
    private final CategoryList categoryList;

    @GetMapping("/popupItemList")
    public String popupItemList(@ModelAttribute ItemCondition itemCondition,
                                @RequestParam(defaultValue = "1")int page,
                                Model model) {
        PageInfo<PopupItemModel> popupItemModelPageInfo = popupService.findByAll(itemCondition, page);
        model.addAttribute("categoryList", categoryList.getCategoryList());
        model.addAttribute("itemList", popupItemModelPageInfo.getList());
        model.addAttribute("totalPages", popupItemModelPageInfo.getPages());

        return "admin/popupItemList";
    }
    @GetMapping("/popupFactoryList")
    public String popupFactoryList(@ModelAttribute FactoryCondition factoryCondition,
                                   @RequestParam(defaultValue = "1")int page,
                                   Model model) {
        PageInfo<FactoryEntity> factoryEntityInfo = popupService.factoryFindByAll(factoryCondition, page);
        model.addAttribute("factoryList", factoryEntityInfo.getList());
        model.addAttribute("totalPages", factoryEntityInfo.getPages());
        return "admin/popupFactoryList";
    }
    @GetMapping("/popupPurchaseList")
    public String popupPurchaseList(@ModelAttribute ItemCondition itemCondition,
                                    @RequestParam(defaultValue = "1")int page,
                                    Model model) {
        PageInfo<PurchaseListModel> purchaseListPageInfo = purchaseService.findAll(itemCondition,page);
        model.addAttribute("categoryList", categoryList.getCategoryList());
        model.addAttribute("purchaseList", purchaseListPageInfo.getList());
        model.addAttribute("totalPages", purchaseListPageInfo.getPages());
        return "admin/popupPurchaseList";
    }
}

