package springframework.akshat.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.akshat.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
}
