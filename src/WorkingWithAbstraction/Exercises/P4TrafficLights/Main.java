package WorkingWithAbstraction.Exercises.P4TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] input = reader.readLine().split("\\s+");
        int n = Integer.parseInt(reader.readLine());

        List<TrafficLight> trafficLights = new LinkedList<>();
        for (String initialState : input) {
            TrafficLight trafficLight = new TrafficLight(LightStates.valueOf(initialState));
            trafficLights.add(trafficLight);
        }

        for (int i = 0; i < n; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.update();
                System.out.print(trafficLight.toString() + " ");
            }
            System.out.println();
        }

    }
}
