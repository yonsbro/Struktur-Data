/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugas.pkg2.struktur.data;

/**
 *
 * @author Wiryono
 */
public class CountingSortDescending {
    public static void main(String[] args) {
        int[] data = {36, 15, 7, 51, 29, 48};
        
        System.out.println("Data sebelum diurutkan:");
        printArray(data);
        
        countingSortDescending(data);
        
        System.out.println("\nData setelah diurutkan (Descending):");
        printArray(data);
    }
    
    // Fungsi Counting Sort untuk Descending Order
    public static void countingSortDescending(int[] arr) {
        if (arr.length == 0) return;
        
        // Temukan nilai maksimum dan minimum
        int max = arr[0], min = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];
        
        // Hitung frekuensi setiap elemen
        for (int num : arr) {
            count[num - min]++;
        }
        
        // Ubah count[i] untuk menentukan posisi akhir (descending)
        for (int i = count.length - 2; i >= 0; i--) {
            count[i] += count[i + 1];
        }
        
        // Bangun array output (descending)
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        
        // Salin kembali ke array asli
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
    
    // Fungsi untuk mencetak array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}