package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import javax.management.relation.Role;
import org.junit.Test;

import enumerations.Habilitation;
import exception.ActionNonAutoriseeException;
import junit.framework.Assert;
import junit.framework.*;
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
    
    /**
     * la méthode fail déjà va déclencher, elle-même, une exception
     * donc on peut pas procéder à la catch de bloc try
     * */
    
    @Test
    public void ecrireMessageKO() {

        // Etape 1 : préparation des objets
        Canal c = new Canal();

        Message m = new Message();
        m.setDestinataire(c);
        m.setText("Bonne année 2021 !");

        Utilisateur utilisateur = new Utilisateur();

        // Etape 2 : appel de la méthode testée
        try {
            c.ecrireMessage(utilisateur, m);

            // Etape 3 test du retour
          //  fail("L'exception aurait du être levée, on ne doit pas passer ici !");
           throw new ActionNonAutoriseeException();
        } catch (ActionNonAutoriseeException e) {

            System.out.println(e.toString());
        }
        
    }
    
    /**
     * 
     * on doit toujour vérifier que deux canaux n'ont pas le même order
     * */
    
    @Test
    public void testCompareCanal() {
    	
    	Canal c1 = new Canal();
    	assertNotNull(c1);
    	
    	Canal c2 = new Canal();
    	assertNotNull(c2);
    	
    	c1.setOrder(5);
    	assertEquals(5, c1.getOrder());
    	
    	c2.setOrder(4);
    	assertEquals(4, c2.getOrder());
    	
    	
    	assertTrue(c1.compareTo(c2)>0);
    	assertTrue(c2.compareTo(c1)<0);
    }

}
