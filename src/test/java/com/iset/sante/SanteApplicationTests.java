package com.iset.sante;

import com.iset.sante.entities.Action;
import com.iset.sante.entities.Evenement;
import com.iset.sante.repositories.ActionRepoitory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SanteApplicationTests {

	@Autowired
	private ActionRepoitory ActionRepoitory;

	@Test
	public void testfindByEvenement() {
		Evenement cat = new Evenement();
		cat.setId(1L);
		List<Action> prods = ActionRepoitory.findByEvenement(cat);;
		for (Action p : prods) {
			System.out.println(p);
		}
	}
}
