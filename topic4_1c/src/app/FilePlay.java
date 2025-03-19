package app;

import java.io.*;

public class FilePlay {

    /**
     * Copies content from the input file to the output file using BufferedReader and BufferedWriter.
     * It reads each line, splits the data using a pipe delimiter '|', and formats it before writing.
     *
     * @param inputFile  The source file to read from.
     * @param outputFile The destination file to write to.
     * @return 0 if successful, -1 if file not found, -2 for an I/O error.
     */
    private static int copyFile(String inputFile, String outputFile) {
        BufferedReader in = null;
        BufferedWriter out = null;

        try {
            // Create BufferedReader for efficient reading
            in = new BufferedReader(new FileReader(inputFile));

            // Create BufferedWriter for writing
            out = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = in.readLine()) != null) { // Read line by line
                String[] tokens = line.split("\\|"); // Split using pipe delimiter

                // Ensure the correct number of tokens to avoid errors
                if (tokens.length == 3) {
                    out.write(String.format("Name is %s %s of age %s\n", tokens[0], tokens[1], tokens[2]));
                }
            }

            return 0; // Successfully copied and formatted

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