package org.shsteimer.espn.api.researchnotes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.shsteimer.espn.api.JEspnApi;
import org.shsteimer.espn.api.method.JEspnApiMethodImpl;
import org.shsteimer.espn.api.resource.JEspnApiResouce;
import org.shsteimer.espn.api.version.JEspnApiVersion;

public class JEspnResearchNotesApi extends JEspnApi<JEspnResearchNotesApi> {
	private static List<JEspnResearchNotesApiMethod> possibleMethods;
	private static Map<JEspnResearchNotesApiMethod, List<JEspnApiResouce>> supportedResourcedByMethodMap;

	protected static List<JEspnApiResouce> availableResources;

	public static JEspnResearchNotesApi getResearchNotes(
			final JEspnApiVersion version, final String apiKey) {
		JEspnResearchNotesApi api = new JEspnResearchNotesApi();
		api.version = version;
		api.parameters = new HashMap<String, String>();
		api.parameters.put("apikey", apiKey);
		api.with(JEspnApiResouce.SPORTS).using(
				JEspnResearchNotesApiMethod.NOTES);
		return api;
	}

	public static List<JEspnApiResouce> getAvailableResource() {
		if (availableResources == null) {
			availableResources = new ArrayList<JEspnApiResouce>();
			availableResources.add(JEspnApiResouce.SPORTS);
			availableResources.add(JEspnApiResouce.MLB);
			availableResources.add(JEspnApiResouce.NCAA_MENS_BASKETBALL);
			availableResources.add(JEspnApiResouce.NBA);
			availableResources.add(JEspnApiResouce.WNBA);
			availableResources.add(JEspnApiResouce.NCAA_WOMENS_BASKETBALL);
			availableResources.add(JEspnApiResouce.NCAA_FOOTBALL);
			availableResources.add(JEspnApiResouce.NFL);
			availableResources.add(JEspnApiResouce.NHL);
		}
		return availableResources;
	}

	public List<JEspnResearchNotesApiMethod> getAvailableMethods() {
		if (possibleMethods == null) {
			possibleMethods = new ArrayList<JEspnResearchNotesApiMethod>();
			possibleMethods.add(JEspnResearchNotesApiMethod.NOTES);
			possibleMethods.add(JEspnResearchNotesApiMethod.NOTE_BY_ID);
			possibleMethods.add(JEspnResearchNotesApiMethod.NOTES_BY_ATHELETE);
			possibleMethods.add(JEspnResearchNotesApiMethod.NOTES_BY_DATE);
			possibleMethods.add(JEspnResearchNotesApiMethod.NOTES_BY_EVENT);
			possibleMethods.add(JEspnResearchNotesApiMethod.NOTES_BY_TEAM);
		}

		List<JEspnResearchNotesApiMethod> availableMethods = new ArrayList<JEspnResearchNotesApiMethod>();
		for (JEspnResearchNotesApiMethod method : possibleMethods) {
			if (methodSupportsResource(method, resource)) {
				availableMethods.add(method);
			}
		}
		return availableMethods;
	}

	public static boolean methodSupportsResource(
			final JEspnResearchNotesApiMethod method,
			final JEspnApiResouce resource) {
		if (supportedResourcedByMethodMap == null) {
			supportedResourcedByMethodMap = new TreeMap<JEspnResearchNotesApiMethod, List<JEspnApiResouce>>();
			addSupportedResourcesNotes();
			addSupportedResourcesNotesByAthelete();
			addSupportedResourcesNotesByDate();
			addSupportedResourcesNotesByEvent();
			addSupportedResourcesNotesById();
			addSupportedResourcesNotesByTeam();
		}
		return supportedResourcedByMethodMap.get(method).contains(resource);
	}

	public JEspnResearchNotesApi using(final JEspnResearchNotesApiMethod method) {
		return using(method, null);
	}

	public JEspnResearchNotesApi using(
			final JEspnResearchNotesApiMethod methodEnum,
			final Map<String, String> methodParameters) {
		method = new JEspnApiMethodImpl(methodEnum.value());
		if (methodParameters != null && methodParameters.size() > 0) {
			for (String key : methodParameters.keySet()) {
				method.addMethodParameter(key, methodParameters.get(key));
			}
		}
		return this;
	}

	private static void addSupportedResourcesNotes() {
		List<JEspnApiResouce> supportedResources = new ArrayList<JEspnApiResouce>();
		supportedResources.add(JEspnApiResouce.SPORTS);
		supportedResources.add(JEspnApiResouce.MLB);
		supportedResources.add(JEspnApiResouce.NCAA_MENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NBA);
		supportedResources.add(JEspnApiResouce.WNBA);
		supportedResources.add(JEspnApiResouce.NCAA_WOMENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NCAA_FOOTBALL);
		supportedResources.add(JEspnApiResouce.NFL);
		supportedResources.add(JEspnApiResouce.NHL);
		supportedResourcedByMethodMap.put(JEspnResearchNotesApiMethod.NOTES,
				supportedResources);

	}

	private static void addSupportedResourcesNotesById() {
		List<JEspnApiResouce> supportedResources = new ArrayList<JEspnApiResouce>();
		supportedResources.add(JEspnApiResouce.SPORTS);
		supportedResources.add(JEspnApiResouce.MLB);
		supportedResources.add(JEspnApiResouce.NCAA_MENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NBA);
		supportedResources.add(JEspnApiResouce.WNBA);
		supportedResources.add(JEspnApiResouce.NCAA_WOMENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NCAA_FOOTBALL);
		supportedResources.add(JEspnApiResouce.NFL);
		supportedResources.add(JEspnApiResouce.NHL);
		supportedResourcedByMethodMap.put(
				JEspnResearchNotesApiMethod.NOTE_BY_ID, supportedResources);

	}

	private static void addSupportedResourcesNotesByDate() {
		List<JEspnApiResouce> supportedResources = new ArrayList<JEspnApiResouce>();
		supportedResources.add(JEspnApiResouce.SPORTS);
		supportedResources.add(JEspnApiResouce.MLB);
		supportedResources.add(JEspnApiResouce.NCAA_MENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NBA);
		supportedResources.add(JEspnApiResouce.WNBA);
		supportedResources.add(JEspnApiResouce.NCAA_WOMENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NCAA_FOOTBALL);
		supportedResources.add(JEspnApiResouce.NFL);
		supportedResources.add(JEspnApiResouce.NHL);
		supportedResourcedByMethodMap.put(
				JEspnResearchNotesApiMethod.NOTES_BY_DATE, supportedResources);

	}

	private static void addSupportedResourcesNotesByAthelete() {
		List<JEspnApiResouce> supportedResources = new ArrayList<JEspnApiResouce>();
		supportedResources.add(JEspnApiResouce.SPORTS);
		supportedResources.add(JEspnApiResouce.MLB);
		supportedResources.add(JEspnApiResouce.NCAA_MENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NBA);
		supportedResources.add(JEspnApiResouce.WNBA);
		supportedResources.add(JEspnApiResouce.NCAA_WOMENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NCAA_FOOTBALL);
		supportedResources.add(JEspnApiResouce.NFL);
		supportedResources.add(JEspnApiResouce.NHL);
		supportedResourcedByMethodMap.put(
				JEspnResearchNotesApiMethod.NOTES_BY_ATHELETE,
				supportedResources);

	}

	private static void addSupportedResourcesNotesByEvent() {
		List<JEspnApiResouce> supportedResources = new ArrayList<JEspnApiResouce>();
		supportedResources.add(JEspnApiResouce.SPORTS);
		supportedResources.add(JEspnApiResouce.MLB);
		supportedResources.add(JEspnApiResouce.NCAA_MENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NBA);
		supportedResources.add(JEspnApiResouce.WNBA);
		supportedResources.add(JEspnApiResouce.NCAA_WOMENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NCAA_FOOTBALL);
		supportedResources.add(JEspnApiResouce.NFL);
		supportedResources.add(JEspnApiResouce.NHL);
		supportedResourcedByMethodMap.put(
				JEspnResearchNotesApiMethod.NOTES_BY_EVENT, supportedResources);

	}

	private static void addSupportedResourcesNotesByTeam() {
		List<JEspnApiResouce> supportedResources = new ArrayList<JEspnApiResouce>();
		supportedResources.add(JEspnApiResouce.SPORTS);
		supportedResources.add(JEspnApiResouce.MLB);
		supportedResources.add(JEspnApiResouce.NCAA_MENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NBA);
		supportedResources.add(JEspnApiResouce.WNBA);
		supportedResources.add(JEspnApiResouce.NCAA_WOMENS_BASKETBALL);
		supportedResources.add(JEspnApiResouce.NCAA_FOOTBALL);
		supportedResources.add(JEspnApiResouce.NFL);
		supportedResources.add(JEspnApiResouce.NHL);
		supportedResourcedByMethodMap.put(
				JEspnResearchNotesApiMethod.NOTES_BY_TEAM, supportedResources);

	}
}
