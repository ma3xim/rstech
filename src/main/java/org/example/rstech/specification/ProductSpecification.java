package org.example.rstech.specification;

import org.example.rstech.model.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductSpecification {

    public static Specification<Product> byFilters(Long categoryId, String name, BigDecimal minPrice, BigDecimal maxPrice, Boolean active) {
        return Specification.<Product>where(categoryId == null ? null : (root, q, cb) ->
                        cb.equal(root.get("category").get("id"), categoryId))
                .and(name == null || name.isBlank() ? null : (root, q, cb) ->
                        cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"))
                .and(minPrice == null ? null : (root, q, cb) ->
                        cb.greaterThanOrEqualTo(root.get("price"), minPrice))
                .and(maxPrice == null ? null : (root, q, cb) ->
                        cb.lessThanOrEqualTo(root.get("price"), maxPrice))
                .and(active == null ? null : (root, q, cb) ->
                        cb.equal(root.get("active"), active));
    }
}

