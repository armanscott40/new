package Galaxy;

public class Planet {
    private String name; // نام سیاره
    private String galaxy; // کهکشان
    private String type; // نوع (GAS یا ROCK)
    private int moons; // تعداد قمر
    private double distanceFromSun; // فاصله از خورشید
    private boolean hasLife; // آیا حیات وجود دارد؟
    private String resources; // منابع طبیعی

    public Planet(String name, String galaxy, String type, int moons, double distanceFromSun, boolean hasLife, String resources) {
        this.name = name;
        this.galaxy = galaxy;
        this.type = type;
        this.moons = moons;
        this.distanceFromSun = distanceFromSun;
        this.hasLife = hasLife;
        this.resources = resources;
    }

    public String getName() {
        return name;
    }

    public void addMoon() {
        this.moons++;
    }

    public boolean isHasLife() {
        return hasLife;
    }

    public void displayResources() {
        if (hasLife) {
            System.out.println("منابع طبیعی سیاره " + name + ": " + resources);
        } else {
            System.out.println("سیاره " + name + " حیات ندارد.");
        }
    }

    @Override
    public String toString() {
        return "Planet: " + name + ", Galaxy: " + galaxy + ", Type: " + type + ", Moons: " + moons +
                ", Distance from Sun: " + distanceFromSun + " km, Life: " + (hasLife ? "has life" : "no life") +
                ", Resources: " + resources;
    }

    public String toFileFormat() {
        return String.format("Planet: %s, %s, %s, %d, %.1f, %s, %s",
                name, galaxy, type, moons, distanceFromSun, (hasLife ? "has life" : "no life"), resources);
    }
}