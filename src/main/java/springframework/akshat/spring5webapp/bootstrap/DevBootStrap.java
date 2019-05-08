package springframework.akshat.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import springframework.akshat.spring5webapp.model.Author;
import springframework.akshat.spring5webapp.model.Book;
import springframework.akshat.spring5webapp.model.Publisher;
import springframework.akshat.spring5webapp.repositories.AuthorRepository;
import springframework.akshat.spring5webapp.repositories.BookRepository;
import springframework.akshat.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        initData();
    }

    private void initData() {

        Publisher harper = new Publisher("Harper Collins");
        Publisher worx = new Publisher("Worx");

        publisherRepository.save(harper);
        publisherRepository.save(worx);

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","1234",harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB","23444",worx);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
