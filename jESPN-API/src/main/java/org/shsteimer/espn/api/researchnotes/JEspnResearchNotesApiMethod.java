package org.shsteimer.espn.api.researchnotes;

public enum JEspnResearchNotesApiMethod {
	NOTES("news/notes"), NOTES_BY_DATE("news/notes/dates/__yyyymmdd__"), NOTE_BY_ID(
			"news/notes/__id__"), NOTES_BY_ATHELETE(
			"athletes/__athleteId__/news/notes"), NOTES_BY_TEAM(
			"teams/__teamId__/news/notes"), NOTES_BY_EVENT(
			"events/__eventId__/news/notes");

	private String value;

	JEspnResearchNotesApiMethod(final String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
