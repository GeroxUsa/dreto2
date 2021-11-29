/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto2_web.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto2_web.Interface.HairProductsInterface;
import reto2_web.Model.HairProducts;

/**
 *
 * @author Adri
 */
@Repository
public class HairProductsRepository {
    @Autowired
    private HairProductsInterface hairProductsCrudRepository;
    
    public List<HairProducts> getAll() {
        return hairProductsCrudRepository.findAll();
    }
    public Optional<HairProducts> getProduct(String Reference) {
        return hairProductsCrudRepository.findById(Reference);
    }

    public HairProducts create(HairProducts hairProducts) {
        return hairProductsCrudRepository.save(hairProducts);
    }

    public void update(HairProducts hairProducts) {
        hairProductsCrudRepository.save(hairProducts);
    }

    public void delete(HairProducts hairProducts) {
        hairProductsCrudRepository.delete(hairProducts);
    }

}
