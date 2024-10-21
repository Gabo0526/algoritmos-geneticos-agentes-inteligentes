package agentes;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import utilidades.Message;
import utilidades.funciones.Func1;
import utilidades.funciones.Func2;
import utilidades.funciones.Func3;

import java.util.UUID;

public class SenderAgent extends Agent {
    private final Func1 func1 = new Func1();
    private final Func2 func2 = new Func2();
    private final Func3 func3 = new Func3();
    private boolean done = false;

    @Override
    protected void setup() {
        System.out.println("Agente " + getLocalName() + " montado.");

        addBehaviour(new SimpleBehaviour() {
            @Override
            public void action() {
                Message.sendMessage(ACLMessage.INFORM, "GAg1", getAgent(), UUID.randomUUID().toString(), null, func1);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.err.println("El sueño fue interrumpido");
                }

                Message.sendMessage(ACLMessage.INFORM, "GAg2", getAgent(), UUID.randomUUID().toString(), null, func2);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.err.println("El sueño fue interrumpido");
                }

                Message.sendMessage(ACLMessage.INFORM, "GAg3", getAgent(), UUID.randomUUID().toString(), null, func3);
                done = true;
            }

            @Override
            public boolean done() {
                return done;
            }
        });
    }
}
