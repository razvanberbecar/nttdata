package com.example.demo.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/pet")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> getPets(){
        return petService.getPets();
    }

    @GetMapping(path = "sort")
    public List<Pet> getPetsSortedBy(@RequestParam(required = false) String field) { return petService.getPetsSortedBy(field); }

    @GetMapping(path = "{type}")
    public List<Pet> getPetsByType(@PathVariable("type") String type) { return petService.getPetsByType(type); }

    @PostMapping
    public void registerPet(@RequestBody Pet pet){
        petService.addNewPet(pet);
    }

    @DeleteMapping(path = "{petId}")
    public void deletePet(@PathVariable("petId") Long petId){
        petService.deletePet(petId);
    }

    @PutMapping(path = "{petId}")
    public void updatePet(
            @PathVariable("petId") Long petId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String owner) {
                petService.updatePet(petId, name, owner);
    }

}
