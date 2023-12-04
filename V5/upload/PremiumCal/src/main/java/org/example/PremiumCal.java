package org.example;

public class PremiumCal {
    public double calculatePremium(BreakDownCover breakdownCover, boolean windscreenRepair, int accidents, int mileage, double estimatedValue, ParkingLocation parkingLocation) {

        double premium = 0.0;

        // Do not proceed if estimated value is too low
        if (estimatedValue < 100.0) {
            return 0;
        }

        // Calculate premium based on breakdown cover
        switch (breakdownCover) {
            case NO_COVER:
                estimatedValue *= 0.01;
                break;
            case ROADSIDE:
                estimatedValue *= 0.02;
                break;
            case AT_HOME:
                estimatedValue *= 0.03;
                break;
            case EUROPEAN:
                estimatedValue *= 0.04;
                break;
        }

        // Increment premium for windscreen repair
        if (windscreenRepair) {
            premium += 30.0;
        }

        // Increment premium for high mileage
        if (mileage > 5000) {
            premium += 50.0;
        }

        // Increment premium for public place parking
        if (parkingLocation == ParkingLocation.PUBLIC_PLACE) {
            premium += 30.0;
        }

        double result = premium+estimatedValue;

        // Apply discount if no accidents last year
        if (accidents == 0) {
            result *= 0.7;
        }
        return result;
    }
}
