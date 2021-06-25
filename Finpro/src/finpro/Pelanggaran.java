/* 
KELOMPOK 1: SOCCER AGENDA
Christoper Luis Alexander - 2301876493
Jonathan Evan Sampurna - 2301876612
Christiano Ekasakti Sangalang - 2301927872
*/
package finpro;
import java.io.Serializable;

public class Pelanggaran implements Serializable{
    private String kartu;
    private String pemainSalah;
    private String sanksi;
    private int lamaSanksi;
    
    public Pelanggaran(String kartu, String pemainSalah, String sanksi, int lamaSanksi) {
        this.kartu = kartu;
        this.pemainSalah = pemainSalah;
        this.sanksi = sanksi;
        this.lamaSanksi = lamaSanksi;
    }
    
    public String showPelanggaran() {
        System.out.println("Kartu: " + kartu);
        System.out.println("Nama Pemain: " + pemainSalah);
        System.out.println("Sanksi: " + sanksi);
        if(lamaSanksi != 0)
            System.out.println("Lama Sanksi: " + lamaSanksi);
        return "";
    }
}