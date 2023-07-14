package matlucca.workshopspringmongo.config;

import matlucca.workshopspringmongo.dto.AuthorDTO;
import matlucca.workshopspringmongo.entities.Post;
import matlucca.workshopspringmongo.entities.User;
import matlucca.workshopspringmongo.repositories.PostRepository;
import matlucca.workshopspringmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Maria Brown", "maria@gmail.com");
        User u2 = new User(null, "Alex Green", "alexgreen@gmail.com");
        User u3 = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(List.of(u1, u2, u3));
        Post p1 = new Post(null, sdf.parse("21/03/2021"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));
        Post p2 = new Post(null, sdf.parse("23/03/2021"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(u1));



        postRepository.saveAll(List.of(p1, p2));

        u1.getPosts().addAll(List.of(p1, p2));
        userRepository.save(u1);

    }

}
