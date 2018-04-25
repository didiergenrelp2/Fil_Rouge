package co.simplon.filrouge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import co.simplon.filrouge.controller.ArmeController;
import co.simplon.filrouge.model.Arme;
import co.simplon.filrouge.repository.ArmeRepository;
import co.simplon.filrouge.service.ArmeService;

/**
 * 
 * @author Didier
 *
 */
@Transactional
@Rollback(true)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FilRougeApplication.class)
public class ArmeCrudTest {
	
	static Arme arme;
	static Arme updatedArme;
	static ArmeService armeService;
	static ResponseEntity<?> newArme;
	static ResponseEntity<?> deletedArme;
	
	@Autowired
	private ArmeController armeController;
	
	@Autowired
	private ArmeRepository armeRepository;
	
	@BeforeClass
	public static void initArme() throws Exception{
		armeService = new ArmeService();
		arme = new Arme();
	}
		
    @Test
	public void testUpdateArme() {

		updatedArme = null;
		arme = createMock("Pistolet", "SIG");
		
		try {
			updatedArme = armeRepository.save(arme);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(updatedArme != null);
		assertEquals("SIG", updatedArme.getMarque());
	}
		
	@Test
	public void testAjouterArme() {
		
		try {
			arme = createMock("Test", "Test");
			newArme = armeController.ajouterArme(arme);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(newArme != null);
	}
	
	@Test
	public void testSupprimerArme() {
		try {
			arme = createMock("Test", "Test");
			deletedArme = armeController.ajouterArme(arme);
			deletedArme = armeController.supprimerArme((long) 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(deletedArme.getBody() == null);
	}
	
	private Arme createMock(String type, String marque) {
		Arme mock = new Arme();
		mock.setType(type);
		mock.setMarque(marque);
     	mock.setId(new Long(1));

		return mock;
	}

}
