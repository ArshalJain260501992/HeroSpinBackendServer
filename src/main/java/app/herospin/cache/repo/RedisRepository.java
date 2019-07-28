package app.herospin.cache.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import app.herospin.movie.model.MoviePageResponse;

@Repository
public class RedisRepository {

	private HashOperations hashOperations;

	private RedisTemplate<String, List<String>> redisTemplate;

	@Autowired
	public RedisRepository(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
		this.hashOperations = this.redisTemplate.opsForHash();
	}

	// public void save(User user) {
	// hashOperations.put("USER", user.getId(), user);
	// }
	// public List findAll() {
	// return hashOperations.values("USER");
	// }
	//
	// public User findById(String id) {
	// return (User) hashOperations.get("USER", id);
	// }
	//
	// public void update(User user) {
	// save(user);
	// }
	//
	// public void delete(String id) {
	// hashOperations.delete("USER", id);
	// }

	public List<Long> findAllMovieIDs() {
		hashOperations.keys("movies");

		return (List<Long>) hashOperations.get("movies", "getAllMovieIDs");
	}

	public MoviePageResponse findMoviePage(int pageNo) {
		return (MoviePageResponse) hashOperations.get("movies", pageNo);
	}

}