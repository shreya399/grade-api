package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

import java.util.Arrays;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Team team = gradeDB.getMyTeam();
        String[] members = team.getMembers();
        //System.out.println(Arrays.toString(members));
        float sum = 0;
        for(String member : members){
            sum += gradeDB.getGrade(member, course).getGrade();
            //System.out.println(gradeDB.getGrade(member, course).getGrade());
        }
        return sum/members.length;
    }
}
