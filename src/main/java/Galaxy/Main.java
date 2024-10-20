package Galaxy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Galaxy> galaxies = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "C:\\Users\\arman\\IdeaProjects\\new\\galaxies.txt";

    public static void main(String[] args) {
            loadGalaxiesFromFile();

            while (true) {
                System.out.println("به سیستم مدیریت کهکشان خوش آمدید!");
                System.out.println("1. نمایش کهکشان‌ها");
                System.out.println("2. اضافه کردن سیاره جدید");
                System.out.println("3. تغییر تعداد قمر سیاره");
                System.out.println("4. نمایش اطلاعات سیاره");
                System.out.println("5. خروج و ذخیره اطلاعات");
                System.out.print("انتخاب شما: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        displayGalaxies();
                        break;
                    case 2:
                        addNewPlanet();
                        break;
                    case 3:
                        changeMoonCount();
                        break;
                    case 4:
                        displayPlanetInfo();
                        break;
                    case 5:
                        saveGalaxiesToFile();
                        System.out.println("خروج و ذخیره اطلاعات...");
                        return;
                    default:
                        System.out.println("انتخاب نامعتبر. لطفاً دوباره تلاش کنید.");
                }
            }
        }

        private static void loadGalaxiesFromFile () {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    String galaxyName = parts[0];
                    Galaxy galaxy = new Galaxy(galaxyName);
                    for (int i = 1; i < parts.length; i++) {
                        String[] planetData = parts[i].split(";");
                        Planet planet = new Planet(planetData[0], planetData[1], planetData[2], planetData[3], planetData[4], galaxyName);
                        galaxy.getPlanets().add(planet);
                    }
                    galaxies.add(galaxy);
                }
            } catch (IOException e) {
                System.out.println("خطا در بارگذاری کهکشان‌ها: " + e.getMessage());
            }
        }

        private static void saveGalaxiesToFile () {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (Galaxy galaxy : galaxies) {
                    writer.write(galaxy.getGalaxyName());
                    for (Planet planet : galaxy.getPlanets()) {
                        writer.write("," + planet.getPlanetName() + ";" + planet.getMoons() + ";" + planet.getDistanceFromSun() + ";" + planet.getLifeExistence() + ";" + planet.getResources());
                    }
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("خطا در ذخیره کهکشان‌ها: " + e.getMessage());
            }
        }

        private static void displayGalaxies () {
            if (galaxies.isEmpty()) {
                System.out.println("هیچ کهکشان موجود نیست.");
            } else {
                for (Galaxy galaxy : galaxies) {
                    System.out.println("کهکشان: " + galaxy.getGalaxyName());
                    System.out.println("سیارات:");
                    for (Planet planet : galaxy.getPlanets()) {
                        System.out.println(" - " + planet.getPlanetName());
                    }
                }
            }
        }

        private static void addNewPlanet () {
            System.out.print("نام کهکشان: ");
            String galaxyName = scanner.nextLine();

            Galaxy galaxy = findOrCreateGalaxy(galaxyName);

            System.out.print("نام سیاره: ");
            String planetName = scanner.nextLine();

            System.out.print("تعداد قمر: ");
            String moons = scanner.nextLine();

            System.out.print("فاصله از خورشید: ");
            String distanceFromSun = scanner.nextLine();

            System.out.print("آیا زندگی وجود دارد؟ (بله/خیر): ");
            String lifeExistence = scanner.nextLine();

            System.out.print("منابع: ");
            String resources = scanner.nextLine();

            Planet newPlanet = new Planet(planetName, moons, distanceFromSun, lifeExistence, resources, galaxyName);
            galaxy.getPlanets().add(newPlanet);
            System.out.println("سیاره جدید اضافه شد.");
        }

        private static Galaxy findOrCreateGalaxy (String galaxyName){
            for (Galaxy galaxy : galaxies) {
                if (galaxy.getGalaxyName().equals(galaxyName)) {
                    return galaxy;
                }
            }
            Galaxy newGalaxy = new Galaxy(galaxyName);
            galaxies.add(newGalaxy);
            return newGalaxy;
        }

        private static void changeMoonCount () {
            System.out.print("نام کهکشان: ");
            String galaxyName = scanner.nextLine();
            Galaxy galaxy = findGalaxy(galaxyName);

            if (galaxy == null) {
                System.out.println("کهکشان پیدا نشد.");
                return;
            }

            System.out.print("نام سیاره: ");
            String planetName = scanner.nextLine();
            Planet planet = findPlanet(galaxy, planetName);

            if (planet == null) {
                System.out.println("سیاره پیدا نشد.");
                return;
            }

            System.out.print("تعداد قمر جدید: ");
            String newMoons = scanner.nextLine();
            planet.setMoons(newMoons);
            System.out.println("تعداد قمر سیاره تغییر کرد.");
        }

        private static void displayPlanetInfo () {
            System.out.print("نام کهکشان: ");
            String galaxyName = scanner.nextLine();
            Galaxy galaxy = findGalaxy(galaxyName);

            if (galaxy == null) {
                System.out.println("کهکشان پیدا نشد.");
                return;
            }

            System.out.print("نام سیاره: ");
            String planetName = scanner.nextLine();
            Planet planet = findPlanet(galaxy, planetName);

            if (planet == null) {
                System.out.println("سیاره پیدا نشد.");
                return;
            }

            System.out.println("اطلاعات سیاره:");
            System.out.println("نام سیاره: " + planet.getPlanetName());
            System.out.println("تعداد قمر: " + planet.getMoons());
            System.out.println("فاصله از خورشید: " + planet.getDistanceFromSun());
            System.out.println("آیا زندگی وجود دارد؟ " + planet.getLifeExistence());
            System.out.println("منابع: " + planet.getResources());
        }

        private static Galaxy findGalaxy (String galaxyName){
            for (Galaxy galaxy : galaxies) {
                if (galaxy.getGalaxyName().equals(galaxyName)) {
                    return galaxy;
                }
            }
            return null;
        }

        private static Planet findPlanet (Galaxy galaxy, String planetName){
            for (Planet planet : galaxy.getPlanets()) {
                if (planet.getPlanetName().equalsIgnoreCase(planetName)) {
                    return planet;
                }
            }
            return null;
        }
    }
