# Nama  : Dion Aji Cahyono
# Nim   : v3920018
# Kelas  : Ti D
#------------------------------------------------------------------------------------
#membuat alphabet dengan huruf kecil dan besar dengan di ikuti nomor key
huruf_kecil = {'A':0, 'a':0, 'B':1, 'b':1, 'C':2, 'c':2, 'D':3, 'd':3,
'E':4, 'e':4, 'F':5, 'f':5, 'G':6, 'g':6, 'H':7, 'h':7, 'I':8, 'i':8,
'J':9, 'j':9, 'K':10, 'k':10, 'L':11, 'l':11, 'M':12, 'm':12, 'N': 13,
'n':13, 'O':14, 'o':14, 'P':15, 'p':15, 'Q':16, 'q':16, 'R':17, 'r':17,
'S':18, 's':18, 'T':19, 't':19, 'U':20, 'u':20, 'V':21, 'v':21, 'W':22,
'w':22, 'X':23, 'x':23, 'Y':24, 'y':24, 'Z':25, 'z':25, '':26 }
def huruf_baru(letter):
    huruf_Besar = {'A':0, 'a':0, 'B':1, 'b':1, 'C':2, 'c':2, 'D':3,
'd':3, 'E':4, 'e':4, 'F':5, 'f':5, 'G':6, 'g':6, 'H':7, 'h':7, 'I':8,
'i':8, 'J':9, 'j':9, 'K':10, 'k':10, 'L':11, 'l':11, 'M':12, 'm':12,
'N': 13, 'n':13, 'O':14, 'o':14, 'P':15, 'p':15, 'Q':16, 'q':16,
'R':17, 'r':17, 'S':18, 's':18, 'T':19, 't':19, 'U':20, 'u':20, 'V':21,
'v':21, 'W':22, 'w':22, 'X':23, 'x':23, 'Y':24, 'y':24, 'Z':25, 'z':25, '':26
}
#membuat variable POS untuk mengambil data dari huruf
    pos = huruf_Besar[letter]
    #kemudian mereturn nilai POS
    return pos
    #membuat Def Putaran huruf ,untuk menentukan putaran kunci
def putaran_huruf(letter, rot):
    menggeser = 97 if letter.islower() else 65 #kemudian menggeser setiap inputan
    return chr((ord(letter) + rot - menggeser) % 26 + menggeser)
#membuat def enkripsi untuk membuat teks menjadi vigenere cipher
def enkripsi(text, key):
    vigenere = []    
    starting_index = 0 #memulai index dari 0
    for letter in text:
    # jika  alfanumerik,maka akan tetap seperti itu
    # kemudian menemukan posisi alfabet
        putaran = huruf_baru(key[starting_index])
    # jika karakter spasi atau non-abjad, tambahkan
        if not letter in huruf_kecil:
            vigenere.append(letter)
        elif letter.isalpha():            
            vigenere.append(putaran_huruf(letter, putaran))             

    #apabila telah mencapai indeks terakhir,maka kan ke reset ke nol, 
    # apbila tidak maka + oleh 1
        if starting_index == (len(key) - 1): 
            starting_index = 0
        else: 
            starting_index += 1

    return ''.join(vigenere) #return join vigenere

text = input("Masukan nama : ")#membuat inputan untuk memasukan teks yang ingin di enkripsi
key = input("Masukan kunci : ")#membuat inputan kunci 

print("Enkripsi : " +enkripsi(text,key))#akan mengambil dari data input masukan nama,kemudian akan di enkripsi
print ("Deskripsi : " +text)#menampilkan dekripsi


