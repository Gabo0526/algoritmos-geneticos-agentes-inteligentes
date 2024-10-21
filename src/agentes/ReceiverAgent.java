package agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import org.jgap.IChromosome;
import utilidades.ShowChromosome;

import java.util.LinkedList;

public class ReceiverAgent extends Agent {
    private LinkedList<Object> messages = new LinkedList<>();

    @Override
    protected void setup() {
        System.out.println("Agente " + getLocalName() + " montado.");

        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage msg = blockingReceive();
                messages.addLast(msg);

                try {
                    double[] variables = ShowChromosome.getChromosomeContent((IChromosome) msg.getContentObject());
                    System.out.printf("Solucion del agente %s:\nx = %f\ny = %f\nFitness igual a: %f\n", msg.getSender().getLocalName(), variables[0], variables[1], ((IChromosome) msg.getContentObject()).getFitnessValue());
                } catch (UnreadableException e) {
                    throw new RuntimeException(e);
                }

                if (messages.size() == 3) {
                    messages.clear();
                }
            }
        });
    }
}
