/**
 * Created by alber on 12/14/2016.
 */
public class Candidate {
    private String name;
    private int voteTotal;

        public Candidate(String name){
            this.name = name;
            voteTotal = 0;
        }

    public int getVoteTotal() {
        return voteTotal;
    }

    public void setVoteTotal(int voteTotal) {
        this.voteTotal = voteTotal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addVote(){
        voteTotal++;
    }
}
