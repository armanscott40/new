package Galaxy;

public class Planet{
    private String planetName;
    private PlanetType planetType;
    private String moons;
    private String distanceFromSun;

    private String lifeExistence;
    public String resources;
   public String galaxyName;

    public Planet(String planetName, String moons, String distanceFromSun, String lifeExistence, String resources,String galaxyName) {
        this.planetName = planetName;
        this.moons = moons;
        this.distanceFromSun = distanceFromSun;
        this.lifeExistence = lifeExistence;
        this.resources = resources;
        this.galaxyName = galaxyName;
    }


    public Planet(String planetName, String planetType, String moons, double distanceFromSun) {
    }

    public Planet(String planetName) {
        this.planetName = planetName;
    }

    public Planet() {
    }

    public Planet(String planetName, PlanetType planetType, String moons, String distanceFromSun) {
        this.planetName = planetName;
        this.planetType = planetType;
        this.moons = moons;
        this.distanceFromSun = distanceFromSun;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public PlanetType getPlanetType() {
        return planetType;
    }

    public void setPlanetType(PlanetType planetType) {
        this.planetType = planetType;
    }

    public String getMoons() {
        return moons;
    }

    public void setMoons(String moons) {
        this.moons = moons;
    }

    public String getDistanceFromSun() {
        return distanceFromSun;
    }

    public void setDistanceFromSun(String distanceFromSun) {
        this.distanceFromSun = distanceFromSun;
    }

    public String getLifeExistence() {
        return lifeExistence;
    }

    public void setLifeExistence(String lifeExistence) {
        this.lifeExistence = lifeExistence;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getGalaxyName() {
        return galaxyName;
    }

    public void setGalaxyName(String galaxyName) {
        this.galaxyName = galaxyName;
    }
}

