package com.example.demo.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addNewProduct(Product product){
        Optional<Product> productOptional = productRepository.findProductByProductName(product.getProductName() );
        if( productOptional.isPresent() ){
            throw new IllegalStateException("name taken");
        }
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        boolean exist = productRepository.existsById(productId);
        if (!exist){
            throw new IllegalStateException(
                    "student with id "+ productId + " does not exists");
        }
        productRepository.deleteById(productId);
    }
    @Transactional
    public void updateProduct(Long productId, Product productDetails){
        Product product = productRepository.findById(productId).orElseThrow( ()-> new IllegalStateException( "Bad Id") );
        if (productDetails != null && !Objects.equals(product.getProductName(), productDetails.getProductName())){
            product.setProductName(productDetails.getProductName());
            product.setCategory(productDetails.getCategory());
            product.setComment(productDetails.getCategory());
            product.setFreshness(productDetails.getFreshness());
            product.setDate(productDetails.getDate());
            product.setPrice(productDetails.getPrice());
        }
    }


}
