package dev.miage.inf2.course.bookstore.endpoint;

import dev.miage.inf2.course.bookstore.domain.BookShop;
import dev.miage.inf2.course.bookstore.model.BookDTO;
import dev.miage.inf2.course.bookstore.model.CustomerDTO;
import info.schnatterer.mobynamesgenerator.MobyNamesGenerator;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@Dependent
@Path("book")
public class BooksEndpoint {


    @Inject
    BookShop bookShop;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance booklist(Collection<BookDTO> books);

        public static native TemplateInstance formNew();
    }

    @Path("all")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getBooks() {
        return Templates.booklist(bookShop.getAllItems());
    }

    @Path("{isbn}")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getBook(@PathParam("isbn") String isbn) {
        Optional<BookDTO> book = bookShop.getAllItems().stream().filter(b -> b.isbn().equals(isbn)).findAny();
        if (book.isEmpty()) {
            throw new WebApplicationException(404);
        } else {
            return Templates.booklist(List.of(book.get()));
        }
    }

    @Path("{isbn}")
    @DELETE
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance buybook(@PathParam("isbn") String isbn) {
        bookShop.sell(new CustomerDTO(MobyNamesGenerator.getRandomName(), MobyNamesGenerator.getRandomName(), "toto@miage.dev", "+3395387845"), isbn);
        return Templates.booklist(bookShop.getAllItems());
    }

    @Path("form-new")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance newBookForm() {
        return Templates.formNew();
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response newbook(@FormParam("author") String authorParam, @FormParam("title") String title, @FormParam("isbn") String isbn, @FormParam("themes") String themesParam, @FormParam("isIt") Boolean isIt) throws URISyntaxException {
        Set<String> authors = new HashSet<>();
        authors.addAll(java.util.Arrays.asList(authorParam.split(",")));
        Set<String> themes = new HashSet<>();
        themes.addAll(java.util.Arrays.asList(themesParam.split(",")));
        BookDTO book = new BookDTO(authors, title, isbn, themes, Objects.equals(isIt,Boolean.TRUE));
        bookShop.stock(book);
        return Response.seeOther(new URI("/book/all")).build();
    }

    @Path("{isbn}/author")
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public Response changeAuthorNameForBook(@PathParam("isbn") String isbn, String newAuthorName) {
        bookShop.updateBookAuthorName(isbn, newAuthorName);
        return Response.accepted().build();

    }

    ;

    @Path("{isbn}/title")
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public Response changeTitleForBook(@PathParam("isbn") String isbn, String newTitle) {
        bookShop.updateBookTitle(isbn, newTitle);
        return Response.accepted().build();

    }

    ;
}
