package io.github.dwin357.tools;

public class Triple <H,J,K> {

    private final H one;
    private final J two;
    private final K three;

    public Triple(H first, J second, K third) {
        one = first;
        two = second;
        three = third;
    }

    public H getOne() {
        return one;
    }
    public J getTwo() {
        return two;
    }
    public K getThree() {
        return three;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;

        if (one != null ? !one.equals(triple.one) : triple.one != null) return false;
        if (two != null ? !two.equals(triple.two) : triple.two != null) return false;
        return three != null ? three.equals(triple.three) : triple.three == null;
    }

    @Override
    public int hashCode() {
        int result = one != null ? one.hashCode() : 0;
        result = 31 * result + (two != null ? two.hashCode() : 0);
        result = 31 * result + (three != null ? three.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Triple{" +
                "one=" + one +
                ", two=" + two +
                ", three=" + three +
                '}';
    }
}
