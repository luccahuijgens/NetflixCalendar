package nl.hu.v1ipass.thirdapp.model;

public class  Series{
	private int code;
	private String title;
	private String genre;
	private int episodes;
	private String startdate;
	private String enddate;
	private String airday;
	private int duration;
	private int score;
	private String productionstudio;
	private int rating;
	private int viewers;
	private String synopsis;
	
	public Series(int code, String title, String genre, int episodes, String startdate, String enddate, String airday,
			int duration, int score, String productionstudio, int rating, int viewers, String synopsis) {
		super();
		this.code = code;
		this.title = title;
		this.genre = genre;
		this.episodes = episodes;
		this.startdate = startdate;
		this.enddate = enddate;
		this.airday = airday;
		this.duration = duration;
		this.score = score;
		this.productionstudio = productionstudio;
		this.rating = rating;
		this.viewers = viewers;
		this.synopsis=synopsis;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getEpisodes() {
		return episodes;
	}
	public void setEpisodes(int episodes) {
		this.episodes = episodes;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getAirday() {
		return airday;
	}
	public void setAirday(String airday) {
		this.airday = airday;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getProductionstudio() {
		return productionstudio;
	}
	public void setProductionstudio(String productionstudio) {
		this.productionstudio = productionstudio;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getViewers() {
		return viewers;
	}
	public void setViewers(int viewers) {
		this.viewers = viewers;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String toString(){
		return title+" "+episodes;
	
}}