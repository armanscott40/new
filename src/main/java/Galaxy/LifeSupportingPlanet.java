package Galaxy;

public class LifeSupportingPlanet extends Planet implements LifeSupportingStatus{


    public LifeSupportingPlanet(String planetName, String moons, String distanceFromSun, String lifeExistence, String resources, String galaxyName) {
        super(planetName, moons, distanceFromSun, lifeExistence, resources, galaxyName);
    }

   public LifeSupportingPlanet(String planetName, PlanetType planetType, String moons, String distanceFromSun) {
      super(planetName, planetType, moons, distanceFromSun);
   }

    public LifeSupportingPlanet(String planetName) {
        super(planetName);
    }

    public LifeSupportingPlanet() {
    }


    @Override
    public void lifeSupporting() {
        System.out.println("this planet is life supported");
    }
}