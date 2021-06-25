/*
FINAL PROJECT KELOMPOK 1: SOCCER AGENDA
Christoper Luis Alexander - 2301876493
Jonathan Evan Sampurna - 2301876612
Christiano Ekasakti Sangalang - 2301927872
 */
package finpro;
import java.io.Serializable;
import java.util.ArrayList;

public class Pertandingan implements Serializable{
    private String kota;
    private String stadion;
    private String tanggal; 
    private String waktu;
    private Tim tim1;
    private Tim tim2;
    private int totalscore1 = 0;
    private int totalscore2 = 0;
    private int score1;
    private int score2;

    ArrayList<Pelanggaran> pelanggaran = new ArrayList<>();
    Wasit wasit;
    
    public Pertandingan(String kota, String stadion, String tanggal, String waktu, Tim tim1, Tim tim2, int score1, int score2, ArrayList<Pelanggaran> pelanggaran, Wasit wasit) {
        this.kota = kota;
        this.stadion = stadion;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.tim1 = tim1;
        this.tim2 = tim2;
        this.score1 = score1;
        this.score2 = score2;
        this.pelanggaran = pelanggaran;
        this.wasit = wasit;
    }
    


    public int hasilscore1(){
        return totalscore1;
    }

    public int hasilscore2(){
        return totalscore2;
    }

    public String getNamaTim1()
    {
        return tim1.getNamaTim();
    }

    public String getNamaTim2()
    {
        return tim2.getNamaTim();
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }
    
    public int getScore1() {
        return score1;
    }
    
    public void setScore2(int score2) {
        this.score2 = score2;
    }
    
    public int getScore2() {
        return score2;
    }
    
    public void showPertandingan() {
        System.out.println("Kota    : " + kota);
        System.out.println("Stadion : " + stadion);
        System.out.println("Tanggal : " + tanggal);
        System.out.println("Waktu   : " + waktu);
        System.out.println(tim1.getNamaTim() + " - " + tim2.getNamaTim());
        System.out.println(getScore1() + " - " + getScore2());
        
        if(!pelanggaran.isEmpty())
        {
            for(int i=0; i<pelanggaran.size(); i++)
            {
                System.out.println("Pelanggaran " + (i+1));
                System.out.println(pelanggaran.get(i).showPelanggaran());
            }
        }
        
        System.out.println("Wasit   : " + wasit.getNamaWasit());
        System.out.println("Posisi  : " + wasit.getPosisiWasit());
    } 
}
