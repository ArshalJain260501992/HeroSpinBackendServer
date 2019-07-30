package app.herospin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.herospin.hero.model.HeroPageResponse;
import app.herospin.service.HeroService;

@RestController
@RequestMapping("heroSpin/heroes")
@CrossOrigin(origins = "*")
public class HeroController {

	@Autowired
	private HeroService heroService;

	@RequestMapping(path = "list/offset/{offset}", method = RequestMethod.GET)
	public ResponseEntity<HeroPageResponse> nextMoviePage(
			@PathVariable("offset") int offset) {
		HeroPageResponse heroPage = heroService.nextHeroPage(offset);
		return new ResponseEntity<>(heroPage, HttpStatus.OK);
	}

}
