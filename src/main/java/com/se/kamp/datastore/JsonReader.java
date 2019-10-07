package com.se.kamp.datastore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A class for Reading JSON files and return list of data objects
 * This class supports for all types(Organization, Ticket, User)
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public final class JsonReader<T>
{

  private final String fileName;

  public JsonReader(String fileName)
  {
    this.fileName = fileName;
  }

  public List<T> readData(Class<T[]> dataClass)
  {
    File file = new File(JsonReader.class.getResource(fileName).getFile());
    try (BufferedReader reader = new BufferedReader(new FileReader(file)))
    {
      Gson gson = new GsonBuilder().create();
      return Arrays.asList(gson.fromJson(reader, dataClass));
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }

    return Collections.emptyList();
  }

}
