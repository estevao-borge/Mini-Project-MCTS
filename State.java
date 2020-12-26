public class State {
	
	private Ilayout layout;
	private State father;
	private int g;		//height of tree
	private int h;		//heuristic value = number of blocks int the right position
	private int f = fValue();
	private int fValue(){return g + h;}
	
	public State(Ilayout l, State n, int hValue) {
		layout = l; 
		father = n;
		if (father != null)
			g = (int) (father.g + l.getG()); 
		else 
			g = 0;
		
		h = hValue;
		f = fValue();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if(!this.layout.equals(other.layout))
			return false;
		return true;
	}
	
	public String toString() { return layout.toString();} 
	public int getG() { return g; }
	public void setH(int x) { this.h = x; }
	public int getH() { return h; }
	public int getF() { return f; }
	public Ilayout getLayout() { return layout; }
	public State getFather() { return father; }
	
	
	public int compareG(State other) {
		return this.h - other.h;
	}
}
