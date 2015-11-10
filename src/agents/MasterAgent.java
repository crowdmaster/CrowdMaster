package agents;

import java.util.ArrayList;
import java.util.List;

/**
 * Master Agent which manage the rest of Agents
 */
public class MasterAgent implements Agent {
    private final List<Agent> agents = new ArrayList<>();

    public MasterAgent(int Count){
        for (int i=0; i<Count; i++){
            agents.add(new SlaveAgent(i, i));
        }
    }

    public boolean add(Agent agent){
        return agents.add(agent);
    }

    @Override
    public void step() {
        for (Agent agent: agents){
            agent.step();
        }
    }
}
