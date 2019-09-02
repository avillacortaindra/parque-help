package com.tefper.daas.parque.util;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;

public class JsonUtil {

	public final static ObjectMapper	jsonMapper;

	public final static CsvParser		csvParser;

	static {
		jsonMapper = JsonFactory.create();

		// Configuration for CSV formats according to requirements
		CsvParserSettings settings = new CsvParserSettings();
		settings.getFormat().setQuote('\'');

		// creates a CSV parser
		csvParser = new CsvParser(settings);
	}

}
