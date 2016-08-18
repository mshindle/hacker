package com.coffeegem.hacker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Scanner {
    private BufferedReader br;

    public Scanner(InputStream in) {
        br = new BufferedReader(new InputStreamReader(in));
    }

    public String nextLine() {
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException ioe) {
            System.err.println(ioe.getLocalizedMessage());
        }
        return line;
    }

    public void close() {
        try {
            br.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getLocalizedMessage());
        }
    }
}
