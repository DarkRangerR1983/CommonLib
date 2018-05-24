package darkranger.libutil.view.TextSpan;
/**
 * @author: david tang
 * @date: 2018/5/21.
 * @className:
 * @classFunction:
 */
public class WordPosition {
    int start;
    int end;

    public WordPosition(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "WordPosition{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}