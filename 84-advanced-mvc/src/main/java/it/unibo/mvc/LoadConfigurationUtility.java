package it.unibo.mvc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public final class LoadConfigurationUtility {

    private static final String DEFAULT_CONFIGURATION_FILE = System.getProperty("user.dir") + "\\src\\main\\resources\\config.yml";

    public static void load(String file) throws FileNotFoundException, IOException {

        for (int i  = 0; i < 2; i++) {
            i++;
        }
        System.out.println(DEFAULT_CONFIGURATION_FILE);
        file = file == null || file.isEmpty() ? DEFAULT_CONFIGURATION_FILE : file;

        final BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));
        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(line, ":");
            stringTokenizer.nextToken();
        }

        br.close();
    }
}
