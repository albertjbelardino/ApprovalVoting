import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by alber on 12/14/2016.
 */
public class ApprovalVote {
    ArrayList<Candidate> voter;
    ArrayList<Candidate> masterCandidateList;
    ArrayList<ArrayList<Candidate>> voterList;

    int numberOfVoters;
    int numberOfCandidates;

    Scanner scan;

        public ApprovalVote(){
            setVars();

            newElectionText();

            getNumberOfVoters();
            getNumberOfCandidates();

            printMasterListText();
            setMasterCandidateList();

            fillElectorate();

            tallyVotes();
        }

        public String returnName(){
            return scan.nextLine();
        }

        public void getNumberOfVoters(){
            System.out.println("How many voters will be voting?");

                try {
                    numberOfVoters = scan.nextInt();
                } catch (Exception e) {
                    System.out.println("Not a number!");
                    getNumberOfVoters();
                }
        }

        public void fillElectorate(){
            //finish election
            while(voterList.size() < numberOfVoters) {

                newVoterText();

                //finish current voter
                //next line doesn't equal return && voter size <= master candidate size
                while (voter.size() < numberOfCandidates) {

                        String name = returnName();

                        for(int j = 0; j < getMasterCandidateListSize(); j++) {
                            if (getMasterCandidateList().get(j).getName().equals(name))
                                masterCandidateList.get(j).addVote();
                        }

                        voter.add(new Candidate(name));
                }

                voterList.add(voter);
                voter.clear();
            }
            }


        public int getMasterCandidateListSize(){
            return masterCandidateList.size();
        }

        public void newElectionText(){
            System.out.println("Begin Election: \n"
                    + "Enter 'f' to finish the election! \n \n");
        }

        public void newVoterText(){
            System.out.println("Voter " + (voterList.size()+ 1));
            System.out.println("Hit 'ENTER Twice for next voter \n \n");
        }

        public void printMasterListText(){
            System.out.println("Enter the Master List of Candidates: \n");
            System.out.println("Hit 'ENTER' Twice to Continue");
        }

        public void getNumberOfCandidates(){
            System.out.println("How many candidates are in the election?");

            try{
                numberOfCandidates = scan.nextInt();
            }
            catch (Exception e){
                System.out.println("Not an Integer!");
                getNumberOfCandidates();
            }
        }

        public void newVoter(){
            voterList.add(voter);
        }

        private void setVars(){
            voter = new ArrayList<>();

            masterCandidateList = new ArrayList<>();

            voterList = new ArrayList<>();

            scan = new Scanner(System.in);
        }

        public void setMasterCandidateList(){
            while(masterCandidateList.size() <= numberOfCandidates){
                masterCandidateList.add(new Candidate(scan.nextLine()));
            }
        }

        public ArrayList<Candidate> getMasterCandidateList(){
            return masterCandidateList;
        }

        public void tallyVotes(){
            for(int i = 1; i <  masterCandidateList.size(); i++){
                System.out.println(masterCandidateList.get(i).getName()
                                    + ": "
                                    + masterCandidateList.get(i).getVoteTotal());
            }
        }
}
