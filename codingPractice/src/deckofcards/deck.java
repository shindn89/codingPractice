/**
 * 
 */
package deckofcards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author DN
 *
 */
public class deck {
	private ArrayList<card> cards;
	private ArrayList<card> pullCards;
	
	public deck() {
		pullCards = new ArrayList<>();
		cards = new ArrayList<>(suit.values().length * rank.values().length);
		reset();
	}
	
	public ArrayList<card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<card> cards) {
		this.cards = cards;
	}

	public ArrayList<card> getPullCards() {
		return pullCards;
	}

	public void setPullCards(ArrayList<card> pullCards) {
		this.pullCards = pullCards;
	}

	public void reset() {
		pullCards.clear();
		cards.clear();
		for(suit s: suit.values()) {
			for(rank r : rank.values()) {
				card c = new card(s,r);
				cards.add(c);
			}
		}
	}
	public card pull() {
		if(cards.isEmpty()) return null;
		card out = cards.get(cards.size()-1);
		cards.remove(out);
		pullCards.add(out);
		return out;
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	public void shuffle2() {
		Random rnd = new Random();
		for(int i = cards.size(); i > 1; i--) {
			//swap(cards, i, rnd.nextInt())
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		deck d = new deck();
		d.shuffle();
		deck c = new deck();
		c.shuffle();
		ArrayList<card> adding = new ArrayList<>();
		adding.addAll(d.getCards());
		adding.addAll(c.getCards());
		d.getCards().addAll(c.getCards());
		System.out.println("total size is = "+d.getCards().size());
		for(card z : d.getCards()) {
			System.out.println(z);
		}
		
		
		String b = "b";
		char f = 'k';
		String v = f+b;
		System.out.println(b.charAt(0));
		String[][] db = new String[10][10];
		String.valueOf('c');
		v.charAt(0);
		
		//d.setCards();
		/*deck total = new deck();
		total.setCards(adding);
		System.out.println("total size is = "+total.getCards().size());
		for(card z: total.getCards()) {
			
		}*/
		int k = 0;
		k ^=9;
		System.out.println(k);
		k^=3;
		System.out.println(k);
		k &= -k;
		System.out.println(k);
	}

}
