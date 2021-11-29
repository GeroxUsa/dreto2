/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto2_web.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reto2_web.Model.HairProducts;
import reto2_web.Service.HairProductService;

/**
 *
 * @author Adri
 */

@RestController
@RequestMapping("api/hairproducts")
@CrossOrigin("*")
public class HairProductsController {
     @Autowired
    private HairProductService hairProductService;

    @GetMapping("/all")
    public List<HairProducts> getAll() {
        return hairProductService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<HairProducts> getProduct(@PathVariable("reference") String reference) {
        return hairProductService.getProduct(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public HairProducts create(@RequestBody HairProducts gadget) {
        return hairProductService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public HairProducts update(@RequestBody HairProducts product) {
        return hairProductService.update(product);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return hairProductService.delete(reference);
    }
}
