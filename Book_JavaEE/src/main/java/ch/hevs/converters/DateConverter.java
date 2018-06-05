package ch.hevs.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="dateConverter")
public class DateConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
		Date date = new Date();
		System.out.println("Hello converter asObject");
			try {
				date = sdf.parse(value);
				return date; 
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return null;
		
	
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		System.out.println("Hello converter");
		SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
		Date date = (Date) value;
			
		return sdf.format(date);
	}

}
