/*
FINAL PROJECT KELOMPOK 1: SOCCER AGENDA
Christoper Luis Alexander - 2301876493
Jonathan Evan Sampurna - 2301876612
Christiano Ekasakti Sangalang - 2301927872
 */
package finpro;
import java.io.Serializable;

public class Wasit implements Serializable{
    private String namaWasit;
    private String usiaWasit;
    private String posisiWasit;
    private String pengalaman;
    
    public Wasit(String namaWasit, String usiaWasit, String posisiWasit, String pengalaman) {
        this.namaWasit = namaWasit;
        this.usiaWasit = usiaWasit;
        this.posisiWasit = posisiWasit;
        this.pengalaman = pengalaman;
    }
    
    public Wasit(String namaWasit, String posisiWasit) {
        this.namaWasit = namaWasit;
        this.posisiWasit = posisiWasit;
    }
    
    public void showWasit() {
        System.out.println("Nama Wasit    : " + namaWasit);
        System.out.println("Usia Wasit    : " + usiaWasit);
        System.out.println("Posisi Wasit  : " + posisiWasit);
        System.out.println("Pengalaman    : " + pengalaman);         
    }
    
    public String getNamaWasit(){
        return namaWasit;
    }
    
    public String getPosisiWasit(){
        return posisiWasit;
    }
    
    public void setNamaWasit(String namaWasit){
        this.namaWasit = namaWasit;
    }
}
