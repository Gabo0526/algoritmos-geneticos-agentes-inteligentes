package utilidades;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import org.jgap.IChromosome;
import utilidades.funciones.MathFunction;

import java.io.Serializable;

public class Message {
    public static void sendMessage(int messageType, String receiver, Agent sender, String conversationId, String stringContent, Serializable objectContent) {
        ACLMessage aclMessage = new ACLMessage(messageType);
        aclMessage.setLanguage(FIPANames.ContentLanguage.FIPA_SL);

        AID aid = new AID();
        aid.setLocalName(receiver);

        aclMessage.addReceiver(aid);
        aclMessage.setSender(sender.getAID());
        aclMessage.setConversationId(conversationId);

        if (objectContent != null) {
            try {
                aclMessage.setContentObject(objectContent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            aclMessage.setContent(stringContent);
        }

        sender.send(aclMessage);
    }

    public static String getFunction(ACLMessage msg) {
        try {
            MathFunction f = (MathFunction) msg.getContentObject();
            return f.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static String getChromosome(ACLMessage msg) {
        try {
            IChromosome c = (IChromosome) msg.getContentObject();
            return c.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static String getPlainText(ACLMessage msg) {
        return msg.getContent();
    }
}
