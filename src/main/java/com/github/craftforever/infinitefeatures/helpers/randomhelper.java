package com.github.craftforever.infinitefeatures.helpers;

import java.util.Random;

// Class used for randomly generating numbers & values
public class randomhelper {
    public static int getRandomNumberInRange(int min, int max, Random random) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return random.nextInt((max - min) + 1) + min;
    }

    public static double getRandomGaussianInRange(double mean, double standardDeviation, double min, double max, Random random){
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        if (mean - 3*standardDeviation < min || mean + 3*standardDeviation > max){
            // There is a > 0.3% chance that when a number is generated it will lie outside the min-max range

            // TODO: The user has picked risky/poor parameters which will lead to the randomness not being correct, idk what to do here.
        }

        double randomValue = 0D;
        do {
            randomValue = mean + random.nextGaussian() * standardDeviation;

            // ensure a legitimate value is generated
        } while (randomValue < min || randomValue > max);

        return randomValue;
    }

}
