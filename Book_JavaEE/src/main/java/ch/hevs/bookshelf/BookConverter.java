package ch.hevs.bookshelf;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Book;


@FacesConverter("bookConverter")
public class BookConverter implements Converter {
	
	@EJB
	private BookShelf bookshelf;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
		if (submittedValue == null || submittedValue.isEmpty()) {
			return null;
		}
		System.out.println("Hello CONVERTER Book");
		try {
			InitialContext ctx = new InitialContext();
			bookshelf = (BookShelf) ctx.lookup("java:global/Book_JavaEE-0.0.1-SNAPSHOT/BookShelfBean!ch.hevs.bookshelf.BookShelf");
			
			Book book = bookshelf.getBook(Long.valueOf(submittedValue));
			return book;
		} catch (NumberFormatException | NamingException e) {
			throw new ConverterException(new FacesMessage(String.format("%s is not a valid Book ID", submittedValue)),
					e);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
		if (modelValue == null) {
            return "";
        }
System.out.println("HEllo converter getAsString()");
        if (modelValue instanceof Book) {
            return String.valueOf(((Book) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Book", modelValue)));
        }
	}

}
