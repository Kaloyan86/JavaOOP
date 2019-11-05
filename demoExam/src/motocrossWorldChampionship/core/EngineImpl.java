package motocrossWorldChampionship.core;

import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.core.interfaces.Engine;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.io.interfaces.OutputWriter;
import motocrossWorldChampionship.repositories.MotorcycleRepository;
import motocrossWorldChampionship.repositories.RaceRepository;
import motocrossWorldChampionship.repositories.RiderRepository;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.Scanner;

public class EngineImpl implements Engine, OutputWriter {
    private ChampionshipController championshipController;
    private Scanner scanner;

    private Repository<Rider> ridersRepository;
    private Repository<Motorcycle> motorcycleRepository;
    private Repository<Race> raceRepository;

    public EngineImpl() {
        this.ridersRepository = new RiderRepository();
        this.motorcycleRepository = new MotorcycleRepository();
        this.raceRepository = new RaceRepository();
        this.championshipController = new ChampionshipControllerImpl(this.ridersRepository,this.motorcycleRepository,this.raceRepository);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {

        String line = "";

        while (!"End".equals(line = scanner.nextLine())) {

            String output = "";

            String[] lineArray = line.split("\\s+");

            String command = lineArray[0];

            switch (command) {
                case "CreateRider":

                    String riderToCreate = lineArray[1];

                    try {
                        output = this.championshipController.createRider(riderToCreate);
                        writeLine(output);
                    } catch (Exception e) {
                        writeLine(e.getMessage());
                    }

                    break;
                case "CreateMotorcycle":

                    String motorcycleType = lineArray[1];
                    String motorcycleModel = lineArray[2];
                    int motorcycleHorsepower = Integer.parseInt(lineArray[3]);

                    try {
                        output = this.championshipController.createMotorcycle(motorcycleType, motorcycleModel, motorcycleHorsepower);
                        writeLine(output);
                    } catch (Exception e) {
                        writeLine(e.getMessage());
                    }

                    break;
                case "AddMotorcycleToRider":

                    String riderName = lineArray[1];
                    String motorcycleToAdd = lineArray[2];

                    try {
                        output = this.championshipController.addMotorcycleToRider(riderName, motorcycleToAdd);
                        writeLine(output);
                    } catch (Exception e) {
                        writeLine(e.getMessage());
                    }


                    break;
                case "AddRiderToRace":

                    String raceName = lineArray[1];
                    String riderToAdd = lineArray[2];

                    try {
                        output = this.championshipController.addRiderToRace(raceName, riderToAdd);
                        writeLine(output);
                    } catch (Exception e) {
                        writeLine(e.getMessage());
                    }

                    break;
                case "CreateRace":

                    String raceToCreate = lineArray[1];
                    int laps = Integer.parseInt(lineArray[2]);

                    try {
                        output = this.championshipController.createRace(raceToCreate, laps);
                        writeLine(output);
                    } catch (Exception e) {
                        writeLine(e.getMessage());
                    }

                    break;
                case "StartRace":

                    String raceToStart = lineArray[1];

                    try {
                        output = this.championshipController.startRace(raceToStart);
                        writeLine(output);
                    } catch (Exception e) {
                        writeLine(e.getMessage());
                    }

                    break;
            }

        }

    }


    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
