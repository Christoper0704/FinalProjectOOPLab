/* 
KELOMPOK 1: SOCCER AGENDA
Christoper Luis Alexander - 2301876493
Jonathan Evan Sampurna - 2301876612
Christiano Ekasakti Sangalang - 2301927872
*/
package finpro;
import java.io.Serializable;

public class Pemain implements Serializable{
    private String namaPemain;
    private int usiaPemain;
    private String posisiPemain;
    
    public Pemain(String namaPemain, int usiaPemain, String posisiPemain){
        this.namaPemain = namaPemain;
        this.usiaPemain = usiaPemain;
        this.posisiPemain = posisiPemain;
    }
    
    public void showPemain(){  
        System.out.println("Nama Pemain    : " + namaPemain);
        System.out.println("Usia Pemain    : " + usiaPemain);
        System.out.println("Posisi Pemain  : " + posisiPemain);
    }
    
    public Pemain(String namaPemain){
        this.namaPemain = namaPemain;
    }
    
    public String getNamaPemain(){
        return namaPemain;
    }    
}
