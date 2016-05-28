package edu.zipcloud.cloudstreetmarket.core.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.zipcloud.cloudstreetmarket.core.entities.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

}
