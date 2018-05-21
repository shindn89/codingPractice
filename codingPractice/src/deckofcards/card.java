package deckofcards;

public class card {
	private suit msuit;
	private rank mrank;
	
	public card(suit s, rank r) {
		this.msuit = s;
		this.mrank = r;
	}

	public suit getMsuit() {
		return msuit;
	}

	public void setMsuit(suit msuit) {
		this.msuit = msuit;
	}

	public rank getMrank() {
		return mrank;
	}

	public void setMrank(rank mrank) {
		this.mrank = mrank;
	}
	
	@Override
	public String toString() {
		return "suit is "+msuit + " rank is " +mrank;
	}
}
