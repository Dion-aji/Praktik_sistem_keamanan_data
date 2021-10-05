public class Enkripsi extends playfair{// class Enkripsi akan mengextend ke class playFair

    public static void main(String[] args) {
        playfair playFair= new playfair();
        String x=playFair.enkripsi("dionajicahyono");// Data yang ingin di enkripsi ,berikut adalah nama saya
        System.out.println("Kunci : Madiun ");
        System.out.println("Plain Text : dionajicahyono ");
        System.out.println("----------------------------");
        System.out.println("Enkripsi : "+x);//Enkripsi akan memproses dari data x 
        System.out.println("Dekripsi  : "+playFair.dekripsi(x));
    }
}
