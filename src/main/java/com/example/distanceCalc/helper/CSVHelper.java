package com.example.distanceCalc.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.example.distanceCalc.station.Station;
import com.example.distanceCalc.station.TrafficType;


//source: https://www.bezkoder.com/spring-boot-upload-csv-file/
public class CSVHelper {
	
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "EVA_NR", "DS100", "IFOPT", "NAME", "Verkehr", "Laenge", "Breite", "Betreiber_Name", "Betreiber_Nr", "Status"};

  public static boolean hasCSVFormat(MultipartFile file) {
    if (!TYPE.equals(file.getContentType())) {
      return false;
    }
    return true;
  }

  
  public static List<Station> csvToStations(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
        		CSVFormat.newFormat(';').withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) { //in our data ; as separator
      List<Station> stations = new ArrayList<Station>();
      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
      NumberFormat format = NumberFormat.getInstance(Locale.GERMANY); //because in our data a comma is used as decimal separator
      for (CSVRecord csvRecord : csvRecords) {
        Station station = null;
		try {
			station = new Station(
			      Integer.parseInt(csvRecord.get("EVA_NR")),
			      csvRecord.get("DS100"),
			      csvRecord.get("NAME"),
			      TrafficType.fromString(csvRecord.get("Verkehr").replaceAll(" ", "_")),
			      format.parse(csvRecord.get("Laenge")).doubleValue(),
			      format.parse(csvRecord.get("Breite")).doubleValue()
			    );
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(station != null) {
			stations.add(station);
		}
      }
      return stations;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }
  

}