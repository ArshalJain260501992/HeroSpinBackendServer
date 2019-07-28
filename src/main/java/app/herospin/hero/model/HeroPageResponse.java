package app.herospin.hero.model;

import java.io.Serializable;

import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
public class HeroPageResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8291390905353875854L;

	private int code;

	private String status;

	private String copyright;

	private String attributionText;

	private String attributionHTML;

	private String etag;

	private Data data;

}
