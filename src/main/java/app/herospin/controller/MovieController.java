package app.herospin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.herospin.movie.model.Movie;
import app.herospin.movie.model.MoviePageResponse;
import app.herospin.service.MovieService;

@RestController
@RequestMapping("heroSpin/movies")
@CrossOrigin(origins = "*")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@RequestMapping(path = "list/page/{pageNo}", method = RequestMethod.GET)
	public ResponseEntity<MoviePageResponse> nextMoviePage(
			@PathVariable("pageNo") int pageNo) {
		MoviePageResponse moviePage = movieService.nextMoviePage(pageNo);
		return new ResponseEntity<>(moviePage, HttpStatus.OK);
	}

	@RequestMapping(path = "pickARandom", method = RequestMethod.GET)
	public ResponseEntity<Movie> pickARandomMovie() {
		List<Long> movieIDs = movieService.getAllMovieIDs();
		Movie movie = movieService.pickARandomMovie(movieIDs);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}

	@RequestMapping(path = "findRelevantRandomMovie/{keyword}", method = RequestMethod.GET)
	public ResponseEntity<Movie> findRelevantRandomMovie(
			@PathVariable("keyword") String query) {
		MoviePageResponse moviePageResponse = movieService
				.findRelevantMoviesPage(query, 1);
		List<Long> movieIDs = movieService
				.registerAllHeroMovieIDs(moviePageResponse, query);
		Movie movie = movieService.pickARandomMovie(movieIDs);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}

}
