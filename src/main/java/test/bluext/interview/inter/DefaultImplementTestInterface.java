package test.bluext.interview.inter;

public interface DefaultImplementTestInterface {

    int functionA();
    default String functionB(){
        return "defaultString";
    }
}
