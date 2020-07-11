//355
package finalodevi;

import java.io.*;
import java.util.Scanner;


public class Finalodevi {
 public static void diziyazdir(int[] dizi){
     for (int i = 0; i < dizi.length; i++) {
         System.out.println(" "+dizi[i]);
     }
     //deneme için kullanıldı
 
 }
 public static int[] diziboyut() throws FileNotFoundException{
 //dinamik olması için dizi boyutlarını bu şekilde öğrenildi
     int boyut1  =-1 ;
     int boyut2 =-1;
     int k1 =0;
 //KONUM HER BİLGİSAYARDA DEĞİŞİKLİK GÖSTERİR DEĞİŞTİRİNCE SİL BURAYI 
    File f = new File("C:\\Users\\AHMETCAN\\Desktop\\finalodevi\\diziler.txt");
    Scanner scanner = new Scanner(f);
    while(scanner.hasNextLine()){
        
        String gelen =scanner.nextLine();
   
        
        if (gelen.equals("dizi1")) {
     
k1=1;
        }
        else if(gelen.equals("dizi2")){
        k1=2;
        }
        if (k1==1) {
            boyut1++;
        }
        else if (k1==2) {
            boyut2++;
        }
    }
    scanner.close();   
             int[] dizi ={boyut1,boyut2};
             return dizi;

}
 
 public static int[] dizileribirlestir(int[] d1, int[] d2) throws IOException {
 int [] dizi3 =new int[d1.length+d2.length];
    int i = 0, j = 0, k = 0;
    while (i < d1.length && j < d2.length)
    {
        if (d1[i] < d2[j])
        {
           dizi3[k] = d1[i];
            i++;
        }
        else
        {
            dizi3[k] = d2[j];
            j++;
        }
        k++;
    }

    while (i < d1.length)
    {
        dizi3[k] = d1[i];
        i++;
        k++;
    }

    while (j < d2.length)
    {
        dizi3[k] = d2[j];
        j++;
        k++;
    }

 //diziyazdir(dizi3);
dosyayaYaz(dizi3);
 return dizi3;
 }
 public static void aramaYap() throws FileNotFoundException{
     //KONUM HER BİLGİSAYARDA DEĞİŞİKLİK GÖSTERİR DEĞİŞTİRİNCE SİL BURAYI 
     File f = new File("C:\\Users\\AHMETCAN\\Desktop\\finalodevi\\siralanmisdiziler.txt");

     do { 
          Scanner scanner = new Scanner(f);
    int sayac=0;
      int kontrol =0;
         try{
         System.out.println("Arama yapmak için bir sayi giriniz. \nÇıkmak için sayı harici herhangi bir tuşa basınız."); 
         Scanner in =new Scanner(System.in);
       int sayi = in.nextInt();
         while(scanner.hasNext()){  

           String gelen =scanner.nextLine();
           sayac++;
           
         if (sayi==Integer.parseInt(gelen)) {
             
             System.out.println("Sayı "+sayac+". Satırda bulundu ");
             
             kontrol=1;
                 
         }
                }
         if (kontrol==0){
             System.out.println("Aranan sayı bulunamadı");
         } {
             
         }
} catch(Exception e){
         System.out.println("İşleminiz sonlandı.");
    break;
     }} while (true);
     
    
  
 }

public static int[] dosyayioku() throws FileNotFoundException, IOException{
    int[] boyut =diziboyut();
    int[] dizi1 =new int[boyut[0]];
      int[] dizi2 =new int[boyut[1]];
      
     int kontrol=0   ;

         int sayac1=0,sayac2=0;
          //KONUM HER BİLGİSAYARDA DEĞİŞİKLİK GÖSTERİR DEĞİŞTİRİNCE SİL BURAYI 
    File f = new File("C:\\Users\\AHMETCAN\\Desktop\\finalodevi\\diziler.txt");
    Scanner scanner = new Scanner(f);
    while(scanner.hasNextLine()){
        String gelen =scanner.nextLine();
     
        if (gelen.equals("dizi1")) {
            kontrol=1;
                    
        }
            if (gelen.equals("dizi2")) {
            kontrol=2;
                    
        }
           if (kontrol==1) {
               if (!gelen.equals("dizi1")) {
                    dizi1[sayac1]=Integer.parseInt(gelen);
            sayac1++;
               }
           
        }
            else if (kontrol==2) {
                if (!gelen.equals("dizi2")) {
            dizi2[sayac2]=Integer.parseInt(gelen);
            sayac2++;
        }
            }
    } 
    scanner.close();   
dizi1 =siralamaYap(dizi1);
dizi2 =siralamaYap(dizi2);
   int[] dizi3= dizileribirlestir(dizi1,dizi2);
return dizi3;


}
public static void dosyayaYaz(int[] dizi) throws FileNotFoundException, IOException{
     //KONUM HER BİLGİSAYARDA DEĞİŞİKLİK GÖSTERİR DEĞİŞTİRİNCE SİL BURAYI     
    File file = new File("C:\\Users\\AHMETCAN\\Desktop\\finalodevi\\siralanmisdiziler.txt");
        
              try {

OutputStream o = new FileOutputStream(file);
                  for (int i = 0; i < dizi.length; i++) {
                String a =String.valueOf(dizi[i]);

                 o.write(a.getBytes());
                 o.write("\n".getBytes());
                  }
                  o.close();
}
catch(Exception e) {
    System.out.println("İşlem başarısız. "+e);
}   
}
public static int[] siralamaYap(int [] dizi){
    
    for (int i = 0; i < dizi.length-1; i++) { 
 
            int sayi = dizi[i]; 
            int temp = i; 
 
            for (int j = i+1; j < dizi.length ; j++) { 
                if(dizi[j]<sayi){ 
                    sayi = dizi[j]; 
                    temp = j; 
                }
            }
 
            if(temp != i){ 
                dizi[temp] = dizi[i];
                dizi[i] = sayi;
            }

        }


return dizi;
}
public static void main(String[] args) throws FileNotFoundException, IOException {
int[] d =dosyayioku();
aramaYap();
//İstenilen methodların hepsi yukarıda mevcuttur. 
//İçiçe kullanımdan dolayı main methodunda çağırmamız gerekmedi.
//dizisiralama() ve dizibirlestir() dosyaokuma methodunda kullanıldı.  
} 

}
