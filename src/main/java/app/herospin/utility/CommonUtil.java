package app.herospin.utility;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.DigestUtils;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CommonUtil {

	public String getMD5HashFor(String msg) {
		return DigestUtils.md5DigestAsHex(msg.getBytes()).toString();
	}

	public HttpHeaders getCommonHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return headers;
	}

	public UriComponentsBuilder getCommonURIBuilder(String url, String apiKey) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("api_key", apiKey).queryParam("language", "en-US");
		return builder;
	}

}
