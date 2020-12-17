package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import javax.management.relation.Role;
import org.junit.Test;

import enumerations.Habilitation;
import exception.ActionNonAutoriseeException;
import junit.framework.Assert;
import models.*;

public class CanalTest {
	
/**
 * Teser pour v�rifer l'�criture d'un message
 * chaque M�thode de test est commenc�e par "test"
 **/
    @Test
    public void testEcrireMessageOK() throws ActionNonAutoriseeException {
        // Etape 1 : pr�paration des objets
        Canal c = new Canal();

        Message m = new Message();
        m.setDestinataire(c);
        m.setText("Bonne f�tes de fin d'ann�e !");

        Utilisateur utilisateur = new Utilisateur();
        
        c.getMapping_role_utilisateurs().put(new models.Role("Membre"), Arrays.asList(utilisateur));
        c.getMapping_role_habilitation().put(new models.Role("Membre"), Arrays.asList(Habilitation.ECRITURE));

        // Etape 2 : appel de la m�thode test�e
        c.ecrireMessage(utilisateur, m);

        // Etape 3 test du retour
        List<Message> historiques = c.getHistoriques();
        assertEquals(1.0, historiques.size(), 0.0);
        System.out.println(historiques.get(0).getText());
    }

}
