package com.uv.other;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        ReadFile r = new ReadFile();
        r.myRead();
    }

    public void myRead() throws IOException {
        FileInputStream fstream = new FileInputStream("d:\\111.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        int currentLine = 0;
        String txnType = "";
        String xmlStr = "";
        while ((strLine = br.readLine()) != null) {
            currentLine++;
            if(currentLine == 1)
            {
                txnType = strLine;
            }
            else
            {
                xmlStr += strLine + "\n";
            }
        }

//        System.out.println("txnType is : " + txnType);
//        System.out.println("xmlStr is : " + xmlStr);
        String result = txnType + "#####" + xmlStr;
        yourStr(result);
        fstream.close();
    }

    public void yourStr(String source) {
        System.out.println(source);
    }
}
