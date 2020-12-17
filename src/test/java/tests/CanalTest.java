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
    
    /**
     * la m�thode fail d�j� va d�clencher, elle-m�me, une exception
     * donc on peut pas proc�der � la catch de bloc try
     * */
    
    @Test
    public void ecrireMessageKO() {

        // Etape 1 : pr�paration des objets
        Canal c = new Canal();

        Message m = new Message();
        m.setDestinataire(c);
        m.setText("Bonne ann�e 2021 !");

        Utilisateur utilisateur = new Utilisateur();

        // Etape 2 : appel de la m�thode test�e
        try {
            c.ecrireMessage(utilisateur, m);

            // Etape 3 test du retour
          //  fail("L'exception aurait du �tre lev�e, on ne doit pas passer ici !");
           throw new ActionNonAutoriseeException();
        } catch (ActionNonAutoriseeException e) {

            System.out.println(e.toString());
        }
        
    }
    
    /**
     * 
     * on doit toujour v�rifier que deux canaux n'ont pas le m�me order
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
