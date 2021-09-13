package _8_clean_code_and_refactoring.exercise.refactoring;

public class TennisGame {
    private static final int LOVE = 0;
    private static final int FIFTEEN = 1;
    private static final int THIRTY = 2;
    private static final int FORTY = 3;
    private static final int OVER_SCORE = 4;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public static String showScore(int player1Score, int player2Score) {
        String score = "";
        int tempScore = 0;
        if (player1Score == player2Score) {
            if (player1Score<OVER_SCORE) {
                score = getString(player1Score)+"-All";
            } else {
                score = getString(player1Score);
            }
        } else if (player1Score >= OVER_SCORE || player2Score >= OVER_SCORE) {
            score = getString(player1Score, player2Score);
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = player1Score;
                else {
                    score += "-";
                    tempScore = player2Score;
                }
                score += getString(tempScore);
            }
        }
        return score;
    }

    private static String getString(int playerScore) {
        String score = "";
        switch (playerScore) {
            case LOVE:
                score = "Love";
                break;
            case FIFTEEN:
                score = "Fifteen";
                break;
            case THIRTY:
                score = "Thirty";
                break;
            case FORTY:
                score = "Forty";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    //get String when score is over 40;
    private static String getString(int player1Score, int player2Score) {
        String score = "";
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult > 1) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }


}