class Solution {
    public long mostPoints(int[][] questions) {
        return process(questions, 0, new HashMap<>());
    }

    public long process(int[][] questions, int index, Map<Integer, Long> mem) {
        int len = questions.length;
        if (index >= len) return 0;
        if (mem.containsKey(index)) return mem.get(index);
        // choose the current question
        long current_question_points = questions[index][0];
        int current_brain_power = questions[index][1];
        long points = current_question_points + process(questions, index + current_brain_power + 1, mem);
        // don't choose the current question
        long points2 = process(questions, index + 1, mem);
        long final_points = Math.max(points, points2);
        mem.put(index, final_points);
        return final_points;
    }
}