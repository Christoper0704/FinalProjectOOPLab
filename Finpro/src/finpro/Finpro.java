/*
FINAL PROJECT KELOMPOK 1: SOCCER AGENDA
Christoper Luis Alexander - 2301876493
Jonathan Evan Sampurna - 2301876612
Christiano Ekasakti Sangalang - 2301927872
 */
package finpro;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Finpro {
    public static Scanner read = new Scanner(System.in);
    public static ArrayList<Pertandingan> pertandingan = new ArrayList<>();
    
    public static ArrayList<Pemain> pemain = new ArrayList<>();
    public static ArrayList<Tim> tim = new ArrayList<>();
    public static ArrayList<Wasit> wasit = new ArrayList<>();
    public static ArrayList<Tim> namateam = new ArrayList<>();

    public static void pressEnter() {
        System.out.print("\nPress enter to continue..");
        try
        {
            System.in.read();
        }  
        catch(IOException e)
        {
        }          
    }
    
    public static void login() {
        String username, password;
        System.out.println("LOGIN");
        System.out.println("=====");
        do
        {
            System.out.print("Username: ");
            username = read.nextLine();            
        }while(!"admin".equals(username));

        do
        {
            System.out.print("Password: ");
            password = read.nextLine();            
        }while(!"admin".equals(password));
    }
    
    public static void menu() {
        System.out.println("\nC E O");
        System.out.println(" ______   _____   _____  _____  _____   _____     ____   _____   ____   _       ____   ____");
        System.out.println("|        |     | |      |      |       |     |   |    | |       |      | \\   | |    | |    |");
        System.out.println("|______  |     | |      |      |_____  |_____|   |____| |  ___  |____  |  \\  | |    | |____|");
        System.out.println("       | |     | |      |      |       |   \\     |    | |     | |      |   \\ | |    | |    |");
        System.out.println(" ______| |_____| |_____ |_____ |_____  |    \\    |    | |_____| |____  |    \\| |___/  |    |");
        System.out.println("==============================================================================================");
        System.out.println("MENU");
        System.out.println("1. Pendataan");
        System.out.println("2. View Data");
        System.out.println("3. Score Turnamen");
        System.out.println("4. Exit");
        System.out.print("Pilih: ");        
    }
    
    public static void inputPertandingan() {
        String waktu, tanggal, kota, stadion, score, namaWasit, posisiWasit, cekKartu, kartu, pemainSalah, sanksi, cekPel;
        int lamaSanksi;
        ArrayList<Pelanggaran> pelanggaran = new ArrayList<>();
        
        String tim1, tim2;
        int score1, score2;
        
        if(tim.isEmpty() || wasit.isEmpty())
        {
            System.out.println("No data yet... Input data Tim dan Wasit first!");
            return;
        }
        
        else if(tim.size() == 1)
        {
            System.out.println("There is only 1 team, input more team...");
            return;
        }
        
        System.out.println("\nI. INPUT PERTANDINGAN\n");
        System.out.println("1. Waktu Pertandingan:");
        do
        {
            System.out.print("a. Waktu/Jam (format=[00:00]): ");
            waktu = read.nextLine();            
        }while(!waktu.matches("[0-9]+:[0-9]+[0-9]") && !waktu.matches("[0-9]+[0-9]:[0-9]+[0-9]"));
        do{
            System.out.print("b. Tanggal (format=[dd/mm/yyyy]): ");
            tanggal = read.nextLine();
        }while(!tanggal.matches("[0-3]+[0-9]/[0-1]+[0-9]/[1-9]+[0-9]+[0-9]+[0-9]"));
        
        System.out.println("\n2. Tempat Pertandingan:");
        System.out.print("a. Nama Kota: ");
        kota = read.nextLine();
        System.out.print("b. Nama Stadion: ");
        stadion = read.nextLine();
        
        System.out.println("\n3. Tim: ");
        int check = 0;
        do
        {
            System.out.print("Nama Tim 1: ");  
            tim1 = read.nextLine();       
            
            for(int k=0; k<tim.size(); k++)
            {
                if((tim.get(k).getNamaTim().compareTo(tim1))==0)
                {
                    check = 1;
                }
            }
        }while(check == 0);

        Tim t1 = new Tim(tim1);
        
        System.out.print("Score Tim 1: ");
        score1 = read.nextInt();
        
        read.nextLine();
        
        check = 0;
        
        do
        {
            System.out.print("Nama Tim 2: ");
            tim2 = read.nextLine();
            
            for(int k=0; k<tim.size(); k++)
            {
                if((tim.get(k).getNamaTim().compareTo(tim2))==0)
                {
                    check = 1;
                }
            }            
        }while(check == 0);
        
        Tim t2 = new Tim(tim2);
        System.out.print("Score Tim 2: ");
        score2 = read.nextInt();
        
        check = 0;

        if(score1>score2)
        {
            for(int k=0;k<tim.size();k++)
        {
            if(t1.getNamaTim().compareTo(tim.get(k).getNamaTim())==0)
            {
                tim.get(k).menang();
            }
            if(t2.getNamaTim().compareTo(tim.get(k).getNamaTim())==0)
            {
                tim.get(k).kalah();
            }
        }
        }
        else if(score1<score2)
        {
            for(int k=0;k<tim.size();k++)
        {
            if(t1.getNamaTim().compareTo(tim.get(k).getNamaTim())==0)
            {
                tim.get(k).kalah();
            }
            if(t2.getNamaTim().compareTo(tim.get(k).getNamaTim())==0)
            {
                tim.get(k).menang();
            }
        }
        }
        else
        {
            for(int k=0;k<tim.size();k++)
        {
            if(t1.getNamaTim().compareTo(tim.get(k).getNamaTim())==0)
            {
                tim.get(k).draw();
            }
            if(t2.getNamaTim().compareTo(tim.get(k).getNamaTim())==0)
            {
                tim.get(k).draw();
            }
        }
        }
        
        System.out.println("\n4. Wasit:");
        read.nextLine();
        do
        {
            do{
                System.out.print("a. Nama [5 - 20 karakter]: ");
                namaWasit = read.nextLine();
            }while(namaWasit.length()<5 || namaWasit.length()>20);
            for(int k=0; k<wasit.size(); k++)
            {
                if((wasit.get(k).getNamaWasit().compareTo(namaWasit))==0)
                {
                    check = 1;
                }
            }            
        }while(check == 0);
        
        System.out.print("b. Posisi: ");
        posisiWasit = read.nextLine();
        
        System.out.println("\n5. Pelanggaran:");
        do
        {
            System.out.print("a. Apakah ada kartu merah/kuning[Y/N] (Case Sensitive): ");
            cekKartu = read.nextLine();
        }while(cekKartu.compareTo("Y")!=0 && cekKartu.compareTo("N")!=0);

        if(cekKartu.compareTo("Y")==0)
        {
            do
            {
                do
                {
                    System.out.print("Kartu yang didapat [merah|kuning] (Case Sensitive): ");
                    kartu = read.nextLine();
                }while(kartu.compareTo("merah")!=0 && kartu.compareTo("kuning")!=0);
                do{
                    System.out.print("Nama pemain yang mendapat kartu [5 - 20 karakter]: ");
                    pemainSalah = read.nextLine();
                }while(pemainSalah.length()<5 && pemainSalah.length()>20);
                System.out.print("Sanksi [Penalti | Dilarang berapa kali main | Sanksi lainnya]: ");
                sanksi = read.nextLine();
                String cekSanksi = "Dilarang berapa kali";
                if(sanksi.contains(cekSanksi))
                {
                    System.out.print("Berapa lama sanksi tersebut: ");
                    lamaSanksi = read.nextInt();
                }
                else
                {
                    lamaSanksi = 0;
                }
                Pelanggaran pel = new Pelanggaran(kartu, pemainSalah, sanksi, lamaSanksi);
                pelanggaran.add(pel);
                read.nextLine();
                do{
                    System.out.print("Apakah terdapat pelanggaran lagi?[Y/N] (Case Sensitive): ");
                    cekPel = read.nextLine();      
                }while(cekPel.compareTo("Y")!=0 && cekPel.compareTo("N")!=0);
            }while(cekPel.compareTo("Y")==0);
        }

        Wasit was = new Wasit(namaWasit, posisiWasit);
        Pertandingan per = new Pertandingan(kota, stadion, tanggal, waktu, t1, t2, score1, score2, pelanggaran, was);
        pertandingan.add(per);
    }
    
    public static void inputTim() {
        String namaTim, alamatTim, pelatih, namaPemain, posisiPemain;
        int usiaPemain;
        
        System.out.println("\nII. INPUT TIM\n");
        
        System.out.println("\n1. Tim:");
        System.out.print("a. Nama: ");
        namaTim = read.nextLine();
        
        System.out.print("b. Alamat: ");
        alamatTim = read.nextLine();
        
        System.out.print("c. Pelatih: ");
        pelatih = read.nextLine();
        
        System.out.println("\n2. Pemain:");
        for(int j=1; j<=11; j++)
        {
            do{
                System.out.print("Nama Pemain " + j + " [5 - 20 karakter]: ");
                namaPemain = read.nextLine();
            }while(namaPemain.length()<5 || namaPemain.length()>20);
            
            System.out.print("Usia Pemain " + j + ": ");
            usiaPemain = read.nextInt();
            read.nextLine();
            
            System.out.print("Posisi Pemain " + j + ": ");
            posisiPemain = read.nextLine();
            
            Pemain play = new Pemain(namaPemain, usiaPemain, posisiPemain);
            pemain.add(play);
        }
        
        Tim team = new Tim(namaTim, alamatTim, pelatih, pemain);
        tim.add(team);
            
    }
    
    public static void inputWasit() {
        String namawasit1, usiawasit, posisiwasit1, pengalamanwasit, choose;
        
        System.out.println("\nIII. INPUT WASIT\n");
        do
        {
            do{
                System.out.print("a. Nama Wasit [5 - 20 karakter]: ");
                namawasit1 = read.nextLine();
            }while(namawasit1.length()<5 || namawasit1.length()>20);
            do{
                System.out.print("b. Usia Wasit: ");
                usiawasit = read.nextLine();
            }while(!usiawasit.matches("[0-9]*$"));
            System.out.print("c. Posisi Wasit: ");
            posisiwasit1 = read.nextLine();
            System.out.print("d. Pengalaman Wasit: ");
            pengalamanwasit = read.nextLine();
            Wasit referee = new Wasit(namawasit1,usiawasit,posisiwasit1,pengalamanwasit);
            wasit.add(referee);
            do{
                System.out.print("Tambah Wasit [Y|N] (Case Sensitive)? ");
                choose = read.nextLine(); 
            }while(choose.compareTo("Y")!=0 && choose.compareTo("N")!=0);
        }while(choose.compareTo("Y")==0);  
    }
    
    public static void writeWasit(String namaFile, ArrayList<Wasit>list) {
        try
        {
            FileOutputStream fileOut = new FileOutputStream(namaFile);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(list);
            objOut.flush();
            objOut.close();
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }              
    }
    
    public static void writeTim(String namaFile, ArrayList<Tim>list) {
        try
        {
            FileOutputStream fileOut = new FileOutputStream(namaFile);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(list);
            objOut.flush();
            objOut.close();
        }

        catch(Exception e)
        {
           e.printStackTrace();
        }              
    }  
    
    public static void writePertandingan(String namaFile, ArrayList<Pertandingan>list) {
        try
        {
            FileOutputStream fileOut = new FileOutputStream(namaFile);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(list);
            objOut.flush();
            objOut.close();
        }

        catch(Exception e)
        {
           e.printStackTrace();
        }              
    }       
    
    public static void readWasit(String namaFile) {
        try
        {
            FileInputStream readData = new FileInputStream(namaFile);
            ObjectInputStream readStream = new ObjectInputStream(readData);

            wasit = (ArrayList<Wasit>) readStream.readObject();
            readStream.close();
            
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }        
    }
    
    public static void readTim(String namaFile) {
        try
        {
            FileInputStream readData = new FileInputStream(namaFile);
            ObjectInputStream readStream = new ObjectInputStream(readData);

            tim = (ArrayList<Tim>) readStream.readObject();
            readStream.close();
            
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }        
    }    
    
    public static void readPertandingan(String namaFile) {
        try
        {
            FileInputStream readData = new FileInputStream(namaFile);
            ObjectInputStream readStream = new ObjectInputStream(readData);

            pertandingan = (ArrayList<Pertandingan>) readStream.readObject();
            readStream.close();
           
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }        
    }       
    
    
    public static void menu1() {
        int choice;
        do
        {
            System.out.println("\nINPUT DATA MENU");
            System.out.println("=================");
            System.out.println("1. Pertandingan");
            System.out.println("2. Tim dan Pemain");
            System.out.println("3. Wasit");
            System.out.print("Pilih: ");
            choice = read.nextInt();
            read.nextLine();
        }while(choice<1 && choice>3);
        
        switch(choice) 
        {
            case 1:
            {
                inputPertandingan();
                break;
            }
            
            case 2:
            {
                inputTim();
                break;
            }
            
            case 3:
            {
                inputWasit();
                break;
            }
        }
        
    }
    
    public static void menu2() {
        int i, choice;
        
        do
        {
            System.out.println("\n=== VIEW DATA ===");
            System.out.println("1. View Data Tim dan Pemain");
            System.out.println("2. View Data Wasit");
            System.out.println("3. View Data Pertandingan");
            System.out.print("Pilih: ");   
            choice = read.nextInt();
        }while(choice<1 && choice>4);
        
        switch(choice)
        {
            case 1:
            {
                if(tim.isEmpty())
                {
                    System.out.println("No data...");
                }
                
                else
                {
                    for(i=0; i<tim.size(); i++)
                    {
                        System.out.println("DATA TIM " + (i+1));
                        tim.get(i).showTim();
                    }                    
                }

                break;
            }
            
            case 2:
            {
                if(wasit.isEmpty())
                {
                    System.out.println("No data...");    
                    return;
                }
                    for(i=0;i<wasit.size();i++)
                    {
                       System.out.println("DATA WASIT " + (i+1));
                       wasit.get(i).showWasit();
                    }                    
                
                break;                
            }
            
            case 3:
            {
                if(pertandingan.isEmpty())
                {
                    System.out.println("No data...");                     
                }
                
                else
                {
                    for(i=0;i<pertandingan.size();i++)
                    {
                       System.out.println("DATA PERTANDINGAN " + (i+1));
                       pertandingan.get(i).showPertandingan();
                    }                    
                }

                break;                
            }
        }
    }
    
    public static void menu3() {
        if(pertandingan.isEmpty())
        {
            System.out.println("Tidak ada data score..Masukkan data pertandingan terlebih dahulu!!");
        }
        else
        {
            for(int i = 0; i<tim.size();i++)
            {
                tim.get(i).kalkulasi();
            }
            
            Collections.sort(tim,Comparator.comparing(Tim::hasilscore));
            Collections.reverse(tim);
            
            System.out.println("SCORE TOURNAMENT\n");
            System.out.printf("\n  Rank  |  Nama Tim       |  Menang  |  Kalah  |  Seri  |  Score  |\n");
            for(int i = 0; i<tim.size();i++)
            {
                System.out.printf("  #%-2d   |  %-14s |  %-7d |  %-5d  |  %-4d  |  %-5d  |\n",(i+1),tim.get(i).getNamaTim(),tim.get(i).getWin(),tim.get(i).getLose(),tim.get(i).getDraw(),tim.get(i).hasilscore());
            }
        }
    }
    
    public static void main(String[] args) {
        try
        {
            int choice;
            login();    
            readWasit("Wasit.txt");
            readTim("Tim.txt");
            readPertandingan("Pertandingan.txt");

            do
            {
                menu();
                choice = read.nextInt();
                read.nextLine();

                switch(choice)
                {
                    case 1:
                    {
                        menu1();
                        pressEnter();
                        break;
                    }

                    case 2:
                    {
                        menu2();
                        pressEnter();
                        break;
                    }

                    case 3:
                    {
                        menu3();
                        pressEnter();
                        break;
                    }

                    case 4:
                    {
                        writeWasit("Wasit.txt", wasit);
                        writeTim("Tim.txt", tim);
                        writePertandingan("Pertandingan.txt", pertandingan);
                        System.out.println("Thank you! :)");
                        break;
                    }
                }
            }while(choice != 4);            
        }
        
        catch(Exception e)
        {
            System.out.println("Error");
        }

    }
}
