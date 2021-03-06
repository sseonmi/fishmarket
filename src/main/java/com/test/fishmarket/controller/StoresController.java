package com.test.fishmarket.controller;

import com.test.fishmarket.dto.Stores;
import com.test.fishmarket.service.StoresService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/stores")
public class StoresController {
    @Autowired
    private StoresService storesService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getStore(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(storesService.getStore(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getStores() throws Exception {
        return new ResponseEntity<>(storesService.getStores(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> setStore(@RequestBody Stores stores) throws Exception {
        return new ResponseEntity<>(storesService.setStore(stores),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> removeStore(@PathVariable Long id) throws Exception {
        storesService.removeStore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}