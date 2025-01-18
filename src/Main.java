import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Name kleopatra= new Name();
        Name puskin = new Name();
        Name maikovsky = new Name();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Задание 1.3");
            System.out.println("2. Задание 2.2");
            System.out.println("3. Задание 2.3");
            System.out.println("4. Задание 3.2");
            System.out.println("5. Задание 4.9");
            System.out.println("6. Задание 5.7");
            System.out.println("0. Выход");

            int choice = (int) getDoubleInput(scanner, "Выберите задание (1-6) или 0 для выхода:");

            switch (choice) {
                case 1:
                    System.out.println("Вы выбрали Задание 1\n");
                    kleopatra.setSurname("Клеопатра");
                    puskin.setFirstName("Пушкин");
                    puskin.setFirstName("Александр");
                    puskin.setPatronymic("Сергеевич");
                    maikovsky.setSurname("Маяковский");
                    maikovsky.setFirstName("Владимир");
                    System.out.println(kleopatra);
                    System.out.println(puskin);
                    System.out.println(maikovsky);

                    break;
                case 2:
                    System.out.println("Вы выбрали Задание 2");
                    PersonName cleopatra = new PersonName(kleopatra, 152);
                    PersonName pushkin = new PersonName(puskin, 167);
                    PersonName mayakovsky = new PersonName(maikovsky, 189);
                    System.out.println(cleopatra);
                    System.out.println(pushkin);
                    System.out.println(mayakovsky);

                    break;
                case 3:
                    System.out.println("Вы выбрали Задание 3");
                    Name ivan= new Name("Иван", "Чудов", null);
                    Name Peter= new Name("Петр", "Чудов", null);
                    Name boris= new Name("Борис", null, null);

                    PersonName ivanPerson = new PersonName(ivan, 10);
                    PersonName peterPerson = new PersonName(Peter, 10);
                    PersonName borisPerson = new PersonName(boris, 10);

                    PersonName Chudov = new PersonName(Peter, 10, ivanPerson);
                    PersonName boris2 = new PersonName(boris, 10, peterPerson);
                    System.out.println(ivanPerson);
                    System.out.println(Chudov);
                    System.out.println(boris2);

                    break;
                case 4:
                    Point[] points1 = {
                            new Point(1, 5),
                            new Point(2, 8),
                            new Point(5, 3)
                    };
                    Polyline polyline1 = new Polyline(points1);
                    System.out.println("Первая ломаная: " + polyline1);


                    Point[] points2 = {
                            new Point(1, 5),
                            new Point(2, -5),
                            new Point(4, -8),
                            new Point(5, 3)
                    };
                    Polyline polyline2 = new Polyline(points2);
                    System.out.println("Вторая ломаная: " + polyline2);

                    double shiftX = getDoubleInput(scanner, "Введите сдвиг по оси X: ");
                    double shiftY = getDoubleInput(scanner, "Введите сдвиг по оси Y: ");

                    System.out.println("Доступные точки для сдвига: ");
                    for (int i = 0; i < points1.length; i++) {
                        System.out.println(i+1 + ": " + points1[i]);
                    }

                    int pointIndex = getPointIndex(scanner, points1.length);


                    polyline1.shiftPoint(polyline2, pointIndex, shiftX, shiftY);

                    System.out.println("Первая ломаная после сдвига: " + polyline1);
                    System.out.println("Вторая ломаная после сдвига: " + polyline2);


                    break;
                case 5:
                    System.out.println("Вы выбрали Задание 5");
                    Polyline emptyPolyline = new Polyline();
                    System.out.println("Пустая ломаная: " + emptyPolyline);


                    Point[] points4 = getPointsFromUser (scanner);
                    polyline1 = new Polyline(points4);
                    System.out.println("Первая ломаная: " + polyline1);

                    break;
                case 6:
                    System.out.println("Вы выбрали Задание 6");

                    Point[] initialPoints = {new Point(1, 5), new Point(2, 8), new Point(5, 3)};
                    Polyline polyline = new Polyline(initialPoints);
                    System.out.println(polyline);

                    System.out.println("Длина ломаной: " + polyline.getLength());

                    Point[] newPoints = {new Point(5, 15), new Point(8, 10)};
                    polyline.addPoints(newPoints);
                    System.out.println(polyline);
                    System.out.println("Длина ломаной после добавления новых точек: " + polyline.getLength());
                    break;
                case 0:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
            }
        }
    }

    public static double getDoubleInput(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                break;
            } else {
                System.out.println("Пожалуйста, введите корректное число.");
                scanner.next();
            }
        }
        return value;
    }

    private static int getPointIndex(Scanner scanner, int length) {
        int index;
        while (true) {
            System.out.print("Введите индекс точки, которую хотите сдвинуть (1-" + (length) + "): ");
            if (scanner.hasNextInt()) {
                index = scanner.nextInt();
                if (index >= 0 && index < length) {
                    break;
                } else {
                    System.out.println("Неверный индекс точки. Пожалуйста, введите индекс от 0 до " + (length - 1) + ".");
                }
            } else {
                System.out.println("Пожалуйста, введите целое число для индекса точки.");
                scanner.next();
            }
        }
        return index;
    }
    private static Point[] getPointsFromUser (Scanner scanner) {
        System.out.print("Введите количество точек: ");
        int numberOfPoints = (int) getDoubleInput(scanner, "Введите корректное количество точек: ");

        Point[] points = new Point[numberOfPoints];

        for (int i = 0; i < numberOfPoints; i++) {
            System.out.println("Введите координаты точки " + (i + 1) + ":");
            double x = getDoubleInput(scanner, "Введите координату X: ");
            double y = getDoubleInput(scanner, "Введите координату Y: ");
            points[i] = new Point(x, y);
        }

        return points;
    }
}
