package edu.umb.cs681.hw17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CovidDataCSV {

    public static void main(String[] args) {

        Path path = Paths.get("Data" ,"CovidPVI_Data.txt");
        try( Stream<String> lines = Files.lines(path) ){

            List<List<String>> matrix = lines.map( line -> {
                return Stream.of( line.split(",") )
                        .map(value->value.substring(0, value.length()))
                        .collect( Collectors.toList() ); })
                    .collect( Collectors.toList() );


            String deathInMA = matrix.stream().filter((i) -> i.get(4).contains("Massachusetts")).parallel()
                    .map((i) -> i.get(7))
                    .reduce("0", (subtotal, element) -> String.valueOf(Integer.parseInt(subtotal) + Integer.parseInt(element)));

            System.out.println("Total number of deaths due to Covid in Massachusetts are: " + deathInMA);


            String deathInSuffolk = matrix.stream().filter((i) -> i.get(5).contains("Suffolk")).parallel()
                    .map((i) -> i.get(7))
                    .reduce("0", (subtotal, element) -> String.valueOf(Integer.parseInt(subtotal) + Integer.parseInt(element)));

            System.out.println("Total number of deaths due to Covid in Suffolk county are: " + deathInSuffolk);

            String max_deathMA = matrix.stream().filter((i) -> i.get(4).contains("Massachusetts")).parallel()
                    .map((i) -> i.get(7))
                    .reduce("0", (result, max_deaths) -> Integer.parseInt(result) > Integer.parseInt(max_deaths) ? result : max_deaths);

            System.out.println("Maximum number of deaths occurred in a county in Massachusetts are: " + max_deathMA);

        }

        catch(IOException ex) {
            ex.printStackTrace();
        }

    }
}
