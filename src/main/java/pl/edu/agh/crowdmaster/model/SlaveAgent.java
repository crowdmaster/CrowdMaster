package pl.edu.agh.crowdmaster.model;


/**
 * Slave Agent
 */
public class SlaveAgent implements Agent{
    private int posx;
    private int posy;

    public SlaveAgent(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
    }

    @Override
    public void step() {
        // for example
        posx++;
        posy++;
    }
}
