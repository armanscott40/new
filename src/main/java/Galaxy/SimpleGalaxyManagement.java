package Galaxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SimpleGalaxyManagement {
    private Galaxy galaxy;

    public static void main(String[] args) {
        SimpleGalaxyManagement management = new SimpleGalaxyManagement();
        management.loadGalaxiesFromFile("galaxy_data.txt");
        management.runMenu();
    }
    public void runMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("به سیستم مدیریت کهکشان خوش آمدید");
            System.out.println("1. نمایش کهکشان‌ها");
            System.out.println("2. اضافه کردن سیاره جدید");
            System.out.println("3. تغییر تعداد قمر سیاره");
            System.out.println("4. نمایش اطلاعات سیاره");
            System.out.println("5. ذخیره‌سازی اطلاعات و خروج");
            System.out.print("انتخاب خود را وارد کنید: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // برای خواندن newline

            switch (choice) {
                case 1:
                    galaxy.displayPlanets();
                    break;
                case 2:
                    System.out.print("نام سیاره: ");
                    String name = scanner.nextLine();
                    System.out.print("کهکشان: ");
                    String galaxyName = scanner.nextLine();
                    System.out.print("نوع سیاره (GAS یا ROCK): ");
                    String type = scanner.nextLine();
                    System.out.print("فاصله از خورشید (کیلومتر): ");
                    String distance = scanner.nextLine();
                    System.out.print("تعداد قمر: ");
                    int moons = scanner.nextInt();
                    scanner.nextLine(); // برای خواندن newline
                    System.out.print("آیا حیات وجود دارد؟ (has life یا no life): ");
                    String life = scanner.nextLine();
                    System.out.print("منابع: ");
                    String resources = scanner.nextLine();

                    boolean hasLife = life.equals("has life");
                    Planet planet = new Planet(name, galaxyName, type, moons, Double.parseDouble(distance), hasLife, resources);
                    galaxy.addPlanet(planet);
                    saveGalaxiesToFile(); // ذخیره اطلاعات بعد از اضافه کردن
                    break;
                case 3:
                    System.out.print("نام سیاره (برای تغییر قمرها): ");
                    String planetName = scanner.nextLine();
                    for (Planet planetItem : galaxy.getPlanets()) {
                        if (planetItem.getName().equalsIgnoreCase(planetName)) {
                            planetItem.addMoon();
                            System.out.println("تعداد قمرهای سیاره " + planetName + " افزایش یافت.");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("نام سیاره برای نمایش اطلاعات: ");
                    String infoPlanetName = scanner.nextLine();
                    for (Planet planetItem : galaxy.getPlanets()) {
                        if (planetItem.getName().equalsIgnoreCase(infoPlanetName)) {
                            System.out.println(planetItem);
                            if (planetItem.isHasLife()) {
                                planetItem.displayResources();
                            }
                            break;
                        }
                    }
                    break;
                case 5:
                    saveGalaxiesToFile(); // ذخیره‌سازی قبل از خروج
                    System.out.println("خروج از برنامه.");
                    break;
                default:
                    System.out.println("انتخاب نامعتبر، دوباره امتحان کنید.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private void loadGalaxiesFromFile(String filename) {
        galaxy = new Galaxy("مجموعه  کهکشان‌ها");
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                galaxy.loadFromFile(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("فایل یافت نشد: " + filename);
        }
    }

    private void saveGalaxiesToFile() {
        try (PrintWriter writer = new PrintWriter("galaxy_data.txt")) {
            galaxy.saveToFile(writer);
        } catch (FileNotFoundException e) {
            System.out.println("خطا در ذخیره‌سازی داده‌ها.");
        }
    }
}