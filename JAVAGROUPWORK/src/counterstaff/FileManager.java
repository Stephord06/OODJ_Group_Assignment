
package counterstaff;

import java.io.*;
import java.util.*;

public class FileManager {
    
    // Read all lines from the file and returns a list of strings
    public static List<String> readFile(String filename) {
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
            reader.close();
        }
        catch (IOException e) {
            System.out.println("Error reading file: " + filename);
        }
        return lines;
    }
    
    
    // Write all lines into the file (overwrites all exsiting contents)
    public static void writeFile(String filename, List<String> lines) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Error writing file: " + filename);
        }
    }
    
    
    // Append a single line to the file
    public static void appendToFile(String filename, String line) {
        try {
            // Check if file ends with newline
            java.io.File file = new java.io.File(filename);
            boolean needsNewLine = false;
            if(file.length() > 0) {
                java.io.RandomAccessFile raf = new java.io.RandomAccessFile(file, "r");
                raf.seek(file.length() - 1);
                int lastChar = raf.read();
                raf.close();
                needsNewLine = (lastChar != '\n');
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            if (needsNewLine) writer.newLine();
            writer.write(line);
            writer.newLine();
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Error appending to file: " + filename);
        }
    }
    
    
    // Generate next ID (ex: "C" + "customers.txt" => "C001")
    public static String generateNextId(String filename, String prefix) {
        List<String> lines = readFile(filename);
        if (lines.isEmpty()) {
            return prefix + "001";
        }
        String lastLine = lines.get(lines.size() - 1);
        String lastId = lastLine.split("\\|")[0];
        int num = Integer.parseInt(lastId.substring(prefix.length()));
        return String.format("%s%03d", prefix, num + 1);
    }
    
    // Get name from txt by ID
    public static String getNameFromFile(String filename, String id) {
        java.util.List<String> lines = readFile(filename);
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts[0].equals(id)) {
                return parts[1];
            }
        }
        return id; // return ID if not found
    }
    
    // Get price from prices.txt
    public static String getPriceFromFile(String serviceType) {
        java.util.List<String> lines = readFile("setPrices.txt");
        for (String line : lines) {
            if (line.startsWith("#")) {
                continue;
            }
            String[] parts = line.split("=");
            
            if (serviceType.equals("Normal Service") && parts[0].equals("1hour")) {
                double price = Double.parseDouble(parts[1].trim());
                return String.format("%.2f", price);
            }
            
            else if (serviceType.equals("Major Service") && parts[0].equals("3hour")) {
                double price = Double.parseDouble(parts[1].trim());
                return String.format("%.2f", price);
            }
        }
        return "0.00";
    }
}
