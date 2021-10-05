public class Enkripsi extends playfair{

    public static void main(String[] args) {
        playfair playFair= new playfair();
        String x=playFair.enkripsi("dionajicahyono");
        System.out.println("Kunci : Madiun ");
        System.out.println("Plain Text : dionajicahyono ");
        System.out.println("----------------------------");
        System.out.println("Enkripsi : "+x);
        System.out.println("Dekripsi  : "+playFair.dekripsi(x));
    }
}