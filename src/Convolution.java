import java.util.Scanner;

public class Convolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cont = 0;
        String[] str = new String[10];
        String[][] n = new String[4][3];
        boolean flag = false;
        for(int i = 0; i < 10; i++){
            str[i] = scanner.nextLine();
            cont++;
            if(str[i].equals("end")){
                str[i] = "";
                break;
            }
        }
        cont = cont -1;
        String str2 = str[0].replace(" ", "") ;

        String str4 = "";

        for (int i = 0; i < cont; i++){
            str4 += str[i] + " ";
        }
        String[] str3 = str[0].split(" ");
        int n2 = str3.length;
        int[][] n3 = new int[cont][n2];
        Scanner sc = new Scanner(str4);

        for (int i = 0; i < cont; i++){
            for (int j = 0; j < n2; j++){
                n3[i][j] = sc.nextInt();
            }
        }
        int[][] n4 = new int[cont][n2];
        //System.out.println(cont);
        if (cont>n2 && n2 == 1){
            for (int i = 0; i < cont; i++) {
                for (int j = 0; j < n2; j++) {
                    //System.out.println(i + " " + j);
                    if(i == 0 && j == 0) {
                        n4[i][j] = (n3[cont-1][j] + n3[i][j]) + (n3[i+1][j] + n3[i][j]);
                    }else if (j-1 < 0 && i+1 > cont-1){
                        n4[i][j] = (n3[i][j]+n3[i][j])+(n3[i-(cont-1)][j]+n3[i-1][j]);
                    }else{
                        n4[i][j] = (n3[i][j]+n3[i][j])+(n3[i-1][j]+n3[i+1][j]);
                    }
                }
            }
        }else if (n2 > cont && cont == 1){
            for (int i = 0; i < cont; i++) {
                for (int j = 0; j < n2; j++) {
                    //System.out.println(i + " " + j);
                    if(i == 0 && j == 0) {
                        n4[i][j] = (n3[i][n2-1] + n3[i][j+1]) + (n3[i][j] + n3[i][j]);
                    }else if (j+1 > n2-1){
                        n4[i][j] = (n3[i][j]+n3[i][j])+(n3[i][j-1]+n3[i][j-(n2-1)]);
                    }else{
                        n4[i][j] = (n3[i][j]+n3[i][j])+(n3[i][j-1]+n3[i][j+1]);
                    }
                }
            }
        }else if (cont == 1 && n2 == 1){
            n4[0][0] = (n3[0][0]+n3[0][0])+(n3[0][0]+n3[0][0]);
        } else{
            for (int i = 0; i < cont; i++){
                for (int j = 0; j < n2; j++){
                    if(i == 0 && j == 0){
                        n4[i][j] = (n3[cont-1][j]+n3[i][n2-1])+(n3[i][j+1]+n3[i+1][j]);
                    }else if (j+1>n2-1 && i-1 < 0){
                        n4[i][j] = (n3[cont-1][j]+n3[i][j-(n2-1)])+(n3[i+1][j]+n3[i][j-1]);
                    }else if (j-1 < 0 && i+1 > cont-1){
                        n4[i][j] = (n3[i][n2-1]+n3[i-1][j])+(n3[i-(cont-1)][j]+n3[i][j+1]);
                    }else if (i+1 > cont-1 && j+1 > n2-1){
                        n4[i][j] = (n3[i][j-1]+n3[i-1][j])+(n3[i][j-(n2-1)]+n3[i-(cont-1)][j]);
                    }else if (j+1 > n2-1){
                        n4[i][j] = (n3[i][j-(n2-1)]+n3[i+1][j])+(n3[i-1][j]+ n3[i][j-1]);
                    }else if (i-1 < 0){
                        n4[i][j] =  (n3[i][j-1]+n3[cont-1][j])+(n3[i][j+1]+n3[i+1][j]);
                    }else if (i+1 > cont-1){
                        n4[i][j] = (n3[i][j-1]+n3[i-1][j])+(n3[i-(cont-1)][j]+n3[i][j+1]);
                    }else if (j-1 < 0){
                        n4[i][j] = (n3[i][n2-1]+n3[i-1][j])+(n3[i+1][j]+n3[i][j+1]);
                    }else{
                        n4[i][j] = (n3[i-1][j]+n3[i][j-1])+(n3[i+1][j]+n3[i][j+1]);
                    }

                }
            }
        }


        for (int i = 0; i < cont; i++){
            for (int j = 0; j < n2; j++){
                System.out.print(n4[i][j] + " ");
            }
            System.out.println();
        }
    }
}
