//package q2;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//
///** ------------------------------------------------------------
// * Node
// * A Node represents one character and its children.
// * The character can be the end of a word or not. 
// * ------------------------------------------------------------
// */
//class Node {
//
//    private char key;
//    private boolean endofword;
//    private Nodes children = new Nodes();
//
//
//    public Node() { this.key = '/'; }
//    public Node(char key) { this.key = key; }
//
//
//    // Add a child node containing the given character
//    Node addChildNode(char c) {
//        Node node = getChildNode(c);
//        if (node==null) {
//            node = new Node(c);
//            children.addNode(c, node);
//        }
//        return node;
//    }
//
//    // Add a word starting at this node by iterating through child nodes
//    void addWord(String s) {
//        Node n = this;
//        int nchars = s.length();
//        for (int i=0; i < nchars; i++) {
//            char c = s.charAt(i);
//            n = n.addChildNode(c);
//            if (i==nchars-1) n.endofword = true;
//        }
//    }
//
//    // Get the child node associated with the given character.
//    // Map returns null if not found, so we'll follow that convention.
//    Node getChildNode(char c) {
//        return children.get(c);
//    }
//
//    // Find node by following characters in string.
//    // If passed empty string, will return this node.
//    Node findNode(String s) {
//        Node n = this;
//        int nchars = s.length();
//        for (int i=0; i < nchars; i++) {
//            char c = s.charAt(i);
//            n = n.getChildNode(c);
//            if (n==null) break;
//        }
//        return n;
//    }
//
//    // Get all words starting with the given prefix.
//    // Find the node corresponding to the prefix, then gather up all the child words.
//    List<String> getWords(String prefix) {
//        List<String> words = new ArrayList<>();
//        Node node = findNode(prefix);
//        if (node!=null) {
//            if (node.endofword) words.add(prefix);
//            node.getWordsRecurse(prefix, words);
//        }
//        return words;
//    }
//
//    // Get all words including and below this node, prefixed with given string,
//    // and add them to the given list.
//    private void getWordsRecurse(String prefix, List<String> words) {
//        for (Node n : children.values()) {
//            String nodestring = prefix + n.key;
//            if (n.endofword) words.add(nodestring);
//            if (n.children.size()>0) n.getWordsRecurse(nodestring, words);
//        }
//    }
//
//        
//    public String toString() { return Character.toString(key); }
//
//}
//
//
//
///** -------------------------------------------------------------
// * Nodes
// * Hashmap from char to Node
// * -------------------------------------------------------------
// */
//@SuppressWarnings("serial")
//class Nodes extends HashMap<Character, Node> {
//    Node addNode(Character k, Node v) { return put(k,v); }
//}
//
//
//
///** -------------------------------------------------------------
// * Trie
// * Add words, get words starting with a certain prefix. 
// * -------------------------------------------------------------
// */
//public class Trie {
//
//    // A trie always has a root node
//    private Node root = new Node();
//
//    
//    // Add a word to the trie
//    public void addWord(String word) { root.addWord(word); }
//
//    // Get a sorted list of words starting with the given prefix string
//    public List<String> getWords(String startingWith) {
//        List<String> words = root.getWords(startingWith);
//        Collections.sort(words); // in place sort
//        return words;
//    }
//
//    // Represent trie as an array, eg "[red, root, beer]". Includes all words, sorted.
//    public String toString() {
//        List<String> words = root.getWords("");
//        return words.toString();
//    }
//
//
//
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//		BufferedReader in = new BufferedReader(reader);
//		String line;
//		boolean nextIsSearchString = false;
//		Trie root = new Trie();
//		while ((line = in.readLine()) != null) {
//		      if(line.isEmpty() || line.equals("\n")) {
//		          nextIsSearchString = true;
//		          line = in.readLine();
//		      }
//		      if(nextIsSearchString) {
//		          List<String> words = root.getWords(line);
//		          if(words == null)
//		        	  System.out.println("NO");
//		          else {
//		        	  for(int i = 0; i < 3; i++)
//		        	  {
//		        		  System.out.println(words.get(i));
//		        	  }
//		          }
//		      } else {
//		          root.addWord(line);
//		      }
//	}
//	}
//}
//
