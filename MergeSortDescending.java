/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugas.pkg2.struktur.data;

/**
 *
 * @author Wiryono
 */
public class MergeSortDescending {
    public static void main(String[] args) {
        int[] data = {45, 21, 27, 14, 85, 62};
        
        System.out.println("Data sebelum diurutkan:");
        printArray(data);
        
        mergeSortDescending(data, 0, data.length - 1);
        
        System.out.println("\nData setelah diurutkan (Descending):");
        printArray(data);
    }
    
    // Fungsi Merge Sort untuk Descending Order
    public static void mergeSortDescending(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            
            // Rekursif: bagi array menjadi sub-array kiri dan kanan
            mergeSortDescending(arr, left, mid);
            mergeSortDescending(arr, mid + 1, right);
            
            // Gabungkan dengan urutan descending
            mergeDescending(arr, left, mid, right);
        }
    }
    
    // Fungsi Merge untuk Descending Order
    public static void mergeDescending(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        // Salin data ke sub-array kiri dan kanan
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];
        
        // Gabungkan dengan perbandingan descending
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {  // Perubahan di sini (>= untuk descending)
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        // Salin sisa elemen jika ada
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    // Fungsi untuk mencetak array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
