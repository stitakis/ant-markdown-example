package org.sti.markdown;

import org.markdown4j.Markdown4jProcessor;
import org.pegdown.PegDownProcessor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by stitakis on 10.12.15.
 */
public class PegDownExample {

    public static void main(String[] args) throws IOException {

        String input = "example.md";
        String output = "example-pegdown.html";

        System.out.println("Input: " + input);
        System.out.println("Output: " + output);

        String userDir = System.getProperties().getProperty("user.dir");
        File in = new File(userDir + File.separatorChar + input);
        File out = new File(userDir + File.separatorChar + output);

        String markdown = new String(Files.readAllBytes(Paths.get(in.getAbsolutePath())));

        // Create processor
        PegDownProcessor processor = new PegDownProcessor();

        // Add stylesheet to html head
        String head = "<!DOCTYPE HTML><HEAD><link rel=\"stylesheet\" href=\"github.css\"></HEAD>";

        // Parse markdown
        String genHtml = processor.markdownToHtml(markdown.toCharArray());

        // head + html content
        String html = head + "<body>" + genHtml + "</body>";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(out))) {
            bw.write(html);
            bw.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }

        System.out.println("Done!");
    }

}
