package com.evercompliant.scrap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UrnOfMystery {
    private static final Random r = new Random();
    private static final int NUMBER_OF_URNS = 10000;
    public static final int MAX_URN_SIZE = 1000;

    public static void main(String[] args) {

        List<Urn> urns = new ArrayList<>();
        for(int i = 0; i < NUMBER_OF_URNS; i++) {
            int urnSize = r.nextInt(MAX_URN_SIZE) + 1;
            int greenAmount = r.nextInt(urnSize);
            urns.add(new Urn(urnSize, greenAmount));
        }

        int acc = 0;
        for(Urn urn : urns) {
            boolean isGreen = r.nextInt(urn.size) < urn.green;
            boolean isGreenChosen = r.nextInt(urn.size) < urn.green;
            if(isGreen == isGreenChosen) {
                ++acc;
            }
        }

        System.out.println(String.format("Marbles drawn matched %d times out of %d urns (%.2f percent success)",
                acc, NUMBER_OF_URNS, 100  * (double) acc / (double) NUMBER_OF_URNS));
    }

    static class Urn {
        int size;
        int green;
        int red;

        Urn(int size, int green) {
            this.size = size;
            this.green = green;
            this.red = size - green;
        }
    }
}
