class cobaAffineCipher {
    // Kunci A dan B
    static int a = 11;
    static int b = 6;
    // membuat penerapan enkripsi nama
    static String encryptMessage(char[] pesan)
    {
        //Pada Teks Cipher awalnya akan kosong
        String cipher = "";
        for (int i = 0; i < pesan.length; i++)
        {
            //Kemudian menerapkan rumus enkripsi ( a x + b ) mod m
            //{ x adalah pesan[i] dan m adalah 26} dan menambahkan 'A' ke
            // dalam rentang alfabet[ 65-90 | A-Z ]
            if (pesan[i] != ' ')
            {
                cipher = cipher
                        + (char) ((((a * (pesan[i] - 'A')) + b) % 26) + 'A');
            } else
            {
                cipher += pesan[i];
            }
        }
        return cipher;
    }
// Kemudian membuat dekripsi nama
    static String decryptCipher(String cipher)
    {
        String nama = "";
        int a_invers = 0;
        int u = 0;
        //Jika a^-1 maka kebalikan perkalian dari a
        for (int i = 0; i < 26; i++)
        {
            u = (a * i) % 26;// memeriksa apakah (a*i)%26 == 1,
            // maka akan meninvers perkalian dari a
            if (u == 1)
            {
                a_invers = i;
            }
        }
        for (int i = 0; i < cipher.length(); i++)
        {
          //Menerapkan rumus dekripsi a^-1 ( x - b ) mod m
            // di sini x adalah sandi[i] dan m adalah 26} dan ditambahkan 'A'
            //untuk membawanya dalam rentang alfabet [ 65-90 | A-Z ]
            if (cipher.charAt(i) != ' ')
            {
                nama = nama + (char) (((a_invers *
                        ((cipher.charAt(i) + 'A' - b)) % 26)) + 'A');
            }
            else
            {
                nama += cipher.charAt(i);
            }
        }
        return nama;
    }
    public static void main(String[] args)
    {

        String Nama = "DIONAJICAHYONO";
        System.out.println("Nama : "+Nama);
        System.out.println("---------------------------------");

        // Akan memanggil fuction  encryption
        String cipherText = encryptMessage(Nama.toCharArray());
        System.out.println("Enkripsi : " + cipherText);

        // Akan memanggil fuction   Decryption
        System.out.println("Dekripsi: " + decryptCipher(cipherText));

    }
}
