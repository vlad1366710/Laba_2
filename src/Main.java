import java.util.Scanner;

public class Main {

    private static final int EXIT_OPTION = 0;
    private static final int TASK_1_3 = 1;
    private static final int TASK_2_2 = 2;
    private static final int TASK_2_3 = 3;
    private static final int TASK_3_2 = 4;
    private static final int TASK_4_9 = 5;
    private static final int TASK_5_7 = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Name kleopatra = new Name();
        Name puskin = new Name();
        Name maikovsky = new Name();

        while (true) {
            printMenu();
            int choice = (int) getDoubleInput(scanner, "Выберите задание (1-6) или 0 для выхода:");

            switch (choice) {
                case EXIT_OPTION:
                    System.out.println("Выход...");
                    return;
                case TASK_1_3:
                    executeTask1_3(kleopatra, puskin, maikovsky);
                    break;
                case TASK_2_2:
                    executeTask2_2(kleopatra, puskin, maikovsky);
                    break;
                case TASK_2_3:
                    executeTask2_3();
                    break;
                case TASK_3_2:
                    executeTask3_2(scanner);
                    break;
                case TASK_4_9:
                    executeTask4_9(scanner);
                    break;
                case TASK_5_7:
                    executeTask5_7(scanner);
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Задание 1.3");
        System.out.println("2. Задание 2.2");
        System.out.println("3. Задание 2.3");
        System.out.println("4. Задание 3.2");
        System.out.println("5. Задание 4.9");
        System.out.println("6. Задание 5.7");
        System.out.println("0. Выход");
    }

    private static void executeTask1_3(Name kleopatra, Name puskin, Name maikovsky) {
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
    }

    private static void executeTask2_2(Name kleopatra, Name puskin, Name maikovsky) {
        System.out.println("Вы выбрали Задание 2");
        PersonName cleopatra = new PersonName(kleopatra, 152);
        PersonName pushkin = new PersonName(puskin, 167);
        PersonName mayakovsky = new PersonName(maikovsky, 189);
        System.out.println(cleopatra);
        System.out.println(pushkin);
        System.out.println(mayakovsky);
    }

    private static void executeTask2_3() {
        System.out.println("Вы выбрали Задание 3");
        Name ivan = new Name("Иван", "Чудов", null);
        Name peter = new Name("Петр", "Чудов", null);
        Name boris = new Name("Борис", null, null);
        PersonName ivanPerson = new PersonName(ivan, 10);
        PersonName peterPerson = new PersonName(peter, 10);
        PersonName borisPerson = new PersonName(boris, 10);
        PersonName chudov = new PersonName(peter, 10, ivanPerson);
        PersonName boris2 = new PersonName(boris, 10, peterPerson);
        System.out.println(ivanPerson);
        System.out.println(chudov);
        System.out.println(boris2);
    }

    private static void executeTask3_2(Scanner scanner) {
        Point[] points1 = new Point[]{new Point(1.0, 5.0), new Point(2.0, 8.0), new Point(5.0, 3.0)};
        Polyline polyline1 = new Polyline(points1);
        System.out.println("Первая ломаная: " + polyline1);

        Point[] points2 = new Point[]{new Point(1.0, 5.0), new Point(2.0, -5.0), new Point(4.0, -8.0), new Point(5.0, 3.0)};
        Polyline polyline2 = new Polyline(points2);
        System.out.println("Вторая ломаная: " + polyline2);

        double shiftX = getDoubleInput(scanner, "Введите сдвиг по оси X: ");
        double shiftY = getDoubleInput(scanner, "Введите сдвиг по оси Y: ");
        System.out.println("Доступные точки для сдвига: ");

        for (int i = 0; i < points1.length; i++) {
            System.out.println((i + 1) + ": " + points1[i]);
        }

        int pointIndex = getPointIndex(scanner, points1.length);
        polyline1.shiftPoint(polyline2, pointIndex, shiftX, shiftY);
        System.out.println("Первая ломаная после сдвига: " + polyline1);
        System.out.println("Вторая ломаная после сдвига: " + polyline2);
    }

    private static void executeTask4_9(Scanner scanner) {
        System.out.println("Вы выбрали Задание 5");
        Polyline emptyPolyline = new Polyline();
        System.out.println("Пустая ломаная: " + emptyPolyline);

        Point[] points = getPointsFromUser(scanner);
        Polyline polyline = new Polyline(points);
        System.out.println("Первая ломаная: " + polyline);
    }

    private static void executeTask5_7(Scanner scanner) {
        System.out.println("Вы выбрали Задание 6");
        Point[] initialPoints = new Point[]{new Point(1.0, 5.0), new Point(2.0, 8.0), new Point(5.0, 3.0)};
        Polyline polyline = new Polyline(initialPoints);
        System.out.println(polyline);
        System.out.println("Длина ломаной: " + polyline.getLength());

        Point[] newPoints = new Point[]{new Point(5.0, 15.0), new Point(8.0, 10.0)};
        polyline.addPoints(newPoints);
        System.out.println(polyline);
        System.out.println("Длина ломаной после добавления новых точек: " + polyline.getLength());
    }

    public static double getDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            }
            System.out.println("Пожалуйста, введите корректное число.");
            scanner.next();
        }
    }

    private static int getPointIndex(Scanner scanner, int length) {
        while (true) {
            System.out.print("Введите индекс точки, которую хотите сдвинуть (1-" + length + "): ");
            if (scanner.hasNextInt()) {
                int index = scanner.nextInt();
                if (index >= 1 && index <= length) {
                    return index - 1;
                }
                System.out.println("Неверный индекс точки. Пожалуйста, введите индекс от 1 до " + length + ".");
            } else {
                System.out.println("Пожалуйста, введите целое число для индекса точки.");
                scanner.next();
            }
        }
    }

    private static Point[] getPointsFromUser(Scanner scanner) {
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