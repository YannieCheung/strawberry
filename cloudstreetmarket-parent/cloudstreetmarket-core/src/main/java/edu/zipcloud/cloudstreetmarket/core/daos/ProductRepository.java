package edu.zipcloud.cloudstreetmarket.core.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import edu.zipcloud.cloudstreetmarket.core.entities.Product;
@Repository
public interface ProductRepository<T extends Product> extends JpaRepository<T, String>, JpaSpecificationExecutor<T>{

}
