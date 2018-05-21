/**
 * 
 */
package q22
;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;



/**
 * @author DN
 *
 */
public class Tries {
	
    private Node root = new Node();

    //add words
    public void addWord(String word) { root.addWord(word); }

    //get words
    public List<String> getWords(String start) {
        List<String> words = root.getWords(start);
        Collections.sort(words);
        return words;
    }
    
    public class Node {

        private char key;
        private boolean check;
        private HashMap<Character, Node> children = new HashMap<>();


        public Node() { this.key = '/'; }
        public Node(char key) { this.key = key; }
        
        List<String> getWords(String prefix) {
            List<String> words = new ArrayList<>();
            Node node = findNode(prefix);
            if (node!=null) {
                if (node.check) {
                	words.add(prefix);
                }
                node.getWordsHelper(prefix, words);
            }
            return words;
        }
        private void getWordsHelper(String prefix, List<String> words) {
            for (Node n : children.values()) {
                String nodestring = prefix + n.key;
                if (n.check) words.add(nodestring);
                if (n.children.size()>0) n.getWordsHelper(nodestring, words);
            }
        }
        private Node findNode(String s) {
            Node n = this;
            int nchars = s.length();
            for (int i=0; i < nchars; i++) {
                char c = s.charAt(i);
                n = n.children.get(c);
                if (n==null) break;
            }
            return n;
        }
        
        
        public void addWord(String s) {
            Node n = this;
            for (int i=0; i < s.length(); i++) {
                char c = s.charAt(i);
                n = n.addChildNode(c);
                if (i==s.length()-1){
                	n.check = true;
                }
            }
        }
        
        public Node addChildNode(char c) {
            Node node = this.children.get(c);
            if (node==null) {
                node = new Node(c);
                this.children.put(c, node);
            }
            return node;
        }
        
        
    }

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		boolean nextIsSearchString = false;
		Tries root = new Tries();
		while ((line = in.readLine()) != null) {
		      if(line.isEmpty() || line.equals("\n")) {
		          nextIsSearchString = true;
		          line = in.readLine();
		      }
		      if(nextIsSearchString) {
		          List<String> words = root.getWords(line);
		          if(words == null || words.isEmpty())
		        	  System.out.println("NO");
		          else {
		        	  for(int i = 0;i< words.size() && i < 3 ; i++)
		        	  {
		        		  System.out.println(words.get(i));
		        	  }
		          }
		      } else {
		          root.addWord(line);
		      }
	}

	}

}


