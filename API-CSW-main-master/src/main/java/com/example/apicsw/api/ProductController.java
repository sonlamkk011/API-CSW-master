package com.example.apicsw.api;

import com.example.apicsw.entity.Product;
import com.example.apicsw.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    final ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Product> Save(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> Delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok("Deleted");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Product> Update(@RequestBody Product productDto, @PathVariable Long id) {
        return ResponseEntity.ok(productService.update(productDto, id));
    }

}
