package org.example.unitconverter.services;

import org.springframework.stereotype.Service;

@Service
public class ConversionService {
    public double convertLength(double value, String from, String to) {
        double meters = switch (from) {
            case "m" -> value;
            case "cm" -> value / 100;
            case "mm" -> value / 1000;
            case "km" -> value * 1000;
            case "in" -> value * 0.0254;
            case "ft" -> value * 0.3048;
            case "yd" -> value * 0.9144;
            default -> throw new IllegalArgumentException("Invalid unit: " + from);
        };
        return switch (to) {
            case "m" -> meters;
            case "cm" -> meters * 100;
            case "mm" -> meters * 1000;
            case "km" -> meters / 1000;
            case "in" -> meters / 0.0254;
            case "ft" -> meters / 0.3048;
            case "yd" -> meters / 0.9144;
            default -> throw new IllegalArgumentException("Invalid unit: " + to);
        };
    }

    public double convertWeight(double value, String from, String to) {
        double grams = switch (from) {
            case "g" -> value;
            case "mg" -> value / 1000;
            case "kg" -> value * 1000;
            case "lb" -> value * 453.592;
            case "oz" -> value * 28.3495;
            default -> throw new IllegalArgumentException("Invalid unit: " + from);
        };
        return switch (to) {
            case "g" -> grams;
            case "mg" -> grams * 1000;
            case "kg" -> grams / 1000;
            case "lb" -> grams / 453.592;
            case "oz" -> grams / 28.3495;
            default -> throw new IllegalArgumentException("Invalid unit: " + to);
        };
    }

    public double convertTemperature(double value, String from, String to) {
        double celsius = switch (from) {
            case "C" -> value;
            case "F" -> (value - 32) * 5 / 9;
            case "K" -> value - 273.15;
            default -> throw new IllegalArgumentException("Invalid unit: " + from);
        };
        return switch (to) {
            case "C" -> celsius;
            case "F" -> celsius * 9 / 5 + 32;
            case "K" -> celsius + 273.15;
            default -> throw new IllegalArgumentException("Invalid unit: " + to);
        };
    }
}
