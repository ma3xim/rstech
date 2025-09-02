package org.example.rstech.service;

import org.example.rstech.dto.ProductDto.*;
import org.example.rstech.exception.NotFoundException;
import org.example.rstech.model.*;

import org.example.rstech.repository.*;
import org.example.rstech.specification.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;
    private final ModelMapper mapper;

    @Transactional
    public Response create(CreateRequest req) {
        Category category = categoryRepo.findById(req.getCategoryId())
                .orElseThrow(() -> new NotFoundException("Категория не найдена"));

        Product p = Product.builder()
                .name(req.getName())
                .description(req.getDescription())
                .price(req.getPrice())
                .imageUrl(req.getImageUrl())
                .category(category)
                .createdAt(LocalDateTime.now())
                .status(req.getStatus() == null ? true : req.getStatus())
                .build();
        p = productRepo.save(p);
        return toResponse(p);
    }

    @Transactional
    public Response update(Long id, UpdateRequest req) {
        Product p = productRepo.findById(id).orElseThrow(() -> new
                NotFoundException("Продукт не найден"));
        if (req.getName() != null) p.setName(req.getName());
        if (req.getDescription() != null)
            p.setDescription(req.getDescription());
        if (req.getPrice() != null) p.setPrice(req.getPrice());
        if (req.getImageUrl() != null) p.setImageUrl(req.getImageUrl());
        if (req.getStatus() != null) p.setStatus(req.getStatus());
        if (req.getCategoryId() != null) {
            Category c = categoryRepo.findById(req.getCategoryId())
                    .orElseThrow(() -> new NotFoundException("Категория не найдена"));
            p.setCategory(c);
        }
        return toResponse(p);
    }

    public void delete(Long id) {
        if (!productRepo.existsById(id)) throw new
                NotFoundException("Продукт не найден");
        productRepo.deleteById(id);
    }

    public Page<Response> search(Long categoryId, String name, BigDecimal
            minPrice, BigDecimal maxPrice, Boolean active, Pageable pageable) {
        Specification<Product> spec =
                ProductSpecification.byFilters(categoryId, name, minPrice, maxPrice, active);
        return productRepo.findAll(spec, pageable).map(this::toResponse);
    }

    private Response toResponse(Product p) {
        return Response.builder()
                .id(p.getId())
                .name(p.getName())
                .description(p.getDescription())
                .price(p.getPrice())
                .imageUrl(p.getImageUrl())
                .categoryId(p.getCategory() != null ? p.getCategory().getId() :
                        null)
                .categoryName(p.getCategory() != null ?
                        p.getCategory().getName() : null)
                .createdAt(p.getCreatedAt().toString())
                .status(p.isStatus())
                .build();
    }
}