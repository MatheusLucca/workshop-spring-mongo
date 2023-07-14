package matlucca.workshopspringmongo.services;

import matlucca.workshopspringmongo.entities.Post;
import matlucca.workshopspringmongo.repositories.PostRepository;
import matlucca.workshopspringmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Post post = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return post;
    }
}
