package app;

import java.io.*;

public class FilePlay {

    /**
     * Copies content from the input file to the output file using BufferedReader and BufferedWriter.
     * It reads each line, splits the data using a pipe delimiter '|', and formats it before writing.
     *
     * @param inputFile  The source file to read from.
     * @param outputFile The destination file to write to.
     * @throws FileNotFoundException if the input file is not found.
     * @throws IOException if an I/O error occurs during reading or writing.
     */
    private static void copyFile(String inputFile, String outputFile) throws FileNotFoundException, IOException {
        BufferedReader in = null;
        BufferedWriter out = null;

        try {
            in = new BufferedReader(new FileReader(inputFile));
            out = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = in.readLine()) != null) { // Read line by line
                String[] tokens = line.split("\\|"); // Split using pipe delimiter

                // Ensure the correct number of tokens to avoid errors
                if (tokens.length == 3) {
                    out.write(String.format("Name is %s %s of age %s\n", tokens[0], tokens[1], tokens[2]));
                }
            }
        } finally {
            // Ensure both reader and writer are closed properly
            try {
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            copyFile("InUsers.txt", "OutFile.txt");
            System.out.println("File copied successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found.");
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred.");
        }
    }
}