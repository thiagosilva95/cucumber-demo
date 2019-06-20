package com.tdev.converters;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.cucumber.cucumberexpressions.Transformer;

public class DateConverter implements Transformer<Date> {

	public Date transform(String arg) throws Throwable {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date retorno = format.parse(arg);
			return retorno;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
