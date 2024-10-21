package contenedor;

import agentes.*;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;

public class Container {
    AgentContainer agentContainer;

    public void configureContainer() throws StaleProxyException {
        Runtime runtime = Runtime.instance();
        runtime.setCloseVM(true);
        Profile profile = new ProfileImpl(null, 1099, null);
        agentContainer = runtime.createMainContainer(profile);
        addAgents();
    }

    public void addAgents() throws StaleProxyException {
        agentContainer.createNewAgent("RAg", ReceiverAgent.class.getName(), null).start();
        agentContainer.createNewAgent("GAg3", GeneticAgent.class.getName(), null).start();
        agentContainer.createNewAgent("GAg2", GeneticAgent.class.getName(), null).start();
        agentContainer.createNewAgent("GAg1", GeneticAgent.class.getName(), null).start();
        agentContainer.createNewAgent("SAg", SenderAgent.class.getName(), null).start();
    }
}
