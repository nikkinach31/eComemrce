package com.example.phonesElasticSearch.Services.impl;

import com.example.phonesElasticSearch.Entity.Product;
import com.example.phonesElasticSearch.Repository.PhonesRepository;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ElasticProductServiceImpl {
    @Autowired
    PhonesRepository phonesRepository;


    public int save(List<Product> product)
    {
        for(Product prod : product)
        {
            phonesRepository.save(prod);
        }
        return product.size();
    }

    public List<Product> generalSearch(String name) {
        QueryBuilder query = QueryBuilders.boolQuery()
                .should(
                        QueryBuilders.queryStringQuery(name)
                                .lenient(true)
                                .field("modelName").field("brand").field("color").field("memory"))
                .should(
                        QueryBuilders.queryStringQuery("*" + name + "*")
                        .lenient(true)
                        .field("modelName").field("brand").field("color").field("memory"));
        Query build = new NativeSearchQueryBuilder()
                                                    .withQuery(query)
                                                    .build();
        return phonesRepository.search(build).getContent();
    }
    public Product findById(String id){
        return phonesRepository.findById(id).get();

    }
    public List<Product> constrainedSearch(String brand,String modelName) {
        QueryBuilder query = QueryBuilders.boolQuery()
                .must(QueryBuilders.queryStringQuery(brand).field("brand"))
                .should(
                        QueryBuilders.queryStringQuery(modelName)
                                .lenient(true)
                                .field("modelName").field("brand").field("color").field("memory"))
                .should(
                        QueryBuilders.queryStringQuery("*" + modelName + "*")
                                .lenient(true)
                                .field("modelName").field("brand").field("color").field("memory"));


        Query build = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();
        return phonesRepository.search(build).getContent();
    }

    public List<Product> multisearch(String brand,String modelName) {
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(brand, modelName)
                .field("brand").field("modelName").field("color").field("memory")
                .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS);
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(multiMatchQueryBuilder)
                .build();
//        System.out.println(searchQuery);
        return phonesRepository.search(searchQuery).getContent();
    }

    public List<Product> multimultisearch(String brand,String modelName, String color, String memory) {
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(brand, modelName, color, memory)
                .field("brand").field("modelName").field("color").field("memory")
                .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS);
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(multiMatchQueryBuilder)
                .build();
//        System.out.println(searchQuery);
        return phonesRepository.search(searchQuery).getContent();
    }


//
//    public List<Product> constrainedSearch2(String genre,String name,String author) {
//        QueryBuilder query = QueryBuilders.boolQuery()
//                .must(QueryBuilders.queryStringQuery(genre).field("genre"))
//                .should(QueryBuilders.queryStringQuery(author).lenient(true).field("genre"))
//                .should(
//                        QueryBuilders.queryStringQuery(name)
//                                .lenient(true)
//                                .field("productName").field("genre").field("author").field("description"))
//                .should(
//                        QueryBuilders.queryStringQuery("*" + name + "*")
//                                .lenient(true)
//                                .field("productName").field("genre").field("author").field("description"));
//
////        Query build = new NativeSearchQueryBuilder().withSort(SortBuilders.fieldSort("productRating").order(SortOrder.DESC))
//        Query build = new NativeSearchQueryBuilder()
//                .withQuery(query)
//                .build();
//        return sortByRelevancy(phonesRepository.search(build).getContent());
//    }
//    public List<Product> listComparision(List<Product> ogList2){
//        if(ogList2==null || ogList2.size()<3)
//            return ogList2;
//        List<Product>ogList=new ArrayList<>(ogList2);
//        List<Product>newList=new ArrayList<>();
//        newList.add(ogList.remove(0));
//        newList.add(ogList.remove(0));
//        if (ogList.size()!=0){
//        Collections.sort(ogList, new Comparator<Product>() {
//            @Override
//            public int compare(Product p1, Product p2) {
//                return p2.getProductRating() - p1.getProductRating();
//            }
//        });
//
////        }}
//            Iterator<Product> productIterator=ogList.iterator();
//            while(productIterator.hasNext()){
//                newList.add(productIterator.next());
//            }}
//        return newList;
//    }

    public void deleteById(String id) {
        phonesRepository.deleteById(id);
    }
    public List<Product> getTopByBrand(String brand){
        QueryBuilder query = QueryBuilders.boolQuery()
                .must(QueryBuilders.queryStringQuery(brand).field("brand"));
        Query build = new NativeSearchQueryBuilder().withSort(SortBuilders.fieldSort("productRating").order(SortOrder.DESC)).withQuery(query)
                .build();
        return phonesRepository.search(build).getContent();
    }

    public List<Product> findAll() {
        Iterable<Product> employeeIterable= phonesRepository.findAll();
        List<Product> employeeList=new ArrayList<>();
        employeeIterable.forEach(employeeList::add);
        return employeeList;

    }
    public List<Product> getTop5(){
        List<Product>theBest=findAll();
        Collections.sort(theBest, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                int rate=p2.getRating() - p1.getRating();
                return (rate);
            }
        });

        return theBest;
    }
}
