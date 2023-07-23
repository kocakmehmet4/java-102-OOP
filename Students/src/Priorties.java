import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;



class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue();


        for (String event : events) {
            String[] parts = event.split(" ");
            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                queue.offer(new Student(id, name, cgpa));
            } else if (parts[0].equals("SERVED")) {
                queue.poll(); // Remove the highest priority student
            }
        }

        List<Student> students = new ArrayList<>();
        while (!queue.isEmpty()) {
            students.add(queue.poll());
        }
        return students;
    }
}


