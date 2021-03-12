public class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String tree : skill_trees) {
            boolean fail = false;
            char lastSkill = '\0';
            for (int i = 0; i < tree.length(); i++) {
                int idx = skill.indexOf(tree.charAt(i));
                if (idx == -1) {
                    continue;
                }

                if (idx > 0) {
                        if (skill.charAt(idx-1) != lastSkill) {
                            fail = true;
                            break;
                        }
                        lastSkill = skill.charAt(idx);
                } else {
                    lastSkill = skill.charAt(0);
                }
            }

            if (!fail) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        SkillTree st = new SkillTree();
        String skill = "CBD";
        String[] skill_trees = new String[]{"BACDE", "CBADF", "AECB", "BDA"};


        System.out.println(st.solution(skill, skill_trees));
    }
}