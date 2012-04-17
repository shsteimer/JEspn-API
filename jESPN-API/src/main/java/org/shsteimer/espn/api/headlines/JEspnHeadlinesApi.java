package org.shsteimer.espn.api.headlines;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.shsteimer.espn.api.JEspnApi;
import org.shsteimer.espn.api.method.JEspnApiMethodImpl;
import org.shsteimer.espn.api.resource.JEspnApiResouce;
import org.shsteimer.espn.api.version.JEspnApiVersion;

public class JEspnHeadlinesApi extends JEspnApi<JEspnHeadlinesApi> {

	private static List<JEspnHeadlinesApiMethod> possibleMethods;
	private static Map<JEspnHeadlinesApiMethod, List<JEspnApiResouce>> supportedResourcedByMethodMap;

	protected static List<JEspnApiResouce> availableResources;

	public static final String INSIDER_YES = "yes";
	public static final String INSIDER_NO = "no";
	public static final String INSIDER_ONLY = "only";

	public static JEspnHeadlinesApi getHeadlines(final JEspnApiVersion version,
			final String apiKey) {
		JEspnHeadlinesApi headlines = new JEspnHeadlinesApi();
		headlines.version = version;
		headlines.parameters = new HashMap<String, String>();
		headlines.parameters.put("apikey", apiKey);
		headlines.with(JEspnApiResouce.SPORTS).using(
				JEspnHeadlinesApiMethod.NEWS);
		return headlines;
	}

	public static List<JEspnApiResouce> getAvailableResource() {
		if (availableResources == null) {
			availableResources = new ArrayList<JEspnApiResouce>();
			availableResources.add(JEspnApiResouce.SPORTS);
			availableResources.add(JEspnApiResouce.NCAA_MENS_BASKETBALL);
			availableResources.add(JEspnApiResouce.NCAA_WOMENS_BASKETBALL);
			availableResources.add(JEspnApiResouce.WNBA);
			availableResources.add(JEspnApiResouce.NBA);
			availableResources.add(JEspnApiResouce.NCAA_FOOTBALL);
			availableResources.add(JEspnApiResouce.NFL);
			availableResources.add(JEspnApiResouce.MLB);
			availableResources.add(JEspnApiResouce.NHL);
			availableResources.add(JEspnApiResouce.GOLF);
			availableResources.add(JEspnApiResouce.TENNIS);
			availableResources.add(JEspnApiResouce.HORSE_RACING);
			availableResources.add(JEspnApiResouce.PROFESSIONAL_SOCCER);
			availableResources.add(JEspnApiResouce.AUTO_RACING);
			availableResources.add(JEspnApiResouce.BOXING);
			availableResources.add(JEspnApiResouce.MMA);
			availableResources.add(JEspnApiResouce.NASCAR);
			availableResources.add(JEspnApiResouce.OLYMPICS);
		}
		return availableResources;

	}

	public List<JEspnHeadlinesApiMethod> getAvailableMethods() {
		if (possibleMethods == null) {
			possibleMethods = new ArrayList<JEspnHeadlinesApiMethod>();
			possibleMethods.add(JEspnHeadlinesApiMethod.NEWS);
			possibleMethods.add(JEspnHeadlinesApiMethod.NEWS_BY_ATHELETE);
			possibleMethods
					.add(JEspnHeadlinesApiMethod.NEWS_BY_ATHELETE_BY_DATE);
			possibleMethods.add(JEspnHeadlinesApiMethod.NEWS_BY_DATE);
			possibleMethods.add(JEspnHeadlinesApiMethod.NEWS_BY_STORY_ID);
			possibleMethods.add(JEspnHeadlinesApiMethod.NEWS_BY_TEAM);
			possibleMethods.add(JEspnHeadlinesApiMethod.NEWS_BY_TEAM_BY_DATE);
			possibleMethods.add(JEspnHeadlinesApiMethod.NEWS_HEADLINES);
			possibleMethods.add(JEspnHeadlinesApiMethod.NEWS_HEADLINES_TOP);

		}

		List<JEspnHeadlinesApiMethod> availableMethods = new ArrayList<JEspnHeadlinesApiMethod>();
		for (JEspnHeadlinesApiMethod method : possibleMethods) {
			if (methodSupportsResource(method, resource)) {
				availableMethods.add(method);
			}
		}
		return availableMethods;
	}

	public static boolean methodSupportsResource(
			final JEspnHeadlinesApiMethod method, final JEspnApiResouce resource) {
		if (supportedResourcedByMethodMap == null) {
			supportedResourcedByMethodMap = new TreeMap<JEspnHeadlinesApiMethod, List<JEspnApiResouce>>();
			addSupportedResourcesNews();
			addSupportedResourcesNewsByDate();
			addSupportedResourcesNewsByAthelete();
			addSupportedResourcesNewsByAtheleteByDate();
			addSupportedResourcesNewsByStoryId();
			addSupportedResourcesNewsByTeam();
			addSupportedResourcesNewsByTeamByDate();
			addSupportedResourcesNewsHeadlines();
			addSupportedResourcesNewsHeadlinesTop();
		}
		return supportedResourcedByMethodMap.get(method).contains(resource);
	}

	public JEspnHeadlinesApi using(final JEspnHeadlinesApiMethod method) {
		return using(method, null);
	}

	public JEspnHeadlinesApi using(final JEspnHeadlinesApiMethod methodEnum,
			final Map<String, String> methodParameters) {
		method = new JEspnApiMethodImpl(methodEnum.value());
		if (methodParameters != null && methodParameters.size() > 0) {
			for (String key : methodParameters.keySet()) {
				method.addMethodParameter(key, methodParameters.get(key));
			}
		}
		return this;
	}

	public JEspnHeadlinesApi insider(final String insider) {
		return addParameter("insider", insider);
	}

	private static void addSupportedResourcesNews() {
		List<JEspnApiResouce> supportedResources = new ArrayList<JEspnApiResouce>();
		supportedResources.add(JEspnApiResouce.SPORTS);
		supportedResources.add(JEspnApiResouce.NCAA_MENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NCAA_WOMENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.WNBA);
		supportedResources.add(JEspnApiResouce.NBA);
		supportedResources.add(JEspnApiResouce.NCAA_FOOTBALL);
		supportedResources.add(JEspnApiResouce.NFL);
		supportedResources.add(JEspnApiResouce.MLB);
		supportedResources.add(JEspnApiResouce.NHL);
		supportedResources.add(JEspnApiResouce.GOLF);
		supportedResources.add(JEspnApiResouce.TENNIS);
		supportedResources.add(JEspnApiResouce.HORSE_RACING);
		supportedResources.add(JEspnApiResouce.PROFESSIONAL_SOCCER);
		supportedResources.add(JEspnApiResouce.AUTO_RACING);
		supportedResources.add(JEspnApiResouce.BOXING);
		supportedResources.add(JEspnApiResouce.MMA);
		supportedResources.add(JEspnApiResouce.NASCAR);
		supportedResources.add(JEspnApiResouce.OLYMPICS);
		supportedResourcedByMethodMap.put(JEspnHeadlinesApiMethod.NEWS,
				supportedResources);
	}

	private static void addSupportedResourcesNewsByAthelete() {
		List<JEspnApiResouce> supportedResources = new ArrayList<JEspnApiResouce>();
		supportedResources.add(JEspnApiResouce.SPORTS);
		supportedResources.add(JEspnApiResouce.NCAA_MENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NCAA_WOMENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.WNBA);
		supportedResources.add(JEspnApiResouce.NBA);
		supportedResources.add(JEspnApiResouce.NCAA_FOOTBALL);
		supportedResources.add(JEspnApiResouce.NFL);
		supportedResources.add(JEspnApiResouce.MLB);
		supportedResources.add(JEspnApiResouce.NHL);
		supportedResources.add(JEspnApiResouce.GOLF);
		supportedResources.add(JEspnApiResouce.TENNIS);
		supportedResources.add(JEspnApiResouce.HORSE_RACING);
		supportedResources.add(JEspnApiResouce.PROFESSIONAL_SOCCER);
		supportedResources.add(JEspnApiResouce.AUTO_RACING);
		supportedResources.add(JEspnApiResouce.BOXING);
		supportedResources.add(JEspnApiResouce.MMA);
		supportedResources.add(JEspnApiResouce.NASCAR);
		supportedResources.add(JEspnApiResouce.OLYMPICS);
		supportedResourcedByMethodMap.put(
				JEspnHeadlinesApiMethod.NEWS_BY_ATHELETE, supportedResources);
	}

	private static void addSupportedResourcesNewsByAtheleteByDate() {
		List<JEspnApiResouce> supportedResources = new ArrayList<JEspnApiResouce>();
		supportedResources.add(JEspnApiResouce.SPORTS);
		supportedResources.add(JEspnApiResouce.NCAA_MENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NCAA_WOMENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.WNBA);
		supportedResources.add(JEspnApiResouce.NBA);
		supportedResources.add(JEspnApiResouce.NCAA_FOOTBALL);
		supportedResources.add(JEspnApiResouce.NFL);
		supportedResources.add(JEspnApiResouce.MLB);
		supportedResources.add(JEspnApiResouce.NHL);
		supportedResources.add(JEspnApiResouce.GOLF);
		supportedResources.add(JEspnApiResouce.TENNIS);
		supportedResources.add(JEspnApiResouce.HORSE_RACING);
		supportedResources.add(JEspnApiResouce.PROFESSIONAL_SOCCER);
		supportedResources.add(JEspnApiResouce.AUTO_RACING);
		supportedResources.add(JEspnApiResouce.BOXING);
		supportedResources.add(JEspnApiResouce.MMA);
		supportedResources.add(JEspnApiResouce.NASCAR);
		supportedResources.add(JEspnApiResouce.OLYMPICS);
		supportedResourcedByMethodMap.put(
				JEspnHeadlinesApiMethod.NEWS_BY_ATHELETE_BY_DATE,
				supportedResources);
	}

	private static void addSupportedResourcesNewsByDate() {
		List<JEspnApiResouce> supportedResources = new ArrayList<JEspnApiResouce>();
		supportedResources.add(JEspnApiResouce.SPORTS);
		supportedResources.add(JEspnApiResouce.NCAA_MENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NCAA_WOMENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.WNBA);
		supportedResources.add(JEspnApiResouce.NBA);
		supportedResources.add(JEspnApiResouce.NCAA_FOOTBALL);
		supportedResources.add(JEspnApiResouce.NFL);
		supportedResources.add(JEspnApiResouce.MLB);
		supportedResources.add(JEspnApiResouce.NHL);
		supportedResources.add(JEspnApiResouce.GOLF);
		supportedResources.add(JEspnApiResouce.TENNIS);
		supportedResources.add(JEspnApiResouce.HORSE_RACING);
		supportedResources.add(JEspnApiResouce.PROFESSIONAL_SOCCER);
		supportedResources.add(JEspnApiResouce.AUTO_RACING);
		supportedResources.add(JEspnApiResouce.BOXING);
		supportedResources.add(JEspnApiResouce.MMA);
		supportedResources.add(JEspnApiResouce.NASCAR);
		supportedResources.add(JEspnApiResouce.OLYMPICS);
		supportedResourcedByMethodMap.put(JEspnHeadlinesApiMethod.NEWS_BY_DATE,
				supportedResources);
	}

	private static void addSupportedResourcesNewsByStoryId() {
		List<JEspnApiResouce> supportedResources = new ArrayList<JEspnApiResouce>();
		supportedResources.add(JEspnApiResouce.SPORTS);
		supportedResources.add(JEspnApiResouce.NCAA_MENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NCAA_WOMENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.WNBA);
		supportedResources.add(JEspnApiResouce.NBA);
		supportedResources.add(JEspnApiResouce.NCAA_FOOTBALL);
		supportedResources.add(JEspnApiResouce.NFL);
		supportedResources.add(JEspnApiResouce.MLB);
		supportedResources.add(JEspnApiResouce.NHL);
		supportedResources.add(JEspnApiResouce.GOLF);
		supportedResources.add(JEspnApiResouce.TENNIS);
		supportedResources.add(JEspnApiResouce.HORSE_RACING);
		supportedResources.add(JEspnApiResouce.PROFESSIONAL_SOCCER);
		supportedResources.add(JEspnApiResouce.AUTO_RACING);
		supportedResources.add(JEspnApiResouce.BOXING);
		supportedResources.add(JEspnApiResouce.MMA);
		supportedResources.add(JEspnApiResouce.NASCAR);
		supportedResources.add(JEspnApiResouce.OLYMPICS);
		supportedResourcedByMethodMap.put(
				JEspnHeadlinesApiMethod.NEWS_BY_STORY_ID, supportedResources);
	}

	private static void addSupportedResourcesNewsByTeam() {
		List<JEspnApiResouce> supportedResources = new ArrayList<JEspnApiResouce>();
		supportedResources.add(JEspnApiResouce.SPORTS);
		supportedResources.add(JEspnApiResouce.NCAA_MENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NCAA_WOMENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.WNBA);
		supportedResources.add(JEspnApiResouce.NBA);
		supportedResources.add(JEspnApiResouce.NCAA_FOOTBALL);
		supportedResources.add(JEspnApiResouce.NFL);
		supportedResources.add(JEspnApiResouce.MLB);
		supportedResources.add(JEspnApiResouce.NHL);
		supportedResources.add(JEspnApiResouce.GOLF);
		supportedResources.add(JEspnApiResouce.TENNIS);
		supportedResources.add(JEspnApiResouce.HORSE_RACING);
		supportedResources.add(JEspnApiResouce.PROFESSIONAL_SOCCER);
		supportedResources.add(JEspnApiResouce.AUTO_RACING);
		supportedResources.add(JEspnApiResouce.BOXING);
		supportedResources.add(JEspnApiResouce.MMA);
		supportedResources.add(JEspnApiResouce.NASCAR);
		supportedResources.add(JEspnApiResouce.OLYMPICS);
		supportedResourcedByMethodMap.put(JEspnHeadlinesApiMethod.NEWS_BY_TEAM,
				supportedResources);
	}

	private static void addSupportedResourcesNewsByTeamByDate() {
		List<JEspnApiResouce> supportedResources = new ArrayList<JEspnApiResouce>();
		supportedResources.add(JEspnApiResouce.SPORTS);
		supportedResources.add(JEspnApiResouce.NCAA_MENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NCAA_WOMENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.WNBA);
		supportedResources.add(JEspnApiResouce.NBA);
		supportedResources.add(JEspnApiResouce.NCAA_FOOTBALL);
		supportedResources.add(JEspnApiResouce.NFL);
		supportedResources.add(JEspnApiResouce.MLB);
		supportedResources.add(JEspnApiResouce.NHL);
		supportedResources.add(JEspnApiResouce.GOLF);
		supportedResources.add(JEspnApiResouce.TENNIS);
		supportedResources.add(JEspnApiResouce.HORSE_RACING);
		supportedResources.add(JEspnApiResouce.PROFESSIONAL_SOCCER);
		supportedResources.add(JEspnApiResouce.AUTO_RACING);
		supportedResources.add(JEspnApiResouce.BOXING);
		supportedResources.add(JEspnApiResouce.MMA);
		supportedResources.add(JEspnApiResouce.NASCAR);
		supportedResources.add(JEspnApiResouce.OLYMPICS);
		supportedResourcedByMethodMap.put(
				JEspnHeadlinesApiMethod.NEWS_BY_TEAM_BY_DATE,
				supportedResources);
	}

	private static void addSupportedResourcesNewsHeadlines() {
		List<JEspnApiResouce> supportedResources = new ArrayList<JEspnApiResouce>();
		supportedResources.add(JEspnApiResouce.SPORTS);
		supportedResources.add(JEspnApiResouce.NCAA_MENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NCAA_WOMENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.WNBA);
		supportedResources.add(JEspnApiResouce.NBA);
		supportedResources.add(JEspnApiResouce.NCAA_FOOTBALL);
		supportedResources.add(JEspnApiResouce.NFL);
		supportedResources.add(JEspnApiResouce.MLB);
		supportedResources.add(JEspnApiResouce.NHL);
		supportedResources.add(JEspnApiResouce.GOLF);
		supportedResources.add(JEspnApiResouce.TENNIS);
		supportedResources.add(JEspnApiResouce.HORSE_RACING);
		supportedResources.add(JEspnApiResouce.PROFESSIONAL_SOCCER);
		supportedResources.add(JEspnApiResouce.AUTO_RACING);
		supportedResources.add(JEspnApiResouce.BOXING);
		supportedResources.add(JEspnApiResouce.MMA);
		supportedResources.add(JEspnApiResouce.NASCAR);
		supportedResources.add(JEspnApiResouce.OLYMPICS);
		supportedResourcedByMethodMap.put(
				JEspnHeadlinesApiMethod.NEWS_HEADLINES, supportedResources);
	}

	private static void addSupportedResourcesNewsHeadlinesTop() {
		List<JEspnApiResouce> supportedResources = new ArrayList<JEspnApiResouce>();
		supportedResources.add(JEspnApiResouce.SPORTS);
		supportedResourcedByMethodMap.put(
				JEspnHeadlinesApiMethod.NEWS_HEADLINES_TOP, supportedResources);
	}
}
