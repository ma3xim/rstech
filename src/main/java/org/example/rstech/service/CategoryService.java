package org.example.rstech.service;

import org.example.rstech.dto.CategoryDto.*;
import org.example.rstech.exception.NotFoundException;
import org.example.rstech.model.*;
import org.example.rstech.repository.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepo;
    private final ProductRepository productRepo;
    private final ModelMapper mapper;

    public Response create(CreateRequest req) {
        Category c = mapper.map(req, Category.class);
        c = categoryRepo.save(c);
        return mapper.map(c, Response.class);
    }

    public List<Response> list() {
        return categoryRepo.findAll().stream().map(c -> mapper.map(c,
                Response.class)).toList();
    }

    @Transactional
    public Response update(Long id, UpdateRequest req) {
        Category c = categoryRepo.findById(id).orElseThrow(() -> new
                NotFoundException("Категория не найдена"));
        if (req.getName() != null) {
            c.setName(req.getName());
        }
        if (req.getDescription() != null) {
            c.setDescription(req.getDescription());
        }
        return mapper.map(c, Response.class);
    }

    @Transactional
    public void delete(Long id) {
        Category c = categoryRepo.findById(id).orElseThrow(() -> new
                NotFoundException("Категория не найдена"));
        productRepo.findAll().stream()
                .filter(p -> p.getCategory() != null &&
                        p.getCategory().getId().equals(id))
                .forEach(p -> {
                    p.setStatus(false);
                    p.setCategory(null);
                });
        categoryRepo.delete(c);
    }
}

