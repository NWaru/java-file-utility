package fileutility;

import java.util.*; 
import java.io.*; 
/**
 *
 * @author nwaru
 */
public class fileUtility {
    
    public static int wordCount(File test) {
        int words = 0; 
        try {
            Scanner in = new Scanner(test);
            while(in.hasNext()) {
                words++; 
                in.next();
            }
        in.close();
        }        
        catch(IOException e) {
            System.out.println(e);
        }
        return(words); 
    }
    
    public static int lineCount(File test) {
        int lines = 0;
        try {
            Scanner in = new Scanner(test);
            while(in.hasNextLine()) {
                lines++;
                in.nextLine();
            }
            in.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }
        return(lines);
    }
    
    public static int count(File test, String word) {
        int occurrences = 0; 
        try {
            Scanner in = new Scanner(test);
            while(in.hasNext()) {
                if(word.toLowerCase().equals(in.next().toLowerCase())) {
                    occurrences++; 
                }
            }
            in.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }
        return(occurrences);
    }
    
    public static void replace(File test, String target, String replacement) {
        String fileState = ""; 
        try {
            Scanner in = new Scanner(test);
            while(in.hasNextLine()) {
                if(in.hasNextLine()) {
                    fileState += (in.nextLine()) + "\n";
                }   
                else {
                    fileState += (in.nextLine());
                }
            }
            fileState = fileState.replace(target, replacement);
            FileWriter fw = new FileWriter(test);
            fw.write(fileState);
            in.close();
            fw.close();
        }     
        catch(IOException e) {
            System.out.println(e);
        }  
    }   
    
    public static void append(File test, String data) {
        String fileState = ""; 
        try {
            Scanner in = new Scanner(test);
            while(in.hasNextLine()) {
                if(in.hasNextLine()) {
                    fileState += (in.nextLine()) + "\n";
                }   
                else {
                    fileState += (in.nextLine()) + " " + data;
                }
            }
            FileWriter fw = new FileWriter(test);
            fw.write(fileState);
            in.close();
            fw.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
    public static void encrypt(File test, int key) {
        String fileState = ""; 
        String workingLine;
        String encrypted ;
        try {
            Scanner in = new Scanner(test);
            while(in.hasNextLine()) {                
                workingLine = in.nextLine();
                encrypted = "";
                
                for(int i = 0; i < workingLine.length(); i++) {
                    int adjust = (int)workingLine.charAt(i); 
                    int newChar = adjust + key; 
                    if((char)adjust != ' ') {
                         encrypted += (char)((newChar)%256); 
                    }
                    else {
                        encrypted += (char)adjust;
                    }
                }                                 
                if(in.hasNextLine()) {
                    fileState += encrypted + "\n";
                }   
                else {
                    fileState += encrypted;
                }              
            }
            FileWriter fw = new FileWriter(test);
            fw.write(fileState);
            in.close();
            fw.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }
        System.out.println(fileState);
    }
    public static void decrypt(File test, int key) {
        String fileState = ""; 
        String workingLine;
        String encrypted ;
        try {
            Scanner in = new Scanner(test);
            while(in.hasNextLine()) {                
                workingLine = in.nextLine();
                encrypted = "";
                
                for(int i = 0; i < workingLine.length(); i++) {
                    int adjust = (int)workingLine.charAt(i); 
                    int originalChar = (adjust - key); 
                    if((originalChar) < 0) {
                        originalChar = 256 - originalChar; 
                }
                    if((char)adjust != ' ') {
                         encrypted += (char)(originalChar); 
                    }
                    else {
                        encrypted += (char)adjust;
                    }
                }                                 
                if(in.hasNextLine()) {
                    fileState += encrypted + "\n";
                }   
                else {
                    fileState += encrypted;
                }              
            }
            FileWriter fw = new FileWriter(test);
            fw.write(fileState);
            in.close();
            fw.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }
        System.out.println(fileState);
    }   
}
