package app.herospin.movie.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Movie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6876678286301287547L;

	private String original_language;

	private String imdb_id;
	
	private String video;

	private String title;

	private String backdrop_path;

	private String revenue;

	private Genres[] genres;

	private String popularity;

	private Production_countries[] production_countries;

	private long id;

	private String vote_count;

	private String budget;

	private String overview;

	private String original_title;

	private String runtime;

	private String poster_path;

	private Spoken_languages[] spoken_languages;

	private Production_companies[] production_companies;

	private String release_date;

	private String vote_average;

	private Belongs_to_collection belongs_to_collection;

	private String tagline;

	private String adult;

	private String homepage;

	private String status;

}
