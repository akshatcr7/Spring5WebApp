package springframework.akshat.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.akshat.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
