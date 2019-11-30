
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author balugoma_sd2023
 */
public class Handle {

    private String file = "account.txt";
    FileWriter write = null;
    FileReader read = null;

    public Handle() throws IOException {

    }

    public FileWriter getWrite() {

        return write;

    }

    public void setWrite(FileWriter write) {
        this.write = write;
    }

    public FileReader getRead() {
        return read;
    }

    public void setRead(FileReader read) {
        this.read = read;
    }

    public void register(ArrayList<String> information) throws IOException {
        write = new FileWriter(file, true);
        try {
            write.write(information.get(0) + "\t" + information.get(1) + "\t" + information.get(2) + "\t" + information.get(3) + "\t" + information.get(4));
            write.write("\r\n");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } finally {
            write.close();
        }
    }

    public void add(ArrayList<String[]> information) throws IOException {
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
        write = new FileWriter(file, true);
        try {
            for (String[] info : information) {
                write.write(info[0] + "\t" + info[1] + "\t" + info[2] + "\t" + info[3] + "\t" + info[4]);
                write.write("\r\n");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } finally {
            write.close();
        }
    }

    public ArrayList<String[]> retrieve() throws FileNotFoundException, IOException {

        String line;
        ArrayList<String[]> tempList = new ArrayList();
        try {

            BufferedReader bufferreader = new BufferedReader(new FileReader(file));

            while ((line = bufferreader.readLine()) != null) {

                String[] temp = line.split("\t");

                tempList.add(temp);

            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return tempList;
    }
}
