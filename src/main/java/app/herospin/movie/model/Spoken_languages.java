package app.herospin.movie.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Spoken_languages implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3096157897156021414L;

	private String name;

	private String iso_639_1;
}