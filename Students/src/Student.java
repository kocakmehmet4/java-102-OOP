
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.PriorityQueue;


public class Student implements Comparable<Student> {
        private int id;
        private String name;
        private double cgpa;

        public Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public int getID() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCGPA() {
            return cgpa;
        }

        @Override
        public int compareTo(Student other) {
            if (this.cgpa != other.cgpa) {
                return Double.compare(other.cgpa, this.cgpa); // Higher CGPA first
            } else if (!this.name.equals(other.name)) {
                return this.name.compareTo(other.name); // Name in ascending order
            } else {
                return Integer.compare(this.id, other.id); // ID in ascending order
            }
        }
    }

