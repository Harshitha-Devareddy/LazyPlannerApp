import java.util.*;

public class LazyPlannerApp {

    private static List<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🧠 Welcome to Lazy Planner!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Task");
            System.out.println("2. View Sorted Schedule");
            System.out.println("3. Exit");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewSchedule();
                case 3 -> System.exit(0);
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Task Name: ");
        String name = scanner.nextLine();

        System.out.print("Deadline (yyyy-MM-dd HH:mm): ");
        String deadline = scanner.nextLine();

        System.out.print("Importance (1-5): ");
        int importance = Integer.parseInt(scanner.nextLine());

        System.out.print("Estimated Time (in hours): ");
        int duration = Integer.parseInt(scanner.nextLine());

        Task newTask = new Task(name, deadline, importance, duration);
        tasks.add(newTask);
        System.out.println("✅ Task added successfully!");
    }

    private static void viewSchedule() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks added.");
            return;
        }

        Collections.sort(tasks);
        System.out.println("\n📋 Your Lazy Smart Schedule:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
