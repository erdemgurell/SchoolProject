

import java.util.Scanner;

public class OgrenciManager extends Veritabani {

    static Scanner scan = new Scanner(System.in);

    public static void ogrenciMenu() throws InterruptedException {

        // TODO  Bu menunun calismasi icin gerekli duzenlemeleri yapiniz

        //do while döngüde kalmayı sağlar, switch veya if menülere yönlenmeyi sağlar...

        {
            System.out.println(
                    "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                            "================== OGRENCI MENU =================\n" +
                            "\t   1- Ogrenci Listesi Yazdir\n" +
                            "\t   2- Soyisimden Ogrenci Bulma\n" +
                            "\t   3- Sinif ve Sube Ile Ogrenci Bulma\n" +
                            "\t   4- Bilgilerini Girerek Ogrenci Ekleme\n" +
                            "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                            "\t   A- ANAMENU\n" +
                            "\t   Q- CIKIS");

                // "1":
                    ogrenciListeYazdir();

                // "2": // Soyisimden Ogrenci Bulma
                    soyisimdenOgrenciBulma();

                // "3": // Sinif ve Sube Ile Ogrenci Bulma
                    sinifVeSubeIleOgrenciBulma();

                // "4": // Bilgilerini Girerek Ogrenci Ekleme
                    ogrenciEkle();

                // "5":
                    tcNoIleOgrenciSilme();

                // "A" VEYA "a":
                    Helper.anaMenu();

                // "Q" VEYA "q":
                    Helper.projeDurdur();

                    //   HATALI TERCİH DURUMUNDA TEKRAR SEÇİM İSTENMELİ
                    System.out.println("Lutfen gecerli tercih yapiniz:");



        }

        // ÇIKIŞ YAPILIRSA
        Helper.projeDurdur();

    }

    private static void tcNoIleOgrenciSilme() throws InterruptedException {
        System.out.println("Silinecek ogrenci kimlik no giriniz");
        String silinecekOgrenci = scan.nextLine();

        String silinecekValue = ogrenciMap.get(silinecekOgrenci);
        String sonucValue = ogrenciMap.remove(silinecekOgrenci);

        System.out.print(silinecekOgrenci + "Siliniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        //  Programın çalışmaya devam etmesi için gerekli
        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            System.out.println("Istediginiz TC numarasi ile ogrenci bulunamadi");
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////

    // TODO ogrenciEkle() methodunu doldurunuz
    private static void ogrenciEkle() {

        // burayi doldurduktan sonra asagidaki kodu siliniz (sout u)
        System.out.println("KONSOLDAN ALDIĞINIZ BİLGİLERLE MAP'E ÖĞRENCİ EKLEYİNİZ ");



    }

    ///////////////////////////////////////////////////////////////////////////////////

    // TODO sinifVeSubeIleOgrenciBulma() methodunu doldurunuz
    // OgretmenManager classindaki branstanOgretmenBulma() methodundan faydalanabilirsiniz
    private static void sinifVeSubeIleOgrenciBulma() throws InterruptedException {

        // burayi doldurduktan sonra asagidaki kodu siliniz (sout u)
        System.out.println("///// KONSOLDAN ALDIGINIZ BILGILERLE, ARANAN OGEYI (SINIF VE SUBE) ICEREN MAP ELEMANLARINI LISTELEYINIZ ////////");




    }

    ///////////////////////////////////////////////////////////////////////////////////

    // TODO soyisimdenOgrenciBulma() methodunu doldurunuz

    private static void soyisimdenOgrenciBulma() throws InterruptedException {

        // burayi doldurduktan sonra asagidaki kodu siliniz (sout u)
        System.out.println("///// KONSOLDAN ALDIGINIZ BILGILERLE (SOYISIM), ARANAN OGEYI ICEREN MAP ELEMANLARINI LISTELEYINIZ ////////");




    }

    ///////////////////////////////////////////////////////////////////////////////////

    // TODO ogrenciListeYazdir() methodunu doldurunuz
    private static void ogrenciListeYazdir() throws InterruptedException {

        // burayi doldurduktan sonra asagidaki kodu siliniz (sout u)
        System.out.println("/////VERITABANI SINIFINDAKI MAP'TE BULUNAN OGRENCILERIN LISTESINI YAZDIRINIZ///////// ");




    }
}
