package app.herospin.hero.model;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Results implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5485294802509781226L;

	private int id;

	private String name;

	private String description;

	private String modified;

	private Thumbnail thumbnail;

	private String resourceURI;

	private Comics comics;

	private Series series;

	private Stories stories;

	private Events events;

	private List<Urls> urls;

}
