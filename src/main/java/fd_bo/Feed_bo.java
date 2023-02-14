package fd_bo;

public class Feed_bo {
	
	private int id;
	private String name;
	private int rating;
	private String feedback;
	
	
	public int getId() {
		return id;
		
	}
	
	public void setId(int id) {
		this.id= id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Feed_bo(String name, int rating, String feedback) {
		super();
		this.name = name;
		this.rating = rating;
		this.feedback = feedback;
	}
	
	
	public Feed_bo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Feed_bo [id=" + id + ", name=" + name + ", rating=" + rating + ", feedback=" + feedback + "]";
	}
	
	
	

}
