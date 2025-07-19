import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task implements Comparable<Task> {
    private String name;
    private LocalDateTime deadline;
    private int importance;
    private int duration; 

    public Task(String name, String deadlineStr, int importance, int duration) {
        this.name = name;
        this.deadline = LocalDateTime.parse(deadlineStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.importance = importance;
        this.duration = duration;
    }

    public double getPriorityScore() {
        long hoursLeft = java.time.Duration.between(LocalDateTime.now(), deadline).toHours();
        int urgency = hoursLeft <= 0 ? 10 : Math.max(0, 100 - (int) hoursLeft);
        return importance * 2 + urgency * 1.5 - duration * 1.2;
    }

    public String getName() {
        return name;
    }

    public String getDeadline() {
        return deadline.toString();
    }

    public int getImportance() {
        return importance;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public int compareTo(Task other) {
        return Double.compare(other.getPriorityScore(), this.getPriorityScore());
    }

    @Override
    public String toString() {
        return name + " | Deadline: " + deadline + " | Importance: " + importance +
                " | Duration: " + duration + "h | Score: " + String.format("%.2f", getPriorityScore());
    }
}
