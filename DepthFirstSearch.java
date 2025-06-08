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

public class DepthFirstSearch {
    private Map<Integer, List<Integer>> graph;

    public DepthFirstSearch() {
        // Membangun graf dengan 7 node
        graph = new HashMap<>();
        graph.put(2, Arrays.asList(4, 6));
        graph.put(4, Arrays.asList(2, 8));
        graph.put(6, Arrays.asList(2, 8, 11));
        graph.put(8, Arrays.asList(4, 6, 13));
        graph.put(11, Arrays.asList(6, 15));
        graph.put(13, Arrays.asList(8, 15));
        graph.put(15, Arrays.asList(11, 13));
    }

    public boolean dfs(int start, int target) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        
        System.out.println("Memulai pencarian DFS dari " + start + " mencari " + target);
        stack.push(start);
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.println("\nMengunjungi node: " + current);
            
            if (current == target) {
                System.out.println("=> Target " + target + " ditemukan!");
                return true;
            }
            
            if (!visited.contains(current)) {
                visited.add(current);
                System.out.println("Menandai " + current + " sebagai dikunjungi");
                
                List<Integer> neighbors = graph.get(current);
                System.out.println("Tetangga " + current + ": " + neighbors);
                
                // Push tetangga dalam urutan terbalik untuk mempertahankan urutan kunjungan
                Collections.reverse(neighbors);
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        System.out.println("Menambahkan " + neighbor + " ke stack");
                        stack.push(neighbor);
                    }
                }
            }
        }
        
        System.out.println("\nTarget " + target + " tidak ditemukan dalam graf.");
        return false;
    }

    public static void main(String[] args) {
        DepthFirstSearch DepthFirstSearch = new DepthFirstSearch();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Struktur Graf:");
        System.out.println("2 -> 4, 6");
        System.out.println("4 -> 2, 8");
        System.out.println("6 -> 2, 8, 11");
        System.out.println("8 -> 4, 6, 13");
        System.out.println("11 -> 6, 15");
        System.out.println("13 -> 8, 15");
        System.out.println("15 -> 11, 13");
        
        System.out.print("\nMasukkan node awal (2,4,6,8,11,13,15): ");
        int start = scanner.nextInt();
        System.out.print("Masukkan target yang dicari: ");
        int target = scanner.nextInt();
        
        DepthFirstSearch.dfs(start, target);
    }
}