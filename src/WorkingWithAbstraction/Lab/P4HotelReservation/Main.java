package WorkingWithAbstraction.Lab.P4HotelReservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split("\\s+");

        double price = Double.parseDouble(data[0]);
        int days = Integer.parseInt(data[1]);

        Season season = Season.valueOf(data[2].toUpperCase());
        Discount discount = Discount.valueOf(data[3].toUpperCase());

        Reservation reservation = new Reservation(price, days, season, discount);

        double total = PriceCalculator.calculate(reservation);

        System.out.printf("%.2f", total);

    }

}
