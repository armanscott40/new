package Galaxy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Galaxy {
    private String galaxyName;
    private List<Planet> planets;


    public Galaxy(String galaxyName, List<Planet> planets) {
        this.galaxyName = galaxyName;
        this.planets = planets;
    }

    public Galaxy(String galaxyName) {
        this.galaxyName = galaxyName;
        this.planets = new ArrayList<>();
    }

    public String getGalaxyName() {
        return galaxyName;
    }

    public void setGalaxyName(String galaxyName) {
        this.galaxyName = galaxyName;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

}