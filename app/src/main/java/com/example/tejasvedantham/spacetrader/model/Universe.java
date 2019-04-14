package com.example.tejasvedantham.spacetrader.model;

import android.support.annotation.NonNull;

import com.google.firebase.database.Exclude;

//import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
//import java.util.logging.SocketHandler;

/**
 * Represents a universe for the game
 *
 * @author Byte Me
 * @version 1.0
 */
public class Universe {

    private Set<SolarSystem> solarSystems;
    private SolarSystem currentSS;

    /**
     * Creates a Universe object for the game
     */
    public Universe () {
        solarSystems = new HashSet<>();
        while (solarSystems.size() < 10) {
            int randomX = (int) (Math.random() * 151);
            int randomY = (int) (Math.random() * 101);
            Coordinate location = new Coordinate(randomX, randomY);
            char name = (char) (solarSystems.size() + 65);
            SolarSystem system = new SolarSystem(Character.toString(name), location);
            solarSystems.add(system);
        }
        currentSS = solarSystems.iterator().next();
    }

    /**
     * Getter method for the solar systems
     * @return the solar systems
     */
    @Exclude
    public Set<SolarSystem> getSolarSystems() {
        return solarSystems;
    }

    @NonNull
    public String toString() {
        StringBuilder toReturn = new StringBuilder("\n");
        toReturn.append("-----------------");
        toReturn.append("Solar Systems:");
        for (int i = 0; i < getSolarSystems().size(); i++) {
            toReturn.append(solarSystems.toArray()[i].toString());
        }

        toReturn.append("-----------------");
        return toReturn.toString();
    }

    public SolarSystem getCurrentSS() {
        return currentSS;
    }

    public void setCurrentSS(SolarSystem ss) {
        this.currentSS = ss;
    }
}
