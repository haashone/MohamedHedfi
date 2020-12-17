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
 * Teser pour vérifer l'écriture d'un message
 * chaque Méthode de test est commencée par "test"
 **/
    @Test
    public void testEcrireMessageOK() throws ActionNonAutoriseeException {
        // Etape 1 : préparation des objets
        Canal c = new Canal();

        Message m = new Message();
        m.setDestinataire(c);
        m.setText("Bonne fêtes de fin d'année !");

        Utilisateur utilisateur = new Utilisateur();
        
        c.getMapping_role_utilisateurs().put(new models.Role("Membre"), Arrays.asList(utilisateur));
        c.getMapping_role_habilitation().put(new models.Role("Membre"), Arrays.asList(Habilitation.ECRITURE));

        // Etape 2 : appel de la méthode testée
        c.ecrireMessage(utilisateur, m);

        // Etape 3 test du retour
        List<Message> historiques = c.getHistoriques();
        assertEquals(1.0, historiques.size(), 0.0);
        System.out.println(historiques.get(0).getText());
    }

}
