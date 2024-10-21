package agentes;

import algoritmogenetico.GeneticAlgorithmFF;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import org.jgap.Configuration;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.impl.DefaultConfiguration;
import utilidades.Message;
import utilidades.funciones.MathFunction;

import java.util.UUID;

public class GeneticAgent extends Agent {
    private Genotype population;
    private final int populationSize = 5;   // Tamaño de población inicial
    private int generation = 0;
    private MathFunction mathFunction;
    private ACLMessage message = null;

    protected void setup() {
        System.out.println("Agente " + getLocalName() + " montado.");

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                if (message == null) {
                    message = blockingReceive();

                    try {
                        mathFunction = (MathFunction) message.getContentObject();
                        System.out.println("Se ha recibido la función matemática: " + Message.getFunction(message));

                    } catch (UnreadableException e) {
                        e.printStackTrace();
                    }

                    try {
                        Configuration conf = new DefaultConfiguration();
                        conf.setFitnessFunction(new GeneticAlgorithmFF(mathFunction));
                        population = GeneticAlgorithmFF.initializeGeneticAlgorithm(conf, populationSize);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                // Evoluciona la población en bloques de 10 generaciones
                System.out.println("Evolucionando bloque de generacion: " + generation);
                GeneticAlgorithmFF.evolveWithParameters(population, 10);
                generation += 10;

                // Criterio de parada, por ejemplo, 100 generaciones
                if (generation >= 1000) {
                    message = null;
                    IChromosome bestSolution = population.getFittestChromosome();

                    Message.sendMessage(ACLMessage.INFORM, "RAg", getAgent(), UUID.randomUUID().toString(), null, bestSolution);
                }
            }
        });
    }
}
