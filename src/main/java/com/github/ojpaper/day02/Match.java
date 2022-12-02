package src.main.java.com.github.ojpaper.day02;

public class Match {

    private static final String OWN_ROCK = "X";
    private static final String OWN_PAPER = "Y";
    private static final String OWN_SCISSOR = "Z";

    private static final String OPPONENT_ROCK = "A";
    private static final String OPPONENT_PAPER = "B";
    private static final String OPPONENT_SCISSOR = "C";

    private static final String LOSS_ENDING = "X";
    private static final String DRAW_ENDING = "Y";
    private static final String WIN_ENDING = "Z";
    
    private static final long ROCK_SCORE = 1;
    private static final long PAPER_SCORE = 2;
    private static final long SCISSOR_SCORE = 3;

    private static final long WIN_SCORE = 6;
    private static final long DRAW_SCORE = 3;
    private static final long LOSS_SCORE = 0;
    
    private String opponent;
    private String own;

    public Match(String opponent, String own) {
        this.opponent = opponent;
        this.own = own;
    }

    private long getMatchScore() {
        return switch(opponent) {
            case OPPONENT_ROCK -> switch(own) {
                case OWN_ROCK -> DRAW_SCORE;
                case OWN_PAPER -> WIN_SCORE;
                case OWN_SCISSOR -> LOSS_SCORE;
                default -> 0;
            };
            case OPPONENT_PAPER -> switch(own) {
                case OWN_ROCK -> LOSS_SCORE;
                case OWN_PAPER -> DRAW_SCORE;
                case OWN_SCISSOR -> WIN_SCORE;
                default -> 0;
            };
            case OPPONENT_SCISSOR -> switch(own) {
                case OWN_ROCK -> WIN_SCORE;
                case OWN_PAPER -> LOSS_SCORE;
                case OWN_SCISSOR -> DRAW_SCORE;
                default -> 0;
            };
            default -> 0;
        };
    }

    private long getMoveScore() {
        return switch(own) {
            case OWN_ROCK -> ROCK_SCORE;
            case OWN_PAPER -> PAPER_SCORE;
            case OWN_SCISSOR -> SCISSOR_SCORE;
            default -> 0;
        };
    }

    public long getTotalScore() {
        return getMatchScore() + getMoveScore();
    }

    private long getMatchScore2() {
        return switch(own) {
            case LOSS_ENDING -> LOSS_SCORE;
            case DRAW_ENDING -> DRAW_SCORE;
            case WIN_ENDING -> WIN_SCORE;
            default -> 0;
        };
    }

    private long getMoveScore2() {
        return switch(opponent) {
            case OPPONENT_ROCK -> switch(own) {
                case LOSS_ENDING -> SCISSOR_SCORE;
                case DRAW_ENDING -> ROCK_SCORE;
                case WIN_ENDING -> PAPER_SCORE;
                default -> 0;
            };
            case OPPONENT_PAPER -> switch(own) {
                case LOSS_ENDING -> ROCK_SCORE;
                case DRAW_ENDING -> PAPER_SCORE;
                case WIN_ENDING -> SCISSOR_SCORE;
                default -> 0;
            };
            case OPPONENT_SCISSOR -> switch(own) {
                case LOSS_ENDING -> PAPER_SCORE;
                case DRAW_ENDING -> SCISSOR_SCORE;
                case WIN_ENDING -> ROCK_SCORE;
                default -> 0;
            };
            default -> 0;
        };
    }

    public long getTotalScore2() {
        return getMatchScore2() + getMoveScore2();
    }
}
