package app.herospin.movie.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Genres implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4731778978413861701L;

	private String name;

	private String id;
}