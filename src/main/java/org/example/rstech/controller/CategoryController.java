package org.example.rstech.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.rstech.dto.CategoryDto.*;
import org.example.rstech.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    //@PreAuthorize("hasAnyRole('USER','ADMIN')")
    @Operation(summary = "Получить список всех категорий")
    @GetMapping
    public List<Response> list() {
        return service.list();
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Создать новую категорию")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response create(@Valid @RequestBody CreateRequest req) {
        return service.create(req);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Обновить категорию")
    @PutMapping("/{id}")
    public Response update(@PathVariable Long id, @RequestBody @Valid UpdateRequest req) {
        return service.update(id, req);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Удалить категорию")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

