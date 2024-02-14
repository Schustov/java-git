package climber;

import java.util.ArrayList;

public class ClimbingGroup {
    public boolean isRecruitment;
    public int numOfAlpinists;
    public ArrayList<Alpinist> alpinists;
    public Mountain mountain;

    public ClimbingGroup(boolean isRecruitment, int numOfAlpinists, Mountain mountain) {
        this.isRecruitment = isRecruitment;
        this.numOfAlpinists = numOfAlpinists;
        this.alpinists = new ArrayList<>();
        this.mountain = mountain;
    }

    public void addAlpinist(Alpinist alpinist) {
        if (isRecruitment || (alpinists.size() < numOfAlpinists)) {
            if (isRecruitment) isRecruitment = false;
            alpinists.add(alpinist);
        } else {
            System.out.println("Набор в группу закрыт или группа полна.");
        }
    }
}
