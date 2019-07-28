package app.herospin.movie.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MoviePageResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2262837506532528611L;

	private long page;

	private long total_pages;

	private Movie[] results;

	private long total_results;

}