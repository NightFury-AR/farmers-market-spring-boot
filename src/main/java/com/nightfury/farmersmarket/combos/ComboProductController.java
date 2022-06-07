package com.nightfury.farmersmarket.combos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("farmers-market/api/v1/combo-productvalidators/")
public class ComboProductController {

    List<ComboProduct> comboProductList = Arrays.asList(
            new ComboProduct(1L,"VegCombo","vegetables",Arrays.asList("carrot","chilly"),120,"100","2kg carrot , 3kg chilly availble. very fresh!","pollachi","night-fury"),
            new ComboProduct(2L,"nutsCombo","dry_fruits",Arrays.asList("carrot","chilly"),120,"100","2kg carrot , 3kg chilly availble. very fresh!","pollachi","night-fury"),
            new ComboProduct(3L,"groceriesCombo","groceries",Arrays.asList("carrot","chilly"),120,"100","2kg carrot , 3kg chilly availble. very fresh!","pollachi","night-fury")
    );

    @GetMapping
    public List<ComboProduct> getComboProductList() {
        if(comboProductList.size()==0) {
        }
        return comboProductList;
    }

    @GetMapping("{comboProductId}")
    public ComboProduct getComboProductById(@PathVariable Long comboProductId) {
        return comboProductList.stream()
                .filter( comboProduct -> comboProduct.getComboProductId() == comboProductId)
                .findFirst()
                .get();
    }

    @GetMapping("categories/{comboProductCategory}")
    public List<ComboProduct> getComboProductByCategories(@PathVariable String comboProductCategory) {
        return comboProductList.stream()
                .filter( comboProduct -> comboProduct.getComboProductCategory()==comboProductCategory)
                .collect(Collectors.toList());
    }

    @PostMapping
    public List<ComboProduct> addNewComboProduct(@RequestBody ComboProduct comboProduct) {
        if(comboProduct!=null) {
            comboProductList.add(comboProduct);
        }
        return comboProductList;
    }

    @DeleteMapping("remove/{comboProductId}")
    public List<ComboProduct> removeProduct(@PathVariable Long comboProductId) {
        ComboProduct comboProduct = comboProductList.stream()
                .filter(comboProduct1 -> comboProduct1.getComboProductId()==comboProductId)
                .findFirst().get();

        comboProductList.remove(comboProduct);
        return comboProductList;
    }


}
