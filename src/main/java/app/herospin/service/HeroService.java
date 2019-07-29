package app.herospin.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import app.herospin.hero.model.HeroPageResponse;
import app.herospin.utility.CommonUtil;

@Service
public class HeroService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${enc.characterRepo.apiKey}")
	private String apiKey;

	@Value("${enc.characterRepo.privateKey}")
	private String privateKey;

	@Value("${characterRepo.apis.listAll}")
	private String listAllHeroURL;

	@Value("${characterRepo.pageSize}")
	private String limit;

	@Cacheable(value = "heroes", key = "{ #offset}")
	public HeroPageResponse nextHeroPage(int offset) {

		HttpHeaders headers = CommonUtil.getCommonHeader();
		long ts = new Date().getTime();
		String hash = ts + privateKey + apiKey;
		hash = CommonUtil.getMD5HashFor(hash);
		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl(listAllHeroURL).queryParam("apikey", apiKey)
				.queryParam("offset", offset).queryParam("limit", limit)
				.queryParam("ts", ts).queryParam("hash", hash);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<HeroPageResponse> response = restTemplate.exchange(
				builder.toUriString(), HttpMethod.GET, entity,
				HeroPageResponse.class);

		return response.getBody();
	}

}
