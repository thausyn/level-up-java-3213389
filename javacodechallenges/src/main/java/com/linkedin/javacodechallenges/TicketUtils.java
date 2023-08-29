package com.linkedin.javacodechallenges;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class TicketUtils {

  public static List<Ticketholder> importTicketHoldersFromCSV(String filename) 
    throws IOException, CsvValidationException {

    List<Ticketholder> ticketholdersList = new ArrayList<>();

    if (!filename.contains(".csv")) {
      System.out.println("This is not a csv file. " + filename);
      return ticketholdersList;
    }    

    FileInputStream fis = new FileInputStream(filename);
    InputStreamReader reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
    CSVReader csvReader = new CSVReader(reader);
    csvReader.readNext();

    String[] row;
    while((row = csvReader.readNext()) != null){
      ticketholdersList.add(new Ticketholder(row[0].trim(), Integer.parseInt(row[1])));
    }

    csvReader.close();
    return ticketholdersList;
  }

  public static Optional<Ticketholder> findTicketHolder(String name, List<Ticketholder> ticketholdersList) {
    return ticketholdersList.stream().filter(ticketHolder -> 
      StringUtils.equalsIgnoreCase(name, ticketHolder.getName())).findFirst();
  }

  public static boolean processTickets(Ticketholder ticketHolder, int numberInParty,
      List<Ticketholder> ticketholdersList) {

    int leftover = ticketHolder.getQuantity() - numberInParty;

    if(leftover < 0){
      System.out.println("You don't have enough tickets for your whole party. You only have " + 
      ticketHolder.getQuantity());
      return false;
    }

    if(leftover != 0){
      System.out.println("I see you still have more coming. I'm keeping your name on the list for them!");
      ticketHolder.setQuantity(leftover);
      return true;
    }

    ticketholdersList.remove(ticketHolder);
    return true;
  }

}
