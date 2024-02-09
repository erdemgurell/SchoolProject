import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class OgretmenManager extends Veritabani {

    static Scanner scan = new Scanner(System.in);
    static Scanner scanStr = new Scanner(System.in);

    public static void ogretmenMenu() throws InterruptedException {

        // TODO ogretmenMenu() methodundaki eksiklikleri tamamlayiniz



        String secim;
        //do while döngüde kalmayı sağlar, switch veya if menülere yönlenmeyi sağlar...
        do {
            System.out.println(
                    "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                            "================= OGRETMEN MENU =================\n" +
                            "\n" +
                            "\t   1- Ogretmenler Listesi Yazdir\t\n" +
                            "\t   2- Soyisimden Ogretmen Bulma\n" +
                            "\t   3- Branstan Ogretmen Bulma\n" +
                            "\t   4- Bilgilerini Girerek Ogretmen Ekleme\n" +
                            "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                            "\t   A- ANAMENU\n" +
                            "\t   Q- CIKIS\n");

            System.out.print("seçiminizi yapınız: ");

            secim = scanStr.nextLine().toLowerCase();

            // ÇIKIŞ YAPILMADIĞI SÜRECE ANA MENÜ VEYA ALT MENÜLER ARASINDA DOLAŞILABİLMELİ.
            // AŞAĞIDAKİ METODLARIN BULUNDUĞU YERE GİDEREK, İLGİLİ METODU TANIMLAYINIZ...
            // CTRL + SOL tık LA METODLAR ARASINDA DOLAŞABİLİRSİNİZ.

            switch (secim) {
                //   "1": // Ogretmenler Listesi Yazdir.
                case "1":
                    ogretmenListesiYazdir();
                    break;

                //   "2": // Soyisimden Ogretmen Bulma
                case "2":
                    soyisimdenOgretmenBulma();
                    break;

                //   "3": // Branstan Ogretmen Bulma
                case "3":
                    branstanOgretmenBulma();
                    break;

                //   "4": // Bilgilerini Girerek Ogretmen Ekleme
                case "4":
                    ogretmenEkleme();
                    break;
                //   "5": // Kimlik No Ile Kayit Silme
                case "5":
                    tcNoIleOgretmenSil();
                    break;

                //   "a" VEYA "A": // Ana Menü Metodu Çağrılabilmeli
                case "a":
                    Helper.anaMenu();
                    break;
                case "q":
                    System.out.println("Çıkış yapılıyor...");
                    break;
                //   "q" VEYA "Q": // Çıkış yapılabilmeli

                //   HATALI TERCİH DURUMUNDA TEKRAR SEÇİM İSTENMELİ
                default:
                    System.out.println("Lutfen gecerli tercih yapiniz:");
                    break;
            }
        } while (!secim.equalsIgnoreCase("q"));

        // ÇIKIŞ YAPILIRSA
        Helper.projeDurdur();
    }


    public static void tcNoIleOgretmenSil() throws InterruptedException {
        System.out.println("Silinecek ogretmen kimlik no giriniz");
        String silinecekOgretmen = scan.nextLine();

        String silinecekValue = Veritabani.ogretmenlerMap.get(silinecekOgretmen);
        String sonucValue = Veritabani.ogretmenlerMap.remove(silinecekOgretmen);

        System.out.print(silinecekOgretmen + " Siliniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        //////////////////////////////////////////////////////////////////////////////
        // BU BLOĞU DEĞİŞTİRMEYİN, DİKKATE ALMAYIN...                               //
        // SİLİNECEK KİMLİK NO YOKSA VEYA BAŞKA BEKLENMEDİK                         //
        // ŞEYLER OLURSA KODUN DEVAMINI SAĞLAYACAK...
        try {                                                                       //
            boolean sonuc = sonucValue.equals(silinecekValue);                      //
        } catch (Exception e) {                                                     //
            System.out.println("Istediginiz Tc numarasi ile ogretmen bulunamadi");  //
        }                                                                           //
        //////////////////////////////////////////////////////////////////////////////
    }

    ///////////////////////////////////////////////////////////////

    // TODO ogretmenEkleme() methodunu doldurunuz
    public static void ogretmenEkleme() {

        System.out.print("öğretmen kimlik no: "); String TcNo=scanStr.nextLine();;
        System.out.print("öğretmen adı: ");  String ad=scanStr.nextLine();
        System.out.print("öğretmen soyadı: ");String soyad=scanStr.nextLine();
        System.out.print("doğum yılı: ");String dYili= scanStr.nextLine();
        System.out.print("branşı: ");String brans= scanStr.nextLine();

        String ogretmenBilgileri = TcNo +", " +  ad + ", " +soyad + ", " + dYili + "," + brans;
        ogretmenlerMap.put(TcNo, ogretmenBilgileri);

    }

    // TODO Bu methodu degistirmeyiniz.
    public static void branstanOgretmenBulma() throws InterruptedException {
        System.out.print("Aradığınız öğretmenin branşını giriniz: ");
        String istenenBrans = scan.nextLine();

        System.out.print(istenenBrans + " branşındaki öğretmenler listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        Set<Map.Entry<String, String>> ogretmenEntrySet = Veritabani.ogretmenlerMap.entrySet();
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "============BRANS ILE OGRETMEN ARAMA ============\n" +
                        "TcNo : Isim , Soyisim , D.Yili , Brans");

        // Daha düzgün bi görünüm için printf veya String.format kullanılabilir... İsteğe bağlı
        for (Map.Entry<String, String> each : ogretmenEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuarr = eachValue.split(", ");
            if (istenenBrans.equalsIgnoreCase(eachValuarr[3])) {
                System.out.println(eachKey + " : " + eachValue + " | ");
            }
        }
    }

    ///////////////////////////////////////////////////////////////

    // TODO soyisimdenOgretmenBulma() methodunu doldurunuz
    public static void soyisimdenOgretmenBulma() throws InterruptedException {

        System.out.print("Aradığınız öğretmenin soyismini giriniz: ");
        String istenenSoyad= scanStr.nextLine();

        System.out.println( istenenSoyad + " soyismindeki öğretmenler listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        Set<Map.Entry<String, String>> ogretmenEntrySet = Veritabani.ogretmenlerMap.entrySet();
        System.out.println(
                "\n ============SOYİSİM İLE ÖĞRETMEN ARAMA ============\n" +
                        "TcNo : Isim , Soyisim , Doğum Yılı, Branş ");

        for (Map.Entry<String, String> each : ogretmenEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuarr = eachValue.split(", ");
            if (istenenSoyad.equalsIgnoreCase(eachValuarr[1])) {
                System.out.println(eachKey + " : " + eachValue + " | ");
            }
        }

    }

    ///////////////////////////////////////////////////////////////

    // TODO ogretmenListesiYazdir() methodunu doldurunuz
    public static void ogretmenListesiYazdir() throws InterruptedException {

        for (Map.Entry <String, String> ogretmen: Veritabani.ogretmenlerMap.entrySet()){
            System.out.println(ogretmen.getKey() + ": " + ogretmen.getValue());
        }

    }
}
