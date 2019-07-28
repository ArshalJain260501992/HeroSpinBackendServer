package app.herospin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import app.herospin.cache.repo.RedisRepository;
import app.herospin.movie.model.Movie;
import app.herospin.movie.model.MoviePageResponse;
import app.herospin.utility.CommonUtil;

@Service
public class MovieService {

	@Autowired
	private RedisRepository redisRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private MovieService movieServiceProxy;

	@Value("${movieRepo.apiKey}")
	private String apiKey;

	@Value("${movieRepo.apis.listAll}")
	private String listAllMovieURL;

	@Value("${movieRepo.apis.findOne}")
	private String findOneMovieURL;

	@Value("${movieRepo.apis.findRelevant}")
	private String findRelevantMovieURL;

	@Cacheable(value = "movies", key = "#pageNo")
	public MoviePageResponse nextMoviePage(int pageNo) {
		MoviePageResponse moviePageResponse = redisRepo.findMoviePage(pageNo);
		if (moviePageResponse == null) {
			HttpHeaders headers = CommonUtil.getCommonHeader();

			UriComponentsBuilder builder = CommonUtil
					.getCommonURIBuilder(listAllMovieURL, apiKey)
					.queryParam("page", pageNo);

			HttpEntity<?> entity = new HttpEntity<>(headers);

			HttpEntity<MoviePageResponse> response = restTemplate.exchange(
					builder.toUriString(), HttpMethod.GET, entity,
					MoviePageResponse.class);

			moviePageResponse = response.getBody();
		}
		return moviePageResponse;
	}

	public Movie pickARandomMovie(List<Long> movieIDs) {
		Long movieID = movieIDs.get(new Random().nextInt(movieIDs.size()));
		return findMovieByID(movieID);
	}

	@Cacheable(value = "movieDetails", key = "#movieID")
	public Movie findMovieByID(Long movieID) throws RestClientException {
		HttpHeaders headers = CommonUtil.getCommonHeader();
		String url = findOneMovieURL + "/" + movieID;
		UriComponentsBuilder builder = CommonUtil.getCommonURIBuilder(url,
				apiKey);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<Movie> response = restTemplate.exchange(
				builder.toUriString(), HttpMethod.GET, entity, Movie.class);
		return response.getBody();
	}

	@Cacheable(value = "movies", key = "#root.methodName")
	public List<Long> getAllMovieIDs() {
		MoviePageResponse moviePageResponse = nextMoviePage(1);
		return registerAllMovieIDs(moviePageResponse);
	}

	private List<Long> registerAllMovieIDs(
			MoviePageResponse moviePageResponse) {
		List<Long> movieIDs = new ArrayList<>();
		addMovieIDs(movieIDs, moviePageResponse.getResults());
		IntStream
				.range(2,
						Long.valueOf(moviePageResponse.getTotal_pages())
								.intValue() + 1)
				.forEachOrdered(pageNo -> addMovieIDs(movieIDs,
						movieServiceProxy.nextMoviePage(pageNo).getResults()));
		return movieIDs;
	}

	private void addMovieIDs(List<Long> movieIDs, Movie[] results) {
		IntStream.range(0, results.length)
				.mapToLong(index -> results[index].getId())
				.forEach(movieIDs::add);
	}

	@Cacheable(value = "movies", key = "#query")
	public List<Long> registerAllHeroMovieIDs(
			MoviePageResponse moviePageResponse, String query) {
		List<Long> movieIDs = new ArrayList<>();
		addMovieIDs(movieIDs, moviePageResponse.getResults());
		IntStream
				.range(2,
						Long.valueOf(moviePageResponse.getTotal_pages())
								.intValue() + 1)
				.forEachOrdered(pageNo -> addMovieIDs(movieIDs,
						movieServiceProxy.findRelevantMoviesPage(query, pageNo)
								.getResults()));
		return movieIDs;
	}

	@Cacheable(value = "movies", key = "{#query, #pageNo}")
	public MoviePageResponse findRelevantMoviesPage(String query, int pageNo) {
		HttpHeaders headers = CommonUtil.getCommonHeader();

		UriComponentsBuilder builder = CommonUtil
				.getCommonURIBuilder(findRelevantMovieURL, apiKey)
				.queryParam("page", pageNo).queryParam("query", query);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<MoviePageResponse> response = restTemplate.exchange(
				builder.toUriString(), HttpMethod.GET, entity,
				MoviePageResponse.class);

		return response.getBody();
	}

}
