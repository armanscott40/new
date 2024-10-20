package Galaxy;

public class ResourceRichPlanet extends Planet implements ResourceRichStatus{


    public ResourceRichPlanet(String planetName, String moons, String distanceFromSun, String lifeExistence, String resources, String galaxyName) {
        super(planetName, moons, distanceFromSun, lifeExistence, resources, galaxyName);
    }

    public ResourceRichPlanet(String planetName, PlanetType planetType, String moons, String distanceFromSun) {
        super(planetName, planetType, moons, distanceFromSun);
    }

    public ResourceRichPlanet(String planetName) {
        super(planetName);
    }

    public ResourceRichPlanet() {
    }



    @Override
    public void resourceRich() {
        System.out.println("this planet is resource rich");
    }
}