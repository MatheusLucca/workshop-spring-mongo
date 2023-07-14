package matlucca.workshopspringmongo.services;

import matlucca.workshopspringmongo.entities.User;
import matlucca.workshopspringmongo.repositories.UserRepository;
import matlucca.workshopspringmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        User user = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); 
        return user;
    }


}
