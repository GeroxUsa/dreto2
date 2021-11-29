/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto2_web.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto2_web.Model.HairProducts;
import reto2_web.Repository.HairProductsRepository;

/**
 *
 * @author Adri
 */
@Service
public class HairProductService {
    @Autowired
    private HairProductsRepository hairProductsRepository;

    public List<HairProducts> getAll() {
        return hairProductsRepository.getAll();
    }

    public Optional<HairProducts> getProduct(String reference) {
        return hairProductsRepository.getProduct(reference);
    }

    public HairProducts create(HairProducts hairProducts) {
        if (hairProducts.getReference() == null) {
            return hairProducts;
        } else {
            return hairProductsRepository.create(hairProducts);
        }
    }

    public HairProducts update(HairProducts hairProducts) {

        if (hairProducts.getReference() != null) {
            Optional<HairProducts> accesoryDb = hairProductsRepository.getProduct(hairProducts.getReference());
            if (!accesoryDb.isEmpty()) {
                
                if (hairProducts.getBrand()!= null) {
                    accesoryDb.get().setBrand(hairProducts.getBrand());
                }
                
                if (hairProducts.getCategory() != null) {
                    accesoryDb.get().setCategory(hairProducts.getCategory());
                }
                
                if (hairProducts.getDescription() != null) {
                    accesoryDb.get().setDescription(hairProducts.getDescription());
                }
                if (hairProducts.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(hairProducts.getPrice());
                }
                if (hairProducts.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(hairProducts.getQuantity());
                }
                if (hairProducts.getPhotography() != null) {
                    accesoryDb.get().setPhotography(hairProducts.getPhotography());
                }
                accesoryDb.get().setAvailability(hairProducts.isAvailability());
                hairProductsRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return hairProducts;
            }
        } else {
            return hairProducts;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getProduct(reference).map(accesory -> {
            hairProductsRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
