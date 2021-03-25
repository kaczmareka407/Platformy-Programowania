package pl.poznan.put.gol.game;

public class ConwaysCell implements Cell {

	protected int i;
	protected int j;

	public ConwaysCell(int i, int j) {
		this.i = i;
		this.j = j;
	}

	@Override
	public Cells neighbors() {
		// TODO implement method ConwaysCell#neighbors()
                
                Cells cells = new Cells();
                
                for (int x=i-1; x<=i+1; x++)
                {
                    for (int y=j-1; y<=j+1; y++)
                    {
                        
                        if(!cells.isEmpty()&&x!=i&&y!=j)
                        {
                            ConwaysCell cell = new ConwaysCell(x, y);
                            cells.add(cell);
                        }
                    }
                }
                return cells;
		//throw new UnsupportedOperationException("Not implemented yet.");
        }

	@Override
	public String toString() {
		return "c(" + i + ":" + j + ")";
	}

}
