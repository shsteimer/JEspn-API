package org.shsteimer.espn.api.resource;


public enum JEspnApiResouce {
	SPORTS("sports"), MLB("sports/baseball/mlb"), NCAA_MENS_BASKETBALL(
			"sports/basketball/mens-college-basketball"), NBA(
			"sports/basketball/nba"), WNBA("sports/basketball/wnba"), NCAA_WOMENS_BASKETBALL(
			"sports/basketball/womens-college-basketball"), BOXING(
			"sports/boxing"), NCAA_FOOTBALL("sports/football/college-football"), NFL(
			"sports/football/nfl"), GOLF("sports/golf"), NHL(
			"sports/hockey/nhl"), HORSE_RACING("sports/horse-racing"), MMA(
			"sports/mma"), OLYMPICS("sports/olympics"), AUTO_RACING(
			"sports/racing"), NASCAR("sports/racing/nascar"), PROFESSIONAL_SOCCER(
			"sports/soccer"), TENNIS("sports/tennis");

	private String value;

	JEspnApiResouce(final String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

}
