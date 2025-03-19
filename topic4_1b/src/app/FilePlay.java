package app;

import java.io.*;

public class FilePlay {

    /**
     * Copies content from the input file to the output file using BufferedReader and BufferedWriter.
     *
     * @param inputFile  The source file to read from.
     * @param outputFile The destination file to write to.
     * @return 0 if successful, -1 if file not found, -2 for an I/O error.
     */
    private static int copyFile(String inputFile, String outputFile) {
        BufferedReader in = null;
        BufferedWriter out = null;

        try {
            // Create BufferedReader for efficient reading and BufferedWriter for writing
            in = new BufferedReader(new FileReader(inputFile));
            out = new BufferedWriter(new FileWriter(outputFile));

            int c;
            while ((c = in.read()) != -1) { // Read character-by-character
                out.write(c);
            }

            return 0; // Successfully copied

        } catch (FileNotFoundException e) {
            return -1; // File not found error
        } catch (IOException e) {
            return -2; // I/O error
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException e) {
                return -2; // Ensuring proper closure
            }
        }
    }

    public static void main(String[] args) {
        int err = copyFile("InUsers.txt", "OutFile.txt");

        // Display appropriate messages based on the return value
        switch (err) {
            case 0:
                System.out.println("File copied successfully.");
                break;
            case -1:
                System.out.println("Error: Input file not found.");
                break;
            case -2:
                System.out.println("Error: An I/O error occurred.");
                break;
            default:
                System.out.println("Unknown error.");
        }
    }
}