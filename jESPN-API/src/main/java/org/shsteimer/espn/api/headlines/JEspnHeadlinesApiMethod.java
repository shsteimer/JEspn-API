package org.shsteimer.espn.api.headlines;


public enum JEspnHeadlinesApiMethod {
	NEWS("news"), NEWS_BY_DATE("news/dates/__yyyymmdd__"), NEWS_HEADLINES(
			"news/headlines"), NEWS_HEADLINES_TOP("news/headlines/top"), NEWS_BY_ATHELETE(
			"athletes/__athleteId__/news"), NEWS_BY_ATHELETE_BY_DATE(
			"athletes/__athleteId__/news/dates/__yyyymmdd__"), NEWS_BY_TEAM(
			"teams/__teamId__/news"), NEWS_BY_TEAM_BY_DATE(
			"teams/__teamId__/news/dates/__yyyymmdd__"), NEWS_BY_STORY_ID(
			"news/__id__");

	private String value;

	JEspnHeadlinesApiMethod(final String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

}
