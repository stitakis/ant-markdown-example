package org.sti.markdown;

import org.markdown4j.Markdown4jProcessor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by stitakis on 10.12.15.
 */
public class Markdown4JExample {

    public static void main(String[] args) throws IOException {

        String input = "example.md";
        String output = "example-markdown4j.html";

        System.out.println("Input: " + input);
        System.out.println("Output: " + output);

        String userDir = System.getProperties().getProperty("user.dir");
        File in = new File(userDir + File.separatorChar + input);
        File out = new File(userDir + File.separatorChar + output);

        // Create processor
        Markdown4jProcessor processor = new Markdown4jProcessor();

        // Add stylesheet to html head
        String head = "<!DOCTYPE HTML><HEAD><link rel=\"stylesheet\" href=\"github.css\"></HEAD>";

        // Parse markdown
        String genHtml = processor.process(in);

        // head + html content
        String html = head + "<body>" + genHtml + "</body>";

        // writing html to a file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(out))) {
            bw.write(html);
            bw.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }

        System.out.println("Done!");
    }

}
