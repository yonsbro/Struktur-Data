/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas.pkg3.struktur.data;

/**
 *
 * @author Wiryono
 */
import java.util.*;

public class BreadthFirstSearch {
    private Map<Integer, List<Integer>> graph;

    public BreadthFirstSearch() {
        // Membangun graf dengan 7 node
        graph = new HashMap<>();
        graph.put(1, Arrays.asList(3, 5));
        graph.put(3, Arrays.asList(1, 5, 7));
        graph.put(5, Arrays.asList(1, 3, 7, 10));
        graph.put(7, Arrays.asList(3, 5, 10, 12));
        graph.put(10, Arrays.asList(5, 7, 12, 16));
        graph.put(12, Arrays.asList(7, 10, 16));
        graph.put(16, Arrays.asList(10, 12));
    }

    public boolean bfs(int start, int target) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        System.out.println("Memulai pencarian BFS dari " + start + " mencari " + target);
        queue.add(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println("Mengunjungi node: " + current);
            
            if (current == target) {
                System.out.println("Target " + target + " ditemukan!");
                return true;
            }
            
            List<Integer> neighbors = graph.get(current);
            System.out.println("Menambahkan tetangga " + current + " ke antrian: " + neighbors);
            
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        
        System.out.println("Target " + target + " tidak ditemukan dalam graf.");
        return false;
    }

    public static void main(String[] args) {
        BreadthFirstSearch BreadthFirstSearch = new BreadthFirstSearch();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Graf yang digunakan:");
        System.out.println("1 -> 3, 5");
        System.out.println("3 -> 1, 5, 7");
        System.out.println("5 -> 1, 3, 7, 10");
        System.out.println("7 -> 3, 5, 10, 12");
        System.out.println("10 -> 5, 7, 12, 16");
        System.out.println("12 -> 7, 10, 16");
        System.out.println("16 -> 10, 12");
        
        System.out.print("Masukkan node awal (1, 3, 5, 7, 10, 12, 16): ");
        int start = scanner.nextInt();
        System.out.print("Masukkan node target yang dicari (1, 3, 5, 7, 10, 12, 16): ");
        int target = scanner.nextInt();
        
        BreadthFirstSearch.bfs(start, target);
    }
}