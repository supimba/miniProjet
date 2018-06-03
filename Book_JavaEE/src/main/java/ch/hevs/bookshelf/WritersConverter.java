package ch.hevs.bookshelf;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import ch.hevs.businessobject.Writer;

@FacesConverter("writerConverter")
public class WritersConverter implements Converter {

	@EJB
	private BookShelfBean bookshelf;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
		  if (submittedValue == null || submittedValue.isEmpty()) {
	            return null;
	        }
System.out.println("Hello CONVERTER Writer");
	        try {
	        	Writer writer = bookshelf.getWriter(Long.valueOf(submittedValue));
	            return writer;
	        } catch (NumberFormatException e) {
	            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Writer ID", submittedValue)), e);
	        }
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
		if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof Writer) {
            return String.valueOf(((Writer) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Writer", modelValue)));
        }
	}

}
