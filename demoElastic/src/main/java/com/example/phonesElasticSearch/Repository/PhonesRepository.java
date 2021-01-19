package com.example.phonesElasticSearch.Repository;

import com.example.phonesElasticSearch.Entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PhonesRepository extends ElasticsearchRepository<Product, String> {

    List<Product> findByModelName(String modelName);
}
