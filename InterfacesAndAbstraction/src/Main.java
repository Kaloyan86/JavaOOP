import Telephony.Smartphone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> phoneNumbers = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

       List<String> sites = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        Smartphone smartphone = new Smartphone(phoneNumbers,sites);


        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());

    }

}
