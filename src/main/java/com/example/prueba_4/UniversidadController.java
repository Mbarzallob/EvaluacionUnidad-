package com.example.prueba_4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UniversidadController {

    @Autowired
    private UniversidadRepository repo;

    @GetMapping("/universidades")
    public List<Universidades> getAll() {
        return repo.findAll();
    }

    @PostMapping("/universidades")
    public Universidades create(@RequestBody Universidades u) {
        return repo.save(u);
    }

    @PutMapping("/universidades/{id}")
    public Universidades update(@PathVariable Long id, @RequestBody Universidades u) {
        u.setId(id);
        return repo.save(u);
    }

    @DeleteMapping("/universidades/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}