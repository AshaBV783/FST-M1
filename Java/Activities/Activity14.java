package Activity8;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.commons.io.FileUtils;

public class Activity14 {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("src/main/resources/newfile.txt");

            // Create parent directories
            file.getParentFile().mkdirs();

            boolean fStatus = file.createNewFile();
            if (fStatus) {
                System.out.println("File created successfully!");
                FileUtils.writeStringToFile(file, "Some text in a file", Charset.defaultCharset());
            } else {
                System.out.println("File already exists at this path.");
            }

            // Read file
            System.out.println("Data in file: " + FileUtils.readFileToString(file, Charset.defaultCharset()));

            // Create directory
            File destDir = new File("src/main/resources/destDir");
            destDir.mkdirs(); // <-- IMPORTANT

            // Copy file to directory
            FileUtils.copyFileToDirectory(file, destDir);

            // Get file from new directory
            File newFile = FileUtils.getFile(destDir, "newfile.txt");

            // Read data from file
            String newFileData = FileUtils.readFileToString(newFile, Charset.defaultCharset());
            System.out.println("Data in new file: " + newFileData);

        } catch (IOException errMessage) {
            System.out.println(errMessage);
        }
    }
}
