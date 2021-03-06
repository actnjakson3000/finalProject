/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
 
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

/**
 * This application segments strings into smaller parts
 * @author jermainerogers
 */
public class Tokenizer {
 
    public static void main(String[] args) {
        InputStream modelIn = null;
 
        try {
            //Creates a FileInputStream by opening a connection to an actual file, the file named by the path name in the file system
            modelIn = new FileInputStream("en-token.bin");
            TokenizerModel model = new TokenizerModel(modelIn);
            TokenizerME tokenizer = new TokenizerME(model);
            String tokens[] = tokenizer.tokenize("John is 26 years old.");
            double tokenProbs[] = tokenizer.getTokenProbabilities();
            
            System.out.println("Token\t: Probability\n-------------------------------");
            for(int i=0;i<tokens.length;i++){
                System.out.println(tokens[i]+"\t: "+tokenProbs[i]);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (modelIn != null) {
                try {
                    modelIn.close();
                }
                catch (IOException e) {
                }
            }
        }
    }
    
}
