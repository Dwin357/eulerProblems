package io.github.dwin357.tools.struct;

public class Tupal<H,J> {
    private final H one;

    public Tupal(H one, J two) {
        this.one = one;
        this.two = two;
    }

    private final J two;


    public H getOne() {
        return one;
    }

    public J getTwo() {
        return two;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tupal<?, ?> aTupal = (Tupal<?, ?>) o;

        if (one != null ? !one.equals(aTupal.one) : aTupal.one != null) return false;
        return two != null ? two.equals(aTupal.two) : aTupal.two == null;
    }

    @Override
    public int hashCode() {
        int result = one != null ? one.hashCode() : 0;
        result = 31 * result + (two != null ? two.hashCode() : 0);
        return result;
    }
}
