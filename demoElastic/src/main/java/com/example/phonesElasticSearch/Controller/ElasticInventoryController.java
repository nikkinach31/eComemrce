package com.example.phonesElasticSearch.Controller;

import com.example.phonesElasticSearch.Entity.Product;
import com.example.phonesElasticSearch.Repository.PhonesRepository;
import com.example.phonesElasticSearch.Services.impl.ElasticProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/search")
public class ElasticInventoryController {
    @Autowired
    ElasticProductServiceImpl elasticProductService;
    @Autowired
    PhonesRepository phonesRepository;

    @CrossOrigin(origins = "http://localhost:8082")
    @PostMapping("/save")
    public int savePhone(@RequestBody List<Product> phones) {
        for (Product  p:phones
             ) {


        phonesRepository.save(p);}
        return phones.size();
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping(value="/findAll")
    List<Product> findAll(){
//        System.out.println(findById("0").getProductId());
        return elasticProductService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping(value="/search/{item}")
    List<Product> generalSearch(@PathVariable("item") String item){
        return elasticProductService.generalSearch(item);
    }

//    @PostMapping(value="/updateInventory/{productId}/{newQuantity}")
//    void updateInventory(@PathVariable("productId") String id,@PathVariable("newQuantity") int newQuantity){
//        Product p=findById(id);
//        int updatedQty=p.getQuantity()+newQuantity;
//        p.setQuantity(updatedQty);
//        save(p);
//        System.out.println(p.getProductId());
//    }

//    @GetMapping(value="/search/{brand}/{item}")
//    List<Product> constrainedSearch(@PathVariable("item") String item,@PathVariable("brand") String brand){
//        return elasticProductService.constrainedSearch(brand,item);
//    }

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping(value="/search/{brand}/{item}")
    List<Product> multisearch(@PathVariable("item") String item,@PathVariable("brand") String brand){
//        System.out.println("\n \n \n  CALLLEDDDD \n \n \n ");
        return elasticProductService.multisearch(brand,item);
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping(value="/search/{brand}/{item}/{color}/{memory}")
    List<Product> multisearch(@PathVariable("item") String item,@PathVariable("brand") String brand,@PathVariable("color") String color,@PathVariable("memory") String memory){
//        System.out.println("\n \n \n  CALLLEDDDD \n \n \n ");
        return elasticProductService.multimultisearch(brand,item,color,memory);
    }

//    @GetMapping(value="/search/{brand}/{item}/{color}")
//    List<Product> constrained2search(@PathVariable("brand") String brand,@PathVariable("item") String item,@PathVariable("color") String color)
//    {
//        return elasticProductService.constrainedSearch2(brand,item,color);
//    }

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping(value="/getTop")
    List<Product> getTop5(){
        return elasticProductService.getTop5();
    }

//    @GetMapping(value="/getTopByGenre/{genre}")
//    List<Product> getTopByGenre(@PathVariable("genre")String genre){
//        return elasticProductService.getTopByGenre(genre);
//    }

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping(value="prodId/{productId}")
    Product findById(@PathVariable("productId") String productId){
        return elasticProductService.findById(productId);
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @PostMapping
    public int save(@RequestBody List<Product> phone){
        return elasticProductService.save(phone);
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @DeleteMapping(value="prodId/{productId}")
    public void deleteById(@PathVariable("employeeId") String productId){
        elasticProductService.deleteById(productId);
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @PutMapping
    public int edit(@RequestBody List<Product> phone){
        return elasticProductService.save(phone);
    }
}
