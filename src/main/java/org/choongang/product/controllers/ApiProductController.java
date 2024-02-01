package org.choongang.product.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.commons.ListData;
import org.choongang.commons.rests.JSONData;
import org.choongang.product.entities.Product;
import org.choongang.product.service.ProductInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ApiProductController {

    private final ProductInfoService productInfoService;
    @GetMapping("/view_product")
    public JSONData<List<Product>> viewProduct(@RequestParam("seq") List<Long> seqs) {
        ProductSearch search = new ProductSearch();
        search.setLimit(10000);
        search.setSeq(seqs);

        ListData<Product> data = productInfoService.getList(search, true);

        return new JSONData<>(data.getItems());
    }
}
