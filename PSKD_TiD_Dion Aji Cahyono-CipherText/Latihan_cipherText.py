#awal mula membuat Variable untuk menyimpan nilai string/Teks dari input
huruf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" #di sini saya menggunakan huruf Kapital
#huruf = "abcdefghijklmnopqrstuvwxyz" | Huruf Kecil
print ("---------------------------")
namaku = input("Nama : ").upper() #  | berhubung saya menggunakan huruf kapital.
                                       #maka menggunakan Uppercase
#namaku = input("Nama : ").lower()   | Jika ingin menggunakan huruf kecil pada keluarannya.
                                       #maka menggunakan Lowercase

#Setelah itu membuat inputan ,untuk pergeseran berapa yang di inginkan                                       
kunci = int(input("Pergeseran Angka : ")) 
#Semisal  : 
#Urutan normal 123456789
#kemudian memisah angka
#pisahan_pertama - 123 
#pisahan_kedua - 456789
#Sehingga nanti akan membentuk Urutan yang baru- 456789123.
if kunci == 0:#dimulainya penginputan dari 0
    urutan_baru = huruf
    #Jika menginputkan angka 0 maka hasil dari yang di masukan pada nama tidak akan berubah
    #Contoh :
    #Nama : Dion aji
    #pergeseran Angka : 0
    #Output : DION AJI
#Pada elif ini akan di jalankan jika memsaukan angka yang lebih dari 0
elif kunci > 0:
    pisahan_pertama = huruf[:kunci]
    pisahan_kedua = huruf[kunci:]
    urutan_baru = pisahan_kedua + pisahan_pertama
    #apabila menginputkan angka 7 ,berhubung saya mendapatkan nomor Kunci 7 maka, 
    # pisahan_pertama akan di tambah dengan pisahan_kedua dan akan membuat hasil urut yang baru
    # ketika program di jalankan. maka nama akan Terenkripsi 
else:
    pisahan_pertama = huruf[:(26 + kunci)]
    pisahan_kedua = huruf[(26 + kunci):]
    urutan_baru = pisahan_kedua + pisahan_pertama
enkripsi=" "
#Fungsi len() berfungsi untuk mengembalikan panjang (jumlah ) dari objek.
for masukan in range(0,len(namaku)):
    if namaku[masukan] == " ":
        enkripsi += " "
    for masukan_huruf in range(0,len(urutan_baru)):
        if namaku[masukan] == huruf[masukan_huruf]:
            enkripsi+= urutan_baru[masukan_huruf]
# Kemudian membuat output untuk hasil dari Pergeseran angka
print ("---------------------------")
print ("Enkripsi :"+enkripsi)
print ("Dekripsi : "+namaku)
print ("---------------------------")