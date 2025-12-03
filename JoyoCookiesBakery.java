/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.joyocookiesbakery;

/**
 *
 * @author IDEAPAD
 */
import java.util.Scanner;
public class JoyoCookiesBakery {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah jenis cookies: ");
        int jumlah = input.nextInt();
        input.nextLine(); 

        String[] namaCookies = new String[jumlah];
        int[] totalBiaya = new int[jumlah];
        int[] totalPendapatan = new int[jumlah];
        int[] labaRugi = new int[jumlah];
        String[] status = new String[jumlah];

        int totalKeseluruhan = 0;
        int labaTertinggi = Integer.MIN_VALUE;
        String cookiesTertinggi = "";
        
        for(int i=0; i<jumlah; i++){
            System.out.println("Cookies ke-" + (i+1));
            
            System.out.println("Nama Cookies: ");
            namaCookies[i] = input.nextLine();
            
            System.out.println("Harga produksi Perbungkus: ");
            int produksi = input.nextInt();
            
            System.out.println("Harga jual perbungkus: ");
            int jual = input.nextInt();
            
            System.out.println("Jumlah terjual: ");
            int terjual = input.nextInt();  
            input.nextLine();
            
            totalBiaya[i] = produksi * terjual;
            totalPendapatan[i] = jual * terjual;
            labaRugi[i] = totalPendapatan[i] - totalBiaya[i];
            
            if(labaRugi[i] > 0){
                status[i] = "Laba";
            }else if(labaRugi[i] < 0){
                status[i] = "Rugi";
            }else{
                status[i] = "Impas";
            }
            
            totalKeseluruhan += labaRugi[i];
            
            if (labaRugi[i] > labaTertinggi) {
                labaTertinggi = labaRugi[i];
                cookiesTertinggi = namaCookies[i];
            }
        }
        
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Nama Cookies | Total Biaya | Total Pendapatan | Laba/Rugi | Status");
        System.out.println("-----------------------------------------------------------");

        for (int i = 0; i < jumlah; i++) {
            System.out.println(
                namaCookies[i] + " | Rp" + totalBiaya[i]
                + " | Rp" + totalPendapatan[i]
                + " | Rp" + labaRugi[i]
                + " | " + status[i]
            );
        }

        System.out.println("-----------------------------------------------------------");
        System.out.println("Total Laba/Rugi Keseluruhan: Rp" + totalKeseluruhan);
        System.out.println("Cookies dengan Laba Tertinggi: " + cookiesTertinggi
                + " (Rp" + labaTertinggi + ")");      
    }
}
