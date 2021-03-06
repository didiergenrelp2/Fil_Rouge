package co.simplon.filrouge;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import co.simplon.filrouge.controller.UtilisateurController;
import co.simplon.filrouge.model.Utilisateur;
import co.simplon.filrouge.service.UtilisateurService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=UtilisateurController.class, secure=false)
public class UtilisateurControllerTest {
	
	static Utilisateur user;
	static Utilisateur newUtilisateur;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UtilisateurService utilisateurService;
	
	@Test
	public void getUtilisateurOK() throws Exception {
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId((long) 1);
		utilisateur.setNom("nomTest");
		
		Mockito.when(utilisateurService.getUtilisateur((long) 1)).thenReturn(utilisateur);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/api/utilisateur/1").accept(MediaType.APPLICATION_JSON);
	       
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
       
        System.out.println(result.getResponse());
        String expected = "{id:1, nom:nomTest}";
       
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void getutilisateurKO_ID_inexistant() throws Exception {
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId((long) 999);
		
		Mockito.when(utilisateurService.getUtilisateur((long) 999)).thenReturn(utilisateur);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/api/utilisateur/999").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	       
        System.out.println(result.getResponse());
        String expected = "{}";
        
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		
	}
	
	@Test
	public void getAllUtilisateursOK() throws Exception {
		
		List<Utilisateur> listUtil = new ArrayList<Utilisateur>();
		
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setId((long) 1);
		utilisateur1.setNom("nom1");
		
		Utilisateur utilisateur2 = new Utilisateur();
		utilisateur2.setId((long) 2);
		utilisateur2.setNom("nom2");
		
		listUtil.add(utilisateur1);
		listUtil.add(utilisateur2);
		
		Mockito.when(utilisateurService.getAllUtilisateurs()).thenReturn(listUtil);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/api/utilisateurs/").accept(MediaType.APPLICATION_JSON);		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
        String expected = "[{id: 1, nom:nom1},{id: 2, nom:nom2}]";       
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		
//		@Test
//		public void updateUtilisateurOK() throws Exception {
//			Long id = newUtilisateur.getId();
//			Utilisateur = null;
//			user.setNom("Lulu");
//			user.setPrenom("Berlu");
//			user.setId(id);
//			try {
//				newUtilisateur = utilisateurService.editUtilisateur(user);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			assertTrue(newUtilisateur != null);
//			assertEquals("Lulu", newUtilisateur.getNom());
//			assertEquals("Berlu", newUtilisateur.getPrenom());
//			
//		}
	}
	
}
