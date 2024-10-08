package Galaxy;

import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;

public class Galaxy {
    private String name; // نام کهکشان
    private List<Planet> planets; // لیست سیارات

    public Galaxy(String name) {
        this.name = name;
        this.planets = new ArrayList<>();
    }

    public void addPlanet(Planet planet) {
        for (Planet p : planets) {
            if (p.getName().equalsIgnoreCase(planet.getName())) {
                System.out.println("این سیاره قبلاً در کهکشان وجود دارد.");
                return;
            }
        }
        planets.add(planet);
        System.out.println("سیاره جدید با موفقیت اضافه شد: " + planet.getName());
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void displayPlanets() {
        for (Planet planet : planets) {
            System.out.println(planet);
        }
    }

    public void loadFromFile(String line) {
        String[] parts = line.split(",");
        if (parts.length == 7) {
            String name = parts[0];
            String galaxy = parts[1];
            String type = parts[2];
            int moons = Integer.parseInt(parts[3].trim());
            double distanceFromSun = Double.parseDouble(parts[4]);
            boolean hasLife = parts[5].equals("has life");
            String resources = parts[6];
            Planet planet = new Planet(name, galaxy, type, moons, distanceFromSun, hasLife, resources);
            addPlanet(planet);
        }
    }

    public void saveToFile(PrintWriter writer) {
        for (Planet planet : planets) {
            writer.println(planet.toFileFormat());
        }
    }
}