package com.data.etl.processors;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * if you use bash shell do this:
 * cat u.data | cut -f1,2,3 | tr "\\" ","
 *
 * Created by agebriel on 8/1/17.
 */
public class MovieLensDataConverter
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader("Mahout/data/u.data"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("Mahout/data/movies.csv"));

		String line = null;
		while((line = reader.readLine()) != null)
		{
			String[] fields = line.split("\\t", -1);
			writer.write(fields[0] + "," + fields[1] + "," + fields[2] + "\n");
		}

		reader.close();
		writer.close();
	}
}
