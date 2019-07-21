package com.example.h2demo.service.impl;

import com.example.h2demo.service.api.CustomFileReader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Scanner;

@Service
public class CustomFileReaderImpl implements CustomFileReader {

    private static final String fileRoute = "classpath:workorder.txt";

    @Override
    public String read() throws IOException {
        FileInputStream inputStream = null;
        Scanner sc = null;
        StringBuilder builder = new StringBuilder();
        try {
            File file = ResourceUtils.getFile(fileRoute);
            inputStream = new FileInputStream(file);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                builder.append(sc.nextLine());
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
        return builder.toString();
    }
}
