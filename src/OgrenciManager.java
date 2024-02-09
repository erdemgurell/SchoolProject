

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class OgrenciManager extends Veritabani {

    static Scanner scan = new Scanner(System.in);

    public static void ogrenciMenu() throws InterruptedException {
        String secim;
        // TODO  Bu menunun calismasi icin gerekli duzenlemeleri yapiniz


        //do while döngüde kalmayı sağlar, switch veya if menülere yönlenmeyi sağlar...
        do {
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

            System.out.println("Lütfen menüden tercihinizi yapınız: ");
            secim = scan.nextLine().toLowerCase();
            switch (secim) {
                case "1":
                    ogrenciListeYazdir();
                    break;
                case "2": // Soyisimden Ogrenci Bulma
                    soyisimdenOgrenciBulma();
                    break;
                case "3": // Sinif ve Sube Ile Ogrenci Bulma
                    sinifVeSubeIleOgrenciBulma();
                    break;
                case "4": // Bilgilerini Girerek Ogrenci Ekleme
                    ogrenciEkle();
                    break;
                case "5":
                    tcNoIleOgrenciSilme();
                    break;
                case "a":
                    Helper.anaMenu();
                    break;
                case "q":
                    Helper.projeDurdur();
                    break;
                default:
                    //   HATALI TERCİH DURUMUNDA TEKRAR SEÇİM İSTENMELİ
                    System.out.println("Lutfen gecerli tercih yapiniz:");
                    break;
            }
        } while (!secim.equalsIgnoreCase("q"));

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
        System.out.print("Öğrenci kimlik no: ");
        String TcNo = scan.nextLine();
        System.out.print("Öğrenci Adı: ");
        String ad = scan.nextLine();
        System.out.print("Öğrenci Soyadı: ");
        String soyad = scan.nextLine();
        System.out.print("Doğum yılı: ");
        String dYili = scan.nextLine();
        System.out.print("Okul No: ");
        String okulNo = scan.nextLine();
        System.out.print("Sınıfı: ");
        String sinif = scan.nextLine();
        System.out.print("Şubesi: ");
        String sube = scan.nextLine();
        Veritabani.ogrenciMap.put(TcNo, ad + ", " + soyad + ", " + dYili + ", " + okulNo + ", " + sinif + ", " + sube);
    }

    ///////////////////////////////////////////////////////////////////////////////////

    // TODO sinifVeSubeIleOgrenciBulma() methodunu doldurunuz
    // OgretmenManager classindaki branstanOgretmenBulma() methodundan faydalanabilirsiniz.
    private static void sinifVeSubeIleOgrenciBulma() throws InterruptedException {
        // burayi doldurduktan sonra asagidaki kodu siliniz (sout u)
        System.out.println("Aradiginiz Öğrencinin Sınıfını Giriniz:");
        String istenenSinif = scan.nextLine();
        System.out.println("Aradiginiz Öğrencinin Şubesini Giriniz:");
        String istenenSube = scan.nextLine();

        System.out.print(istenenSinif + istenenSube + " Öğrenciler Listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        Set<Map.Entry<String, String>> ogrenciEntrySet = Veritabani.ogrenciMap.entrySet();
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "============BRANS ILE ÖĞRENCİ ARAMA ============\n" +
                        "TcNo : Isim , Soyisim , Doğum Yılı, OkulNo, Sınıfı, Şube");

        // Daha düzgün bi görünüm için printf veya String.format kullanılabilir... İsteğe bağlı
        for (Map.Entry<String, String> each : ogrenciEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValuarr = eachValue.split(", ");
            if (istenenSinif.equalsIgnoreCase(eachValuarr[4])) {
                if (istenenSube.equalsIgnoreCase(eachValuarr[5])){
                    System.out.println(eachKey + " : " + eachValue + " | ");
                }
            }
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////

    // TODO soyisimdenOgrenciBulma() methodunu doldurunuz

    private static void soyisimdenOgrenciBulma() throws InterruptedException {
        System.out.println("Aradiginiz Öğrencinin Soyadını Giriniz:");
        String istenenSoyad = scan.nextLine();

        System.out.print(istenenSoyad + " Öğrenciler Listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        Set<Map.Entry<String, String>> ogrenciEntrySet = Veritabani.ogrenciMap.entrySet();
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "============SOYİSİM ILE ÖĞRENCİ ARAMA ============\n" +
                        "TcNo : Isim , Soyisim , Doğum Yılı, OkulNo, Sınıfı, Şube");

        // Daha düzgün bi görünüm için printf veya String.format kullanılabilir... İsteğe bağlı
        for (Map.Entry<String, String> each : ogrenciEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuarr = eachValue.split(", ");
            if (istenenSoyad.equalsIgnoreCase(eachValuarr[1])) {
                System.out.println(eachKey + " : " + eachValue + " | ");
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////

    // TODO ogrenciListeYazdir() methodunu doldurunuz
    private static void ogrenciListeYazdir(){
        for (Map.Entry<String, String> each :Veritabani.ogrenciMap.entrySet()){
            System.out.println(each.getKey() + " : " + each.getValue());
        }
    }
}
