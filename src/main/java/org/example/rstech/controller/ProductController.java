package org.example.rstech.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.rstech.dto.ProductDto.*;
import org.example.rstech.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    //@PreAuthorize("hasAnyRole('USER','ADMIN')")
    @Operation(summary = "Найти продукты")
    @GetMapping
    public Page<Response> search(@RequestParam(required = false) Long categoryId,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) BigDecimal minPrice,
                                 @RequestParam(required = false) BigDecimal maxPrice,
                                 @RequestParam(required = false) Boolean active,
                                 @RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "20") int size,
                                 @RequestParam(defaultValue = "id,desc") String sort) {
        String[] sp = sort.split(",");
        Pageable pageable = PageRequest.of(page, size,
                Sort.by(Sort.Direction.fromString(sp[1]), sp[0]));
        return service.search(categoryId, name, minPrice, maxPrice, active,
                pageable);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Создать новый продукт")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response create(@Valid @RequestBody CreateRequest req) {
        return
                service.create(req);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Обновить продукт")
    @PutMapping("/{id}")
    public Response update(@PathVariable Long id,
                           @Valid @RequestBody UpdateRequest req) {
        return service.update(id, req);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Удалить продукт")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

