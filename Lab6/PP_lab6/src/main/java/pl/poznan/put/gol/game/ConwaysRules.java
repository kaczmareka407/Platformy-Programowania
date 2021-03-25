package pl.poznan.put.gol.game;

public class ConwaysRules implements Rules {

	@Override
	public boolean inNextGeneration(boolean alive, int numberOfNeighbors) {
		// TODO implement method ConwaysRules#inNextGeneration()
		if (!alive && numberOfNeighbors==3)
                {
                    return true;
                }
                else if (alive && (numberOfNeighbors==2||numberOfNeighbors==3))
                {
                    return true;
                }
                else return false;
                

//throw new UnsupportedOperationException("Not implemented yet.");
	}

}
