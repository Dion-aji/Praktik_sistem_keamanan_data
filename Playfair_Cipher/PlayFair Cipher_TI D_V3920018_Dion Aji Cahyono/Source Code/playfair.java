import java.awt.*;
// Awal mula membuat class play fair
public class playfair {
    private String kunci="madiun";//menambahkan kunci yang akan di gunakan
    private char[] kunci_arraay=kunci.toUpperCase().toCharArray();//membuat karakter kunci array
     // kunci akan di rubah ke huruf kapital
    private char[] huruf={'A','B','C','D','E','F','G','H','I'
                          ,'K','L','M','N','O','P','Q','R','S'
                          ,'T','U','V','W','X','Y','Z'};//membuat karakter huruf dari A- Z
    char[][] matrix = new char[5][5];
    StringBuffer buffer = new StringBuffer();
    public playfair(){
        int j=0,k=0;
        for (int i=0;i<kunci_arraay.length;i++){//membuat integer i dengan dimulai dari 0
            // jika nilai i lebih kecil dari kunci array maka
            if(k!=5){
                if(!cek(kunci_arraay[i])){
                    matrix[j][k++]=kunci_arraay[i];
                }
            }else {
                i--;
                k=0;j++;
            }
        }
        for (int i=0;i<huruf.length;i++){
            if(k!=5){
                if(!cek(huruf[i])){
                    matrix[j][k++]=huruf[i];
                }
            }else {
                i--;
                k=0;j++;
            }
        }
    }
    // fungsi untuk memeriksa karakter duplikat
    private boolean cek(char a){
        for (int i=0;i<5;i++) {
            for (int j = 0; j < 5; j++) {
                if(matrix[i][j]==a){
                    return true;
                }
            }
        }
        return false;
    }
    //Berfungsi Untuk mengenkripsi
    public String enkripsi(String msg){
        msg=msg.toUpperCase();
        msg=msg.replaceAll("J","I");//mengganti huruf J ke i,yang berhubung j tidak digunakan
        if(msg.length()%2!=0){
            msg=msg.concat("X");
        }
        char[] msgs=msg.toCharArray();
        for (int i=0;i<msgs.length;i++){
            Point x1=find(msgs[i++]);
            Point x2=find(msgs[i]);

            if(x1.x==x2.x){
//same row
                if(x1.y+1==5){
                    x1.y=0;
                }
                else {
                    x1.y++;
                }
                if(x2.y+1==5){
                    x2.y=0;
                }else {
                    x2.y++;
                }
                buffer.append(matrix[x1.x][x1.y]);
                buffer.append(matrix[x2.x][x2.y]);
            }else if(x1.y==x2.y){
//same column
                if(x1.x+1==5){
                    x1.x=0;
                }
                else {
                    x1.x++;
                }
                if(x2.x+1==5){
                    x2.x=0;
                }else {
                    x2.x++;
                }
                buffer.append(matrix[x1.x][x1.y]);
                buffer.append(matrix[x2.x][x2.y]);
            }else{
                //diagonal
                if(x2.x>x1.x) {
                    int d=x2.x-x1.x;
                    x2.x=x2.x-d;
                    x1.x=x1.x+d;
                }else{
                    int d=x1.x-x2.x;
                    x2.x=x2.x+d;
                    x1.x=x1.x-d;
                }
                buffer.append(matrix[x2.x][x2.y]);
                buffer.append(matrix[x1.x][x1.y]);
            }
        }
        return buffer.toString();
    }
    // berfungsi untuk mendekripsi
    public String dekripsi(String msg){
        buffer.delete(0,buffer.length());
        msg=msg.toUpperCase();
        char[] msgs=msg.toCharArray();
        for (int i=0;i<msgs.length;i++){
            Point x1=find(msgs[i++]);
            Point x2=find(msgs[i]);

            if(x1.x==x2.x){   //same row
                if(x1.y-1<0){
                    x1.y=4;
                }
                else {
                    x1.y--;
                }
                if(x2.y-1<0){
                    x2.y=4;
                }else {
                    x2.y--;
                }
                buffer.append(matrix[x1.x][x1.y]);
                buffer.append(matrix[x2.x][x2.y]);
            }else if(x1.y==x2.y){   //same column

                if(x1.x-1<0){
                    x1.x=4;
                }
                else {
                    x1.x--;
                }
                if(x2.x-1<0){
                    x2.x=4;
                }else {
                    x2.x--;
                }
                buffer.append(matrix[x1.x][x1.y]);
                buffer.append(matrix[x2.x][x2.y]);
            }else{  //diagonal
                if(x2.x>x1.x) {
                    int d=x2.x-x1.x;
                    x2.x=x2.x-d;
                    x1.x=x1.x+d;
                }else{
                    int d=x1.x-x2.x;
                    x2.x=x2.x+d;
                    x1.x=x1.x-d;
                }
                buffer.append(matrix[x2.x][x2.y]);
                buffer.append(matrix[x1.x][x1.y]);
            }
        }
        return buffer.toString();
    }
    // function  to return positon of character in matrix
    private Point find(char c){
        Point a=null;
        for (int i=0;i<5;i++) {
            for (int j = 0; j < 5; j++) {
                if(matrix[i][j]==c){
                    a=new Point(i,j);
                    return a;
                }
            }
        }
        return a;
    }
}