package edu.umb.cs681.hw03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.rotateLeft;
import static java.lang.Integer.sum;

public class CovidDataCSV {

    public static void main(String[] args) {

        Path path = Paths.get("Data" ,"CovidPVI_Data.txt");
        try( Stream<String> lines = Files.lines(path) ){
            List<List<String>> matrix = lines.map( line -> {
                return Stream.of( line.split(",") )
                    .map(value->value.substring(0, value.length()))
                    .collect( Collectors.toList() ); })
                    .collect( Collectors.toList() );


            List Mass = matrix.stream().filter((i) -> i.get(4).contains("Massachusetts")).collect(Collectors.toList());

            List suffolk = matrix.stream().filter((i) -> i.get(5).contains("Suffolk")).collect(Collectors.toList()).get(0);
            System.out.println("\n1. Number of deaths occurred in the Suffolk county of the Massachusetts state are: " + suffolk.get(7));

            String deathInMA = matrix.stream().filter((i) -> i.get(4).contains("Massachusetts"))
                    .map((i) -> i.get(7)).reduce("0", (subtotal, element) -> String.valueOf(Integer.parseInt(subtotal) + Integer.parseInt(element)));

            System.out.println("\n2. Total number of deaths in State of Massachusetts are: " + deathInMA);

            System.out.println("\n3. Average number of deaths in State of Massachusetts are: " + Integer.parseInt(deathInMA)/Mass.size());



        }

        catch(IOException ex) {
            ex.printStackTrace();
        }

    }
}
