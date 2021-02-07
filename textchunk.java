package lol;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.chunker.ChunkerME;

public class textchunk {
	public static void main(String args[]) throws IOException {
		
		//Perform chunking on the training dataset
		InputStream modelIn = null;
		ChunkerModel model = null;
		modelIn = new FileInputStream("C:/Users/abhis/eclipse-workspace/opennlp/opennlp_models/en-chunker.bin");
		model = new ChunkerModel(modelIn);
		ChunkerME chunker = new ChunkerME(model);
		
		String tokens[] = new String[] { "Rockwell", "International", "Corp.", "'s",
			    "Tulsa", "unit", "said", "it", "signed", "a", "tentative", "agreement",
			    "extending", "its", "contract", "with", "Boeing", "Co.", "to",
			    "provide", "structural", "parts", "for", "Boeing", "'s", "747",
			    "jetliners", "." };
		
		InputStream posModelIn = new FileInputStream("C:/Users/abhis/eclipse-workspace/opennlp/opennlp_models/en-pos-maxent.bin");
        POSModel posModel = new POSModel(posModelIn);
        POSTaggerME posTagger = new POSTaggerME(posModel);
        String tags[] = posTagger.tag(tokens);
		String tag[] = chunker.chunk(tokens, tags);
		
		//Isolate Noun Phrase and Verb Phrase
		String test = tag[0];
		System.out.print(test);
			for(int i = 0; i < tag.length;i++) {
				if(tag[i] == test) {
					System.out.println(tokens[i] +" "+ tag[i]);
				}
			}
		}
	}
