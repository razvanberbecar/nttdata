package com.example.demo.Service;

import com.example.demo.Model.Pet;
import com.example.demo.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getPets(){
        return petRepository.findAll();
    }

    public List<Pet> getPetsByType (String type){
        return petRepository.findByType(type);
    }

    public List<Pet> getPetsSortedBy(String field){
        String[] parts = field.split(",");
        Sort.Direction direction = parts.length > 1 && "desc".equalsIgnoreCase(parts[1])
            ? Sort.Direction.DESC
            : Sort.Direction.ASC;
        return petRepository.findAllSorted(Sort.by(direction, parts[0]));
    }

    public void addNewPet(Pet pet) {
        Optional<Pet> petOptional = petRepository.findByOwner(pet.getOwner());
        if(petOptional.isPresent()) throw new IllegalStateException("Pet with owner already exists");

        petRepository.save(pet);
    }

    public void deletePet(Long petId) {
        boolean exists = petRepository.existsById(petId);
        if(!exists) throw new IllegalStateException("Pet with id " + petId + " does not exist");
        petRepository.deleteById(petId);
    }

    @Transactional
    public void updatePet(Long petId, String name, String owner) {
        Pet pet = petRepository.findById(petId).orElseThrow(() -> new IllegalStateException("Pet with id " + petId + " does not exist"));
        if (name != null && name.length() > 0 && !pet.getName().equals(name)) {
            pet.setName(name);
        }
        if (owner != null && owner.length() > 0 && !pet.getOwner().equals(owner)) {
            Optional<Pet> petOptional = petRepository.findByOwner(owner);
            if(petOptional.isPresent()) throw new IllegalStateException("Pet with owner already exists");
            pet.setOwner(owner);
        }
    }
}
