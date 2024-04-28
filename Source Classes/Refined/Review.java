package project.Refined;

class Review {

    private static int id_count = 0;
    private int id;
    private int stars;
    private String feedback;

    Review() {
        id_count++;
        this.id = id_count;
    }

    Review(int stars, String feedback) {
        this();
        this.stars = stars;
        this.feedback = feedback;

    }

    public int getID() {
        return this.id;
    }

    public float getStars() {
        return this.stars;
    }

    public String getFeedback() {
        return this.feedback;
    }
}
