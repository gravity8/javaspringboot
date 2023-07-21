package gravity.springframework.spring5webapp.bootstrap;

import gravity.springframework.spring5webapp.domain.Author;
import gravity.springframework.spring5webapp.domain.Book;
import gravity.springframework.spring5webapp.domain.Publisher;
import gravity.springframework.spring5webapp.repositories.AuthorRepository;
import gravity.springframework.spring5webapp.repositories.BookRepository;
import gravity.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG publishing");
        publisher.setCity("St Peterburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);



        publisherRepository.save(publisher);
        Author rod =  new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB","8374982023");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);





        System.out.println("started in Bootstrap");
        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Number of books by Publisher are: " + publisher.getBooks().size());

    }
}
