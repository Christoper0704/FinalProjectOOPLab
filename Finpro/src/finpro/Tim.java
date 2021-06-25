/* 
KELOMPOK 1: SOCCER AGENDA
Christoper Luis Alexander - 2301876493
Jonathan Evan Sampurna - 2301876612
Christiano Ekasakti Sangalang - 2301927872
*/
package finpro;
import java.io.Serializable;
import java.util.ArrayList;

public class Tim implements Serializable, HitungScore{
    private String namaTim;
    private String alamatTim;
    private String pelatih;
    private int totalscore;
    private int win;
    private int lose;
    private int draw;
    ArrayList<Pemain> pemain;
    
    public Tim(String namaTim, String alamatTim, String pelatih, ArrayList<Pemain> pemain){
        this.namaTim = namaTim;
        this.alamatTim = alamatTim;
        this.pelatih = pelatih;
        this.pemain = pemain;
        this.win = 0;
        this.lose = 0;
        this.draw = 0;
    }

    public Tim(String namaTim)
    {
        this.namaTim = namaTim;
    }
    
    public void showTim(){  
        System.out.println("Nama Tim    : " + namaTim);
        System.out.println("Alamat Tim  : " + alamatTim);
	System.out.println("Pelatih     : " + pelatih);
	System.out.println("Pemain      : ");
        
        for(int i=0;i<pemain.size();i++)
        {
            System.out.println("+ " + (i+1) + "." + pemain.get(i).getNamaPemain());
        }
    }

    public void kalkulasi()
    {
        this.totalscore = win*3 + lose*0 + draw*1;
    }
    
    public int getWin()
    {
        return win;
    }
    
    public int getLose()
    {
        return lose;
    }
    
    public int getDraw()
    {
        return draw;
    }
    
    public int hasilscore()
    {
        return totalscore;
    }

    public String getNamaTim(){
        return namaTim;
    }
    
    public String getAlamatTim(){
        return alamatTim;
    }
    
    public String getPelatih(){
        return pelatih;
    }   

    @Override
    public void menang() {
        this.win++;
    }

    @Override
    public void kalah() {
        this.lose++;
    }

    @Override
    public void draw() {
        this.draw++;
    }
  
}
