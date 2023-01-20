package io.meighen.presenter;

import java.io.*;

public class PowerI {

    public static double pow(double num, int n) {
        double res = 1.0;
        for (int i = 0; i < n; i++) {
            res = res * num;
        }

        return res;
    }

//    public String readf(String file) {
//
//    }

    public void rwfunc(String from, String to) {

        FileReader reader = null;
        FileWriter writer = null;
        BufferedReader br = null;

        try {
            reader = new FileReader(from);
            writer = new FileWriter(to);
            br = new BufferedReader(reader);

            String line;
            while ((line = br.readLine()) != null) {
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                br.close();

                writer.close();
                reader.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(pow(2,0));
//        Math.pow();
    }
}
