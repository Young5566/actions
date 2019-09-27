package young.thrift.thriftTest.service;

public class Test {
    public enum Type {
        FAISS(1);

        Type(int value) {
            this.value = value;
        }
        private int value;

        public int getValue() {
            return value;
        }
    }
}
