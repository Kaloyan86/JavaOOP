package Telephony;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder();

        for (String site : urls) {
            try {
                for (char symbol : site.toCharArray()) {
                    if (Character.isDigit(symbol)) {
                        throw new IllegalArgumentException("Invalid URL!");
                    }
                }
                stringBuilder.append("Browsing: ").append(site).append("!").append(System.lineSeparator());
            } catch (IllegalArgumentException ex) {
                stringBuilder.append(ex.getMessage()).append(System.lineSeparator());
            }

        }


        return stringBuilder.toString();
    }

    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();

            for (String number : numbers) {
                try {
                for (char symbol : number.toCharArray()) {
                    if (!Character.isDigit(symbol)) {
                        throw new IllegalArgumentException("Invalid number!");
                    }
                }
                stringBuilder.append("Calling... ").append(number).append(System.lineSeparator());
                } catch (IllegalArgumentException ex) {
                    stringBuilder.append(ex.getMessage()).append(System.lineSeparator());
                }
            }




        return stringBuilder.toString();
    }
}
